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

            String uri = request.getURI();
            String path = uri.split("\\?")[0];

            // --- Lógica de Roteamento ---
            if (request.getMethod().equals("POST")) {
                if (path.equals("/login")) {
                    handleLogin(request, response);
                } else if (path.equals("/proposal/decision")) {
                    handleProposalDecision(request, response);
                } else {
                    response.setResponseStatus("404 Not Found");
                }
            } else if (request.getMethod().equals("GET")) {
                if (path.equals("/proposals")) {
                    handleProposals(request, response);
                } else if (path.equals("/shows/scheduled")) {
                    handleScheduledShows(request, response);
                } else if (path.equals("/show/details")) {
                    handleShowDetails(request, response);
                } else {
                    handleStaticFile(request, response);
                }
            } else {
                response.setResponseStatus("405 Method Not Allowed");
            }

            response.send(outS);
        } catch (IOException ex) {
            System.err.println("Erro na thread: " + ex.getMessage());
        } finally {
            try { sock.close(); } catch (IOException ex) { System.err.println("Erro ao fechar o socket."); }
        }
    }

    private void handleShowDetails(HTTPmessage request, HTTPmessage response) {
        String uri = request.getURI();
        String query = "";
        int queryIndex = uri.indexOf('?');
        if (queryIndex != -1) {
            query = uri.substring(queryIndex + 1);
        }

        if (!query.startsWith("id=")) {
            response.setResponseStatus("400 Bad Request");
            response.setContentFromString("{\"error\":\"Parâmetro 'id' ausente ou inválido.\"}", "application/json");
            return;
        }

        try {
            int showId = Integer.parseInt(query.split("=")[1]);
            System.out.println("A procurar detalhes para o espetáculo #" + showId);

            String showDetailsJson = getShowDetails(showId);

            if (showDetailsJson == null) {
                response.setResponseStatus("404 Not Found");
                response.setContentFromString("{\"error\":\"Show not found.\"}", "application/json");
            } else {
                response.setContentFromString(showDetailsJson, "application/json");
                response.setResponseStatus("200 Ok");
            }
        } catch (NumberFormatException e) {
            response.setResponseStatus("400 Bad Request");
            response.setContentFromString("{\"error\":\"ID inválido.\"}", "application/json");
        }
    }

    private String getShowDetails(int showId) {
        String proposalSQL = "SELECT NUMBER, EVENTDATETIME, EVENTDURATION, LATITUDE, LONGITUDE, INSURANCEVALUE, FIRSTNAME, LASTNAME, SIMULATIONVIDEOLINK, PROPOSALTEXT FROM SHOW_PROPOSAL WHERE NUMBER = ?";
        String dronesSQL = "SELECT DM.NAME, SPMC.QUANTITY FROM DRONE_MODEL DM " +
                "JOIN SHOW_PROPOSAL_MODEL_COUNTS SPMC ON DM.ID = SPMC.DRONE_MODEL_ID " +
                "WHERE SPMC.SHOW_PROPOSAL_ID = ?";
        String figuresSQL = "SELECT DESCRIPTION FROM FIGURE " +
                "JOIN FIGUREINSHOWPROPOSAL ON FIGURE.ID = FIGUREINSHOWPROPOSAL.FIGURE_ID " +
                "JOIN SHOW_PROPOSAL_FIGUREINSHOWPROPOSAL ON FIGUREINSHOWPROPOSAL.ID = SHOW_PROPOSAL_FIGUREINSHOWPROPOSAL.FIGURESLIST_ID " +
                "WHERE SHOW_PROPOSAL_FIGUREINSHOWPROPOSAL.SHOWPROPOSAL_NUMBER = ?";
        StringBuilder json = new StringBuilder();

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            // 1. Get Proposal Details
            try (PreparedStatement stmt = conn.prepareStatement(proposalSQL)) {
                stmt.setInt(1, showId);
                ResultSet rs = stmt.executeQuery();
                if (!rs.next()) return null;

                json.append("{");
                json.append("\"id\":").append(rs.getInt("NUMBER")).append(",");
                json.append("\"dateTime\":\"").append(rs.getTimestamp("EVENTDATETIME").toInstant().toString()).append("\",");
                json.append("\"duration\":").append(rs.getInt("EVENTDURATION")).append(",");
                json.append("\"latitude\":").append(rs.getDouble("LATITUDE")).append(",");
                json.append("\"longitude\":").append(rs.getDouble("LONGITUDE")).append(",");
                json.append("\"insuranceValue\":").append(rs.getDouble("INSURANCEVALUE")).append(",");
                json.append("\"firstName\":\"").append(escapeJson(rs.getString("FIRSTNAME"))).append("\",");
                json.append("\"lastName\":\"").append(escapeJson(rs.getString("LASTNAME"))).append("\",");
                json.append("\"proposalText\":\"").append(escapeJson(rs.getString("PROPOSALTEXT"))).append("\",");
                json.append("\"simulationVideoLink\":\"").append(escapeJson(rs.getString("SIMULATIONVIDEOLINK"))).append("\",");
            }

            // 2. Adiciona um array de drones vazio
            json.append("\"drones\":[");
            try (PreparedStatement stmt = conn.prepareStatement(dronesSQL)) {
                stmt.setInt(1, showId);
                ResultSet rs = stmt.executeQuery();
                boolean first = true;
                while (rs.next()) {
                    if (!first) json.append(",");
                    json.append("{\"name\":\"").append(escapeJson(rs.getString("NAME"))).append("\",");
                    json.append("\"quantity\":").append(rs.getInt("QUANTITY")).append("}");
                    first = false;
                }
            }
            json.append("],");

            // 3. Get Figures
            json.append("\"figures\":[");
            try (PreparedStatement stmt = conn.prepareStatement(figuresSQL)) {
                stmt.setInt(1, showId);
                ResultSet rs = stmt.executeQuery();
                boolean first = true;
                int figureCount = 1;
                while (rs.next()) {
                    if (!first) json.append(",");
                    json.append("{\"name\":\"Figure ").append(figureCount).append("\",");
                    json.append("\"description\":\"").append(escapeJson(rs.getString("DESCRIPTION"))).append("\"}");
                    first = false;
                    figureCount++;
                }
            }
            json.append("]");
            json.append("}");

        } catch (SQLException e) {
            System.err.println("Erro de SQL a procurar detalhes do espetáculo #" + showId + ": " + e.getMessage());
            return null;
        }

        return json.toString();
    }

    private void handleScheduledShows(HTTPmessage request, HTTPmessage response) {
        String uri = request.getURI();
        String query = null;
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
        System.out.println("A procurar espetáculos agendados para o utilizador: " + username);

        List<String> showsList = getScheduledShowsForUser(username);
        String showsJsonString = "[" + String.join(",", showsList) + "]";
        response.setContentFromString(showsJsonString, "application/json");
        response.setResponseStatus("200 Ok");
    }

    private List<String> getScheduledShowsForUser(String username) {
        // Query para obter os detalhes do evento de propostas com estado 'ACCEPTED'
        final String sql = "SELECT SP.NUMBER, SP.EVENTDATETIME, SP.LATITUDE, SP.LONGITUDE " +
                "FROM SHOW_PROPOSAL SP " +
                "JOIN REPRESENTATIVE R ON SP.CUSTOMER_NUMBER = R.CUSTOMER_VAT " +
                "WHERE R.SYSTEMUSER_USERNAME = ? AND SP.STATUS = 'SCHEDULED'";

        List<String> shows = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // Envia a data no formato ISO, que é universalmente reconhecido pelo JavaScript
                String showJson = "{" +
                        "\"id\":" + rs.getInt("NUMBER") + "," +
                        "\"dateTime\":\"" + rs.getTimestamp("EVENTDATETIME").toInstant().toString() + "\"," +
                        "\"latitude\":" + rs.getDouble("LATITUDE") + "," +
                        "\"longitude\":" + rs.getDouble("LONGITUDE") +
                        "}";
                shows.add(showJson);
            }
            System.out.println("Encontrados " + shows.size() + " espetáculos agendados para o utilizador " + username);
        } catch (SQLException e) {
            System.err.println("Erro de SQL a procurar espetáculos agendados: " + e.getMessage());
        }
        return shows;
    }

    private void handleProposalDecision(HTTPmessage request, HTTPmessage response) {
        String body = request.getContentAsString();
        try {
            String idStr = body.split("\"id\":")[1].split(",")[0].replaceAll("[^0-9]", "").trim();
            String status = body.split("\"status\":\"")[1].split("\"")[0].trim();
            int id = Integer.parseInt(idStr);

            boolean success = updateProposalStatus(id, status);

            if (success) {
                response.setResponseStatus("200 OK");
                response.setContentFromString("Decision processed.", "text/plain");
                System.out.println("Decisão processada para a proposta #" + id + ": " + status);
            } else {
                response.setResponseStatus("500 Internal Server Error");
                response.setContentFromString("Failed to update proposal status in the database.", "text/plain");
            }
        } catch (Exception e) {
            response.setResponseStatus("400 Bad Request");
            response.setContentFromString("Invalid request body format.", "text/plain");
            System.err.println("Erro ao fazer parse do corpo do pedido de decisão: " + e.getMessage());
        }
    }

    private boolean updateProposalStatus(int proposalId, String status) {
        if (!status.equals("ACCEPTED") && !status.equals("REJECTED")) {
            System.err.println("Tentativa de atualizar para estado inválido: " + status);
            return false;
        }
        final String sql = "UPDATE SHOW_PROPOSAL SET STATUS = ? WHERE NUMBER = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, status);
            stmt.setInt(2, proposalId);
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.err.println("Erro de SQL ao atualizar a proposta #" + proposalId + ": " + e.getMessage());
            return false;
        }
    }

    private List<String> getPendingProposalsForUser(String username) {
        final String sql = "SELECT SP.NUMBER, SP.PROPOSALTEXT FROM SHOW_PROPOSAL SP " +
                "JOIN REPRESENTATIVE R ON SP.CUSTOMER_NUMBER = R.CUSTOMER_VAT " +
                "WHERE R.SYSTEMUSER_USERNAME = ? AND SP.STATUS = 'PENDENT'";
        List<String> proposals = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int proposalId = rs.getInt("NUMBER");
                String proposalText = rs.getString("PROPOSALTEXT");
                String proposalJson = "{\"id\":" + proposalId + ",\"name\":\"" + escapeJson("Proposal " + proposalId) + "\",\"text\":\"" + escapeJson(proposalText) + "\"}";
                proposals.add(proposalJson);
            }
            System.out.println("Encontradas " + proposals.size() + " propostas criadas para o utilizador " + username);
        } catch (SQLException e) {
            System.err.println("Erro de SQL a procurar propostas para " + username + ": " + e.getMessage());
        }
        return proposals;
    }

    private void handleStaticFile(HTTPmessage request, HTTPmessage response) {
        String uri = request.getURI();
        String resourcePath = "www" + (uri.equals("/") ? "/index.html" : uri);
        try (InputStream is = this.getClass().getClassLoader().getResourceAsStream(resourcePath)) {
            if (is == null) {
                response.setResponseStatus("404 Not Found");
                response.setContentFromString("<html><body><h1>404 Not Found</h1></body></html>", "text/html");
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
        System.out.println("A procurar propostas criadas para o utilizador: " + username);
        List<String> proposalsList = getPendingProposalsForUser(username);
        String proposalsJsonString = "[" + String.join(",", proposalsList) + "]";
        response.setContentFromString(proposalsJsonString, "application/json");
        response.setResponseStatus("200 Ok");
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

    private String escapeJson(String text) {
        if (text == null) return "";
        return text.replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r")
                .replace("\t", "\\t");
    }
}