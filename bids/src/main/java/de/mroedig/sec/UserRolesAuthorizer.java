package de.mroedig.sec;

import org.apache.wicket.Session;
import org.apache.wicket.authroles.authorization.strategies.role.IRoleCheckingStrategy;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.spring.injection.annot.SpringBean;

import de.mroedig.services.BenutzerService;

public class UserRolesAuthorizer implements IRoleCheckingStrategy {

	public UserRolesAuthorizer() {
		super();
		Injector.get().inject(this);
	}

	@SpringBean
	private BenutzerService benutzerService;

	@Override
	public boolean hasAnyRole(Roles roles) {
		RolesSession authSession = (RolesSession) Session.get();
		if (authSession.getAktuellerBenutzer() == null) {
			return false;
		}
		return benutzerService.benutzerHasAnyRoles(authSession
				.getAktuellerBenutzer());

	}

}
