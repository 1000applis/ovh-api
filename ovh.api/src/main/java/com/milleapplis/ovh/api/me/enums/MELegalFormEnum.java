package com.milleapplis.ovh.api.me.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum MELegalFormEnum {
	ASSOCIATION("association"),
	CORPORATION("corporation"),
	INDIVIDUAL("individual"),
	OTHER("other");
	
	private String priority; 
	
	private MELegalFormEnum(String priority) {
		this.priority = priority;
	}
	
	@JsonValue
	public String toString() {
		return priority;
	}
	
	@JsonValue
	public MELegalFormEnum fromString(String value) {
		if (value == null) {
			return null;
		}
		for (MELegalFormEnum currentPriority : MELegalFormEnum.values()) {
			if (value.equals(currentPriority.toString())) {
				return currentPriority;
			}
		}
		return null;
	}
}
