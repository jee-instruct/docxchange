package com.vamsee.spring.services.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.log4j.Logger;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.queryparser.flexible.standard.QueryParserUtil;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.suggest.Lookup;
import org.apache.lucene.search.suggest.analyzing.AnalyzingInfixSuggester;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.NoLockFactory;
import org.apache.lucene.util.BytesRef;
import org.apache.lucene.util.Version;
import org.carrot2.clustering.lingo.LingoClusteringAlgorithm;
import org.carrot2.clustering.synthetic.ByUrlClusteringAlgorithm;
import org.carrot2.core.Cluster;
import org.carrot2.core.Controller;
import org.carrot2.core.ControllerFactory;
import org.carrot2.core.IDocumentSource;
import org.carrot2.core.ProcessingComponentConfiguration;
import org.carrot2.core.ProcessingResult;
import org.carrot2.core.attribute.CommonAttributesDescriptor;
import org.carrot2.source.lucene.LuceneDocumentSource;
import org.carrot2.source.lucene.LuceneDocumentSourceDescriptor;
import org.carrot2.source.lucene.SimpleFieldMapperDescriptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.vamsee.spring.lucene.beans.IndexFile;
import com.vamsee.spring.lucene.beans.IndexFileIterator;
import com.vamsee.spring.lucene.beans.Result;
import com.vamsee.spring.lucene.beans.SearchResult;
import com.vamsee.spring.properties.AppProperties;
import com.vamsee.spring.services.IndexService;
import com.vamsee.spring.util.DateUtil;

@Service
public class IndexServiceImpl implements IndexService {
	private static final Logger LOGGER = Logger.getLogger(IndexServiceImpl.class);
	
	@Autowired
	private AppProperties appproperties;
	private File index =null;
	private File suggest =null;
	private Directory directory = null;
	private Directory suggestDirectory = null;
	private Analyzer analyzer = new StandardAnalyzer();
	private AnalyzingInfixSuggester suggester = null;
	private IndexWriterConfig iwc=new IndexWriterConfig(Version.LATEST,analyzer);
	private IndexWriter writer = null;
	private IndexReader indexReader = null;
	private IndexSearcher indexSearcher= null;
	private QueryParser parser  = null;
	private static final String TITLE_FIELD="title";
	private static final String CONTENTS_FIELD="contents";
	private static final String ID_FIELD="id";
	private static final String USER_FIELD="user";
	private static final String CONTENT_TYPE_FIELD="contentType";
	private static final String DATE_FIELD="date";
	private static final String TIME_FIELD="time";
	private final ExecutorService executorService = Executors.newCachedThreadPool();
	private static SearchResult searchResult = new SearchResult();
	private static List<Result> results = new ArrayList<Result>();
	private Query q = null;
	private TopDocs docs = null;
	private ScoreDoc[] hits = null;
	private static List<String> suggestions = new ArrayList<String>();
	
	@PostConstruct
	public void createOrVerifyIndex() throws Exception {
			LOGGER.info("Initializing Index..........................please Wait..0%");
			index = new File(appproperties.getLuceneIndexPath());
			suggest = new File(appproperties.getLiceneSuggestIndexPath());
			directory = FSDirectory.open(index,NoLockFactory.getNoLockFactory());
			suggestDirectory = FSDirectory.open(suggest, NoLockFactory.getNoLockFactory());
			iwc.setOpenMode(OpenMode.CREATE_OR_APPEND);
			writer = new IndexWriter(directory, iwc);
			writer.commit();
			indexReader = DirectoryReader.open(directory);
			indexSearcher = new IndexSearcher(indexReader,executorService);
			parser = new MultiFieldQueryParser(new String[]{TITLE_FIELD, CONTENTS_FIELD}, analyzer);
			suggester =  new AnalyzingInfixSuggester(Version.LATEST,suggestDirectory,analyzer,analyzer,AnalyzingInfixSuggester.DEFAULT_MIN_PREFIX_CHARS);
			if (!suggest.exists() && !suggest.isDirectory()) {
				LOGGER.info("Lucene Suggest did not exist.........................................Building Please wait.........0%");
				suggester.build(new IndexFileIterator(new ArrayList<IndexFile>().iterator()));
				suggester.refresh();
				LOGGER.info("Lucene Suggest Build Complete...................................................................100%");
			}
			LOGGER.info("Lucene Ready............................................100%");
	}
	
	@PreDestroy
	public void closeAll() throws Exception{
		writer.commit();
		writer.close();
		indexReader.close();
		suggester.close();
		directory.close();
	}
	
	public void addDocumentToSuggest(IndexFile indexFile) throws Exception{
		for(String suggestions:indexFile.getSuggestStrings()){
		getSuggester().add(new BytesRef(suggestions), null, 1L, null);	
		}
		getSuggester().refresh();
	}

	public IndexWriter getWriter() {
		return writer;
	}

	public IndexSearcher getIndexSearcher() {
		return indexSearcher;
	}
	
	public QueryParser getParser() {
		return parser;
	}

	public AnalyzingInfixSuggester getSuggester() {
		return suggester;
	}

	@Override
	public void addFileToIndex(IndexFile indexFile) throws Exception{
		// TODO Auto-generated method stub
		if(CollectionUtils.isNotEmpty(indexFile.getTextStrings())){
			for(String token: indexFile.getTextStrings()){
				 Document document = new Document();
				 document.add(new TextField(TITLE_FIELD, indexFile.getFileName().trim(), Field.Store.YES));
				 document.add(new TextField(CONTENTS_FIELD, token.trim(), Field.Store.YES));
				 document.add(new StringField(ID_FIELD, indexFile.getFileId().trim(), Field.Store.YES));
				 document.add(new StringField(USER_FIELD, indexFile.getUserIdentifier(), Field.Store.YES));
				 document.add(new StringField(CONTENT_TYPE_FIELD, indexFile.getFileContent(), Field.Store.YES));
				 document.add(new StringField(DATE_FIELD, DateUtil.getCurrentDate(), Field.Store.YES));
				 document.add(new StringField(TIME_FIELD, DateUtil.getCurrentTime(), Field.Store.YES));
				 getWriter().addDocument(document);
			}
		}else{
			 Document document = new Document();
			 document.add(new TextField(TITLE_FIELD, indexFile.getFileName().trim(), Field.Store.YES));
			 document.add(new StringField(ID_FIELD, indexFile.getFileId().trim(), Field.Store.YES));
			 document.add(new StringField(USER_FIELD, indexFile.getUserIdentifier(), Field.Store.YES));
			 document.add(new StringField(CONTENT_TYPE_FIELD, indexFile.getFileContent(), Field.Store.YES));
			 document.add(new StringField(DATE_FIELD, DateUtil.getCurrentDate(), Field.Store.YES));
			 document.add(new StringField(TIME_FIELD, DateUtil.getCurrentTime(), Field.Store.YES));
			 getWriter().addDocument(document);
		}
		  getWriter().commit();
		  LOGGER.info("File Indexed Successfully..............");
		  indexFile.getSuggestStrings().add(indexFile.getFileName().trim());
		  addDocumentToSuggest(indexFile); 
		  LOGGER.info("File Name added to Suggestions..............");
	}

	@Override
	public SearchResult runSearch(String query,int hitsPerPage) throws Exception {
		// TODO Auto-generated method stub
		results.clear();
		q = getParser().parse(QueryParserUtil.escape(query));
		Long start = System.currentTimeMillis();
		docs = getIndexSearcher().search(q, Integer.MAX_VALUE);
		hits=docs.scoreDocs;
		int totalHits = docs.totalHits;
		for (int i=0; i < hits.length; i++) {
		Document doc=getIndexSearcher().doc(hits[i].doc);
		Result res = new Result(doc.get(CONTENTS_FIELD), doc.get(TITLE_FIELD), doc.get(ID_FIELD),doc.get(USER_FIELD),doc.get(CONTENT_TYPE_FIELD),doc.get(DATE_FIELD),doc.get(TIME_FIELD));
		results.add(res);
		}
		searchResult.setSearchTime((System.currentTimeMillis() - start)/1000.0000);
		searchResult.setQuery(query);
		searchResult.setHits(totalHits);
		searchResult.setResults(results);
		return searchResult;
	}
	
	
	public List<String> getSuggestionsForQuery(String query, int noOfSuggestions) throws Exception{
		suggestions.clear();
		List<Lookup.LookupResult> results = getSuggester().lookup(query, noOfSuggestions, true, true);
		for (Lookup.LookupResult result : results) {
			suggestions.add(result.key.toString());
        }
		return suggestions;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getClusterByCarrot2(String query) {
		// TODO Auto-generated method stub
		List<String> strs = new ArrayList<String>();
		final Controller controller=ControllerFactory.createCachingPooling(IDocumentSource.class);
		final List<org.carrot2.core.Document> documents=Lists.newArrayList();
		try{
		q = getParser().parse(QueryParserUtil.escape(query));
		docs = getIndexSearcher().search(q, Integer.MAX_VALUE);
		hits=docs.scoreDocs;
		for (int i=0; i < hits.length; i++) {
		Document doc=getIndexSearcher().doc(hits[i].doc);
		documents.add(new org.carrot2.core.Document(doc.get(CONTENTS_FIELD),doc.get(TITLE_FIELD),doc.get(USER_FIELD)));
		}
		 final ProcessingResult byTopicClusters=controller.process(documents,query,LingoClusteringAlgorithm.class);
		 final List<Cluster> clustersByTopic=byTopicClusters.getClusters();
		 final ProcessingResult byDomainClusters=controller.process(documents,query,ByUrlClusteringAlgorithm.class);
		 final List<Cluster> clustersByDomain=byDomainClusters.getClusters();
		    for(Cluster c :clustersByDomain){
		    	strs.add(c.getLabel());
		    }
			for(Cluster c :clustersByTopic){
				strs.add(c.getLabel());
			}
		}catch(Exception ex){
			
		}
		return strs;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getClusterByCarrotVersion2(String query) {
		// TODO Auto-generated method stub
		List<String> strs = new ArrayList<String>();
		final Controller controller=ControllerFactory.createPooling();
		  final Map<String,Object> luceneGlobalAttributes=new HashMap<String,Object>();
		  LuceneDocumentSourceDescriptor.attributeBuilder(luceneGlobalAttributes).directory(directory);
		  SimpleFieldMapperDescriptor.attributeBuilder(luceneGlobalAttributes).titleField(TITLE_FIELD).contentField(CONTENTS_FIELD).searchFields(Arrays.asList(new String[]{TITLE_FIELD,CONTENTS_FIELD}));
		  controller.init(new HashMap<String,Object>(),new ProcessingComponentConfiguration(LuceneDocumentSource.class,"lucene",luceneGlobalAttributes));
		  final Map<String,Object> processingAttributes=Maps.newHashMap();
		  CommonAttributesDescriptor.attributeBuilder(processingAttributes).query(query);
		  ProcessingResult process=controller.process(processingAttributes,"lucene",LingoClusteringAlgorithm.class.getName());
		  for(Cluster c : process.getClusters()){
			  strs.add(c.getLabel()+" >>>> "+c.getAllDocuments().size());
		  }
		return strs;
	}
	
	
	
	

}
