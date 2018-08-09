package com.gestionStock.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.gestionStock.entities.Commande;
import com.gestionStock.entities.LigneCommande;

public interface IGestionStock {

	public boolean reaprovisionner(String idArticle,int qte);
	public boolean retier(String idArticle,int qte);
	public void passerCommande(String idCommande,String idArticle, int qte,double remise);
	public Page<LigneCommande> listArticleParCommande(String idCommande, int page, int size);
	public List<Commande> listCommandeParClient(Integer idClient);
	
}
