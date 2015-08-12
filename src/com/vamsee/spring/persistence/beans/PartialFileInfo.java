package com.vamsee.spring.persistence.beans;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PartialFileInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7848823800405516822L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="filename")
	private String fileName;
	
	@Column(name="filesize")
	private Integer fileSize;
	
	@Column(name="filecontenttype")
	private String fileContentType;
	
	@Column(name="file_uploaded_by")
	private String fileUploadedBy;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getFileUploadedBy() {
		return fileUploadedBy;
	}

	public void setFileUploadedBy(String fileUploadedBy) {
		this.fileUploadedBy = fileUploadedBy;
	}

	public Timestamp getUploadedTime() {
		return uploadedTime;
	}

	public void setUploadedTime(Timestamp uploadedTime) {
		this.uploadedTime = uploadedTime;
	}

	@Column(name="uploaded_time")
	private Timestamp uploadedTime;

	


}
