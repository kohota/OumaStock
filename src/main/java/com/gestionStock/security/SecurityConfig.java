package com.gestionStock.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("1234").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("user").password("1234").roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin().loginPage("/login");
		http.csrf().disable();
		http.exceptionHandling().accessDeniedPage("/errorpage");
		http.authorizeRequests().antMatchers("/listerArticle","/ajouterArticle","/FormAddArticle","/listerCategorie","/ajouterCategorie","/FormAddCategorie","/categorie/articleList").hasRole("ADMIN");
		http.authorizeRequests().antMatchers("/listerClient","/ajouterClient","/FormAddClient","/client/commandeList","/Panier","/ajouterAupanierForm","/ajouterAuPanier","/listerPanier","/deleteFromPanier","/ValiderCommande").hasRole("USER");
	}

}
