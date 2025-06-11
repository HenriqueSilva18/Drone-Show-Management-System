package lapr4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class HttpAjaxCustomerAppRequest extends Thread {
    private final String baseFolder;
    private final Socket sock;

    public HttpAjaxCustomerAppRequest(Socket s, String f) {
        baseFolder = f;
        sock = s;
    }

    public void run() {
        try (DataOutputStream outS = new DataOutputStream(sock.getOutputStream());
             DataInputStream inS = new DataInputStream(sock.getInputStream())) {

            HTTPmessage request = new HTTPmessage(inS);
            HTTPmessage response = new HTTPmessage();

            // Roteamento de pedidos
            if (request.getMethod().equals("GET")) {
                if (request.getURI().startsWith("/api/proposals/")) {
                    handleGetShowProposal(request, response);
                } else {
                    handleGetStaticFile(request, response);
                }
            } else if (request.getMethod().equals("POST") && request.getURI().equals("/login")) {
                // NOVA LÓGICA PARA TRATAR O LOGIN
                handleLogin(request, response);
            }
            else {
                response.setResponseStatus("405 Method Not Allowed");
            }
            response.send(outS);

        } catch (IOException ex) {
            System.err.println("Error processing request: " + ex.getMessage());
        } finally {
            try {
                sock.close();
            } catch (IOException e) {
                // Ignorar erro no fecho
            }
        }
    }

    // Método para servir ficheiros estáticos
    private void handleGetStaticFile(HTTPmessage request, HTTPmessage response) {
        String uri = request.getURI();
        String fullname = baseFolder + (uri.equals("/") ? "/index.html" : uri);
        if (!response.setContentFromFile(fullname)) {
            response.setResponseStatus("404 Not Found");
        } else {
            response.setResponseStatus("200 Ok");
        }
    }

    // Método para tratar o pedido de uma proposta
    private void handleGetShowProposal(HTTPmessage request, HTTPmessage response) {
        String uri = request.getURI();
        String proposalCode = uri.substring("/api/proposals/".length());
        System.out.println("Recebido pedido para a proposta com código: " + proposalCode);

        // Lógica de negócio simulada para encontrar o ficheiro da proposta
        String filePath = "docs/data/Proposta_mod_01.txt"; // Simulação

        if (response.setContentFromFile(filePath)) {
            response.setResponseStatus("200 Ok");
            System.out.println("Ficheiro da proposta enviado.");
        } else {
            response.setResponseStatus("404 Not Found");
            System.out.println("Proposta com o código '" + proposalCode + "' não encontrada.");
        }
    }

    // NOVO: Método para tratar o pedido de login
    private void handleLogin(HTTPmessage request, HTTPmessage response) {
        String requestBody = request.getContentAsString();
        System.out.println("Recebido pedido de login com corpo: " + requestBody);

        // --- LÓGICA DE NEGÓCIO ---
        // Extrair username e password do JSON
        // Para simplificar, vamos fazer uma verificação básica.
        // Numa aplicação real, você deve usar uma biblioteca de JSON (como Gson ou Jackson)
        // e um serviço de autenticação.

        if (requestBody.contains("\"username\":\"mariarep\"") && requestBody.contains("\"password\":\"Password1\"")) {
            response.setResponseStatus("200 Ok");
            response.setContentFromString("{\"message\":\"Login successful\"}", "application/json");
            System.out.println("Login bem sucedido para o utilizador mariarep.");
        } else {
            response.setResponseStatus("401 Unauthorized");
            response.setContentFromString("{\"error\":\"Invalid credentials\"}", "application/json");
            System.out.println("Falha no login. Credenciais inválidas.");
        }
        // --- FIM DA LÓGICA DE NEGÓCIO ---
    }
}