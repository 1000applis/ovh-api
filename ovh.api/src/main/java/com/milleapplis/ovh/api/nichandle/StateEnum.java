package com.milleapplis.ovh.api.nichandle;

import com.fasterxml.jackson.annotation.JsonValue;

public enum StateEnum {
	COMPLETE("complete"),
	INCOMPLETE("incomplete");
	
	private String priority; 
	
	private StateEnum(String priority) {
		this.priority = priority;
	}
	
	@JsonValue
	public String toString() {
		return priority;
	}
	
	@JsonValue
	public StateEnum fromString(String value) {
		if (value == null) {
			return null;
		}
		for (StateEnum currentPriority : StateEnum.values()) {
			if (value.equals(currentPriority.toString())) {
				return currentPriority;
			}
		}
		return null;
	}
}
