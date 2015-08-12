package com.vamsee.spring.hibernate.dao.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vamsee.spring.hibernate.dao.NewUserRegistrationDAO;
import com.vamsee.spring.persistence.hibernate.entities.NewUserRegistration;

@Repository
@Transactional
public class NewUserRegistrationDAOImpl implements NewUserRegistrationDAO {

	private static final Logger LOGGER = Logger.getLogger(NewUserRegistrationDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public boolean checkIfUserAlreadyRegistered(String emailId) {
		// TODO Auto-generated method stub
		List<NewUserRegistration> registeredUsers =  sessionFactory.getCurrentSession().createQuery("from NewUserRegistration where emailId = :emailId").setParameter("emailId", emailId).list();
		if(CollectionUtils.isNotEmpty(registeredUsers)){
			return true;
		}
		return false;
	}


	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Long persistNewRegistration(NewUserRegistration newUserRegistration) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(newUserRegistration);
		return newUserRegistration.getId();
	}

}
