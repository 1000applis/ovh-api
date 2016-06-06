package com.milleapplis.ovh.api.api;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.milleapplis.ovh.api.auth.AccessRules;
import com.milleapplis.ovh.api.me.enums.MECredentialStateEnum;

public class Credential {

	@JsonProperty
	private boolean ovhSupport;
	@JsonProperty
	private MECredentialStateEnum status;
	@JsonProperty
	private long applicationId;
	@JsonProperty
	private long credentialId;
	@JsonProperty
	private List<AccessRules> rules;
	@JsonProperty
	private Date expiration;
	@JsonProperty
	private Date lastUse;
	@JsonProperty
	private Date creation;
	
	public String toString() {
		return String.format("[OVHSupport : %s][Status : %s][Application id : %s][Credential id : %s][Acess rules : %s][Expiration date : %s][Last use : %s][Creation date : %s]", 
				ovhSupport, status, applicationId, credentialId, rules, expiration, lastUse, creation);
	}
	
	public boolean isOvhSupport() {
		return ovhSupport;
	}
	public void setOvhSupport(boolean ovhSupport) {
		this.ovhSupport = ovhSupport;
	}
	public MECredentialStateEnum getStatus() {
		return status;
	}
	public void setStatus(MECredentialStateEnum status) {
		this.status = status;
	}
	public long getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(long applicationId) {
		this.applicationId = applicationId;
	}
	public long getCredentialId() {
		return credentialId;
	}
	public void setCredentialId(long credentialId) {
		this.credentialId = credentialId;
	}
	public List<AccessRules> getRules() {
		return rules;
	}
	public void setRules(List<AccessRules> rules) {
		this.rules = rules;
	}
	public Date getExpiration() {
		return expiration;
	}
	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}
	public Date getLastUse() {
		return lastUse;
	}
	public void setLastUse(Date lastUse) {
		this.lastUse = lastUse;
	}
	public Date getCreation() {
		return creation;
	}
	public void setCreation(Date creation) {
		this.creation = creation;
	}
}
