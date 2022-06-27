package com.AirfTest;


import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;
import javax.validation.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;




@Entity
@Table(name="databaseoffer")

public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") 
	private Long id;
	
	@NotNull(message = "the firstname can't be empty")
	private String firstName;

	@NotNull(message = "the lastname can't be empty")
	private String lastName;
	
	@NotNull(message="password is mandatory")
	private String password;
	
	@Past(message = "The birthdate must be in the past ")
	@NotNull(message = "the birthdate must be higher than 18 years old, please type again")
	private Date birthDate;
	
	
	@Pattern(regexp = "^[a-zA-Z àâäèéêëîïôœùûüÿçÀÂÄÈÉŒÇ]+$", message = "the name of country can't have numeric or special characters is not allowed")
	private String countryOfResidence;
	
	@NotNull(message = "phonenumber is optional")
	private String phoneNumber;
	
	@Pattern(regexp = "(MALE|FEMALE|OTHER)$", message = "wrong type , please change")
	@NotNull(message = "gender is optional")
	private String gender;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getBirthDate() {
		return birthDate;
	}
    public void setBirthDate(int Year, int Month, int Day) {
	Calendar cal = Calendar.getInstance();
    cal.set( Year, Month, Day );
    this.birthDate = cal.getTime();
		
	}
	public String getCountryOfResidence() {
		return countryOfResidence;
	}
	public void setCountryOfResidence(String countryOfResidence) {
		this.countryOfResidence = countryOfResidence;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String string) {
		this.phoneNumber = string;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	

	
}
