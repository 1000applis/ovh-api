package com.milleapplis.ovh.api.nichandle;

import com.fasterxml.jackson.annotation.JsonValue;

public enum OvhCompanyEnum {
	KIMSUFI("kimsufi"),
	OVH("ovh"),
	SOYOUSTART("soyoustart");
	
	private String priority; 
	
	private OvhCompanyEnum(String priority) {
		this.priority = priority;
	}
	
	@JsonValue
	public String toString() {
		return priority;
	}
	
	@JsonValue
	public OvhCompanyEnum fromString(String value) {
		if (value == null) {
			return null;
		}
		for (OvhCompanyEnum currentPriority : OvhCompanyEnum.values()) {
			if (value.equals(currentPriority.toString())) {
				return currentPriority;
			}
		}
		return null;
	}
}
