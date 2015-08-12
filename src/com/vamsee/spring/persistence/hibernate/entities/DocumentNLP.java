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
@Table(name="docxchange_document_nlp")
public class DocumentNLP implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4054895221446390102L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="document_id")
	private Integer documentId;
	
	@Column(name="nlp_type")
	private String nlpType;
	
	@Column(name="nlp_discovery")
	private String nlpDiscovery;
	
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

	public String getNlpType() {
		return nlpType;
	}

	public void setNlpType(String nlpType) {
		this.nlpType = nlpType;
	}

	public String getNlpDiscovery() {
		return nlpDiscovery;
	}

	public void setNlpDiscovery(String nlpDiscovery) {
		this.nlpDiscovery = nlpDiscovery;
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
