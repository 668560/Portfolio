package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity

//Lombok 
@Getter
@Setter
@RequiredArgsConstructor
@ToString

public class Restaurant {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	//contact-info
	private String city;
	private String zipCode;
	private String phone;
	private String url_webpage;
	
	//scores
	private int peanutScore;
	private int eggScore;
	private int dairyScore;
	private int overallScore;
	
	
	public Restaurant(String name, String city, String zipCode, String phone, String url_webpage, int peanutScore,
			int eggScore, int dairyScore, int overallScore) {
		super();
		this.name = name;
		this.city = city;
		this.zipCode = zipCode;
		this.phone = phone;
		this.url_webpage = url_webpage;
		this.peanutScore = peanutScore;
		this.eggScore = eggScore;
		this.dairyScore = dairyScore;
		this.overallScore = overallScore;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUrl_webpage() {
		return url_webpage;
	}
	public void setUrl_webpage(String url_webpage) {
		this.url_webpage = url_webpage;
	}
	public int getPeanutScore() {
		return peanutScore;
	}
	public void setPeanutScore(int peanutScore) {
		this.peanutScore = peanutScore;
	}
	public int getEggScore() {
		return eggScore;
	}
	public void setEggScore(int eggScore) {
		this.eggScore = eggScore;
	}
	public int getDairyScore() {
		return dairyScore;
	}
	public void setDairyScore(int dairyScore) {
		this.dairyScore = dairyScore;
	}
	public int getOverallScore() {
		return overallScore;
	}
	public void setOverallScore(int score) {
		this.overallScore = score;
	}

	
}
