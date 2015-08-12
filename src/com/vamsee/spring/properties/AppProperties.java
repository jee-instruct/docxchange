package com.vamsee.spring.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppProperties {
	
	@Value("${lucene.index.path}")
	private String luceneIndexPath;
	
	@Value("${lucene.suggest.path}")
	private String liceneSuggestIndexPath;
	
	@Value("${docxchange.registration.rest.url}")
	private String registrationRestURL;
	
	@Value("${docxchange.forgotpassword.url}")
	private String forgotPasswordURL;

	public String getForgotPasswordURL() {
		return forgotPasswordURL;
	}

	public String getRegistrationRestURL() {
		return registrationRestURL;
	}

	public String getLuceneIndexPath() {
		return luceneIndexPath;
	}

	public String getLiceneSuggestIndexPath() {
		return liceneSuggestIndexPath;
	}

	
	
	
	

}
