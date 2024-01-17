package javaKlasser;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping (value = "/paameldt")
public class PaameldtController {
	
	
	@GetMapping
	public String  visPameldingside() {
	return "paameldt";

	}
	

}
