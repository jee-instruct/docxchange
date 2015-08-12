package com.vamsee.spring.persistence.hibernate.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="ref_registration_status")
public class RefRegistrationStatus implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5084966613521704673L;

	@Id
	private Long id;
	
	@Column(name="registration_status")
	private String registrationStatus;
	
	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="updated_by")
	private String updatedBy;
	
	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="updated_date")
	private Date updatedDate;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "refRegistrationStatus")
	private List<NewUserRegistration> registrations;
	

	public List<NewUserRegistration> getRegistrations() {
		return registrations;
	}

	public void setRegistrations(List<NewUserRegistration> registrations) {
		this.registrations = registrations;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRegistrationStatus() {
		return registrationStatus;
	}

	public void setRegistrationStatus(String registrationStatus) {
		this.registrationStatus = registrationStatus;
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
