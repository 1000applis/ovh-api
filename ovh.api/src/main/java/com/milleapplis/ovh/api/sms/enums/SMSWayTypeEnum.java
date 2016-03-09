package com.milleapplis.ovh.api.sms.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum SMSWayTypeEnum {
	INCOMING("incoming"),
	OUTGOING("outgoing");
	
	private String priority; 
	
	private SMSWayTypeEnum(String priority) {
		this.priority = priority;
	}
	
	@JsonValue
	public String toString() {
		return priority;
	}
	
	@JsonValue
	public SMSWayTypeEnum fromString(String value) {
		if (value == null) {
			return null;
		}
		for (SMSWayTypeEnum currentPriority : SMSWayTypeEnum.values()) {
			if (value.equals(currentPriority.toString())) {
				return currentPriority;
			}
		}
		return null;
	}
}
