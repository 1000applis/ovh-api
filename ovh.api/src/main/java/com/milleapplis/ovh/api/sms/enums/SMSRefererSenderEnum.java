package com.milleapplis.ovh.api.sms.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum SMSRefererSenderEnum {
	CUSTOM("custom"),
	DOMAIN("domain"),
	LINE("line"),
	NIC("nic"),
	OWNER("owner");
	
	private String priority; 
	
	private SMSRefererSenderEnum(String priority) {
		this.priority = priority;
	}
	
	@JsonValue
	public String toString() {
		return priority;
	}
	
	@JsonValue
	public SMSRefererSenderEnum fromString(String value) {
		if (value == null) {
			return null;
		}
		for (SMSRefererSenderEnum currentPriority : SMSRefererSenderEnum.values()) {
			if (value.equals(currentPriority.toString())) {
				return currentPriority;
			}
		}
		return null;
	}
}
