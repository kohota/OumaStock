package com.gestionStock.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

public class Article {
	@Id
	private String idArticle;
	private String nom;
	private double prixAchat;
	private double prixVente;
	
	private int qteStock;
	@ManyToOne
	@JoinColumn(name="code_categorie")
	private Categorie categorie;
	
	public String getIdArticle() {
		return idArticle;
	}
	public void setIdArticle(String idArticle) {
		this.idArticle = idArticle;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public double getPrixAchat() {
		return prixAchat;
	}
	public void setPrixAchat(double prixAchat) {
		this.prixAchat = prixAchat;
	}
	public double getPrixVente() {
		return prixVente;
	}
	public void setPrixVente(double prixVente) {
		this.prixVente = prixVente;
	}
	public int getQteStock() {
		return qteStock;
	}
	public void setQteStock(int qteStock) {
		this.qteStock = qteStock;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Article(String idArticle, String nom, double prixAchat, double prixVente,int qteStock,Categorie categorie) {
		super();
		this.idArticle = idArticle;
		this.nom = nom;
		this.prixAchat = prixAchat;
		this.prixVente = prixVente;
		this.qteStock=qteStock;
		this.categorie=categorie;
	}
	
	
}
