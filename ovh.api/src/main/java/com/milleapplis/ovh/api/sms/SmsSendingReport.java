package com.milleapplis.ovh.api.sms;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SmsSendingReport {

	@JsonProperty
	private double  totalCreditsRemoved;
	@JsonProperty
	private List<String> invalidReceivers;
	@JsonProperty
	private List<String> ids;
	@JsonProperty
	private List<String> validReceivers;
	
	
	
	public double getTotalCreditsRemoved() {
		return totalCreditsRemoved;
	}
	public void setTotalCreditsRemoved(double totalCreditsRemoved) {
		this.totalCreditsRemoved = totalCreditsRemoved;
	}
	public List<String> getInvalidReceivers() {
		return invalidReceivers;
	}
	public void setInvalidReceivers(List<String> invalidReceivers) {
		this.invalidReceivers = invalidReceivers;
	}
	public List<String> getIds() {
		return ids;
	}
	public void setIds(List<String> ids) {
		this.ids = ids;
	}
	public List<String> getValidReceivers() {
		return validReceivers;
	}
	public void setValidReceivers(List<String> validReceivers) {
		this.validReceivers = validReceivers;
	}
	

}
