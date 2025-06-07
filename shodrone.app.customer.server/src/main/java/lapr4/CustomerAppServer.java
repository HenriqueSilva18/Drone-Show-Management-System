// Em shodrone.app.customer.server/src/main/java/lapr4/CustomerAppServer.java

package lapr4;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

public class CustomerAppServer {

    static private ServerSocket sock;

    public static void main(String args[]) {
        Socket cliSock;

        if (args.length != 1) {
            System.out.println("Uso: java lapr4.CustomerAppServer <porta>");
            System.exit(1);
        }

        // Carregar configurações do ficheiro application.properties
        Properties props = new Properties();
        try (InputStream input = CustomerAppServer.class.getClassLoader().getResourceAsStream("application.properties")) {
            if (input == null) {
                System.out.println("Ficheiro 'application.properties' não encontrado no classpath.");
            } else {
                props.load(input);
            }
        } catch (IOException ex) {
            System.out.println("Erro ao ler 'application.properties'.");
        }

        // Obter a pasta web do ficheiro de propriedades, ou usar "www" como default
        final String baseFolder = props.getProperty("http.server.webroot", "www");

        int port;
        try {
            port = Integer.parseInt(args[0]);
        } catch (NumberFormatException ex) {
            System.out.println("Porta inválida.");
            System.exit(1);
            return;
        }

        try {
            sock = new ServerSocket(port);
        } catch (IOException ex) {
            System.out.println("Falha ao abrir a porta local " + port);
            System.exit(1);
        }

        System.out.println("Servidor da App do Cliente a correr na porta " + port + "...");
        System.out.println("A servir ficheiros da pasta: " + baseFolder);

        while (true) {
            try {
                cliSock = sock.accept();
                HttpAjaxCustomerAppRequest req = new HttpAjaxCustomerAppRequest(cliSock, baseFolder);
                req.start();
            } catch (IOException e) {
                System.out.println("Erro ao aceitar ligação de cliente: " + e.getMessage());
            }
        }
    }
}