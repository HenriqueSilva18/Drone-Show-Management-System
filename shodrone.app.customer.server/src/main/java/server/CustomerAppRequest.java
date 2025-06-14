package server;

import java.io.*;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        } catch (IOException ex) {
            System.out.println("Erro na thread ao criar streams de dados");
        }
        try {
            HTTPmessage request = new HTTPmessage(inS);
            HTTPmessage response = new HTTPmessage();

            if (request.getMethod().equals("POST") && request.getURI().equals("/login")) {
                handleLogin(request, response);
            } else if (request.getMethod().equals("GET")) {
                handleGet(request, response); // NOVA LÓGICA PARA SERVIR FICHEIROS
            } else {
                response.setResponseStatus("405 Method Not Allowed");
                response.setContentFromString("<h1>405 Method Not Allowed</h1>", "text/html");
            }
            response.send(outS);
        } catch (IOException ex) {
            System.out.println("Erro na thread ao ler o pedido");
        }
        try {
            sock.close();
        } catch (IOException ex) {
            System.out.println("CLOSE IOException");
        }
    }

    /**
     * Trata de pedidos GET. Serve ficheiros estáticos da pasta 'www'.
     */
    private void handleGet(HTTPmessage request, HTTPmessage response) {
        String uri = request.getURI();
        String resourcePath = "www" + (uri.equals("/") ? "/index.html" : uri);

        try (InputStream is = this.getClass().getClassLoader().getResourceAsStream(resourcePath)) {
            if (is == null) {
                response.setResponseStatus("404 Not Found");
                response.setContentFromString("<html><body><h1>404 File not found</h1></body></html>", "text/html");
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
        }
    }

    private void handleLogin(HTTPmessage request, HTTPmessage response) {
        String body = request.getContentAsString();
        String[] credentials = body.split(":", 2);
        if (credentials.length != 2) {
            response.setResponseStatus("400 Bad Request");
            response.setContentFromString("Formato de credenciais inválido.", "text/plain");
            return;
        }
        String username = credentials[0];
        String password = credentials[1];

        if (checkCredentialsAndRole(username, password)) {
            System.out.println("Utilizador '" + username + "' (Customer Representative) autenticado com sucesso.");
            response.setResponseStatus("200 OK");
            response.setContentFromString("Autenticação bem-sucedida!", "text/plain");
        } else {
            System.out.println("Falha na autenticação para o utilizador '" + username + "'.");
            response.setResponseStatus("401 Unauthorized");
            response.setContentFromString("Autenticação falhou: Credenciais inválidas ou sem permissão.", "text/plain");
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
            System.err.println("Erro de SQL ao verificar credenciais e role: " + e.getMessage());
            return false;
        }
    }
}