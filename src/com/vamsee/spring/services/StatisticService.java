package com.vamsee.spring.services;

import java.util.List;

import com.vamsee.spring.controllers.beans.Statistics;

public interface StatisticService {
	public List<Statistics> getStatsByUserAndCount();
	public List<Statistics> getStatsByUserAndSize();
	public List<Statistics> getStatsByFileTypeAndCount();
	public List<Statistics> getStatsByFileTypeAndSize();

}
