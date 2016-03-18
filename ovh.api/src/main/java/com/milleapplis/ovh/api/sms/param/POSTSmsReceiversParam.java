package com.milleapplis.ovh.api.sms.param;

import com.fasterxml.jackson.annotation.JsonProperty;

public class POSTSmsReceiversParam {
	@JsonProperty
	private String csvUrl;
	@JsonProperty
	private String description;
	@JsonProperty
	private long slotId;
	
	
	public String getCsvUrl() {
		return csvUrl;
	}
	public void setCsvUrl(String csvUrl) {
		this.csvUrl = csvUrl;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getSlotId() {
		return slotId;
	}
	public void setSlotId(long slotId) {
		this.slotId = slotId;
	}
	

	
	
}
