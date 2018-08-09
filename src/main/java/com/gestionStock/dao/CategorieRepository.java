package com.gestionStock.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestionStock.entities.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, String>{

}
