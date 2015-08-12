package com.vamsee.spring.util;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;


public class HttpUtils {
	private static final Logger LOGGER = Logger.getLogger(HttpUtils.class);
	
	public static void invokeRestAPI(String url){
		try{
			CloseableHttpClient client = HttpClientBuilder.create().build(); 	
			HttpResponse response = client.execute(new HttpGet(url));
		    int statusCode = response.getStatusLine().getStatusCode();
		    LOGGER.info("Successfully invoked a HTTP Method with status code >>>> "+ statusCode);
		}catch(Exception ex){
			LOGGER.error("Error Occured while calling the HTTP Method >>>>>>>>>>>>>> ", ex);
		}
	}

}
