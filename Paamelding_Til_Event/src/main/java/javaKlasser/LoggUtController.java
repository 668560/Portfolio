package javaKlasser;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;

@Controller
	@RequestMapping("/utlogging" )
	public class LoggUtController {
		
		@GetMapping
		public String visLoggUt() {
			return "innlogging_med_melding";
		}
		
		@PostMapping
		public String loggUt (HttpServletRequest request, RedirectAttributes ra) {
			LoginUtil.loggutBruker(request.getSession());
			ra.addFlashAttribute("error_message", "Du er nå utlogget");
			
			return "redirect:innlogging_med_melding";
		}

}
