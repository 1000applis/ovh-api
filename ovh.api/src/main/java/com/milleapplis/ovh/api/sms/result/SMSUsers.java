package com.milleapplis.ovh.api.sms.result;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SMSUsers {

	@JsonProperty
	private SMSQuota quotaInformations;
	@JsonProperty
	private String password;
	@JsonProperty
	private String stopCallBack;
	@JsonProperty
	private List<String> ipRestrictions;
	private SMSAlertThreshold alertThresholdInformations;
	private String login;
	private String callBack;
	
	
	public String toString() {
		return String.format("[Login : %s][Quota info : %s][Stop callback : %s][IP Restrictions : %s][Alert threshold info : %s][Callback : %s]", 
				login, quotaInformations, stopCallBack, ipRestrictions, alertThresholdInformations, callBack);
	}


	public SMSQuota getQuotaInformations() {
		return quotaInformations;
	}


	public void setQuotaInformations(SMSQuota quotaInformations) {
		this.quotaInformations = quotaInformations;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getStopCallBack() {
		return stopCallBack;
	}


	public void setStopCallBack(String stopCallBack) {
		this.stopCallBack = stopCallBack;
	}


	public List<String> getIpRestrictions() {
		return ipRestrictions;
	}


	public void setIpRestrictions(List<String> ipRestrictions) {
		this.ipRestrictions = ipRestrictions;
	}


	public SMSAlertThreshold getAlertThresholdInformations() {
		return alertThresholdInformations;
	}


	public void setAlertThresholdInformations(
			SMSAlertThreshold alertThresholdInformations) {
		this.alertThresholdInformations = alertThresholdInformations;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getCallBack() {
		return callBack;
	}


	public void setCallBack(String callBack) {
		this.callBack = callBack;
	}
	

	
}
