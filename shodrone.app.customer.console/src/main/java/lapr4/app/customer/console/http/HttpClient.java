package lapr4.app.customer.console.http;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class HttpClient {
    private final String serverIP;
    private final int serverPort;

    public HttpClient(String serverIP, int serverPort) {
        this.serverIP = serverIP;
        this.serverPort = serverPort;
    }

    /**
     * Pede ao servidor uma proposta de espetáculo pelo seu código.
     * @param proposalCode O código único da proposta.
     * @return A resposta HTTP do servidor, que pode conter o ficheiro.
     */
    public HTTPmessage getShowProposal(String proposalCode) {
        try {
            InetAddress serverAddr = InetAddress.getByName(serverIP);
            try (Socket sock = new Socket(serverAddr, serverPort);
                 DataOutputStream sOut = new DataOutputStream(sock.getOutputStream());
                 DataInputStream sIn = new DataInputStream(sock.getInputStream())) {

                HTTPmessage request = new HTTPmessage();
                request.setRequestMethod("GET");
                request.setURI("/api/proposals/" + proposalCode);

                System.out.println("A pedir a proposta '" + proposalCode + "' ao servidor...");
                request.send(sOut);

                System.out.println("A aguardar resposta...");
                HTTPmessage response = new HTTPmessage(sIn);
                System.out.println("Resposta recebida com status: " + response.getStatus());

                return response;

            } catch (IOException ex) {
                System.out.println("Erro de comunicação com o servidor: " + ex.getMessage());
                return null;
            }
        } catch (UnknownHostException ex) {
            System.out.println("Endereço do servidor inválido: " + serverIP);
            return null;
        }
    }
}