package com.vamsee.spring.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vamsee.spring.hibernate.dao.FileDAO;
import com.vamsee.spring.persistence.hibernate.entities.File;
import com.vamsee.spring.services.FileService;

@Service
public class FileServiceImpl implements FileService {
	
	@Autowired
	private FileDAO fileDAO;

	@Override
	public File getFileById(Long Id) {
		// TODO Auto-generated method stub
		return fileDAO.getFileById(Id);
	}

}
