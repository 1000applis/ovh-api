package com.milleapplis.ovh.api.me.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum MEOvhCompanyEnum {
	KIMSUFI("kimsufi"),
	OVH("ovh"),
	SOYOUSTART("soyoustart");
	
	private String priority; 
	
	private MEOvhCompanyEnum(String priority) {
		this.priority = priority;
	}
	
	@JsonValue
	public String toString() {
		return priority;
	}
	
	@JsonValue
	public MEOvhCompanyEnum fromString(String value) {
		if (value == null) {
			return null;
		}
		for (MEOvhCompanyEnum currentPriority : MEOvhCompanyEnum.values()) {
			if (value.equals(currentPriority.toString())) {
				return currentPriority;
			}
		}
		return null;
	}
}
