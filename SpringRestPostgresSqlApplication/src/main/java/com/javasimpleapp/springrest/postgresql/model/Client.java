package com.javasimpleapp.springrest.postgresql.model;
import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client implements Serializable {

	private static final long serialVersionUID = -3009157732242241606L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "code")
	private String code;

	@Column(name = "nom")
	private String nom;
	
	@Column(name = "prenom")
	private String prenom;

	@Column(name = "dateNaissance")
	private Date dateNaissance;
	
	@Column(name = "adresse")
	private String adresse;

	@Column(name = "ville")
	private String ville;
	
	@Column(name = "codePostal")
	private Long codePostal;

	@Column(name = "tel")
	private String tel;
	
	@Column(name = "fax")
	private String fax;

	@Column(name = "gsm")
	private String gsm;
	
	@Column(name = "email")
	private String email;

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

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Long getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(Long codePostal) {
		this.codePostal = codePostal;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getGsm() {
		return gsm;
	}

	public void setGsm(String gsm) {
		this.gsm = gsm;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	protected Client() {}

	public Client(long id, String code, String nom, String prenom, Date dateNaissance, String adresse, String ville,
			Long codePostal, String tel, String fax, String gsm, String email) {
		this.id = id;
		this.code = code;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.ville = ville;
		this.codePostal = codePostal;
		this.tel = tel;
		this.fax = fax;
		this.gsm = gsm;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", code=" + code + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance="
				+ dateNaissance + ", adresse=" + adresse + ", ville=" + ville + ", codePostal=" + codePostal + ", tel="
				+ tel + ", fax=" + fax + ", gsm=" + gsm + ", email=" + email + "]";
	}
	
	
	
	}

