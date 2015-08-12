package com.vamsee.spring.hibernate.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vamsee.spring.controllers.beans.Statistics;
import com.vamsee.spring.hibernate.dao.StatisticsDAO;

@Repository
public class StatisticsDAOImpl implements StatisticsDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Statistics> getStatsByUserAndCount() {
		// TODO Auto-generated method stub
	List<Object[]>	results = sessionFactory.getCurrentSession().createSQLQuery("SELECT uploaded_by,COUNT(uploaded_by) FROM docxchange_document_info GROUP BY uploaded_by").list();
	 List<Statistics> stats = new ArrayList<Statistics>();
	if(CollectionUtils.isNotEmpty(results)){
	for(Object[] row :results){
		stats.add(new Statistics((String)row[0],(BigInteger) row[1]));
		}
	}
		return stats;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Statistics> getStatsByUserAndSize() {
		// TODO Auto-generated method stub
		List<Object[]>	results = sessionFactory.getCurrentSession().createSQLQuery("SELECT uploaded_by,SUM(document_size) FROM docxchange_document_info GROUP BY uploaded_by").list();
		 List<Statistics> stats = new ArrayList<Statistics>();
		if(CollectionUtils.isNotEmpty(results)){
		for(Object[] row :results){
			stats.add(new Statistics((String)row[0],(BigInteger) row[1]));
			}
		}
			return stats;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Statistics> getStatsByFileTypeAndCount() {
		// TODO Auto-generated method stub
		List<Object[]>	results = sessionFactory.getCurrentSession().createSQLQuery("SELECT document_content_type,COUNT(document_content_type) FROM docxchange_document_info GROUP BY document_content_type").list();
		 List<Statistics> stats = new ArrayList<Statistics>();
		if(CollectionUtils.isNotEmpty(results)){
		for(Object[] row :results){
			stats.add(new Statistics((String)row[0],(BigInteger) row[1]));
			}
		}
			return stats;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Statistics> getStatsByFileTypeAndSize() {
		// TODO Auto-generated method stub
		List<Object[]>	results = sessionFactory.getCurrentSession().createSQLQuery("SELECT document_content_type,SUM(document_size) FROM docxchange_document_info GROUP BY document_content_type").list();
		 List<Statistics> stats = new ArrayList<Statistics>();
		if(CollectionUtils.isNotEmpty(results)){
		for(Object[] row :results){
			stats.add(new Statistics((String)row[0],(BigInteger) row[1]));
			}
		}
			return stats;
	}

}
