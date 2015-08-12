package com.vamsee.spring.hibernate.dao;

import com.vamsee.spring.persistence.hibernate.entities.File;

public interface FileDAO {
	
	public Long PersistFile(File file);
	public File getFileById(Long id);

}
