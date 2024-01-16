package src;

import java.util.List;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(schema = "oblig3dat107_jpa")

public class Avdeling {
	
	
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int avdelingid;
	
	@Basic	
	String navn;
	
	
	@OneToOne (cascade = CascadeType.PERSIST)
	@JoinColumn(name = "sjef", referencedColumnName = "ansattid") //eller omvendt
	Ansatt sjef;
	
	@OneToMany (mappedBy = "avdeling", cascade = CascadeType.PERSIST)
	private List<Ansatt> ansatte;
	
	public Avdeling() {}
	
	public Avdeling(String navn, Ansatt sjef) {
		super();
		//this.avdelingid = avdelingid;
		this.navn = navn;
		this.sjef = sjef;
	}

	public int getAvdelingid() {
		return avdelingid;
	}

	public void setAvdelingid(int avdelingid) {
		this.avdelingid = avdelingid;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public Ansatt getSjef() {
		return sjef;
	}

	public void setSjef(Ansatt sjef) {


		this.sjef = sjef;
	}

	
	
	public List<Ansatt> getAnsatte() {
		return ansatte;
	}

	public void setAnsatte(List<Ansatt> ansatte) {
		this.ansatte = ansatte;
	}

	@Override
	public String toString() {

		return String.format("Avdelingid: avdelingid=    %d,    navn=   %s, sjef=%s", avdelingid, navn, sjef.toString());

	}
}