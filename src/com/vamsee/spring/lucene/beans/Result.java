package com.vamsee.spring.lucene.beans;

import java.io.Serializable;

public class Result implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4427576772241556122L;
	
	private String text;
	private String fileName;
	private String id;
	private String userIdentifier;
	private String fileContentType;
	private String date;
	private String time;
	
	private String fileDownloadURL;
	
	
	public Result(){
		
	}

	public Result(String text, String fileName, String id,
			String userIdentifier, String fileContentType, String date,
			String time) {
		super();
		this.text = text;
		this.fileName = fileName;
		this.id = id;
		this.userIdentifier = userIdentifier;
		this.fileContentType = fileContentType;
		this.date = date;
		this.time = time;
	}

	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getUserIdentifier() {
		return userIdentifier;
	}



	public void setUserIdentifier(String userIdentifier) {
		this.userIdentifier = userIdentifier;
	}



	public String getFileContentType() {
		return fileContentType;
	}



	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getFileDownloadURL() {
		return "/docxchange/file/downloadfile/"+getId();
	}

	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	@Override
	public String toString() {
		return "Result [text=" + text + ", fileName=" + fileName + ", id=" + id
				+ "]";
	}



}
