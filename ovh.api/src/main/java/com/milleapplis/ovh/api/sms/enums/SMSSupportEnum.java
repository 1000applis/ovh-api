package com.milleapplis.ovh.api.sms.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum SMSSupportEnum {
    BOTH("both"),
    MAIL("mail"),
    SMS("sms");
	
	private String priority; 
	
	private SMSSupportEnum(String priority) {
		this.priority = priority;
	}
	
	@JsonValue
	public String toString() {
		return priority;
	}
	
	@JsonValue
	public SMSSupportEnum fromString(String value) {
		if (value == null) {
			return null;
		}
		for (SMSSupportEnum currentPriority : SMSSupportEnum.values()) {
			if (value.equals(currentPriority.toString())) {
				return currentPriority;
			}
		}
		return null;
	}
}
