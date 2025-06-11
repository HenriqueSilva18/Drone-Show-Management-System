package lapr4.app.customer.console.presentation;

import eapli.framework.actions.Action;
import eapli.framework.io.util.Console;
import lapr4.app.customer.console.http.HTTPmessage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientLoginAction implements Action {

    private static final String SERVER_IP = "localhost";
    private static final int SERVER_PORT = 8080;

    @Override
    public boolean execute() {
        System.out.println("== Login ==");

        final String username = Console.readLine("Username:");
        final String password = Console.readLine("Password:");

        if (username == null || username.trim().isEmpty() || password == null || password.trim().isEmpty()) {
            System.out.println("Login cancelled.");
            return false;
        }

        Socket clientSocket = null;
        try {
            InetAddress serverIP = InetAddress.getByName(SERVER_IP);
            clientSocket = new Socket(serverIP, SERVER_PORT);

            String jsonRequest = String.format("{\"username\":\"%s\", \"password\":\"%s\"}", username, password);
            HTTPmessage request = new HTTPmessage();
            request.setRequestMethod("POST");
            request.setURI("/login");
            request.setContentFromString(jsonRequest, "application/json");

            DataOutputStream sOut = new DataOutputStream(clientSocket.getOutputStream());
            DataInputStream sIn = new DataInputStream(clientSocket.getInputStream());

            request.send(sOut);
            HTTPmessage response = new HTTPmessage(sIn);

            // --- CORREÇÃO APLICADA AQUI ---
            // 1. A verificação do status agora é mais flexível ("startsWith")
            if (response.getStatus() != null && response.getStatus().startsWith("200")) {
                System.out.println("\nLogin successful!");
                System.out.println("Welcome, " + username + "!");

                // 2. Após o login, chamamos diretamente o menu principal (MainMenu.java)
                // Isto garante que o utilizador avança para o menu correto.
                final MainMenu menu = new MainMenu();
                menu.show();

                // Retornamos true para indicar sucesso, mas o fluxo principal da UI continua a partir do MainMenu.
                return true;
            } else {
                System.out.println("\nLogin failed. Server responded with status: " + response.getStatus());
                System.out.println("Message: " + response.getContentAsString());
                return false;
            }

        } catch (UnknownHostException e) {
            System.err.println("Error: The server '" + SERVER_IP + "' was not found.");
            return false;
        } catch (IOException e) {
            System.err.println("Error during communication with the server: " + e.getMessage());
            return false;
        } finally {
            if (clientSocket != null) {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    // Ignorar
                }
            }
        }
    }
}