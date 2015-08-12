package com.vamsee.spring.persistence.hibernate.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="docxchange_new_user_registration")
public class NewUserRegistration implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5988757567379777854L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="email_id")
	private String emailId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="job_title")
	private String jobTitle;
	
	@Column(name="user_type_id")
	private Long userTypeId;
	
	@Column(name="organization")
	private String organization;
	
	@Column(name="noOfEmployees")
	private Integer noOfEmployees;
	
	@Column(name="address1")
	private String address1;
	
	@Column(name="address2")
	private String address2;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="country")
	private String country;
	
	@Column(name="zipcode")
	private String zipcode;
	
	@Column(name="password")
	private String password;

	@Column(name="email_sent_date")
	private Date emailSentDate;
	
	@Column(name="restration_hash_code")
	private String registrationHashCode;
	
	@Column(name="registration_success_date")
	private Date registrationSuccessDate;
	
	@Column(name="email_sent_count")
	private Integer emailSentCount;
	  
	  @Column(name="created_by")
		private String createdBy;
		
		@Column(name="updated_by")
		private String updatedBy;
		
		@Column(name="created_date")
		private Date createdDate;
		
		@Column(name="updated_date")
		private Date updatedDate;
		
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "registration_status_id", nullable = false)
		private RefRegistrationStatus refRegistrationStatus;
		
		
		public NewUserRegistration(){
			
		}

		public NewUserRegistration(String emailId, String firstName,
				String lastName, String jobTitle, Long userTypeId,
				String organization, Integer noOfEmployees, String address1,
				String address2, String phoneNumber, String city, String state,
				String country, String zipcode, String password,
				String registrationHashCode,
				String createdBy, String updatedBy, Date createdDate,
				Date updatedDate, RefRegistrationStatus refRegistrationStatus) {
			super();
			this.emailId = emailId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.jobTitle = jobTitle;
			this.userTypeId = userTypeId;
			this.organization = organization;
			this.noOfEmployees = noOfEmployees;
			this.address1 = address1;
			this.address2 = address2;
			this.phoneNumber = phoneNumber;
			this.city = city;
			this.state = state;
			this.country = country;
			this.zipcode = zipcode;
			this.password = password;
			this.registrationHashCode = registrationHashCode;
			this.createdBy = createdBy;
			this.updatedBy = updatedBy;
			this.createdDate = createdDate;
			this.updatedDate = updatedDate;
			this.refRegistrationStatus = refRegistrationStatus;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
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

		public String getJobTitle() {
			return jobTitle;
		}

		public void setJobTitle(String jobTitle) {
			this.jobTitle = jobTitle;
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

		public Date getEmailSentDate() {
			return emailSentDate;
		}

		public void setEmailSentDate(Date emailSentDate) {
			this.emailSentDate = emailSentDate;
		}

		public String getRegistrationHashCode() {
			return registrationHashCode;
		}

		public void setRegistrationHashCode(String registrationHashCode) {
			this.registrationHashCode = registrationHashCode;
		}

		public Date getRegistrationSuccessDate() {
			return registrationSuccessDate;
		}

		public void setRegistrationSuccessDate(Date registrationSuccessDate) {
			this.registrationSuccessDate = registrationSuccessDate;
		}

		public Integer getEmailSentCount() {
			return emailSentCount;
		}

		public void setEmailSentCount(Integer emailSentCount) {
			this.emailSentCount = emailSentCount;
		}

		public String getCreatedBy() {
			return createdBy;
		}

		public void setCreatedBy(String createdBy) {
			this.createdBy = createdBy;
		}

		public String getUpdatedBy() {
			return updatedBy;
		}

		public void setUpdatedBy(String updatedBy) {
			this.updatedBy = updatedBy;
		}

		public Date getCreatedDate() {
			return createdDate;
		}

		public void setCreatedDate(Date createdDate) {
			this.createdDate = createdDate;
		}

		public Date getUpdatedDate() {
			return updatedDate;
		}

		public void setUpdatedDate(Date updatedDate) {
			this.updatedDate = updatedDate;
		}
		
		

}
