package src;

import java.util.Iterator;
import java.util.List;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(schema = "oblig3dat107_jpa")

public class Prosjekt {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO
	private int prosjektid;
	
	@Basic
	private String prosjektnavn;
	
	@Basic
	private String prosjektbeskrivelse;
	
	
	
	@OneToMany(mappedBy = "prosjekt", cascade = CascadeType.PERSIST)
		private List<Ansattprosjekt> ansattprosjekt;

	
	public Prosjekt () {}
	
	public Prosjekt(String prosjektnavn, String prosjektbeskrivelse) {
		super();
		// this.prosjektid = prosjektid;
		this.prosjektnavn = prosjektnavn;
		this.prosjektbeskrivelse = prosjektbeskrivelse;
		
	}
	
	

	
	

	public int getProsjektid() {
		return prosjektid;
	}


	public void setProsjektid(int prosjektid) {
		this.prosjektid = prosjektid;
	}

	public String getProsjektnavn() {
		return prosjektnavn;
	}


	public void setProsjektnavn(String prosjektnavn) {
		this.prosjektnavn = prosjektnavn;
	}

	public String getProsjektbeskrivelse() {
		return prosjektbeskrivelse;
	}

	public void setProsjektbeskrivelse(String prosjektbeskrivelse) {
		this.prosjektbeskrivelse = prosjektbeskrivelse;
	}

	
	

	public void leggTilAnsatt(Ansatt a, String rolle) {
		Ansattprosjekt ap =new Ansattprosjekt(a, this, 0, rolle);
		
		
		ansattprosjekt.add(ap);
		
		a.ansattprosjekt.add(ap);
		
	}
	
	
	public String prosjektUtskrift() {
		
		Double totTimer =0.0; 
		String ut = "" 
		+ prosjektnavn + " " + "\n " 
		+  prosjektbeskrivelse 
		+ "\n \n";
		
		
		
		 Iterator <Ansattprosjekt> it = ansattprosjekt.iterator();
		
		while (it.hasNext()) {
		 
			Ansattprosjekt aat = it.next();
			
		totTimer += aat.getArbeidstimer();	
		
		ut += 
		"Fornavn: "+ aat.getAnsatt().getFornavn() + "\n" + 
		"Etternavn: "+ aat.getAnsatt().getEtternavn()+ "\n" + 
		"Rolle: " + aat.getRolle() + "\n" +
		"Arbeidstimer: " + aat.getArbeidstimer() + "\n" + 
		"Total arbeidstimer: " + 	totTimer +"\n \n";
		
		
		
		
	}
		
		
		return ut;
	}	
	

	
	
	public String toString() {
		
		return String.format("Prosjekt: prosjektid=%d,prosjektnavn=%s, prosjektbeskrivelse=%s",
				prosjektid, prosjektnavn, prosjektbeskrivelse);
	
				
	}
}