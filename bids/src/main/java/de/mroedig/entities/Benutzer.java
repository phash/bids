package de.mroedig.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Benutzer extends BasisEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4307732077374637628L;
	private String benutzername;
	private String passwort;
	@OneToMany
	private Set<Auction> auktionenAlsBieter;

	@OneToMany
	private Set<Gebot> gebote;

	public Set<Auction> getAuktionenAlsBieter() {
		return auktionenAlsBieter;
	}

	public void setAuktionenAlsBieter(Set<Auction> auktionenAlsBieter) {
		this.auktionenAlsBieter = auktionenAlsBieter;
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
