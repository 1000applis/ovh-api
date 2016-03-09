package com.milleapplis.ovh.api.sms.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum SMSCodingEnum {
	SEVEN_BIT("7bit"),
	EIGHT_BIT("8bit");
	
	private String priority; 
	
	private SMSCodingEnum(String priority) {
		this.priority = priority;
	}
	
	@JsonValue
	public String toString() {
		return priority;
	}
	
	@JsonValue
	public SMSCodingEnum fromString(String value) {
		if (value == null) {
			return null;
		}
		for (SMSCodingEnum currentPriority : SMSCodingEnum.values()) {
			if (value.equals(currentPriority.toString())) {
				return currentPriority;
			}
		}
		return null;
	}
}
