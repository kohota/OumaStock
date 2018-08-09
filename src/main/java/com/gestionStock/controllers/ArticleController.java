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

import com.gestionStock.dao.ArticleRepository;
import com.gestionStock.dao.CategorieRepository;
import com.gestionStock.entities.Article;
import com.gestionStock.entities.Categorie;



@Controller
public class ArticleController {

	@Autowired
	private ArticleRepository articleRepository;
	@Autowired
	private CategorieRepository categorieRepository;
	
	@RequestMapping("/listerArticle")
	public String articleList(Model model,@RequestParam(name="page",defaultValue="0") int p,@RequestParam(defaultValue="5")int size) {
		Page<Article> articles = articleRepository.findAll(new PageRequest(p, size));
		int[] pages = new int[articles.getTotalPages()];
		
		model.addAttribute("articles", articles.getContent());
		model.addAttribute("nombrePages", pages);
		return "Articles/ListerArticle";
	}
	
	@RequestMapping(value = "/ajouterArticle", method = RequestMethod.POST)
			public String addClient(Article article) {
			articleRepository.save(article);
			
			
			return "redirect:listerArticle";
			}
	
	@RequestMapping(value = "/FormAddArticle")
	public String formulaireAjoutClient(Model model) {
	List<Categorie> listCategorie=	categorieRepository.findAll();
	model.addAttribute("listCategorie", listCategorie);
	model.addAttribute("article", new Article());
	return "Articles/ajouterArticle";
	}
	
}
