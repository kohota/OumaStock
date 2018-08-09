package com.gestionStock;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gestionStock.dao.ArticleRepository;
import com.gestionStock.dao.CategorieRepository;
import com.gestionStock.dao.ClientRepository;
import com.gestionStock.dao.CommandeRepository;
import com.gestionStock.dao.LigneCommandeRepository;
import com.gestionStock.entities.Article;
import com.gestionStock.entities.Categorie;
import com.gestionStock.entities.Client;
import com.gestionStock.entities.Commande;
import com.gestionStock.entities.LigneCommande;

@SpringBootApplication
public class OumaStockApplication implements CommandLineRunner{

	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private CommandeRepository commandeRepository;
	@Autowired
	private LigneCommandeRepository ligneCommandeRepository;
	@Autowired
	private ArticleRepository articleRepository;
	@Autowired
	private CategorieRepository categorieRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(OumaStockApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
/*		Client c1 = new Client("YounessMaarouf", "Sidi Kacem");

		clientRepository.save(c1);

		Client c2 = new Client("fadwa", "rabat");
		clientRepository.save(c2);
		Client c3 = new Client("oumaima", "Sidi Kacem");
		clientRepository.save(c3);

		Commande com1 = new Commande("c11111", new Date(), c1);
		commandeRepository.save(com1);
		Commande com2 = new Commande("c22222", new Date(), c2);
		commandeRepository.save(com2);
		Commande com3 = new Commande("c33333", new Date(), c3);
		commandeRepository.save(com3);

		Categorie cat1 = new Categorie("cat1", "PC");
		categorieRepository.save(cat1);

		Article art1 = new Article("art1", "Lenovo1", 1999.89, 3000.78, 12, cat1);

		articleRepository.save(art1);

		ligneCommandeRepository.save(new LigneCommande(11, 100, com1, art1));*/
	}
}
