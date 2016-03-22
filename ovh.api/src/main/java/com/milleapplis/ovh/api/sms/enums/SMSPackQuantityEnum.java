package com.milleapplis.ovh.api.sms.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum SMSPackQuantityEnum {
	_100("100"),
	_1000("1000"),
	_10000("10000"),
	_100000("100000"),
	_1000000("1000000"),
	_200("200"),
	_250("250"),
	_2500("2500"),
	_25000("25000"),
	_500("500"),
	_5000("5000"),
	_50000("50000");
	
	private String priority; 
	
	private SMSPackQuantityEnum(String priority) {
		this.priority = priority;
	}
	
	@JsonValue
	public String toString() {
		return priority;
	}
	
	@JsonValue
	public SMSPackQuantityEnum fromString(String value) {
		if (value == null) {
			return null;
		}
		for (SMSPackQuantityEnum currentPriority : SMSPackQuantityEnum.values()) {
			if (value.equals(currentPriority.toString())) {
				return currentPriority;
			}
		}
		return null;
	}
}
