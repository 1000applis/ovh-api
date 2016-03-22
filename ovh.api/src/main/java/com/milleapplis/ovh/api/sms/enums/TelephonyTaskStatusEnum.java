package com.milleapplis.ovh.api.sms.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TelephonyTaskStatusEnum {
	DOING("doing"),
	DONE("done"),
	ERROR("error"),
	PAUSE("pause"),
	TODO("todo");
	
	private String priority; 
	
	private TelephonyTaskStatusEnum(String priority) {
		this.priority = priority;
	}
	
	@JsonValue
	public String toString() {
		return priority;
	}
	
	@JsonValue
	public TelephonyTaskStatusEnum fromString(String value) {
		if (value == null) {
			return null;
		}
		for (TelephonyTaskStatusEnum currentPriority : TelephonyTaskStatusEnum.values()) {
			if (value.equals(currentPriority.toString())) {
				return currentPriority;
			}
		}
		return null;
	}
}
