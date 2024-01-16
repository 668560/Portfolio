package src;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;




@Entity
@Table(schema = "oblig3dat107_jpa")

@IdClass(CompositeKey.class)


public class Ansattprosjekt {
	
	
	

	@Id
	//@GeneratedValue(strategy = GeneratedType.AUTO)
	@ManyToOne 
	@JoinColumn(name = "ansattid") //referencedColumnName = "ansattid)
	private Ansatt ansatt;
	
	@Id
	 @ManyToOne
	//@GeneratedValue(strategy = GeneratedType.AUTO)
	@JoinColumn(name = "prosjektid")
	private Prosjekt prosjekt;
	
	//evt SERIAL kolonne
	
	
	//OBS primernøkkel klasse 
	
	@Basic
	private double arbeidstimer;
	
	@Basic
	private String rolle;
	
	//TODO
	
	//@Id 
	//CompositeKey nokkel = new CompositeKey();
	

	public Ansattprosjekt() {
		
	}

	
	public Ansattprosjekt(Ansatt ansatt, Prosjekt prosjekt, double arbeidstimer, String rolle) {
		super();
		this.ansatt = ansatt;
		this.prosjekt = prosjekt;
		//ansatt.leggTilnsattprosjekt
		this.arbeidstimer = arbeidstimer;
		this.rolle = rolle;
	}

	public Ansatt getAnsatt() {
		return ansatt;
	}

	public void setAnsatt(Ansatt ansattr) {
		this.ansatt = ansattr;
	}

	public Prosjekt getProsjekt() {
		return prosjekt;
	}

	public void setProsjekt(Prosjekt prosjektr) {
		this.prosjekt = prosjektr;
	}

	public double getArbeidstimer() {
		return arbeidstimer;
	}

	public void setArbeidstimer(double arbeidstimer) {
		this.arbeidstimer = arbeidstimer;
	}

	public String getRolle() {
		return rolle;
	}

	public void setRolle(String rolle) {
		this.rolle = rolle;
	}
	

	//public double nokkel() {
		//return nokke;
	
	
	///
	public void timeforing(double arbeidstimer) {
		
		
		this.arbeidstimer+= arbeidstimer;
		
	}
	
	
	
	
	
}