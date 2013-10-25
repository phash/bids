package de.mroedig.sec;

import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;

public class RegisterPanel extends Panel {

	public RegisterPanel(String id) {
		super(id);

		add(new RegisterForm("registerForm"));
		add(new FeedbackPanel("feedback"));
	}

}
