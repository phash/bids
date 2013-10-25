package de.mroedig.sec;

import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;

public class LoginPanel extends Panel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2944539348595158650L;

	public LoginPanel(String id) {
		super(id);
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new LoginForm("loginForm"));
		add(new FeedbackPanel("feedback"));
	}

}
