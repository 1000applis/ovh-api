package com.milleapplis.ovh.api.sms;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.milleapplis.ovh.api.sms.enums.SMSStatusSenderEnum;
import com.milleapplis.ovh.api.sms.enums.SMSTypeTemplateEnum;

@JsonInclude(Include.NON_NULL)
public class TemplateControl {
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
	@JsonProperty(required=false)
	private String comment; 
	@JsonProperty(required=false)
	private SMSStatusSenderEnum status;
	@JsonProperty(required=false)
	private Date datetime;
	
	
	
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
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public SMSStatusSenderEnum getStatus() {
		return status;
	}
	public void setStatus(SMSStatusSenderEnum status) {
		this.status = status;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	
	
}
