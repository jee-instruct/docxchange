package com.vamsee.spring.hibernate.dao;

import com.vamsee.spring.persistence.hibernate.entities.NewUserRegistration;

public interface NewUserRegistrationDAO {
	
	public boolean checkIfUserAlreadyRegistered(String emailId);
	public Long persistNewRegistration(NewUserRegistration newUserRegistration);

}
