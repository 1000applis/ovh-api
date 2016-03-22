package com.milleapplis.ovh.api.sms.param;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ServiceRenew {
	@JsonProperty
	private boolean automatic;
	@JsonProperty
	private boolean deleteAtExpiration;
	@JsonProperty
	private boolean forced;
	@JsonProperty
	private long period;
	
	public boolean isAutomatic() {
		return automatic;
	}
	public void setAutomatic(boolean automatic) {
		this.automatic = automatic;
	}
	public boolean isDeleteAtExpiration() {
		return deleteAtExpiration;
	}
	public void setDeleteAtExpiration(boolean deleteAtExpiration) {
		this.deleteAtExpiration = deleteAtExpiration;
	}
	public boolean isForced() {
		return forced;
	}
	public void setForced(boolean forced) {
		this.forced = forced;
	}
	public long getPeriod() {
		return period;
	}
	public void setPeriod(long period) {
		this.period = period;
	}
	
}
