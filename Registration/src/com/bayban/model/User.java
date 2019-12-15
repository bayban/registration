package com.bayban.model;

import java.math.BigDecimal;
import java.util.Date;

public class User {
	private BigDecimal mobilePhone;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String gender;
	private String email;

	public BigDecimal getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(BigDecimal mobilePhone) {
		this.mobilePhone = mobilePhone;
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
