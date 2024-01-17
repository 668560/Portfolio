 package javaKlasser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
@RequestMapping (value = "/start")
public class PaameldingController {

	@Autowired
	private DeltagerService deltagerService;
	 
	@Autowired
	private PassordService passordSevice;
	
	@GetMapping
	public String mottattRegistrering() {
		return "paamelding_med_melding";
	}
	
	
	@PostMapping
	public String sjekkDeltager(
			@Valid @ModelAttribute("deltager") Deltager deltager, BindingResult bindingResult, Model model, 
			HttpServletRequest request, RedirectAttributes ra) {
		
		if (bindingResult.hasErrors()) {
			String feilmeldinger = bindingResult.getAllErrors().stream()
					.map(e -> e.getDefaultMessage())
					.reduce("", (f, e) -> f + e +"<br>");
			
			model.addAttribute("feilmeldinger", feilmeldinger);
			
		//	System.err.println(feilmeldinger);
			return "paamelding_med_melding";
			
			
		}
	
		
		 if (!deltagerService.passordLikTest(deltager.getHash(),deltager.getSalt()))
		 {
		 ra.addFlashAttribute("feil", "Passordene er ulike");
		// System.out.println("feil, Passordene er ulike");
	return "redirect:start";
}
		
		
	
	 boolean lageDeltager = deltagerService.opretteDeltaker(
				deltager.getMobil(), 
				deltager.getFornavn(), 
				deltager.getEtternavn(),
				deltager.getHash(), 
				deltager.getSalt(), 
				deltager.getKjonn()
				);
	 
	 if (!lageDeltager) {
			ra.addFlashAttribute("feil", "Kunne ikke registrere deltager, telefonnummer er allerede i bruk");
			return "redirect:start";
		}
	 
	 
	
		
		
	 // hvis  deltager lagt riktig ,  logg in automatisk
		Deltager eksisterendeDeltager = deltagerService.hentDeltager(deltager.getMobil());
		LoginUtil.loggInnBruker(request, eksisterendeDeltager.getMobil());
		
		ra.addFlashAttribute("fornavn", eksisterendeDeltager.getFornavn());
		ra.addFlashAttribute("etternavn", eksisterendeDeltager.getEtternavn());
		ra.addFlashAttribute("mobil", eksisterendeDeltager.getMobil());
		ra.addFlashAttribute("kjonn", eksisterendeDeltager.getKjonn());
	
	
		
	 return "redirect:paameldt";      	
	}
	
	
	
	//public String hvisPaameldtSide() {return "paameldt";}
	
	
	
	
	
	
	
	
}


