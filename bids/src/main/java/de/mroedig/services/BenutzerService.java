package de.mroedig.services;

import de.mroedig.entities.Benutzer;

public interface BenutzerService {

	Benutzer authenticate(String username, String password);

	boolean benutzerHasAnyRoles(Benutzer aktuellerBenutzer);

	boolean erstelleNeuenBenutzer(String username, String password);

}
