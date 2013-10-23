package de.mroedig.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Auction extends BasisEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2557591632876673435L;
	private String auktionsGegenstand;
	private Integer preisInCent;
	private Integer laufzeitInSekunden;
	private Date startZeitpunkt;
	private String waehrung;

	private String servername;
	private String spielname;

	public String getServername() {
		return servername;
	}

	public void setServername(String servername) {
		this.servername = servername;
	}

	public String getSpielname() {
		return spielname;
	}

	public void setSpielname(String spielname) {
		this.spielname = spielname;
	}

	@ManyToOne
	private Benutzer besitzer;
	@OneToMany
	private Set<Gebot> gebote;

	public Benutzer getBesitzer() {
		return besitzer;
	}

	public void setBesitzer(Benutzer besitzer) {
		this.besitzer = besitzer;
	}

	public Set<Gebot> getGebote() {
		return gebote;
	}

	public void setGebote(Set<Gebot> gebote) {
		this.gebote = gebote;
	}

	public String getWaehrung() {
		return waehrung;
	}

	public void setWaehrung(String waehrung) {
		this.waehrung = waehrung;
	}

	public String getAuktionsGegenstand() {
		return auktionsGegenstand;
	}

	public void setAuktionsGegenstand(String auktionsGegenstand) {
		this.auktionsGegenstand = auktionsGegenstand;
	}

	public Integer getPreisInCent() {
		return preisInCent;
	}

	public void setPreisInCent(Integer preisInCent) {
		this.preisInCent = preisInCent;
	}

	public Integer getLaufzeitInSekunden() {
		return laufzeitInSekunden;
	}

	public void setLaufzeitInSekunden(Integer laufzeitInSekunden) {
		this.laufzeitInSekunden = laufzeitInSekunden;
	}

	public Date getStartZeitpunkt() {
		return startZeitpunkt;
	}

	public void setStartZeitpunkt(Date startZeitpunkt) {
		this.startZeitpunkt = startZeitpunkt;
	}

}
