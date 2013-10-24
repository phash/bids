package de.mroedig.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.apache.wicket.util.io.IClusterable;
import org.hibernate.validator.constraints.Length;

@Entity
public class Benutzer extends BasisEntity<Long> implements IClusterable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4307732077374637628L;

	@Column(unique = true)
	private String benutzername;

	@Length(min = 6)
	private String passwort;

	@OneToMany
	private Set<Gebot> gebote;

	@ManyToMany
	private Set<Rollen> rollen;

	public Set<Rollen> getRollen() {
		return rollen;
	}

	public void setRollen(Set<Rollen> rollen) {
		this.rollen = rollen;
	}

	public Benutzer() {
		super();
		rollen = null;
	}

	public Benutzer(String uid, Set<Rollen> roles) {
		if (uid == null) {
			throw new IllegalArgumentException("benutzername must be not null");
		}
		if (roles == null) {
			throw new IllegalArgumentException("roles must be not null");
		}
		benutzername = uid;
		rollen = roles;
	}

	public Set<Gebot> getGebote() {
		return gebote;
	}

	public void setGebote(Set<Gebot> gebote) {
		this.gebote = gebote;
	}

	public String getBenutzername() {
		return benutzername;
	}

	public void setBenutzername(String benutzername) {
		this.benutzername = benutzername;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

}
