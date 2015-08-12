package com.vamsee.spring.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vamsee.spring.controllers.beans.RegistrationForm;
import com.vamsee.spring.hibernate.dao.NewUserRegistrationDAO;
import com.vamsee.spring.hibernate.dao.ReferenceDataDAO;
import com.vamsee.spring.persistence.hibernate.entities.NewUserRegistration;
import com.vamsee.spring.persistence.hibernate.entities.RefMailStatus;
import com.vamsee.spring.persistence.hibernate.entities.RefRegistrationStatus;
import com.vamsee.spring.persistence.hibernate.entities.RefUserRole;
import com.vamsee.spring.persistence.hibernate.entities.RefUserType;
import com.vamsee.spring.properties.AppProperties;
import com.vamsee.spring.services.RegistrationService;
import com.vamsee.spring.util.DateUtil;
import com.vamsee.spring.util.HttpUtils;
import com.vamsee.spring.util.SecurityUtils;
@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private NewUserRegistrationDAO newUserRegistrationDAO;
	
	@Autowired
	private ReferenceDataDAO  referenceDataDAO;
	
	@Autowired
	private AppProperties appProperties;

	@Override
	public void saveNewRegistration(RegistrationForm registrationForm) {
		// TODO Auto-generated method stub
		String hash = SecurityUtils.generateSHA512Hash(registrationForm.getEmailId()+System.currentTimeMillis());
		NewUserRegistration newRegistration = new NewUserRegistration(registrationForm.getEmailId(), registrationForm.getFirstName(), registrationForm.getLastName(), registrationForm.getJobTitle(), registrationForm.getUserTypeId(), 
				registrationForm.getOrganization(), registrationForm.getNoOfEmployees(), registrationForm.getAddress1(), registrationForm.getAddress2(), registrationForm.getPhoneNumber(), registrationForm.getCity(), registrationForm.getState(), registrationForm.getCountry(), 
				registrationForm.getZipcode(), SecurityUtils.encryptPassword(registrationForm.getPassword()), hash, registrationForm.getEmailId(), registrationForm.getEmailId(), 
				DateUtil.getCurrentSqlDate(), DateUtil.getCurrentSqlDate(), referenceDataDAO.getRefRegistrationStatusById(4L));
		
		Long registeredId = newUserRegistrationDAO.persistNewRegistration(newRegistration);
		
		// call External Application  for the rest of the registration process...
		HttpUtils.invokeRestAPI(appProperties.getRegistrationRestURL()+"/"+registeredId+"/"+hash);
	}

	@Override
	public boolean checkIfUserAlreadyRegistered(String emailId) {
		// TODO Auto-generated method stub
		return newUserRegistrationDAO.checkIfUserAlreadyRegistered(emailId);
	}

	@Override
	public List<RefUserType> getRefUserTypes() {
		// TODO Auto-generated method stub
		return referenceDataDAO.getRefUserTypes();
	}

	@Override
	public List<RefUserRole> getRefUserRole() {
		// TODO Auto-generated method stub
		return referenceDataDAO.getRefUserRole();
	}

	@Override
	public List<RefRegistrationStatus> getRefRegistrationStatus() {
		// TODO Auto-generated method stub
		return referenceDataDAO.getRefRegistrationStatus();
	}

	@Override
	public List<RefMailStatus> getRefMailStatus() {
		// TODO Auto-generated method stub
		return referenceDataDAO.getRefMailStatus();
	}

	@Override
	public RefRegistrationStatus getRefRegistrationStatusById(Long Id) {
		// TODO Auto-generated method stub
		return referenceDataDAO.getRefRegistrationStatusById(Id);
	}

}
