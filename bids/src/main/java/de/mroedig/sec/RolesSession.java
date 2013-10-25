package de.mroedig.sec;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;
import org.apache.wicket.spring.injection.annot.SpringBean;

import de.mroedig.entities.Benutzer;
import de.mroedig.services.BenutzerService;

public class RolesSession extends WebSession {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8308699344088211519L;
	private Benutzer aktuellerBenutzer;

	public RolesSession() {
		this(null);
	}

	@SpringBean
	private BenutzerService benutzerService;

	public RolesSession(Request request) {

		super(request);
		Injector.get().inject(this);

	}

	public Benutzer getAktuellerBenutzer() {
		return aktuellerBenutzer;
	}

	public void setAktuellerBenutzer(Benutzer aktuellerBenutzer) {
		this.aktuellerBenutzer = aktuellerBenutzer;
	}

	public boolean authenticate(String username, String password) {
		Benutzer loginUser = benutzerService.authenticate(username, password);
		setAktuellerBenutzer(loginUser);
		return getAktuellerBenutzer() != null;
	}

}
