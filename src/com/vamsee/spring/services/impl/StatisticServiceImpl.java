package com.vamsee.spring.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vamsee.spring.controllers.beans.Statistics;
import com.vamsee.spring.hibernate.dao.StatisticsDAO;
import com.vamsee.spring.services.StatisticService;
@Service
@Transactional(propagation=Propagation.NEVER)
public class StatisticServiceImpl implements StatisticService {
	
	@Autowired
	private StatisticsDAO statisticsDAO;

	@Override
	public List<Statistics> getStatsByUserAndCount() {
		// TODO Auto-generated method stub
		return statisticsDAO.getStatsByUserAndCount();
	}

	@Override
	public List<Statistics> getStatsByUserAndSize() {
		// TODO Auto-generated method stub
		return statisticsDAO.getStatsByUserAndSize();
	}

	@Override
	public List<Statistics> getStatsByFileTypeAndCount() {
		// TODO Auto-generated method stub
		return statisticsDAO.getStatsByFileTypeAndCount();
	}

	@Override
	public List<Statistics> getStatsByFileTypeAndSize() {
		// TODO Auto-generated method stub
		return statisticsDAO.getStatsByFileTypeAndSize();
	}

}
