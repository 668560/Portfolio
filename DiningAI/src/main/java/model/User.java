package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity

//Lombok 
@Getter
@Setter
@RequiredArgsConstructor

public class User {

//User_info
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
private String displayName;
//contact_info
private String city;
private String state;
private String zipcode;
//preferences
private Boolean peanutAllergy;
private Boolean eggAllergy;
private Boolean diaryAllergy;


public User(String displayName, String city, String state, String zipcode, Boolean peanutAllergy,
		Boolean eggAllergy, Boolean diaryAllergy) {
	super();
	this.displayName = displayName;
	this.city = city;
	this.state = state;
	this.zipcode = zipcode;
	this.peanutAllergy = peanutAllergy;
	this.eggAllergy = eggAllergy;
	this.diaryAllergy = diaryAllergy;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getDisplayName() {
	return displayName;
}
public void setDisplayName(String displayName) {
	this.displayName = displayName;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getZipcode() {
	return zipcode;
}
public void setZipcode(String zipcode) {
	this.zipcode = zipcode;
}
public Boolean getPeanutAllergy() {
	return peanutAllergy;
}
public void setPeanutAllergy(Boolean peanutAllergy) {
	this.peanutAllergy = peanutAllergy;
}
public Boolean getEggAllergy() {
	return eggAllergy;
}
public void setEggAllergy(Boolean eggAllergy) {
	this.eggAllergy = eggAllergy;
}
public Boolean getDiaryAllergy() {
	return diaryAllergy;
}
public void setDiaryAllergy(Boolean diaryAllergy) {
	this.diaryAllergy = diaryAllergy;
}
@Override
public String toString() {
	return "User [id=" + id + ", displayName=" + displayName + ", city=" + city + ", state=" + state + ", zipcode="
			+ zipcode + ", peanutAllergy=" + peanutAllergy + ", eggAllergy=" + eggAllergy + ", diaryAllergy="
			+ diaryAllergy + "]";
}


}
