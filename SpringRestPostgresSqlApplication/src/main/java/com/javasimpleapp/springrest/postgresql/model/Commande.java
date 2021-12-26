package com.javasimpleapp.springrest.postgresql.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "commande")
public class Commande {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "numero")
	private String numero;

	@Column(name = "date")
	private Date date;
	
	

	@Column(name = "prixtotal")
	private String prixtotal;

	@Column(name = "etat")
	private String etat;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPrixtotal() {
		return prixtotal;
	}

	public void setPrixtotal(String prixtotal) {
		this.prixtotal = prixtotal;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}
	public Commande(long id, String numero, Date date, String prixtotal, String etat) {
		super();
		this.id = id;
		this.numero = numero;
		this.date = date;
		this.prixtotal = prixtotal;
		this.etat = etat;
	}

	@Override
	public String toString() {
		return "Commande [id=" + id + ", numero=" + numero + ", date=" + date + ", prixtotal=" + prixtotal + ", etat="
				+ etat + "]";
	}

}
