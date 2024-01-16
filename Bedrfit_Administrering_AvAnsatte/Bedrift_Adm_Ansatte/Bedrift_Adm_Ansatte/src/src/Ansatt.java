package src;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(schema="oblig3dat107_jpa")

public class Ansatt {
	
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ansattid;
	
	@Basic
	private String brukernavn;
	@Basic
	private String fornavn;
	@Basic
	private String etternavn;
	//private int ansettelsesdato;
	
	@Temporal(TemporalType.DATE)
	private java.util.Date ansettelsesdato;
	
	//localDate
	
	@Basic
	private String stilling;
	
	@Basic
	private int maanedslonn; //i oere
	
	@ManyToOne 
	@JoinColumn (name = "avdelingid")
	private Avdeling avdeling; 
	
	
	
	@OneToMany(mappedBy = "ansatt", cascade = CascadeType.PERSIST)
	public List<Ansattprosjekt> ansattprosjekt;
	
	
	
	
	public Ansatt() {
		
	}
	
	public Ansatt(  String brukernavn, String fornavn, String etternavn, Date ansettelsesdato,
			String stilling, int maanedslonn) {
		super();
		//this.ansattid = ansattid;
		this.brukernavn = brukernavn;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.ansettelsesdato = ansettelsesdato;
		this.stilling = stilling;
		this.maanedslonn = maanedslonn;
		
		
		
	}
	

	public Integer getAnsattid() {
		return ansattid;
	}

	public void setAnsattid(int ansattid) {
		this.ansattid = ansattid;
	}

	public String getBrukernavn() {
		return brukernavn;
	}

	public void setBrukernavn(String brukernavn) {
		this.brukernavn = brukernavn;
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

	
	  public java.util.Date getAnsettelsesdato() { return ansettelsesdato; }
	  
	  public void setAnsettelsesdato(java.util.Date ansettelsesdato) {
	  this.ansettelsesdato = ansettelsesdato; }
	 
	/*
	 * public int getAnsettelsesdato() { return ansettelsesdato; }
	 * 
	 * public void setAnsettelsesdato(int ansettelsesdato) { this.ansettelsesdato =
	 * ansettelsesdato; }
	 */

	public String getStilling() {
		return stilling;
	}

	public void setStilling(String stilling) {
		this.stilling = stilling;
	}

	public float getMaanedslonn() {
		return maanedslonn;
	}

	public void setMaanedslonn(int maanedslonn) {
		this.maanedslonn = maanedslonn;
	}
	//public void leggTilAnsattprosjekt(Ansattprosjekt prosjekt)
	
	
	
	///
	
	public Avdeling getAvdeling() {
		return avdeling;
	}

	public void setAvdeling(Avdeling avdeling) {
		this.avdeling = avdeling;
	}
	
	///
	
	

	@Override
	public String toString() {
		
		return String.format("Ansatt: ansattid=%d,fornavn=%s, etternavn=%s, ansettelsesdato==%s, stilling=%s, maanedslonn=%d", 
				ansattid, fornavn, etternavn, ansettelsesdato.toString(), stilling, maanedslonn);
	
				
		//return String.format("Person: id=%d, navn=%s", id, navn);
	}


}
