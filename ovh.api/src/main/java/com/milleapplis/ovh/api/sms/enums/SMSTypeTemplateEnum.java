package com.milleapplis.ovh.api.sms.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum SMSTypeTemplateEnum {
	ALERTING("alerting"),
	AUTHENTICATION("authentication"),
	TRANSACTIONAL("transactional");
	
	private String priority; 
	
	private SMSTypeTemplateEnum(String priority) {
		this.priority = priority;
	}
	
	@JsonValue
	public String toString() {
		return priority;
	}
	
	public static SMSTypeTemplateEnum fromString(String value) {
		if (value == null) {
			return null;
		}
		for (SMSTypeTemplateEnum currentPriority : SMSTypeTemplateEnum.values()) {
			if (value.equals(currentPriority.toString())) {
				return currentPriority;
			}
		}
		return null;
	}
}
