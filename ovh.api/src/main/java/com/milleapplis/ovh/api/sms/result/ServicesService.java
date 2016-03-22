package com.milleapplis.ovh.api.sms.result;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.milleapplis.ovh.api.sms.enums.ServiceStateEnum;

public class ServicesService {

	@JsonProperty
	private ServiceStateEnum status;
	@JsonProperty
	private Date engagedUpTo;
	@JsonProperty
	private List<Long> possibleRenewPeriod;
	@JsonProperty
	private String contactBilling;
	@JsonProperty
	private ServiceRenew renew;
	@JsonProperty
	private String domain;
	@JsonProperty
	private Date expiration;
	@JsonProperty
	private String contactTech;
	@JsonProperty
	private String contactAdmin;
	@JsonProperty
	private Date creation;
	
	
	
	public String toString() {
		return String.format("[Status : %s][EngagedU up to : %s][Possible renew period : %s][Contact billing : %s][Renew : %s][Domain : %s][Expiration : %s][Contact tech : %s][Contact admin : %s]",
				status, engagedUpTo, possibleRenewPeriod, contactBilling, renew, domain, expiration, contactTech, contactAdmin);
	}

	
	
	public ServiceStateEnum getStatus() {
		return status;
	}

	public void setStatus(ServiceStateEnum status) {
		this.status = status;
	}

	public Date getEngagedUpTo() {
		return engagedUpTo;
	}

	public void setEngagedUpTo(Date engagedUpTo) {
		this.engagedUpTo = engagedUpTo;
	}

	public List<Long> getPossibleRenewPeriod() {
		return possibleRenewPeriod;
	}

	public void setPossibleRenewPeriod(List<Long> possibleRenewPeriod) {
		this.possibleRenewPeriod = possibleRenewPeriod;
	}

	public String getContactBilling() {
		return contactBilling;
	}

	public void setContactBilling(String contactBilling) {
		this.contactBilling = contactBilling;
	}

	public ServiceRenew getRenew() {
		return renew;
	}

	public void setRenew(ServiceRenew renew) {
		this.renew = renew;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public Date getExpiration() {
		return expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

	public String getContactTech() {
		return contactTech;
	}

	public void setContactTech(String contactTech) {
		this.contactTech = contactTech;
	}

	public String getContactAdmin() {
		return contactAdmin;
	}

	public void setContactAdmin(String contactAdmin) {
		this.contactAdmin = contactAdmin;
	}

	public Date getCreation() {
		return creation;
	}

	public void setCreation(Date creation) {
		this.creation = creation;
	}

	
	
}
