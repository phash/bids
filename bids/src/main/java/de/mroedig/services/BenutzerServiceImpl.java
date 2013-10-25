package de.mroedig.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.mroedig.dao.BenutzerDao;
import de.mroedig.dao.RollenDao;
import de.mroedig.entities.Benutzer;
import de.mroedig.sec.BidsPasswordEncoder;

@Service
public class BenutzerServiceImpl implements BenutzerService {

	@Autowired
	private BenutzerDao benutzerDao;

	@Autowired
	private RollenDao rollenDao;

	@Override
	@Transactional
	public Benutzer authenticate(String username, String password) {
		// TODO passwort hashen
		return benutzerDao.findByUserNameAndPassword(username, password);

	}

	@Override
	@Transactional
	public boolean benutzerHasAnyRoles(Benutzer aktuellerBenutzer) {

		Benutzer persBenutzer = benutzerDao.getById(aktuellerBenutzer
				.getIdent());
		if (persBenutzer == null || persBenutzer.getRollen() == null) {
			return false;
		}
		return persBenutzer.getRollen().size() > 0;

	}

	@Override
	public boolean erstelleNeuenBenutzer(String username, String password) {
		Benutzer gefundenerBenutzer = benutzerDao.findByUserName(username);
		if (gefundenerBenutzer != null) {
			return false;
		}

		Benutzer neuerBenutzer = new Benutzer();
		neuerBenutzer.setBenutzername(username);
		BidsPasswordEncoder encoder = new BidsPasswordEncoder();
		neuerBenutzer.setPasswort(encoder.encodePassword(username, username));
		neuerBenutzer.getRollen().add(rollenDao.getStandardRolle());

		return benutzerDao.persistiere(neuerBenutzer) != null;

	}
}
