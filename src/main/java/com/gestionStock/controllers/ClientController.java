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

import com.gestionStock.dao.ClientRepository;
import com.gestionStock.entities.Client;
import com.gestionStock.entities.Commande;
import com.gestionStock.service.IGestionStock;

@Controller
public class ClientController {
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private IGestionStock gestionStock;
	@RequestMapping("/listerClient")
	public String clientV(Model model,@RequestParam(name="page",defaultValue="0") int p,@RequestParam(defaultValue="5")int size) {
		Page<Client> clients = clientRepository.findAll(new PageRequest(p, size));
		int[] pages = new int[clients.getTotalPages()];
		
		model.addAttribute("clients", clients.getContent());
		model.addAttribute("nombrePages", pages);
		return "Clients/ListerClient";
	}
	
	@RequestMapping(value = "/ajouterClient", method = RequestMethod.POST)
			public String addClient(Client client) {
			clientRepository.save(client);
			
			
			return "redirect:listerClient";
			}
	
	@RequestMapping(value = "/FormAddClient")
	public String formulaireAjoutClient(Model model) {
	model.addAttribute("client", new Client());
	return "Clients/ajouterClient";
	}
	
	@RequestMapping(value = "/client/commandeList", method = RequestMethod.POST)
	public @ResponseBody List<Commande> commandeList(Integer idClient) {
		return gestionStock.listCommandeParClient(idClient);
	}

	
}
