package lapr4.app.customer.console.presentation;

import eapli.framework.actions.menu.Menu;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ExitWithMessageAction;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

public class FrontMenu extends AbstractUI {

	private static final int EXIT_OPTION = 0;
	private static final int LOGIN_OPTION = 1;

	@Override
	public boolean show() {
		drawFormTitle();
		return doShow();
	}

	@Override
	public boolean doShow() {
		final Menu menu = new Menu();

		menu.addItem(LOGIN_OPTION, "Login", new ClientLoginAction());
		menu.addItem(EXIT_OPTION, "Exit", new ExitWithMessageAction("Bye, Bye"));

		final MenuRenderer renderer = new VerticalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
		return renderer.render();
	}

	@Override
	public String headline() {
		return "Customer App";
	}
}