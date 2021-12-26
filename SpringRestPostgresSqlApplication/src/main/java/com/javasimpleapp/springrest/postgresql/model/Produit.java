package com.javasimpleapp.springrest.postgresql.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produit")
public class Produit extends Categorie implements Serializable {
	
	private static final long serialVersionUID = -3009157732242241606L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "code")
	private String code;

	@Column(name = "marque")
	private String marque;
	
	@Column(name = "modele")
	private String modele;

	@Column(name = "caracteristique")
	private String caracteristique;
	
	@Column(name = "prixunitaire")
	private int prixunitaire;

	@Column(name = "quantite")
	private long quantite;
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public String getCaracteristique() {
		return caracteristique;
	}

	public void setCaracteristique(String caracteristique) {
		this.caracteristique = caracteristique;
	}

	public int getPrixunitaire() {
		return prixunitaire;
	}

	public void setPrixunitaire(int prixunitaire) {
		this.prixunitaire = prixunitaire;
	}

	public long getQuantite() {
		return quantite;
	}

	public void setQuantite(long quantite) {
		this.quantite = quantite;
	}

	



	public Produit(String libelle, long id, String code, String marque, String modele, String caracteristique,
			int prixunitaire, long quantite) {
		super(libelle);
		this.id = id;
		this.code = code;
		this.marque = marque;
		this.modele = modele;
		this.caracteristique = caracteristique;
		this.prixunitaire = prixunitaire;
		this.quantite = quantite;
	}

	@Override
	public String toString() {
		return "Produit [id=" + id + ", code=" + code + ", marque=" + marque + ", modele=" + modele
				+ ", caracteristique=" + caracteristique + ", prixunitaire=" + prixunitaire + ", quantite=" + quantite
				+ "]";
	}
	
	

}
