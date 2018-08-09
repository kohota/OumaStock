package com.gestionStock.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gestionStock.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{

	
}
