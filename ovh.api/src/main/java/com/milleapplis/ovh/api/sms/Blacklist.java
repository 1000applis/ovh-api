package com.milleapplis.ovh.api.sms;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Blacklist {

	@JsonProperty
	private Date dateCreation;
	@JsonProperty
	private String number;
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}

	
	
}
