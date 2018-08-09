package com.gestionStock.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Client {
	@Id
	@GeneratedValue
	private Integer idClient;
	private String nom;
	private String adresse;
	@JsonIgnore
	@OneToMany(mappedBy="client",fetch=FetchType.LAZY)
	private Collection<Commande> listC;
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Client(String nom, String adresse) {
		super();
		this.nom = nom;
		this.adresse = adresse;
	}
	public Integer getIdClient() {
		return idClient;
	}
	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public Collection<Commande> getListC() {
		return listC;
	}
	public void setListC(Collection<Commande> listC) {
		this.listC = listC;
	}
	
	
}
