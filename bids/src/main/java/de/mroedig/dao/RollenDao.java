package de.mroedig.dao;

import de.mroedig.entities.Rollen;

public interface RollenDao extends BasisDao<Rollen> {

	Rollen getStandardRolle();

}
