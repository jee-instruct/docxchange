package com.vamsee.spring.services.concurrent;

import java.io.ByteArrayInputStream;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.vamsee.spring.hibernate.dao.FileDAO;
import com.vamsee.spring.lucene.beans.IndexFile;
import com.vamsee.spring.persistence.hibernate.entities.File;
import com.vamsee.spring.persistence.hibernate.entities.FileInfo;
import com.vamsee.spring.services.IndexService;
import com.vamsee.spring.services.TikkaService;
import com.vamsee.spring.util.DateUtil;
import com.vamsee.spring.util.TextUtil;

@Component(value="documentHandlerService")
@Scope("prototype")
public class DocumentHandlerService implements Runnable {
	private static final Logger LOGGER = Logger.getLogger(DocumentHandlerService.class);
	
	@Autowired
	private IndexService indexService;
	
	@Autowired
	private TikkaService tikkaService;
	
	@Autowired
	private FileDAO fileDAO;
	
	private String userIdentifier;
	
	private MultipartFile file;
	
	private byte[] bytes;
	
	public String getUserIdentifier() {
		return userIdentifier;
	}

	public void setUserIdentifier(String userIdentifier) {
		this.userIdentifier = userIdentifier;
	}

	public byte[] getBytes() {
		return bytes;
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	@Override
	@Transactional
	public void run() {
		// TODO Auto-generated method stub
		LOGGER.info(getFile().getOriginalFilename() +" uploaded! "+getFile().getSize()/1024+" Kb");
		String extract = "";
		try {
			extract = tikkaService.extractTextFromFile(new ByteArrayInputStream(getBytes()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LOGGER.error("Errored while extracting text.... from >>>>>> "+getFile().getOriginalFilename() , e);
		}
		
		File file = new File(getBytes(), userIdentifier, userIdentifier, DateUtil.getCurrentSqlDate(), DateUtil.getCurrentSqlDate());
		FileInfo fileInfo = new FileInfo(file, userIdentifier, DateUtil.getCurrentSqlDate(), getFile().getContentType(), getFile().getOriginalFilename(),
				(int)getFile().getSize(), userIdentifier, userIdentifier, DateUtil.getCurrentSqlDate(), DateUtil.getCurrentSqlDate());
		file.setFileInfo(fileInfo);
		
		try{
		IndexFile indexFile = new IndexFile(getFile().getOriginalFilename(),Long.toString(fileDAO.PersistFile(file)),TextUtil.getTextTokens(extract,350),TextUtil.getTextTokens(extract,50),getUserIdentifier());
		indexFile.setFileContent(getFile().getContentType());
		indexService.addFileToIndex(indexFile);
		}catch(Exception ex){
			LOGGER.error("Error Occured while Creating Index for the Document >>>>>> "+ getFile().getOriginalFilename(), ex);
		}
	}

}
