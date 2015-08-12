package com.vamsee.spring.lucene.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SearchResult implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4680478985216444107L;
	private String query;
	private int hits;
	private double searchTime;
	private List<Result> results = new ArrayList<Result>();
	
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public List<Result> getResults() {
		return results;
	}
	public void setResults(List<Result> results) {
		this.results = results;
	}
	public double getSearchTime() {
		return searchTime;
	}
	public void setSearchTime(double searchTime) {
		this.searchTime = searchTime;
	}
	
	
	
	

}
