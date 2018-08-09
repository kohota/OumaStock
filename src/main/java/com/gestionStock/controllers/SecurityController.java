package com.gestionStock.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.descriptor.web.ErrorPage;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {

	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/errorpage")
	public String errorPage() {
		return "erreur";
	}
	
	@RequestMapping("/")
	public String home() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String role= authentication.getAuthorities().toString();
		if(role.equalsIgnoreCase("[ROLE_USER]")) {
			return "redirect:listerClient";
		}
		if(role.equalsIgnoreCase("[ROLE_ADMIN]")) {
			return "redirect:listerCategorie";
		}
		return "redirect:logout";
	}
	
	@RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request) {
        System.out.println("logout()");
        HttpSession httpSession = request.getSession();
        httpSession.invalidate();
        return "redirect:login";
    }
}
