package com.vamsee.spring.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SecurityUtils {
	
	public static String encryptPassword(String password){
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.encode(password);
	}
	
	public static String generateMD5Hash(String content){
        return DigestUtils.md5Hex(content);      
    }

	public static String generateSHA512Hash(String content){
        return DigestUtils.sha512Hex(content);      
    }
	
	public static String generateSHA384Hash(String content){
        return DigestUtils.sha384Hex(content);   
    }
	

}
