package com.milleapplis.ovh.api.me.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum MEApplicationStatusEnum {
	ACTIVE("active"),
	BLOCKED("blocked"),
	INACTIVE("inactive"),
	TRUSTED("trusted");
	
	private String priority; 
	
	private MEApplicationStatusEnum(String priority) {
		this.priority = priority;
	}
	
	@JsonValue
	public String toString() {
		return priority;
	}
	
	@JsonValue
	public MEApplicationStatusEnum fromString(String value) {
		if (value == null) {
			return null;
		}
		for (MEApplicationStatusEnum currentPriority : MEApplicationStatusEnum.values()) {
			if (value.equals(currentPriority.toString())) {
				return currentPriority;
			}
		}
		return null;
	}
}
