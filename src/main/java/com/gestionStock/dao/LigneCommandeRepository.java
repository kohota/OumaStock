package com.gestionStock.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gestionStock.entities.LigneCommande;

public interface LigneCommandeRepository extends JpaRepository<LigneCommande, Integer>{
	@Query("select l from LigneCommande l where l.commande.idCommande=:x order by l.idLc") 
	public List<LigneCommande> listArticleParCommande(@Param("x") String idCommande);
	
	@Query("select l from LigneCommande l where l.commande.idCommande=:x order by l.idLc") 
	public Page<LigneCommande> listArticleParCommande(@Param("x") String idCommande, Pageable pageable);
}
