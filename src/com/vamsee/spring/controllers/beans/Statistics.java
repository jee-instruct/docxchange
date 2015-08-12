package com.vamsee.spring.controllers.beans;

import java.io.Serializable;
import java.math.BigInteger;

import com.vamsee.spring.util.TextUtil;

public class Statistics implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8508940266890806832L;

	private String name;
	
	private String fileSize;

	public String getReadableFileSize() {
		return TextUtil.readableFileSize(getValue());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}

	private Long value;

	public Statistics() {

	}

	public Statistics(String name, BigInteger value) {
		super();
		this.name = name;
		this.value = value.longValue();
	}

}
