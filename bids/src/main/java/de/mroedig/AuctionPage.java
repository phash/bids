package de.mroedig;

import org.apache.wicket.Session;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

import de.mroedig.sec.RolesSession;

public class AuctionPage extends WebPage {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5745212432891738222L;

	@Override
	protected void onInitialize() {

		super.onInitialize();
		RolesSession authSession = (RolesSession) Session.get();

		add(new Label("erfolg", authSession.getAktuellerBenutzer()
				.getBenutzername()));
	}
}
