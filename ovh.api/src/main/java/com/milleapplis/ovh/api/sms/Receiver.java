package com.milleapplis.ovh.api.sms;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Receiver {

	@JsonProperty
	private long slotId;
	@JsonProperty
	private long records;
	@JsonProperty
	private String description;
	@JsonProperty
	private Date datetime;
	
	
	
	public long getSlotId() {
		return slotId;
	}
	public void setSlotId(long slotId) {
		this.slotId = slotId;
	}
	public long getRecords() {
		return records;
	}
	public void setRecords(long records) {
		this.records = records;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	
	
	
}
