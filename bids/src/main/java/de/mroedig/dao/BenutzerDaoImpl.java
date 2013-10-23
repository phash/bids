package de.mroedig.dao;

import org.springframework.stereotype.Repository;

import de.mroedig.entities.Benutzer;

@Repository(value = "benutzerDao")
public class BenutzerDaoImpl extends BasisDaoImpl<Benutzer> implements
		BenutzerDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 827163382674959810L;

}
