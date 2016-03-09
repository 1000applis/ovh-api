package com.milleapplis.ovh.api.sms.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum SMSPttDurationEnum {
	INDETERMINATED("indeterminated"),
	PERMANENT("permanent"),
	TEMPORARY("temporary");
	
	private String priority; 
	
	private SMSPttDurationEnum(String priority) {
		this.priority = priority;
	}
	
	@JsonValue
	public String toString() {
		return priority;
	}
	
	public static SMSPttDurationEnum fromString(String value) {
		if (value == null) {
			return null;
		}
		for (SMSPttDurationEnum currentPriority : SMSPttDurationEnum.values()) {
			if (value.equals(currentPriority.toString())) {
				return currentPriority;
			}
		}
		return null;
	}
}
