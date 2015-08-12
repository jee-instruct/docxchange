package com.vamsee.spring.persistence.hibernate.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="docxchange_document_info")
public class FileInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1559681641668044010L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
    @JoinColumn(name="document_id")
	private File file;
	
	@Column(name="uploaded_by")
	private String uploadedBy;
	
	@Column(name="uploaded_date")
	private Date uploadedDate;
	
	@Column(name="document_content_type")
	private String fileContentType;
	
	@Column(name="document_name")
	private String fileName;
	
	@Column(name="document_size")
	private Integer fileSize;
	
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

	public String getUploadedBy() {
		return uploadedBy;
	}

	public void setUploadedBy(String uploadedBy) {
		this.uploadedBy = uploadedBy;
	}

	public Date getUploadedDate() {
		return uploadedDate;
	}

	public void setUploadedDate(Date uploadedDate) {
		this.uploadedDate = uploadedDate;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Integer getFileSize() {
		return fileSize;
	}

	public void setFileSize(Integer fileSize) {
		this.fileSize = fileSize;
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

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public FileInfo(){
	}
	
	public FileInfo( File file, String uploadedBy,
			Date uploadedDate, String fileContentType, String fileName,
			Integer fileSize, String createdBy, String updatedBy,
			Date createdDate, Date updatedDate) {
		super();
		this.file = file;
		this.uploadedBy = uploadedBy;
		this.uploadedDate = uploadedDate;
		this.fileContentType = fileContentType;
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}
	
	
	
	
}
