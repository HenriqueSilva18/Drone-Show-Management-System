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
                // NOVO: Verifica se o pedido é para uma proposta
                if (request.getURI().startsWith("/api/proposals/")) {
                    handleGetShowProposal(request, response);
                } else { // Se não, serve ficheiros estáticos como antes
                    handleGetStaticFile(request, response);
                }
            } else {
                response.setResponseStatus("405 Method Not Allowed");
            }
            response.send(outS);

        } catch (IOException ex) {
            // Tratar excepções
        } finally {
            try { sock.close(); } catch (IOException e) { /*...*/ }
        }
    }

    // Método para servir ficheiros estáticos (o antigo `handleGet`)
    private void handleGetStaticFile(HTTPmessage request, HTTPmessage response) {
        String uri = request.getURI();
        String fullname = baseFolder + (uri.equals("/") ? "/index.html" : uri);
        if (!response.setContentFromFile(fullname)) {
            response.setResponseStatus("404 Not Found");
        } else {
            response.setResponseStatus("200 Ok");
        }
    }

    // NOVO: Método para tratar o pedido de uma proposta
    private void handleGetShowProposal(HTTPmessage request, HTTPmessage response) {
        String uri = request.getURI();
        // Extrai o código da proposta do URI (ex: de "/api/proposals/XYZ123" para "XYZ123")
        String proposalCode = uri.substring("/api/proposals/".length());

        System.out.println("Recebido pedido para a proposta com código: " + proposalCode);

        // --- LÓGICA DE NEGÓCIO ---
        // Aqui, você usaria um serviço/repositório para encontrar o caminho do ficheiro da proposta.
        // String filePath = showProposalService.findProposalFilePathByCode(proposalCode);

        // Para este exemplo, vamos simular:
        String filePath;
        if (proposalCode.equals("PROPOSAL01")) {
            // Supondo que tem um ficheiro de exemplo para devolver
            filePath = "docs/data/Proposta_mod_01.txt"; // Simulação com um ficheiro existente no projeto
        } else {
            filePath = null;
        }
        // --- FIM DA LÓGICA DE NEGÓCIO ---

        if (filePath != null && response.setContentFromFile(filePath)) {
            response.setResponseStatus("200 Ok");
            System.out.println("Ficheiro da proposta encontrado e enviado.");
        } else {
            response.setResponseStatus("404 Not Found");
            System.out.println("Proposta com o código '" + proposalCode + "' não encontrada.");
        }
    }
}