package com.milleapplis.ovh.api.nichandle;

import com.fasterxml.jackson.annotation.JsonValue;

public enum GenderEnum {
	FEMALE("female"),
	MALE("male");
	
	private String priority; 
	
	private GenderEnum(String priority) {
		this.priority = priority;
	}
	
	@JsonValue
	public String toString() {
		return priority;
	}
	
	@JsonValue
	public GenderEnum fromString(String value) {
		if (value == null) {
			return null;
		}
		for (GenderEnum currentPriority : GenderEnum.values()) {
			if (value.equals(currentPriority.toString())) {
				return currentPriority;
			}
		}
		return null;
	}
}
