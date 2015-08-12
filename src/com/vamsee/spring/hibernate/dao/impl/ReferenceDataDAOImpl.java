package com.vamsee.spring.hibernate.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vamsee.spring.hibernate.dao.ReferenceDataDAO;
import com.vamsee.spring.persistence.hibernate.entities.RefMailStatus;
import com.vamsee.spring.persistence.hibernate.entities.RefRegistrationStatus;
import com.vamsee.spring.persistence.hibernate.entities.RefUserRole;
import com.vamsee.spring.persistence.hibernate.entities.RefUserType;

@Repository
@Transactional(readOnly = true)
public class ReferenceDataDAOImpl implements ReferenceDataDAO {

	private static final Logger LOGGER = Logger.getLogger(ReferenceDataDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RefUserType> getRefUserTypes() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from RefUserType").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RefUserRole> getRefUserRole() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from RefUserRole").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RefRegistrationStatus> getRefRegistrationStatus() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from RefRegistrationStatus").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RefMailStatus> getRefMailStatus() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from RefMailStatus").list();
	}

	@Override
	public RefRegistrationStatus getRefRegistrationStatusById(Long Id) {
		// TODO Auto-generated method stub
		return (RefRegistrationStatus) sessionFactory.getCurrentSession().load(RefRegistrationStatus.class, Id);
	}

}
