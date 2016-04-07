package com.milleapplis.ovh.api.sms;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.milleapplis.ovh.api.sms.enums.SMSQuotaStatusEnum;

public class Quota {
	@JsonProperty
	private SMSQuotaStatusEnum quotaStatus;
	@JsonProperty
	private double quotaLeft;
	
	public String toString() {
		return String.format("[Quota status : %s][Quota left : %s]",quotaStatus, quotaLeft);
	}
	
	public SMSQuotaStatusEnum getQuotaStatus() {
		return quotaStatus;
	}
	public void setQuotaStatus(SMSQuotaStatusEnum quotaStatus) {
		this.quotaStatus = quotaStatus;
	}
	public double getQuotaLeft() {
		return quotaLeft;
	}
	public void setQuotaLeft(double quotaLeft) {
		this.quotaLeft = quotaLeft;
	}

	
}
