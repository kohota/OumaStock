package com.gestionStock.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gestionStock.dao.ArticleRepository;
import com.gestionStock.dao.ClientRepository;
import com.gestionStock.dao.CommandeRepository;
import com.gestionStock.dto.Purchase;
import com.gestionStock.entities.Article;
import com.gestionStock.entities.Client;
import com.gestionStock.entities.Commande;

import com.gestionStock.service.IGestionStock;
import com.gestionStock.Utility.*;

@Controller

public class CommandeController {
	@Autowired 
	private ArticleRepository articleRepository;
	@Autowired
	private CommandeRepository commandeRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private IGestionStock metierStock;
	private List<Purchase> listpurchase= new ArrayList<Purchase>();
	
	@RequestMapping("/Panier")
	public String addToCart(HttpServletRequest request) {
		HttpSession session= request.getSession(true);
		session.setAttribute("panier", listpurchase);
		return "redirect:ajouterAupanierForm";
	}
	
	@RequestMapping("/ajouterAupanierForm")
	public String ajouterAuPanierForm(Model model) {
		List<Article> articles = articleRepository.findAll();
		model.addAttribute("articles", articles);
		return "Commande/formAdd";
	}
	
	@RequestMapping(value="/ajouterAuPanier",method=RequestMethod.POST)
	public String ajouterAuPanier(HttpServletRequest request,String idArticle,int qte,double remise) {
		HttpSession session= request.getSession();
		List<Purchase> purchases=(List<Purchase>) session.getAttribute("panier");
		
		Purchase p = new Purchase(idArticle, qte, remise);
		if(purchases.contains(p)) {
			return "redirect:ajouterAupanierForm?message";
		}
		purchases.add(p);
		session.setAttribute("panier", purchases);
		for (Purchase purchase2 : purchases) {
			System.out.println(purchase2.getIdArticle());
		}
		return "redirect:ajouterAupanierForm";
	}
	
	@RequestMapping("/listerPanier")
	public String listerPanier(Model model) {
		List<Client> clients = clientRepository.findAll();
		model.addAttribute("clients", clients);
		return "Commande/ListerPaniers";
	}
	
	
	@RequestMapping(value="/deleteFromPanier",method = RequestMethod.GET)
	public String deleFromPanier(HttpServletRequest request,String idArticle) {
		HttpSession session= request.getSession();
		List<Purchase> purchases=(List<Purchase>) session.getAttribute("panier");
		for (int i = 0; i < purchases.size(); i++) {
			if(purchases.get(i).getIdArticle().equalsIgnoreCase(idArticle)) {
				purchases.remove(i);
				
			}
		}
		
		return "redirect:listerPanier";
	}
	
	@RequestMapping(value="/ValiderCommande",method=RequestMethod.POST)
	public String validerCommande(HttpServletRequest request,Integer idClient) {
		HttpSession session= request.getSession();
		List<Purchase> purchases=(List<Purchase>) session.getAttribute("panier");
		String idCommande = Utile.getNextCodeDossiers();
		Client client = clientRepository.findOne(idClient);
		Commande c = new Commande(idCommande, new Date(), client);
		commandeRepository.save(c);
		System.out.println(c.getIdCommande() + " " + client.getIdClient());
		for (Purchase purchase : purchases) {
			metierStock.passerCommande(c.getIdCommande(), purchase.getIdArticle(), purchase.getQte(), purchase.getRemise());
		}
		session.removeAttribute("panier");
		return "redirect:listerClient";
	}
	
}
