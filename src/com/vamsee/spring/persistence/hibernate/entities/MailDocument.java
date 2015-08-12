package com.vamsee.spring.persistence.hibernate.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="docxchange_mail_document")
public class MailDocument implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 182422958937137169L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="document_id")
	private Integer documentId;
	
	@Column(name="mail_document_status_id")
	private Integer mailDocumentStatusId;
	
	@Column(name="mail_document_exception")
	private String mailDocumentException;
	
	@Column(name="mail_from_user_email")
	private String userEmail;
	
	@Column(name="mail_user_sent_date")
	private Date userSentDate;
	
	@Column(name="mail_document_hashcode")
	private String mailDocumentHashCode;
	
	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="updated_by")
	private String updatedBy;
	
	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="updated_date")
	private Date updatedDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getDocumentId() {
		return documentId;
	}

	public void setDocumentId(Integer documentId) {
		this.documentId = documentId;
	}

	public Integer getMailDocumentStatusId() {
		return mailDocumentStatusId;
	}

	public void setMailDocumentStatusId(Integer mailDocumentStatusId) {
		this.mailDocumentStatusId = mailDocumentStatusId;
	}

	public String getMailDocumentException() {
		return mailDocumentException;
	}

	public void setMailDocumentException(String mailDocumentException) {
		this.mailDocumentException = mailDocumentException;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Date getUserSentDate() {
		return userSentDate;
	}

	public void setUserSentDate(Date userSentDate) {
		this.userSentDate = userSentDate;
	}

	public String getMailDocumentHashCode() {
		return mailDocumentHashCode;
	}

	public void setMailDocumentHashCode(String mailDocumentHashCode) {
		this.mailDocumentHashCode = mailDocumentHashCode;
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
