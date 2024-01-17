package javaKlasser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping (value = "/deltagerliste")
public class DeltagerListeController {
	
	@Autowired
	private DeltagerService deltagerService;
	
	
	@GetMapping
	public String visDeltagerListe(HttpServletRequest httpRequest, ModelMap model, RedirectAttributes ra) { 
		
		if(!LoginUtil.erBrukerInnlogget(httpRequest.getSession())) {
			ra.addFlashAttribute("feil", "Du må logge deg in for å gå videre");
			return"redirect:innlogging_med_melding";
		}
		
		
		
		model.addAttribute("deltagere", deltagerService.finnAlleDeltagere());
		model.addAttribute("innloggetBruker", 
				deltagerService.hentDeltager((String)httpRequest.getSession().getAttribute("mobil")));
		//System.out.println(deltagerService.hentDeltager((String)httpRequest.getSession().getAttribute("mobil")).toString());
		
		
		return "deltagerliste";
		
	}
	
	
	
	

}
