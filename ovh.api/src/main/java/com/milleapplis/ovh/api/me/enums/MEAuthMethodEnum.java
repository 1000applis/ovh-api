package com.milleapplis.ovh.api.me.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum MEAuthMethodEnum {
	DELETE("DELETE"),
	GET("GET"),
	POST("POST"),
	PUT("PUT");
	
	private String priority; 
	
	private MEAuthMethodEnum(String priority) {
		this.priority = priority;
	}
	
	@JsonValue
	public String toString() {
		return priority;
	}
	
	@JsonValue
	public MEAuthMethodEnum fromString(String value) {
		if (value == null) {
			return null;
		}
		for (MEAuthMethodEnum currentPriority : MEAuthMethodEnum.values()) {
			if (value.equals(currentPriority.toString())) {
				return currentPriority;
			}
		}
		return null;
	}
}
