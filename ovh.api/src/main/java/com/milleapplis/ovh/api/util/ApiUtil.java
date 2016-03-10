package com.milleapplis.ovh.api.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.milleapplis.ovh.api.core.OVHApiException;

public class ApiUtil {

	private static final Logger LOG = LoggerFactory.getLogger(ApiUtil.class);

	public static String HashSHA1(String text) throws OVHApiException {
		
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-1");
			byte[] sha1hash = new byte[40];
			md.update(text.getBytes("iso-8859-1"), 0, text.length());
			//md.update(text.getBytes("utf8"), 0, text.length());
			sha1hash = md.digest();
			return convertToHex(sha1hash);
		} 
		catch (NoSuchAlgorithmException e) {
			final String message = "NoSuchAlgorithmException: " + text + " " + e;
			throw new OVHApiException(message, e);
		} 
		catch (UnsupportedEncodingException e) {
			final String message = "UnsupportedEncodingException: " + text + " "
					+ e;
			throw new OVHApiException(message, e);
		}
	}

	private static String convertToHex(byte[] data) {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < data.length; i++) {
			int halfbyte = (data[i] >>> 4) & 0x0F;
			int two_halfs = 0;
			do {
				if ((0 <= halfbyte) && (halfbyte <= 9))
					buf.append((char) ('0' + halfbyte));
				else
					buf.append((char) ('a' + (halfbyte - 10)));
				halfbyte = data[i] & 0x0F;
			} while (two_halfs++ < 1);
		}
		return buf.toString();
	}

	
	public static String computeHash(String applicationSecret, String consumerKey, Method method, String query, String body, long timestamp) throws OVHApiException {

        //Creation de la signature
        String toSign    = applicationSecret + "+" + consumerKey + "+" + method.toString() + "+" + query + "+" + body + "+" + timestamp;
        LOG.debug("ToSign = " + toSign);
        String signature = "$1$" + HashSHA1(toSign);
        LOG.debug("Signature = " + signature);
        
        return signature;
	}
}
