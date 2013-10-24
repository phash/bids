package de.mroedig.dao;

import de.mroedig.entities.Benutzer;

public interface BenutzerDao extends BasisDao<Benutzer> {

	Benutzer findByUserNameAndPassword(String username, String password);

	Benutzer findByUserName(String username);

}
