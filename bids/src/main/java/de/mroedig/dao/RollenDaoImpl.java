package de.mroedig.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import de.mroedig.entities.Rollen;

public class RollenDaoImpl extends BasisDaoImpl<Rollen> implements RollenDao {

	@Override
	public Rollen getStandardRolle() {
		Criteria myCriteria = getNewCriteria();
		myCriteria.add(Restrictions.eq("bezeichnung", "USER"));
		return (Rollen) myCriteria.uniqueResult();
	}
}
