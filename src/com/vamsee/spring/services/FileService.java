package com.vamsee.spring.services;

import com.vamsee.spring.persistence.hibernate.entities.File;

public interface FileService {
	
	public File getFileById(Long Id);
	
	

}
