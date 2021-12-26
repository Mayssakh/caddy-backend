package com.javasimpleapp.springrest.postgresql.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "categorie")
public class Categorie {



	@Column(name = "libelle")
	private String libelle;

	

	public String getLibelle() {
		return libelle;
	}

	public Categorie( String libelle) {
	
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return "Categorie [libelle=" + libelle + "]";
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
}
