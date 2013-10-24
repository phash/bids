package de.mroedig;

import org.apache.wicket.Session;
import org.apache.wicket.authroles.authorization.strategies.role.RoleAuthorizationStrategy;
import org.apache.wicket.authroles.authorization.strategies.role.metadata.MetaDataRoleAuthorizationStrategy;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;

import de.mroedig.sec.RolesSession;
import de.mroedig.sec.UserRolesAuthorizer;

/**
 * Application object for your web application. If you want to run this
 * application without deploying, run the Start class.
 * 
 * @see de.mroedig.Start#main(String[])
 */
public class WicketApplication extends WebApplication {

	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends WebPage> getHomePage() {
		return HomePage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init() {
		super.init();
		getComponentInstantiationListeners().add(
				new SpringComponentInjector(this));
		getDebugSettings().setDevelopmentUtilitiesEnabled(true);
		getSecuritySettings().setAuthorizationStrategy(
				new RoleAuthorizationStrategy(new UserRolesAuthorizer()));

		MetaDataRoleAuthorizationStrategy.authorize(AuctionPage.class, "USER");
	}

	@Override
	public Session newSession(Request request, Response response) {
		return new RolesSession(request);
	}
}
