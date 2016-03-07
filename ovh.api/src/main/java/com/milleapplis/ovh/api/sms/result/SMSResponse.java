package com.milleapplis.ovh.api.sms.result;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SMSResponse {

	@JsonProperty
	private String text;
	@JsonProperty
	private String cgiUrl;
	@JsonProperty
	private List<String> trackingOptions;
	@JsonProperty
	private String trackingDefaultSmsSender;
	@JsonProperty
	private String responseType;
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getCgiUrl() {
		return cgiUrl;
	}
	public void setCgiUrl(String cgiUrl) {
		this.cgiUrl = cgiUrl;
	}
	public List<String> getTrackingOptions() {
		return trackingOptions;
	}
	public void setTrackingOptions(List<String> trackingOptions) {
		this.trackingOptions = trackingOptions;
	}
	public String getTrackingDefaultSmsSender() {
		return trackingDefaultSmsSender;
	}
	public void setTrackingDefaultSmsSender(String trackingDefaultSmsSender) {
		this.trackingDefaultSmsSender = trackingDefaultSmsSender;
	}
	public String getResponseType() {
		return responseType;
	}
	public void setResponseType(String responseType) {
		this.responseType = responseType;
	}
	
	
	
	
}
