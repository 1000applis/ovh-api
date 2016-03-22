package com.milleapplis.ovh.api.sms.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ReferenceCountryEnum {
	AL("all"),
	CA("ca"),
	CZ("cz"),
	DE("de"),
	EN("en"),
	ES("es"),
	FI("fi"),
	FR("fr"),
	GB("gb"),
	IE("ie"),
	IT("it"),
	LT("lt"),
	MA("ma"),
	NL("nl"),
	PL("pl"),
	PP("pp"),
	PT("pt"),
	QC("qc"),
	RU("ru"),
	SK("sk"),
	SN("sn"),
	TN("tn"),
	WE("we");
	
	private String priority; 
	
	private ReferenceCountryEnum(String priority) {
		this.priority = priority;
	}
	
	@JsonValue
	public String toString() {
		return priority;
	}
	
	@JsonValue
	public ReferenceCountryEnum fromString(String value) {
		if (value == null) {
			return null;
		}
		for (ReferenceCountryEnum currentPriority : ReferenceCountryEnum.values()) {
			if (value.equals(currentPriority.toString())) {
				return currentPriority;
			}
		}
		return null;
	}
}
