package com.vamsee.webservice.rest;

import java.security.Principal;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vamsee.spring.controllers.beans.Statistics;
import com.vamsee.spring.lucene.beans.SearchResult;
import com.vamsee.spring.services.IndexService;
import com.vamsee.spring.services.StatisticService;

@RestController
@RequestMapping(value="/secure/api")
public class SearchWS {
	
	private static final Logger LOGGER = Logger.getLogger(SearchWS.class);
	
	@Autowired
	private IndexService indexService;
	
	@Autowired
	private StatisticService  statisticService;
	
	@RequestMapping(value = "/suggestions", method = { RequestMethod.GET})
	public List<String> getSuggestions(@RequestParam("query") String query,Principal principal){
		try {
			return indexService.getSuggestionsForQuery(query, 10);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LOGGER.error(" Error while get suggestions for user query >>>>>> "+ query, e);
		}
		return Collections.emptyList();
		
	}
	
	@RequestMapping(value = "/search", method = { RequestMethod.GET})
	public SearchResult searchQuery(@RequestParam("query") String query,Principal principal){
		try {
			if(query.length() >3)
			return indexService.runSearch(query, 20);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LOGGER.error(" Error while get search results for user query >>>>>> "+ query, e);
		}
		return null;
	}
	
	
	@RequestMapping(value = "/stats/user/count", method = { RequestMethod.GET})
	public List<Statistics> getUserStatByCount(){
		return statisticService.getStatsByUserAndCount();
		
	}
	
	@RequestMapping(value = "/stats/user/size", method = { RequestMethod.GET})
	public List<Statistics> getUserStatBySize(){
		return statisticService.getStatsByUserAndSize();
		
	}
	
	@RequestMapping(value = "/stats/fileType/count", method = { RequestMethod.GET})
	public List<Statistics> getFileTypeByCount(){
		return statisticService.getStatsByFileTypeAndCount();
		
	}
	
	@RequestMapping(value = "/stats/fileType/size", method = { RequestMethod.GET})
	public List<Statistics> getFileTypeBySize(){
		return statisticService.getStatsByFileTypeAndSize();
	}
	
	@RequestMapping(value = "/clustering", method = { RequestMethod.GET})
	public List<String> clusterQuery(@RequestParam("query") String query,Principal principal){
		try {
			if(query.length() >3)
			return indexService.getClusterByCarrot2(query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LOGGER.error(" Error while get search results for user query >>>>>> "+ query, e);
		}
		return null;
	}
	
	

}
