package com.milleapplis.ovh.api.sms.result;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SMSServiceName {
	@JsonProperty
	private SMSResponse smsResponse;
	@JsonProperty
	private String status;
	@JsonProperty
	private long creditsLeft;
	@JsonProperty
	private String name;
	@JsonProperty
	private int userQuantityWithQuota;
	@JsonProperty
	private String description;
	@JsonProperty
	private String callBack;
	@JsonProperty
	private long creditThresholdForAutomaticRecredit;
	@JsonProperty
	private String stopCallBack;
	@JsonProperty
	private long creditsHoldByQuota;
	@JsonProperty
	private String automaticRecreditAmount;
	@JsonProperty
	private Templates templates;
	
	public SMSResponse getSmsResponse() {
		return smsResponse;
	}
	public void setSmsResponse(SMSResponse smsResponse) {
		this.smsResponse = smsResponse;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getCreditsLeft() {
		return creditsLeft;
	}
	public void setCreditsLeft(long creditsLeft) {
		this.creditsLeft = creditsLeft;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUserQuantityWithQuota() {
		return userQuantityWithQuota;
	}
	public void setUserQuantityWithQuota(int userQuantityWithQuota) {
		this.userQuantityWithQuota = userQuantityWithQuota;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCallBack() {
		return callBack;
	}
	public void setCallBack(String callBack) {
		this.callBack = callBack;
	}
	public long getCreditThresholdForAutomaticRecredit() {
		return creditThresholdForAutomaticRecredit;
	}
	public void setCreditThresholdForAutomaticRecredit(long creditThresholdForAutomaticRecredit) {
		this.creditThresholdForAutomaticRecredit = creditThresholdForAutomaticRecredit;
	}
	public String getStopCallBack() {
		return stopCallBack;
	}
	public void setStopCallBack(String stopCallBack) {
		this.stopCallBack = stopCallBack;
	}
	public long getCreditsHoldByQuota() {
		return creditsHoldByQuota;
	}
	public void setCreditsHoldByQuota(long creditsHoldByQuota) {
		this.creditsHoldByQuota = creditsHoldByQuota;
	}
	public String getAutomaticRecreditAmount() {
		return automaticRecreditAmount;
	}
	public void setAutomaticRecreditAmount(String automaticRecreditAmount) {
		this.automaticRecreditAmount = automaticRecreditAmount;
	}
	public Templates getTemplates() {
		return templates;
	}
	public void setTemplates(Templates templates) {
		this.templates = templates;
	}
	
	
	
}
