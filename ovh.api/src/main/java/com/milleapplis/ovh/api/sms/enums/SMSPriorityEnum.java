package com.milleapplis.ovh.api.sms.enums;

public enum SMSPriorityEnum {
	HIGH("high"),
	LOW("low"),
	MEDIUM("medium"),
	VERY_LOW("veryLow");
	
	private String priority; 
	
	private SMSPriorityEnum(String priority) {
		this.priority = priority;
	}
	
	public String toString() {
		return priority;
	}
	
	public static SMSPriorityEnum fromString(String value) {
		if (value == null) {
			return null;
		}
		for (SMSPriorityEnum currentPriority : SMSPriorityEnum.values()) {
			if (value.equals(currentPriority.toString())) {
				return currentPriority;
			}
		}
		return null;
	}
}
