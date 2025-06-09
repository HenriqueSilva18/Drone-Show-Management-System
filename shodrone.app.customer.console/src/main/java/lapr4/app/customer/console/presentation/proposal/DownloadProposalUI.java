package lapr4.app.customer.console.presentation.proposal;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import lapr4.app.customer.console.http.HTTPmessage;
import lapr4.app.customer.console.http.HttpClient;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DownloadProposalUI extends AbstractUI {

    private final HttpClient httpClient;

    public DownloadProposalUI() {
        Properties props = new Properties();
        try (InputStream input = DownloadProposalUI.class.getClassLoader().getResourceAsStream("application.properties")) {
            props.load(input);
        } catch (IOException ex) {
            System.out.println("Aviso: Não foi possível ler o ficheiro application.properties. Usando valores por defeito.");
        }

        String serverIp = props.getProperty("app.server.ip", "localhost");
        int serverPort = Integer.parseInt(props.getProperty("app.server.port", "8080"));

        this.httpClient = new HttpClient(serverIp, serverPort);
    }

    @Override
    protected boolean doShow() {
        final String code = Console.readLine("Por favor, introduza o código da proposta que deseja descarregar:");

        HTTPmessage response = httpClient.getShowProposal(code);

        if (response == null) {
            System.out.println("Não foi possível comunicar com o servidor.");
            return false;
        }

        if (response.getStatus().equals("200 Ok") && response.hasContent()) {
            String filename = "proposta-" + code + ".pdf";
            try (FileOutputStream fos = new FileOutputStream(filename)) {
                fos.write(response.getContent());
                System.out.println("\nSucesso! A proposta foi guardada no ficheiro: " + filename);
            } catch (IOException e) {
                System.out.println("\nErro: Não foi possível guardar o ficheiro recebido. " + e.getMessage());
            }
        } else if (response.getStatus().equals("404 Not Found")) {
            System.out.println("\nLamentamos, mas não foi encontrada nenhuma proposta com o código '" + code + "'.");
        } else {
            System.out.println("\nOcorreu um erro no servidor: " + response.getStatus());
        }

        return false;
    }

    @Override
    public String headline() {
        return "Descarregar Proposta de Espetáculo";
    }
}