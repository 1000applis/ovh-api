package com.milleapplis.ovh.api.sms.result;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ServiceRenew {

	@JsonProperty
	private Long period;
	@JsonProperty
	private boolean forced;
	@JsonProperty
	private boolean automatic;
	@JsonProperty
	private boolean deleteAtExpiration;
	
	public String toString() {
		return String.format("[Period : %s][Forced : %s][Automatic : %s][Delete at expiration : %s]", 
				period, forced, automatic, deleteAtExpiration);
	}
	
	public Long getPeriod() {
		return period;
	}
	public void setPeriod(Long period) {
		this.period = period;
	}
	public boolean isForced() {
		return forced;
	}
	public void setForced(boolean forced) {
		this.forced = forced;
	}
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

	
	
}
