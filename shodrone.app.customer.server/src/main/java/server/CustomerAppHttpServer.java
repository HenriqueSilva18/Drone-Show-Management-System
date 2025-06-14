package server;
import java.io.IOException;
import javax.net.ssl.SSLSocket;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Servidor HTTP principal para a Customer App.
 * Baseado em HttpServerAjaxVoting.
 * Aceita ligações de clientes e lança uma nova thread (CustomerAppRequest) para cada um.
 */
public class CustomerAppHttpServer {
    static private final String BASE_FOLDER = "www";
    static private ServerSocket sock;

    public static void main(String args[]) throws Exception {
        Socket cliSock;

        if (args.length != 1) {
            System.out.println("O número da porta local é obrigatório na linha de comandos.");
            System.out.println("Uso: java CustomerAppHttpServer <port>");
            System.exit(1);
        }

        int port = Integer.parseInt(args[0]);

        try {
            // Inicializar o H2 Driver para a base de dados
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Driver H2 não encontrado. Adiciona o .jar do H2 ao teu classpath.");
            System.exit(1);
        }


        try {
            sock = new ServerSocket(port);
        } catch (IOException ex) {
            System.out.println("Falha ao abrir a porta local " + port);
            System.exit(1);
        }
        System.out.println("Servidor pronto, a escutar na porta " + port);


        while (true) {
            cliSock = sock.accept();
            System.out.println("Ligação aceite de " + cliSock.getInetAddress().getHostAddress() + ":" + cliSock.getPort());
            CustomerAppRequest req = new CustomerAppRequest(cliSock, BASE_FOLDER);
            req.start();
        }
    }
}