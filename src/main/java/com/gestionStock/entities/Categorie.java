package com.gestionStock.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Categorie {
	@Id
	private String idCath;
	private String nom;
	@JsonIgnore
	@OneToMany(mappedBy="categorie")
	private Collection<Article> listA;
	public Collection<Article> getListA() {
		return listA;
	}
	public void setListA(Collection<Article> listA) {
		this.listA = listA;
	}
	public Categorie(String idcath, String nom) {
		super();
		this.idCath = idcath;
		this.nom = nom;
	}
	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getIdCath() {
		return idCath;
	}
	public void setIdCath(String idCath) {
		this.idCath = idCath;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	
}
