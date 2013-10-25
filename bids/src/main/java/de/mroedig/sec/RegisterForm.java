package de.mroedig.sec;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.util.value.ValueMap;

import de.mroedig.services.BenutzerService;

public class RegisterForm extends Form<Void> {
	private final ValueMap properties = new ValueMap();

	@SpringBean
	private BenutzerService benutzerService;

	public RegisterForm(String id) {
		super(id);
		Injector.get().inject(this);

		add(new TextField<String>("benutzername", new PropertyModel<String>(
				properties, "benutzername")));
		add(new PasswordTextField("passwort", new PropertyModel<String>(
				properties, "passwort")));
		add(new PasswordTextField("passwort2", new PropertyModel<String>(
				properties, "passwort2")));
	}

	@Override
	protected void onSubmit() {
		if (!getPassword().equals(getPassword2())) {
			String errmsg = getString("registerError", null,
					"Passwords don't match");
			error(errmsg);
		} else {
			if (benutzerService.erstelleNeuenBenutzer(getUsername(),
					getPassword())) {
				info("Neuer Benutzer registriert");
			} else {
				error("Error while creating new user");
			}

		}

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
	private String getPassword2() {
		return properties.getString("passwort2");
	}

	/**
	 * @return
	 */
	private String getUsername() {
		return properties.getString("benutzername");
	}

}
