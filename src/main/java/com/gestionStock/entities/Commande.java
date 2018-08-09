package com.gestionStock.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Commande {
	@Id
	private String idCommande;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="GMT")
	private Date dateCommande;
	@ManyToOne
	@JoinColumn(name="code_client")
	private Client client;
	@JsonIgnore
	@OneToMany(mappedBy="commande",fetch=FetchType.LAZY)
	private Collection<LigneCommande> listLC;
	public Collection<LigneCommande> getListLC() {
		return listLC;
	}
	public void setListLC(Collection<LigneCommande> listLC) {
		this.listLC = listLC;
	}
	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Commande(String idCommande, Date dateCommande,Client client) {
		super();
		this.idCommande = idCommande;
		this.dateCommande = dateCommande;
		this.client=client;
	}
	public String getIdCommande() {
		return idCommande;
	}
	public void setIdCommande(String idCommande) {
		this.idCommande = idCommande;
	}
	public Date getDateCommande() {
		return dateCommande;
	}
	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	
}
