package com.vamsee.spring.hibernate.dao;

import java.util.List;

import com.vamsee.spring.controllers.beans.Statistics;

public interface StatisticsDAO {

	public List<Statistics> getStatsByUserAndCount();
	public List<Statistics> getStatsByUserAndSize();
	public List<Statistics> getStatsByFileTypeAndCount();
	public List<Statistics> getStatsByFileTypeAndSize();
	
	
	
}
