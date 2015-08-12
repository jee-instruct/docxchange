package com.vamsee.spring.util;

import java.text.DecimalFormat;
import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

public class TextUtil {
	
	public static ArrayList<String> getTextTokens(String text,int noOfTokens){
		ArrayList<String> array = null;
		if(StringUtils.isNotEmpty(text)){
			array = new ArrayList<String>();
		text = text.replaceAll("\\s+", " ");
		String[] words = text.split("(?=[\\s\\.])");
		int i = 0;
		while (words.length > i) {
		    String line = "";
		    while ( words.length > i && line.length() + words[i].length() < noOfTokens ) {
		        line += words[i];
		        i++;
		    }
		    array.add(line.trim());
		}
	}
		return array;
	}
	
	
	public static String readableFileSize(long size) {
	    if(size <= 0) return "0";
	    final String[] units = new String[] { "B", "kB", "MB", "GB", "TB" };
	    int digitGroups = (int) (Math.log10(size)/Math.log10(1024));
	    return new DecimalFormat("#,##0.#").format(size/Math.pow(1024, digitGroups)) + " " + units[digitGroups];
	}
	
	
	
	
	
	
	
	
	

}
