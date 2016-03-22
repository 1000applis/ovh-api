package com.milleapplis.ovh.api.sms.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum SMSTodoGeneralPublicStepsEnum {
    CHECK_ORDER("checkOrder"),
    CREATE_HLRS("createHlrs"),
    FINISHING("finishing"),
    SEND_MAIL_REPORT("sendMailReport"),
    STARTING("starting"),
    WAIT_FOR_HLRS("waitForHlrs");
	
	private String priority; 
	
	private SMSTodoGeneralPublicStepsEnum(String priority) {
		this.priority = priority;
	}
	
	@JsonValue
	public String toString() {
		return priority;
	}
	
	@JsonValue
	public SMSTodoGeneralPublicStepsEnum fromString(String value) {
		if (value == null) {
			return null;
		}
		for (SMSTodoGeneralPublicStepsEnum currentPriority : SMSTodoGeneralPublicStepsEnum.values()) {
			if (value.equals(currentPriority.toString())) {
				return currentPriority;
			}
		}
		return null;
	}
}
