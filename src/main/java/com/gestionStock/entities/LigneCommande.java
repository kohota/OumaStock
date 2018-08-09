package com.gestionStock.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity

public class LigneCommande {
	@Id
	@GeneratedValue
	private Integer idLc;
	private long qte;
	private double remise;
	@ManyToOne
	@JoinColumn(name="code_commande")
	private Commande commande;
	@ManyToOne
	@JoinColumn(name="code_article")
	private Article article;
	public LigneCommande() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LigneCommande(long qte, double remise, Commande commande,Article article) {
		super();
		this.qte = qte;
		this.remise = remise;
		this.commande = commande;
		this.article=article;
	}
	public Integer getIdLc() {
		return idLc;
	}
	public void setIdLc(Integer idLc) {
		this.idLc = idLc;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public long getQte() {
		return qte;
	}
	public void setQte(long qte) {
		this.qte = qte;
	}
	public double getRemise() {
		return remise;
	}
	public void setRemise(double remise) {
		this.remise = remise;
	}
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	
	
	
}
