package com.vamsee.spring.services;

import java.util.List;

import com.vamsee.spring.lucene.beans.IndexFile;
import com.vamsee.spring.lucene.beans.SearchResult;

public interface IndexService {
	
	public void addFileToIndex(IndexFile indexFile)throws Exception;
	public SearchResult runSearch(String query,int hitsPerPage) throws Exception;
	public List<String> getSuggestionsForQuery(String query,int noOfSuggestions) throws Exception;
	public List<String> getClusterByCarrot2(String query);
	public List<String> getClusterByCarrotVersion2(String query);

}
