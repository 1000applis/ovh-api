package com.milleapplis.ovh.api.sms;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Templates {
	@JsonProperty
	private boolean customizedEmailMode;
	@JsonProperty
	private String emailBody;
	@JsonProperty
	private boolean customizedSmsMode;
	@JsonProperty
	private String emailSubject;
	@JsonProperty
	private String smsBody;
	@JsonProperty
	private String emailFrom;
	
	public boolean isCustomizedEmailMode() {
		return customizedEmailMode;
	}
	public void setCustomizedEmailMode(boolean customizedEmailMode) {
		this.customizedEmailMode = customizedEmailMode;
	}
	public String getEmailBody() {
		return emailBody;
	}
	public void setEmailBody(String emailBody) {
		this.emailBody = emailBody;
	}
	public boolean isCustomizedSmsMode() {
		return customizedSmsMode;
	}
	public void setCustomizedSmsMode(boolean customizedSmsMode) {
		this.customizedSmsMode = customizedSmsMode;
	}
	public String getEmailSubject() {
		return emailSubject;
	}
	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}
	public String getSmsBody() {
		return smsBody;
	}
	public void setSmsBody(String smsBody) {
		this.smsBody = smsBody;
	}
	public String getEmailFrom() {
		return emailFrom;
	}
	public void setEmailFrom(String emailFrom) {
		this.emailFrom = emailFrom;
	}
	
	
}
