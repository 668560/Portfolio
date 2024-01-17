package javaKlasser;

import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.validation.constraints.Size;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="deltager", schema ="deltager")
public class Deltager {
	
	
	@Id
	@Pattern(regexp = "^\\d{8}$", message="Mobilnummer må være eksakt 8 sifre")
	@NotNull(message = "Mobil er obligatorisk")
	private String mobil;	
	
	@Size(min=2, message="Navn må inneholde minst 2 tegn")
	@Size(max=20, message="Navn kan inneholde max 12 tegn")
	@NotNull(message = "Fornavn er obligatorisk")
	private String fornavn;
	
	@Size(min=2, message="Etternavn må inneholde minst 2 tegn")
	@Size(max=20, message="Navn kan inneholde max 12 tegn")
	@NotNull(message = "Etternavn er obligatorisk")
	private String etternavn;
	
	
	@NotNull(message="passord kan ikke vaere null")
	private String hash;
	
	@NotNull(message="passord kan ikke vaere null")
	private String salt;
	
	
	@NotNull
	@Pattern(regexp = "^(mann)|(kvinne)$", message="Må være Mann eller Kvinne")
	private String kjonn;
	
	

	public Deltager() {
		super();
		
	}
	

		

	public Deltager(@Pattern(regexp = "^\\d{8}$", message="Mobilnummer må være eksakt 8 sifre") @NotNull(message = "Mobil er obligatorisk") String mobil,
			@Size(min = 2, message = "Navn må inneholde minst 2 tegn") @Size(max = 20, message = "Navn kan inneholde max 12 tegn") @NotNull(message = "Fornavn er obligatorisk") String fornavn,
			@Size(min = 2, message = "Etternavn må inneholde minst 2 tegn") @Size(max = 20, message = "Navn kan inneholde max 12 tegn") @NotNull(message = "Etternavn er obligatorisk") String etternavn,
			@NotNull(message = "passord kan ikke vaere null") String hash,
			@NotNull(message = "passord kan ikke vaere null") String salt, @NotNull String kjonn) {
		super();
		this.mobil = mobil;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.hash = hash;
		this.salt = salt;
		this.kjonn = kjonn;
	}




	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public String getMobil() {
		return mobil;
	}

	public void setMobil(String mobil) {
		this.mobil = mobil;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}


	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getKjonn() {
		return kjonn;
	}

	public void setKjonn(String kjonn) {
		this.kjonn = kjonn;
	}

	@Override
	public String toString() {
		return "Deltager [fornavn=" + fornavn + ", etternavn=" + etternavn + ", mobil=" + mobil
				+ ", kjonn=" + kjonn + "]";
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
