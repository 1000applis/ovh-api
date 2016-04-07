package com.milleapplis.ovh.api.reference;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CountryEnum {
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
	
	private CountryEnum(String priority) {
		this.priority = priority;
	}
	
	@JsonValue
	public String toString() {
		return priority;
	}
	
	@JsonValue
	public CountryEnum fromString(String value) {
		if (value == null) {
			return null;
		}
		for (CountryEnum currentPriority : CountryEnum.values()) {
			if (value.equals(currentPriority.toString())) {
				return currentPriority;
			}
		}
		return null;
	}
}
