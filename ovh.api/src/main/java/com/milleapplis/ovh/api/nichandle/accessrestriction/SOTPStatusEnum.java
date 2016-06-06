package com.milleapplis.ovh.api.nichandle.accessrestriction;

import com.fasterxml.jackson.annotation.JsonValue;

public enum SOTPStatusEnum {
	DISABLED("disabled"),
	ENABLED("enabled"),
	NEED_CODE_VALIDATION("needCodeValidation"),
	NEED_EMAIL_VALIDATION("needEmailValidation");
	
	private String priority; 
	
	private SOTPStatusEnum(String priority) {
		this.priority = priority;
	}
	
	@JsonValue
	public String toString() {
		return priority;
	}
	
	@JsonValue
	public SOTPStatusEnum fromString(String value) {
		if (value == null) {
			return null;
		}
		for (SOTPStatusEnum currentPriority : SOTPStatusEnum.values()) {
			if (value.equals(currentPriority.toString())) {
				return currentPriority;
			}
		}
		return null;
	}
}
