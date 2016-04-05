package com.milleapplis.ovh.api.sms;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReceiversAsynchronousCleanReport {

	@JsonProperty
	private double totalCreditsRemoved;
	@JsonProperty
	private long taskId;
	
	
	public double getTotalCreditsRemoved() {
		return totalCreditsRemoved;
	}
	public void setTotalCreditsRemoved(double totalCreditsRemoved) {
		this.totalCreditsRemoved = totalCreditsRemoved;
	}
	public long getTaskId() {
		return taskId;
	}
	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}
	
	
}
