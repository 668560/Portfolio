package javaKlasser;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/innlogging_med_melding")
public class LogInController {
	
	
		@Autowired
		private DeltagerService deltagerService;
		
		@Autowired
		private PassordService passordService;
		
		
		@GetMapping
		public String visLogInSide() {
			
			return"innlogging_med_melding";
			
		}
		
		@PostMapping
		public String loggInn (@RequestParam String mobil, @RequestParam String passord,
				HttpServletRequest request, RedirectAttributes ra ,HttpSession httpSession) {
			
			
			
			
			
			Deltager deltager = deltagerService.hentDeltager(mobil);
		
			if (deltager == null) {
				
						ra.addFlashAttribute("error_message", "bruker finnes ikke, prøv å skrive inn tlf nummer passord på nytt");
				return"redirect:innlogging_med_melding";
			}
			
		
			
			if(deltager !=null && !passordService.erKorrektPassord(passord, deltager.getSalt(), deltager.getHash())) {
				ra.addFlashAttribute("error_message", "passord er feil");
				return"redirect:innlogging_med_melding";
			}
			
			
		/////////
			
			
			
			
			
			
			httpSession.setAttribute("mobil", mobil);
			httpSession.setAttribute("erBrukerInnlogget",true);
			return "redirect:deltagerliste";
			
		}
		


	
	
	
	
	

}
