package com.milleapplis.ovh.api.sms.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.milleapplis.ovh.api.sms.enums.SMSRefererSenderEnum;
import com.milleapplis.ovh.api.sms.enums.SMSStatusSenderEnum;
import com.milleapplis.ovh.api.sms.enums.SMSTypeSenderEnum;

public class SMSSender {
	@JsonProperty
	private String comment;
	@JsonProperty
	private String sender;
	@JsonProperty
	private SMSStatusSenderEnum status;
	@JsonProperty
	private SMSTypeSenderEnum type;
	@JsonProperty
	private String description;
	@JsonProperty
	private SMSRefererSenderEnum referer;
	@JsonProperty
	private String validationMedia;
	
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public SMSStatusSenderEnum getStatus() {
		return status;
	}
	public void setStatus(SMSStatusSenderEnum status) {
		this.status = status;
	}
	public SMSTypeSenderEnum getType() {
		return type;
	}
	public void setType(SMSTypeSenderEnum type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public SMSRefererSenderEnum getReferer() {
		return referer;
	}
	public void setReferer(SMSRefererSenderEnum referer) {
		this.referer = referer;
	}
	public String getValidationMedia() {
		return validationMedia;
	}
	public void setValidationMedia(String validationMedia) {
		this.validationMedia = validationMedia;
	}
	
	public String toString() {
		StringBuffer result = new StringBuffer();
		
		result.append("[Sender : " + sender + "]");
		result.append("[Status : " + status + "]");
		result.append("[Comment : " + comment + "]");
		result.append("[Type : " + type + "]");
		result.append("[Description : " + description + "]");
		result.append("[Referer : " + referer + "]");
		result.append("[ValidationMedia : " + validationMedia + "]");
		
		return result.toString();
	}
	
}
