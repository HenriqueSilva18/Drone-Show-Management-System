package lapr4.app.customer.console.presentation;

import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ExitWithMessageAction;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;
import lapr4.app.customer.console.http.HttpClient;
import lapr4.app.customer.console.presentation.proposal.AcceptRejectProposalUI;
import lapr4.app.customer.console.presentation.proposal.DownloadProposalUI;


public class MainMenu extends AbstractUI {

    private static final String SEPARATOR_LABEL = "--------------";
    private static final int EXIT_OPTION = 0;

    // Opções do menu principal re-numeradas
    private static final int DOWNLOAD_PROPOSAL_OPTION = 1;
    private static final int ACCEPT_REJECT_PROPOSAL_OPTION = 2;

    // O serviço de autenticação da framework foi removido pois não é usado aqui.
    private final HttpClient httpClient = new HttpClient("localhost", 8080); // Configure se necessário

    @Override
    public boolean show() {
        drawFormTitle();
        return doShow();
    }

    @Override
    public boolean doShow() {
        final Menu menu = buildMainMenu();
        final MenuRenderer renderer = new VerticalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        return renderer.render();
    }

    private Menu buildMainMenu() {
        final Menu mainMenu = new Menu();

        // A secção "My User" foi removida porque depende do sistema de autenticação
        // da framework eapli, que não estamos a usar neste contexto. A opção "Exit"
        // serve como funcionalidade de logout.
        mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        mainMenu.addItem(MenuItem.of(DOWNLOAD_PROPOSAL_OPTION, "Download Proposal", () -> {
            new DownloadProposalUI().show();
            return false;
        }));
        mainMenu.addItem(MenuItem.of(ACCEPT_REJECT_PROPOSAL_OPTION, "Accept/Reject Proposal", () -> {
            new AcceptRejectProposalUI(httpClient).show();
            return false;
        }));
        mainMenu.addItem(MenuItem.of(EXIT_OPTION, "Exit", new ExitWithMessageAction("Bye, Bye")));

        return mainMenu;
    }

    @Override
    public String headline() {
        return "Main Menu";
    }
}