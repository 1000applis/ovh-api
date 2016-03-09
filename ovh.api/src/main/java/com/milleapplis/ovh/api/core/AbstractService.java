package com.milleapplis.ovh.api.core;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

import com.milleapplis.ovh.api.credential.Credential;
import com.milleapplis.ovh.api.util.ApiUtil;
import com.milleapplis.ovh.api.util.Method;

public abstract class AbstractService {
	private String baseUrlString  = "https://eu.api.ovh.com/1.0/";
	  
	protected String serviceUrl;

	protected Credential credential;
	
	public AbstractService(Credential credential) {
		this.credential = credential;
	}
	
	protected String executeService(Method method, String url, String body) throws OVHApiException {
		try {
			String serviceURLString = baseUrlString + url;
			URL    serviceURL = new URL(serviceURLString);
			long timestamp  = new Date().getTime()/1000;

			String signature = ApiUtil.computeHash(credential.getApplicationSecret(), credential.getConsumerKey(), method, serviceURLString, body, timestamp);
			
	        HttpURLConnection req = (HttpURLConnection) serviceURL.openConnection();
	        req.setRequestMethod(method.name());
	        req.setRequestProperty("Content-Type",      "application/json");
	        req.setRequestProperty("X-Ovh-Application", credential.getApplicationKey());
	        req.setRequestProperty("X-Ovh-Consumer",    credential.getConsumerKey());
	        req.setRequestProperty("X-Ovh-Signature",   signature);
	        req.setRequestProperty("X-Ovh-Timestamp",   "" + timestamp);
	
	        if (body != null && !"".equals(body)) {
	        	req.setDoOutput(true);
		        OutputStream outputStream = req.getOutputStream();
		        outputStream.write(body.getBytes());
	        }
	        
	        String inputLine;
	        BufferedReader in;
	        int responseCode = req.getResponseCode();
	        
	        if ( responseCode == 200 ) {
	        	//Récupération du résultat de l'appel
	            in = new BufferedReader(new InputStreamReader(req.getInputStream()));
	        }
	        else {
	            in = new BufferedReader(new InputStreamReader(req.getErrorStream()));
	        }
	        
	        StringBuffer response   = new StringBuffer();
	 
	        while ((inputLine = in.readLine()) != null) {
	            response.append(inputLine);
	        }
	        in.close();
	 
	        if (responseCode != 200) {
	        	throw new OVHApiException(response.toString());
	        }
	        
	        //retour du résultat
	        return response.toString();
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Unable to execute request [%s] for URL [%s]",method.name(), url), e);
		}
	}
	
}
