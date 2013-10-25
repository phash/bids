package de.mroedig.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import org.apache.wicket.util.io.IClusterable;

@Entity
public class Rollen extends BasisEntity<Long> implements IClusterable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -848644751093092228L;

	@Column(nullable = false, unique = true)
	private String bezeichnung;

	@ManyToMany
	private final Set<Benutzer> angehoerendeBenutzer = new HashSet<Benutzer>(10);

}
