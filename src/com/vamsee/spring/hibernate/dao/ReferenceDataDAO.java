package com.vamsee.spring.hibernate.dao;

import java.util.List;

import com.vamsee.spring.persistence.hibernate.entities.RefMailStatus;
import com.vamsee.spring.persistence.hibernate.entities.RefRegistrationStatus;
import com.vamsee.spring.persistence.hibernate.entities.RefUserRole;
import com.vamsee.spring.persistence.hibernate.entities.RefUserType;

public interface ReferenceDataDAO {
	
	public List<RefUserType> getRefUserTypes();
	public List<RefUserRole> getRefUserRole();
	public List<RefRegistrationStatus> getRefRegistrationStatus();
	public List<RefMailStatus> getRefMailStatus();
	public RefRegistrationStatus getRefRegistrationStatusById(Long Id);

}
