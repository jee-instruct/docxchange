package com.vamsee.spring.services;

import java.io.InputStream;

public interface TikkaService {
	
	public String extractTextFromFile(InputStream stream) throws Exception;

}
