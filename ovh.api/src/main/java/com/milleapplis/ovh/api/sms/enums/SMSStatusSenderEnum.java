package com.milleapplis.ovh.api.sms.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum SMSStatusSenderEnum {
	DISABLE("disable"),
	ENABLE("enable"),
	REFUSED("refused"),
	WAITING_VALIDATION("waitingValidation");
	
	
	private String priority; 
	
	private SMSStatusSenderEnum(String priority) {
		this.priority = priority;
	}
	
	@JsonValue
	public String toString() {
		return priority;
	}
	
	@JsonValue
	public SMSStatusSenderEnum fromString(String value) {
		if (value == null) {
			return null;
		}
		for (SMSStatusSenderEnum currentPriority : SMSStatusSenderEnum.values()) {
			if (value.equals(currentPriority.toString())) {
				return currentPriority;
			}
		}
		return null;
	}
}
