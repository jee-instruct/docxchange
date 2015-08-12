package com.vamsee.spring.services;

import java.util.List;

import com.vamsee.spring.controllers.beans.RegistrationForm;
import com.vamsee.spring.persistence.hibernate.entities.NewUserRegistration;
import com.vamsee.spring.persistence.hibernate.entities.RefMailStatus;
import com.vamsee.spring.persistence.hibernate.entities.RefRegistrationStatus;
import com.vamsee.spring.persistence.hibernate.entities.RefUserRole;
import com.vamsee.spring.persistence.hibernate.entities.RefUserType;

public interface RegistrationService {
	
	public void saveNewRegistration(RegistrationForm registrationForm);
	public boolean checkIfUserAlreadyRegistered(String emailId);
	
	public List<RefUserType> getRefUserTypes();
	public List<RefUserRole> getRefUserRole();
	public List<RefRegistrationStatus> getRefRegistrationStatus();
	public List<RefMailStatus> getRefMailStatus();
	public RefRegistrationStatus getRefRegistrationStatusById(Long Id);

}
