package com.milleapplis.ovh.api.nichandle;

import com.fasterxml.jackson.annotation.JsonValue;

public enum LegalFormEnum {
	ASSOCIATION("association"),
	CORPORATION("corporation"),
	INDIVIDUAL("individual"),
	OTHER("other");
	
	private String priority; 
	
	private LegalFormEnum(String priority) {
		this.priority = priority;
	}
	
	@JsonValue
	public String toString() {
		return priority;
	}
	
	@JsonValue
	public LegalFormEnum fromString(String value) {
		if (value == null) {
			return null;
		}
		for (LegalFormEnum currentPriority : LegalFormEnum.values()) {
			if (value.equals(currentPriority.toString())) {
				return currentPriority;
			}
		}
		return null;
	}
}
