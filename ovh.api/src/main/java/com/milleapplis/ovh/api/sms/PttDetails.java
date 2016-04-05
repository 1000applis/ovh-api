package com.milleapplis.ovh.api.sms;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.milleapplis.ovh.api.sms.enums.SMSPttDurationEnum;

public class PttDetails {
	@JsonProperty
	private String comment;
	@JsonProperty
	//private SMSPttDurationType duration;
	private SMSPttDurationEnum duration;
	@JsonProperty
	private String description;
	
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public SMSPttDurationEnum getDuration() {
		return duration;
	}
	public void setDuration(SMSPttDurationEnum duration) {
		this.duration = duration;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
	
}
