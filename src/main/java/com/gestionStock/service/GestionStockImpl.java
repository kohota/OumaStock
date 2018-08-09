package com.gestionStock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestionStock.dao.ArticleRepository;
import com.gestionStock.dao.CommandeRepository;
import com.gestionStock.dao.LigneCommandeRepository;
import com.gestionStock.entities.Article;
import com.gestionStock.entities.Commande;
import com.gestionStock.entities.LigneCommande;
@Service
@Transactional
public class GestionStockImpl implements IGestionStock{
	@Autowired
	private CommandeRepository commandeRepository;
	@Autowired
	private LigneCommandeRepository ligneCommandeRepository;
	@Autowired
	private ArticleRepository articleRepository;
	
	@Override
	public boolean reaprovisionner(String idArticle, int qte) {
		
		Article a = articleRepository.findOne(idArticle);
		if(a != null) {
			a.setQteStock(a.getQteStock() + qte);
			articleRepository.save(a);
			return true;
		}
		
		return false;
	}

	@Override
	public void passerCommande(String idCommande, String idArticle, int qte, double remise) {
		Commande c = commandeRepository.findOne(idCommande);
		Article a = articleRepository.findOne(idArticle);
		if ( a != null && c != null) {
			
			if(retier(a.getIdArticle(), qte)) {
				LigneCommande lc = new LigneCommande(qte, remise, c, a);
				ligneCommandeRepository.save(lc);
			}
			
			
		}
		
		
		
	}

	@Override
	public Page<LigneCommande> listArticleParCommande(String idCommande, int page, int size) {
		// TODO Auto-generated method stub
		return ligneCommandeRepository.listArticleParCommande(idCommande, new PageRequest(page, size));
	}

	@Override
	public List<Commande> listCommandeParClient(Integer idClient) {
		// TODO Auto-generated method stub
		return commandeRepository.listCommandeParClient(idClient);
	}

	@Override
	public boolean retier(String idArticle, int qte) {
		Article a = articleRepository.findOne(idArticle);
		if(a != null) {
			if( a.getQteStock() > qte) {
				a.setQteStock(a.getQteStock() - qte);
				articleRepository.save(a);
				return true;
			}
			
		}
		
		return false;
	}

}
