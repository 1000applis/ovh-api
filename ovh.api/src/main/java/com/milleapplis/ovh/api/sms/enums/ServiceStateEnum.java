package com.milleapplis.ovh.api.sms.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ServiceStateEnum {
    EXPIRED("expired"),
    IN_CREATION("inCreation"),
    OK("ok"),
    UN_PAID("unPaid");
	
	private String priority; 
	
	private ServiceStateEnum(String priority) {
		this.priority = priority;
	}
	
	@JsonValue
	public String toString() {
		return priority;
	}
	
	@JsonValue
	public ServiceStateEnum fromString(String value) {
		if (value == null) {
			return null;
		}
		for (ServiceStateEnum currentPriority : ServiceStateEnum.values()) {
			if (value.equals(currentPriority.toString())) {
				return currentPriority;
			}
		}
		return null;
	}
}
