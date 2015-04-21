package com.huayu.platform.util.string;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Security {
	private final static Logger logger = LoggerFactory.getLogger(Security.class
			.getCanonicalName());

	public static String encryptWithMD5(String pass) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] passBytes = pass.getBytes();
			md.reset();
			byte[] digested = md.digest(passBytes);
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < digested.length; i++) {
				sb.append(Integer.toHexString(0xff & digested[i]));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException ex) {
			logger.warn("{} Covert to md5 failure , because {} ", pass, ex);
		}

		return "";

	}
}
