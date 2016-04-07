package com.milleapplis.ovh.api.sms;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.milleapplis.ovh.api.sms.enums.SMSSupportEnum;

public class AlertThreshold {
	@JsonProperty
	private SMSSupportEnum support;
	@JsonProperty
	private long alertThreshold;
	@JsonProperty
	private String alertEmail;
	@JsonProperty
	private String alertNumber;
	
	public String toString() {
		return String.format("[Suport : %s][Alert threshold : %s][Alert mail : %s][Alert number : %s]", support, alertThreshold, alertEmail, alertNumber);
	}

	public SMSSupportEnum getSuport() {
		return support;
	}

	public void setSuport(SMSSupportEnum suport) {
		this.support = suport;
	}

	public long getAlertThreshold() {
		return alertThreshold;
	}

	public void setAlertThreshold(long alertThreshold) {
		this.alertThreshold = alertThreshold;
	}

	public String getAlertEmail() {
		return alertEmail;
	}

	public void setAlertEmail(String alertEmail) {
		this.alertEmail = alertEmail;
	}

	public String getAlertNumber() {
		return alertNumber;
	}

	public void setAlertNumber(String alertNumber) {
		this.alertNumber = alertNumber;
	}
	

}
