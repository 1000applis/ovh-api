package com.milleapplis.ovh.api.me.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum MEGenderEnum {
	FEMALE("female"),
	MALE("male");
	
	private String priority; 
	
	private MEGenderEnum(String priority) {
		this.priority = priority;
	}
	
	@JsonValue
	public String toString() {
		return priority;
	}
	
	@JsonValue
	public MEGenderEnum fromString(String value) {
		if (value == null) {
			return null;
		}
		for (MEGenderEnum currentPriority : MEGenderEnum.values()) {
			if (value.equals(currentPriority.toString())) {
				return currentPriority;
			}
		}
		return null;
	}
}
