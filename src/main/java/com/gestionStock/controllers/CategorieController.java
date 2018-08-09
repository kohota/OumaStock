package com.gestionStock.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gestionStock.dao.ArticleRepository;
import com.gestionStock.dao.CategorieRepository;
import com.gestionStock.entities.Article;
import com.gestionStock.entities.Categorie;



@Controller
public class CategorieController {
	@Autowired
	private CategorieRepository categorieRepository;
	@Autowired
	private ArticleRepository articleRepository;
	
	@RequestMapping("/listerCategorie")
	public String lister(Model model,@RequestParam(name="page",defaultValue="0") int p,@RequestParam(defaultValue="5")int size) {
		Page<Categorie> categories = categorieRepository.findAll(new PageRequest(p, size));
		int[] pages = new int[categories.getTotalPages()];
		
		model.addAttribute("categories", categories.getContent());
		model.addAttribute("nombrePages", pages);
		return "Categories/ListerCategorie";
	}
	
	@RequestMapping(value = "/ajouterCategorie", method = RequestMethod.POST)
			public String add(Categorie categorie) {
			categorieRepository.save(categorie);
			
			
			return "redirect:listerCategorie";
			}
	
	@RequestMapping(value = "/FormAddCategorie")
	public String formulaireAjout(Model model) {
	model.addAttribute("categorie", new Categorie());
	return "Categories/ajouterCategorie";
	}
	
	
	@RequestMapping(value = "/categorie/articleList", method = RequestMethod.POST)
	public @ResponseBody List<Article> articleList(String idCath) {
		return articleRepository.listArticleParCategorie(idCath);
	}
}
