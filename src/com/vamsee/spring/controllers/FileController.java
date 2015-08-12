package com.vamsee.spring.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.vamsee.spring.persistence.hibernate.entities.File;
import com.vamsee.spring.services.FileService;
import com.vamsee.spring.services.concurrent.DocumentHandlerService;

@Controller
@RequestMapping(value="/file")
public class FileController {
	private static final Logger LOGGER = Logger.getLogger(FileController.class);
	
	@Autowired
	private TaskExecutor taskExecutor;
	
	@Autowired
	private WebApplicationContext  context;
	
	@Autowired
	private FileService fileService;
	
	
	@RequestMapping(value = "/downloadfile/{fileId}")
    public void handleFileDownload(@PathVariable Long fileId, HttpServletResponse response) {
		File f = fileService.getFileById(fileId);
		response.setContentType(f.getFileInfo().getFileContentType());
		response.setContentLength(f.getFileInfo().getFileSize());
		response.setHeader("Content-Disposition","attachment; filename="+f.getFileInfo().getFileName());
		try{
			FileCopyUtils.copy(f.getFileData(), response.getOutputStream());
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	@RequestMapping(value = "/upload", method = {RequestMethod.POST })
	public void fileUploadController(MultipartHttpServletRequest request, HttpServletResponse response,Principal principal) throws Exception {
	/*
	 * If we need to break down a file in to chunks on the client side and then transfer to server then we can do it on the client side by setting chunk size.
	 * Once here we get all the chunks we simply do a merge of all the chunks to get the complete file.
	 * 
	 * 	
	 	Iterator<String> itr =  request.getFileNames();
        MultipartFile mpf = request.getFile(request.getFileNames().next());
        while(itr.hasNext()){
        	 mpf = request.getFile(itr.next()); 
        	 System.out.println(mpf.getOriginalFilename() +" uploaded! "+mpf.getSize()/1024+" Kb");
        }
        
        *
        *
        */
        MultipartFile mpf = request.getFile(request.getFileNames().next());
        DocumentHandlerService documentHandlerService = context.getBean(DocumentHandlerService.class);
        documentHandlerService.setFile(mpf);
        documentHandlerService.setBytes(mpf.getBytes());
        documentHandlerService.setUserIdentifier(principal.getName());
        taskExecutor.execute(documentHandlerService);
	}
	
	
	

}
