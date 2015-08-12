package com.vamsee.spring.lucene.beans;

import java.io.Serializable;
import java.util.ArrayList;

public class IndexFile implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3173216244943242142L;
	
	private String fileName;
	private String fileId;
	private String fileContent;
	private ArrayList<String>  textStrings;
	private ArrayList<String>  suggestStrings;
	private String userIdentifier;
	
	public IndexFile (){

	}
	
	public IndexFile(String fileName, String fileId,
			ArrayList<String> textStrings, ArrayList<String> suggestStrings,String userIdentifier) {
		super();
		this.fileName = fileName;
		this.fileId = fileId;
		this.textStrings = textStrings;
		this.suggestStrings = suggestStrings;
		this.userIdentifier = userIdentifier;
	}

	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileId() {
		return fileId;
	}
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public String getFileContent() {
		return fileContent;
	}

	public void setFileContent(String fileContent) {
		this.fileContent = fileContent;
	}

	public ArrayList<String> getTextStrings() {
		return textStrings;
	}

	public void setTextStrings(ArrayList<String> textStrings) {
		this.textStrings = textStrings;
	}

	public ArrayList<String> getSuggestStrings() {
		return suggestStrings;
	}

	public void setSuggestStrings(ArrayList<String> suggestStrings) {
		this.suggestStrings = suggestStrings;
	}

	public String getUserIdentifier() {
		return userIdentifier;
	}

	public void setUserIdentifier(String userIdentifier) {
		this.userIdentifier = userIdentifier;
	}
	
	

}
