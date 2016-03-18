package com.milleapplis.ovh.api.sms.result;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SMSIncoming {

	@JsonProperty
	private double credits;
	@JsonProperty
	private String sender;
	@JsonProperty
	private Date creationDatetime;
	@JsonProperty
	private long id;
	@JsonProperty
	private String tag;
	@JsonProperty
	private String message;
	
	public String toString() {
		return String.format("[Credit : %s][Sender : %s][Creation date : ‰s][Tag : %s][Message : %s]", credits, sender, creationDatetime, tag, message);
	}
	
	public double getCredits() {
		return credits;
	}
	public void setCredits(double credits) {
		this.credits = credits;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public Date getCreationDatetime() {
		return creationDatetime;
	}
	public void setCreationDatetime(Date creationDatetime) {
		this.creationDatetime = creationDatetime;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
