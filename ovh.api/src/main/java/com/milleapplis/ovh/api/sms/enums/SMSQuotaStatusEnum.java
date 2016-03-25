package com.milleapplis.ovh.api.sms.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum SMSQuotaStatusEnum {
    ACTIVE("active"),
    INACTIVE("inactive");
	
	private String priority; 
	
	private SMSQuotaStatusEnum(String priority) {
		this.priority = priority;
	}
	
	@JsonValue
	public String toString() {
		return priority;
	}
	
	@JsonValue
	public SMSQuotaStatusEnum fromString(String value) {
		if (value == null) {
			return null;
		}
		for (SMSQuotaStatusEnum currentPriority : SMSQuotaStatusEnum.values()) {
			if (value.equals(currentPriority.toString())) {
				return currentPriority;
			}
		}
		return null;
	}
}
