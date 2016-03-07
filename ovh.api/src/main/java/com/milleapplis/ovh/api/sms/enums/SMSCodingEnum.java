package com.milleapplis.ovh.api.sms.enums;

public enum SMSCodingEnum {
	SEVEN_BIT("7bit"),
	EIGHT_BIT("8bit");
	
	private String priority; 
	
	private SMSCodingEnum(String priority) {
		this.priority = priority;
	}
	
	public String toString() {
		return priority;
	}
	
	public SMSCodingEnum fromString(String value) {
		if (value == null) {
			return null;
		}
		for (SMSCodingEnum currentPriority : SMSCodingEnum.values()) {
			if (value.equals(currentPriority.toString())) {
				return currentPriority;
			}
		}
		return null;
	}
}
