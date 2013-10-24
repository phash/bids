package de.mroedig;

import org.apache.log4j.Logger;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import de.mroedig.debug.DebugPanel;
import de.mroedig.sec.LoginPanel;

public class HomePage extends WebPage {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8475701354265685748L;

	private static Logger log = Logger.getLogger(HomePage.class);

	private Form<?> neueAuktionsForm;
	private DebugPanel debugPanel;
	private LoginPanel loginPanel;

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
		loginPanel = new LoginPanel("loginPanel");
		add(loginPanel);

	}
}
