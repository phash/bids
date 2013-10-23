package de.mroedig;

import org.apache.log4j.Logger;
import org.apache.wicket.authroles.authentication.panel.SignInPanel;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import de.mroedig.debug.DebugPanel;

public class HomePage extends WebPage {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7017540703152285562L;

	private static Logger log = Logger.getLogger(HomePage.class);

	private Form<?> neueAuktionsForm;
	private DebugPanel debugPanel;
	private SignInPanel signInPanel;

	public HomePage(final PageParameters parameters) {
		super(parameters);

	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		debugPanel = new DebugPanel("debugPanel");
		add(debugPanel);
		neueAuktionsForm = new NewAuctionForm("neueAuktionsForm");
		add(neueAuktionsForm);
		signInPanel = new SignInPanel("signInPanel");
		add(signInPanel);

	}
}
