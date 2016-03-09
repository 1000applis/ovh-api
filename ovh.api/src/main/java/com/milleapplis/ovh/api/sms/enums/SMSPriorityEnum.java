package com.milleapplis.ovh.api.sms.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum SMSPriorityEnum {
	HIGH("high"),
	LOW("low"),
	MEDIUM("medium"),
	VERY_LOW("veryLow");
	
	private String priority; 
	
	private SMSPriorityEnum(String priority) {
		this.priority = priority;
	}
	
	@JsonValue
	public String toString() {
		return priority;
	}
	
	@JsonValue
	public static SMSPriorityEnum fromString(String value) {
		if (value == null) {
			return null;
		}
		for (SMSPriorityEnum currentPriority : SMSPriorityEnum.values()) {
			if (value.equals(currentPriority.toString())) {
				return currentPriority;
			}
		}
		return null;
	}
}
