package com.milleapplis.ovh.api.sms.param;

import com.fasterxml.jackson.annotation.JsonProperty;

public class POSTSmsSendersParam {
	@JsonProperty
	private String description;
	@JsonProperty
	private String reason;
	@JsonProperty
	private String sender;
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}

	
	
}
