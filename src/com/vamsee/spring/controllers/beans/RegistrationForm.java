package com.vamsee.spring.controllers.beans;

import java.io.Serializable;
import java.util.List;

import com.vamsee.spring.persistence.hibernate.entities.RefUserType;

public class RegistrationForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 661573316128053616L;
	
	private String emailId;
	private String firstName;
	private String lastName;
	private Long userTypeId;
	private String organization;
	private String jobTitle;
	private Integer noOfEmployees;
	private String address1;
	private String address2;
	private String phoneNumber;
	private String city;
	private String state;
	private String country;
	private String zipcode;
	private String password;
	private List<RefUserType> userTypes;
	
	
	public RegistrationForm(){
		
	}
	
	public RegistrationForm(List<RefUserType> userTypes) {
		super();
		this.userTypes = userTypes;
	}

	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
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
	public Long getUserTypeId() {
		return userTypeId;
	}
	public void setUserTypeId(Long userTypeId) {
		this.userTypeId = userTypeId;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public Integer getNoOfEmployees() {
		return noOfEmployees;
	}
	public void setNoOfEmployees(Integer noOfEmployees) {
		this.noOfEmployees = noOfEmployees;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<RefUserType> getUserTypes() {
		return userTypes;
	}
	public void setUserTypes(List<RefUserType> userTypes) {
		this.userTypes = userTypes;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	@Override
	public String toString() {
		return "RegistrationForm [emailId=" + emailId + ", firstName="
				+ firstName + ", lastName=" + lastName + ", userTypeId="
				+ userTypeId + ", organization=" + organization + ", jobTitle="
				+ jobTitle + ", noOfEmployees=" + noOfEmployees + ", address1="
				+ address1 + ", address2=" + address2 + ", phoneNumber="
				+ phoneNumber + ", city=" + city + ", state=" + state
				+ ", country=" + country + ", zipcode=" + zipcode
				+ ", password=" + password + "]";
	}

	
	
	
}
