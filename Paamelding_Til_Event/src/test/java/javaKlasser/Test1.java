package javaKlasser;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

@ExtendWith(MockitoExtension.class) 
public class Test1 {
	
	
	
	
	
	
	private Validator  validator = Validation.buildDefaultValidatorFactory().getValidator();
	
	
	
	@Test
	public void etGyldigNavn() {
		Deltager deltager = new Deltager("55555555", "Nils","Nilsen", "1234", "1234", "kvinne");
		assertTrue(erGyldigEgenskap(deltager, "fornavn"));
		
		
	}
	
	
	
		@Test
		public void etUgyldigNavn() {
			Deltager deltager = new Deltager("55555555", "s","Nilsen", "1234", "1234", "kvinne");
			assertFalse(erGyldigEgenskap(deltager, "fornavn"));
		
	}
		
		
	
	@ParameterizedTest
	@ValueSource (strings = {"", "B", "klmlkmfllkfmlkmm32lk3mllkm"})
	public void ugyldigeNavn(String navnFraListe) {
		
		
		Deltager deltager = new Deltager("55555555", navnFraListe,"Nilsen", "1234", "1234", "kvinne");
		
	
				  assertFalse(erGyldigEgenskap(deltager,"fornavn"));
				
				
	}
	
	
	@ParameterizedTest
	@ValueSource (strings = {"Anders", "Helene-Mari", "Qu"})
	public void GyldigeNavn(String navnFraListe) {
		
		
		Deltager deltager = new Deltager("55555555", navnFraListe,"Nilsen", "1234", "1234", "kvinne");
		
	
				  assertTrue(erGyldigEgenskap(deltager,"fornavn"));
				
				
	}


	@ParameterizedTest
	@ValueSource (strings = {"", "B", "klmlkmfllkfmlkmm32lk3mllkm"})
	public void UgyldigeEtternavn(String navnFraListe) {
		
		
		Deltager deltager = new Deltager("55555555", "Nils",navnFraListe, "1234", "1234", "kvinne");
		
	
				  assertFalse(erGyldigEgenskap(deltager,"etternavn"));
				
				
	}
	
	
	@ParameterizedTest
	@ValueSource (strings = {"Morricone", "Einstein", "Alldin"})
	public void GyldigeEtternavn(String navnFraListe) {
		
		
		Deltager deltager = new Deltager("55555555", "Nils",navnFraListe, "1234", "1234", "kvinne");
		
	
				  assertTrue(erGyldigEgenskap(deltager,"etternavn"));
				
				
	}
	
	
	
	@ParameterizedTest
	@ValueSource (strings = {"12345678", "00090009", "23223221"})
	public void GyldigeMobilnr(String mobilNrListe) {
		
		
		Deltager deltager = new Deltager(mobilNrListe, "Gitte" ,"Nilsen", "1234", "1234", "kvinne");
		
	
				  assertTrue(erGyldigEgenskap(deltager,"mobil"));
				
				
	}

	
	@ParameterizedTest
	@ValueSource (strings = {"12", "", "1234567890", "AdSdsdsd"})
	public void UgyldigeMobilnr(String mobilNrListe) {
		
		
		Deltager deltager = new Deltager(mobilNrListe, "Gitte" ,"Nilsen", "1234", "1234", "kvinne");
		
	
				  assertFalse(erGyldigEgenskap(deltager,"mobil"));
							
	}
	
	@ParameterizedTest
	@ValueSource (strings = {"kvinne", "mann"})
	public void GyldigeKjonn(String kjoennListe) {
		
		
		Deltager deltager = new Deltager( "12345678","Gitte" ,"Nilsen", "1234", "1234", kjoennListe);
		
	
				  assertTrue(erGyldigEgenskap(deltager,"kjonn"));
				
	}
	
	@ParameterizedTest
	@ValueSource (strings = {"Hen", "", "Hønu"})
	public void UgyldigeKjonn(String kjoennListe) {
		
		
		Deltager deltager = new Deltager("12345678","Gitte" ,"Nilsen", "1234", "1234", kjoennListe);
		
	
				  assertFalse(erGyldigEgenskap(deltager,"kjonn"));
	
				  
	}
	
	
	
	
	private boolean erGyldigEgenskap(Deltager deltager, String egenskap) {
		
		return !validator.validate(deltager).stream()			//Strøm av alle feil (ConstraintViolations)
				.map(v -> v.getPropertyPath().toString())	//Strøm av alle "egenskaper" med feil
				.collect(Collectors.toSet())				//Samlet opp i et Set av "egenskaper" med feil
				.contains(egenskap);						//Om den "egenskapen" vi lurer på har feil
	}
	
	
	
	
	
	

}


