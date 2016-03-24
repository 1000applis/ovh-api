package com.milleapplis.ovh.api.sms.param;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.milleapplis.ovh.api.sms.enums.SMSTypeTemplateEnum;

public class POSTSmsTemplateControl {
	@JsonProperty
	private SMSTypeTemplateEnum activity;
	@JsonProperty
	private String description;
	@JsonProperty
	private String message;
	@JsonProperty
	private String name;
	@JsonProperty
	private String reason;
	
	
	public SMSTypeTemplateEnum getActivity() {
		return activity;
	}
	public void setActivity(SMSTypeTemplateEnum activity) {
		this.activity = activity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
}
