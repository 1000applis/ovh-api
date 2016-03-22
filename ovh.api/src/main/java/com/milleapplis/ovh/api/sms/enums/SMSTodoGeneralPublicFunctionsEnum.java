package com.milleapplis.ovh.api.sms.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum SMSTodoGeneralPublicFunctionsEnum {
    CLEAN_SMS_RECEIVERS("cleanSmsReceivers");
	
	private String priority; 
	
	private SMSTodoGeneralPublicFunctionsEnum(String priority) {
		this.priority = priority;
	}
	
	@JsonValue
	public String toString() {
		return priority;
	}
	
	@JsonValue
	public SMSTodoGeneralPublicFunctionsEnum fromString(String value) {
		if (value == null) {
			return null;
		}
		for (SMSTodoGeneralPublicFunctionsEnum currentPriority : SMSTodoGeneralPublicFunctionsEnum.values()) {
			if (value.equals(currentPriority.toString())) {
				return currentPriority;
			}
		}
		return null;
	}
}
