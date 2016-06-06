package com.milleapplis.ovh.api.nichandle.accessrestriction;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SOTPAccount {

	@JsonProperty
	private long remaining;
	@JsonProperty
	private SOTPStatusEnum status;
	
	public String toString() {
		return String.format("[Remaining : %s][Status : %s]", remaining, status);
	}

	public long getRemaining() {
		return remaining;
	}

	public void setRemaining(long remaining) {
		this.remaining = remaining;
	}

	public SOTPStatusEnum getStatus() {
		return status;
	}

	public void setStatus(SOTPStatusEnum status) {
		this.status = status;
	}
	
	
	
}
