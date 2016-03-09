package com.milleapplis.ovh.api.me.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum MECredentialStateEnum {
	EXPIRED("expired"),
	PENDING_VALIDATION("pendingValidation"),
	REFUSED("refused"),
	VALIDATED("validated");
	
	private String priority; 
	
	private MECredentialStateEnum(String priority) {
		this.priority = priority;
	}
	
	@JsonValue
	public String toString() {
		return priority;
	}
	
	@JsonValue
	public MECredentialStateEnum fromString(String value) {
		if (value == null) {
			return null;
		}
		for (MECredentialStateEnum currentPriority : MECredentialStateEnum.values()) {
			if (value.equals(currentPriority.toString())) {
				return currentPriority;
			}
		}
		return null;
	}
}
