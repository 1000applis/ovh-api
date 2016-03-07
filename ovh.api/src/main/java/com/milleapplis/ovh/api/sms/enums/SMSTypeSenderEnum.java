package com.milleapplis.ovh.api.sms.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum SMSTypeSenderEnum {
	ALPHA("alpha"),
	NUMERIC("numeric");
	
	private String priority; 
	
	private SMSTypeSenderEnum(String priority) {
		this.priority = priority;
	}
	
	@JsonValue
	public String toString() {
		return priority;
	}
	
	@JsonValue
	public SMSTypeSenderEnum fromString(String value) {
		if (value == null) {
			return null;
		}
		for (SMSTypeSenderEnum currentPriority : SMSTypeSenderEnum.values()) {
			if (value.equals(currentPriority.toString())) {
				return currentPriority;
			}
		}
		return null;
	}
}
