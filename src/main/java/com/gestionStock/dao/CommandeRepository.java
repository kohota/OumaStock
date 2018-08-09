package com.gestionStock.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gestionStock.entities.Commande;

public interface CommandeRepository extends JpaRepository<Commande, String>{

	@Query("select c from Commande c where c.client.idClient=:x order by c.dateCommande desc")
	public List<Commande> listCommandeParClient(@Param("x") Integer idClient);
}
