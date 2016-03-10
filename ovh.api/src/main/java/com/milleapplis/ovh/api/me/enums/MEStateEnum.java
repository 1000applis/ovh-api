package com.milleapplis.ovh.api.me.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum MEStateEnum {
	COMPLETE("complete"),
	INCOMPLETE("incomplete");
	
	private String priority; 
	
	private MEStateEnum(String priority) {
		this.priority = priority;
	}
	
	@JsonValue
	public String toString() {
		return priority;
	}
	
	@JsonValue
	public MEStateEnum fromString(String value) {
		if (value == null) {
			return null;
		}
		for (MEStateEnum currentPriority : MEStateEnum.values()) {
			if (value.equals(currentPriority.toString())) {
				return currentPriority;
			}
		}
		return null;
	}
}
