package com.gestionStock.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gestionStock.entities.Article;

public interface ArticleRepository extends JpaRepository<Article, String>{
	
	@Query("select a from Article a where a.categorie.idCath=:x")
	public List<Article> listArticleParCategorie(@Param("x") String idCath);
	
	@Query("select a from Article a where a.categorie.idCath = :x")
	public Page<Article> listArticleParCategorie(@Param("x") String idCategorie, Pageable pageable);
}
