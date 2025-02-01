package com.samer.Enaip.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;

import com.samer.Enaip.Ripository.StudentiRepository;
import com.samer.Enaip.Servizi.GoldPriceService;
import com.samer.Enaip.Servizi.StudentiServizi;
import com.samer.Enaip.modelli.GoldPrice;
import com.samer.Enaip.modelli.Studenti;


import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import java.util.*;
@Controller
@RequestMapping("/Enaip/Studenti")
public class StudentiController {

	@Autowired
	StudentiRepository stRp;
	@Autowired
	StudentiServizi stSc;
	
	
	@GetMapping({"","/"})

	public String index(
			Model model
			) {
	long i=	(long)stSc.ListaStudenti();
	model.addAttribute("count", i);
	return ("/Studenti/index");
	}
	
	@GetMapping("/listaStudenti")
	public String stampaAll(
			Model model
			) {
	ArrayList<Studenti>lista = (ArrayList<Studenti>) stSc.stampaAll();
	model.addAttribute("Lista", lista);
		return ("/Studenti/studenti");
	}
	
	 @GetMapping("/edit/{matricola}")
	 public String showEditForm(
			 @PathVariable Long matricola,
			 Model model
			 
			 ) {
		Studenti studente = stSc.getStudentiById(matricola);
		model.addAttribute("studente", studente);
		return ("/Studenti/Studenti-form");
		 
	 }
	 
	 @GetMapping("/new")
	    public String showCreateForm(
	    		Model model
	    		) {
	    	
	        model.addAttribute("studente", new Studenti());
	        return ("/Studenti/Studenti-form");
	    }
	 
	 
	 
	 // Salva un nuovo utente con validazione
	    @PostMapping("/save")
	    public String saveUser(
	    		@Valid @ModelAttribute("studente") Studenti studente,
	    		BindingResult result,
	    		Model model
	    		
	    		) {
	        if (result.hasErrors()) {
	            return "Studenti/Studenti-form";  // Ritorna al form se ci sono errori di validazione
	        }
	       
	    	model.addAttribute("studente", studente);
	        stSc.saveUser(studente);
	        return "redirect:/Enaip/Studenti/listaStudenti";
	    }

	    @GetMapping("/delete/{matricola}")
	    public String deleteStudente
	    (
	    		@PathVariable Long matricola
	    		){
			stSc.deleteStudente(matricola);
			 return "redirect:/Enaip/Studenti/listaStudenti";
	    }
	    
	    @Autowired
	    private GoldPriceService goldPriceService;

	    @GetMapping("/gold-price")
	    public String getGoldPrice(Model model) {
	        GoldPrice goldPrice = goldPriceService.getGoldPrice(); // Recupera il prezzo dell'oro
	        model.addAttribute("goldPrice", goldPrice); // Aggiungi l'oggetto goldPrice al modello
	        System.out.println("gold: " + goldPrice.getExchangeRate()); // Stampa il valore per debug
	        return "gold-price"; // Nome del template
	    }
	 
	 
}
