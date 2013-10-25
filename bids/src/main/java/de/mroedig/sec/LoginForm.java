package de.mroedig.sec;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.util.value.ValueMap;

import de.mroedig.AuctionPage;

public class LoginForm extends Form<Void> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2534447015430138769L;
	private final ValueMap properties = new ValueMap();

	public LoginForm(String id) {
		super(id);

		add(new TextField<String>("benutzername", new PropertyModel<String>(
				properties, "benutzername")));
		add(new PasswordTextField("passwort", new PropertyModel<String>(
				properties, "passwort")));
	}

	@Override
	protected void onSubmit() {
		RolesSession session = getMySession();
		if (session.authenticate(getUsername(), getPassword())) {
			setResponsePage(AuctionPage.class);
		} else {
			String errmsg = getString("loginError", null,
					"Unable to sign you in");
			error(errmsg);
		}

	}

	private RolesSession getMySession() {
		return (RolesSession) getSession();

	}

	/**
	 * @return
	 */
	private String getPassword() {
		return properties.getString("passwort");
	}

	/**
	 * @return
	 */
	private String getUsername() {
		return properties.getString("benutzername");
	}
}
