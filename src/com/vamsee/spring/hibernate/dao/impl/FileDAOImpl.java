package com.vamsee.spring.hibernate.dao.impl;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vamsee.spring.hibernate.dao.FileDAO;
import com.vamsee.spring.persistence.hibernate.entities.File;

@Repository
@Transactional(readOnly = true)
public class FileDAOImpl implements FileDAO {
	private static final Logger LOGGER = Logger.getLogger(FileDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Long PersistFile(File file) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(file);
		return file.getId();
	}

	@Override
	public File getFileById(Long id) {
		// TODO Auto-generated method stub
		return (File) sessionFactory.getCurrentSession().get(File.class, id);
	}

}
