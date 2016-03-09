package com.milleapplis.ovh.api.credential;

/**
 * Class used to store application credentials.
 * This object must be passed to all services during construction.
 *  
 * @author sginer
 *
 */
public class Credential {

	private String applicationKey;
	private String applictionSecret;
	private String consumerKey;
	
	public Credential(String applicationKey, String applicationSecret, String consumerKey) {
		this.applicationKey = applicationKey;
		this.applictionSecret = applicationSecret;
		this.consumerKey = consumerKey;
	}
	
	public String getApplicationKey() {
		return applicationKey;
	}
	public void setApplicationKey(String applicationKey) {
		this.applicationKey = applicationKey;
	}
	public String getApplicationSecret() {
		return applictionSecret;
	}
	public void setApplictionSecret(String applictionSecret) {
		this.applictionSecret = applictionSecret;
	}
	public String getConsumerKey() {
		return consumerKey;
	}
	public void setConsumerKey(String consumerKey) {
		this.consumerKey = consumerKey;
	}
	
	
}
