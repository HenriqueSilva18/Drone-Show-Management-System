package server;

import java.io.*;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerAppRequest extends Thread {
    String baseFolder;
    Socket sock;
    DataInputStream inS;
    DataOutputStream outS;

    private static final String DB_URL = "jdbc:h2:tcp://vsgate-s2.dei.isep.ipp.pt:10860/databaseName";
    private static final String DB_USER = "admin";
    private static final String DB_PASSWORD = "admin";

    public CustomerAppRequest(Socket s, String f) {
        baseFolder = f;
        sock = s;
    }

    @Override
    public void run() {
        try {
            outS = new DataOutputStream(sock.getOutputStream());
            inS = new DataInputStream(sock.getInputStream());

            HTTPmessage request = new HTTPmessage(inS);
            HTTPmessage response = new HTTPmessage();

            System.out.println("A processar pedido " + request.getMethod() + " para o URI: " + request.getURI());

            // Extrai o caminho (path) do URI, ignorando os parâmetros da query
            String uri = request.getURI();
            String path = uri.split("\\?")[0];

            // --- Roteamento dos Pedidos ---
            if (request.getMethod().equals("POST") && path.equals("/login")) {
                handleLogin(request, response);
            } else if (request.getMethod().equals("GET")) {
                if (path.equals("/proposals")) {
                    handleProposals(request, response);
                } else {
                    handleStaticFile(request, response);
                }
            } else {
                response.setResponseStatus("405 Method Not Allowed");
                response.setContentFromString("<h1>405 Method Not Allowed</h1>", "text/html");
            }
            response.send(outS);
        } catch (IOException ex) {
            System.err.println("Erro na thread: " + ex.getMessage());
        } finally {
            try {
                sock.close();
            } catch (IOException ex) {
                System.err.println("Exceção ao fechar o socket: " + ex.getMessage());
            }
        }
    }

    private void handleStaticFile(HTTPmessage request, HTTPmessage response) {
        String uri = request.getURI();
        String resourcePath = "www" + (uri.equals("/") ? "/index.html" : uri);

        try (InputStream is = this.getClass().getClassLoader().getResourceAsStream(resourcePath)) {
            if (is == null) {
                response.setResponseStatus("404 Not Found");
                response.setContentFromString("<html><body><h1>404 File not found</h1></body></html>", "text/html");
                System.err.println("Recurso não encontrado: " + resourcePath);
            } else {
                String contentType = "text/html";
                if (uri.endsWith(".js")) contentType = "application/javascript";
                if (uri.endsWith(".css")) contentType = "text/css";
                byte[] data = is.readAllBytes();
                response.setContent(data, contentType);
                response.setResponseStatus("200 Ok");
            }
        } catch (IOException ex) {
            response.setResponseStatus("500 Internal Server Error");
            response.setContentFromString("<html><body><h1>500 Internal Server Error</h1></body></html>", "text/html");
            System.err.println("Erro ao ler recurso " + resourcePath + ": " + ex.getMessage());
        }
    }

    private void handleProposals(HTTPmessage request, HTTPmessage response) {
        String uri = request.getURI();
        String query = null;

        // Extrai a query string do URI
        int queryStartIndex = uri.indexOf('?');
        if (queryStartIndex != -1) {
            query = uri.substring(queryStartIndex + 1);
        }

        if (query == null || !query.startsWith("user=")) {
            response.setResponseStatus("400 Bad Request");
            response.setContentFromString("{\"error\":\"Parâmetro 'user' ausente ou inválido.\"}", "application/json");
            return;
        }

        String username = query.split("=")[1];
        System.out.println("A procurar propostas pendentes para o utilizador: " + username);

        List<String> proposalsList = getPendingProposalsForUser(username);

        String proposalsJsonString = "[" + String.join(",", proposalsList) + "]";
        response.setContentFromString(proposalsJsonString, "application/json");
        response.setResponseStatus("200 Ok");
    }

    private List<String> getPendingProposalsForUser(String username) {
        final String sql = "SELECT SP.NUMBER, SP.PROPOSALTEXT FROM SHOW_PROPOSAL SP " +
                "JOIN REPRESENTATIVE R ON SP.CUSTOMER_NUMBER = R.CUSTOMER_VAT " +
                "WHERE R.SYSTEMUSER_USERNAME = ? AND SP.STATUS = 'CREATED'";

        List<String> proposals = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int proposalId = rs.getInt("NUMBER");
                String proposalText = rs.getString("PROPOSALTEXT");

                String proposalJson = "{" +
                        "\"id\":" + proposalId + "," +
                        "\"name\":\"" + escapeJson("Proposal " + proposalId) + "\"," +
                        "\"text\":\"" + escapeJson(proposalText) + "\"" +
                        "}";
                proposals.add(proposalJson);
            }
            System.out.println("Encontradas " + proposals.size() + " propostas criadas para o utilizador " + username);
        } catch (SQLException e) {
            System.err.println("Erro de SQL a procurar propostas para " + username + ": " + e.getMessage());
        }
        return proposals;
    }

    private String escapeJson(String text) {
        if (text == null) return "";
        return text.replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r")
                .replace("\t", "\\t");
    }

    private void handleLogin(HTTPmessage request, HTTPmessage response) {
        String body = request.getContentAsString();
        String[] credentials = body.split(":", 2);
        if (credentials.length != 2) {
            response.setResponseStatus("400 Bad Request");
            response.setContentFromString("Invalid credentials format.", "text/plain");
            return;
        }
        String username = credentials[0];
        String password = credentials[1];

        System.out.println("Tentativa de autenticação para o utilizador: " + username);

        if (checkCredentialsAndRole(username, password)) {
            System.out.println("Autenticação bem-sucedida para o utilizador '" + username + "' (Customer Representative)");
            response.setResponseStatus("200 OK");
            response.setContentFromString("Authentication successful!", "text/plain");
        } else {
            System.out.println("Autenticação falhou para o utilizador '" + username + "'. Credenciais inválidas ou sem a role necessária.");
            response.setResponseStatus("401 Unauthorized");
            response.setContentFromString("Authentication failed: Invalid credentials or permission denied.", "text/plain");
        }
    }

    private boolean checkCredentialsAndRole(String username, String password) {
        final String sql = "SELECT COUNT(SU.USERNAME) " +
                "FROM T_SYSTEMUSER SU " +
                "JOIN T_ROLESET RS ON SU.ROLES_PK = RS.PK " +
                "JOIN T_ROLESET_T_ROLEASSIGNMENT RSR ON RS.PK = RSR.ROLESET_PK " +
                "JOIN T_ROLEASSIGNMENT RA ON RSR.ASSIGNMENTS_PK = RA.PK " +
                "WHERE SU.USERNAME = ? AND SU.PASSWORD = ? AND RA.ROLENAME = 'CUSTOMER_REPRESENTATIVE'";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next() && rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            System.err.println("Erro de SQL ao verificar credenciais para o utilizador " + username + ": " + e.getMessage());
            return false;
        }
    }
}