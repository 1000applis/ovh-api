package com.milleapplis.ovh.api.me.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum MELanguageEnum {
	cs_CZ("cs_CZ"),
	de_DE("de_DE"),
	en_GB("en_GB"),
	en_IE("en_IE"),
	es_ES("es_ES"),
	fi_FI("fi_FI"),
	fr_FR("fr_FR"),
	fr_MA("fr_MA"),
	fr_SN("fr_SN"),
	fr_TN("fr_TN"),
	it_IT("it_IT"),
	lt_LT("lt_LT"),
	nl_NL("nl_NL"),
	pl_PL("pl_PL"),
	pt_PT("pt_PT");
	
	private String priority; 
	
	private MELanguageEnum(String priority) {
		this.priority = priority;
	}
	
	@JsonValue
	public String toString() {
		return priority;
	}
	
	@JsonValue
	public MELanguageEnum fromString(String value) {
		if (value == null) {
			return null;
		}
		for (MELanguageEnum currentPriority : MELanguageEnum.values()) {
			if (value.equals(currentPriority.toString())) {
				return currentPriority;
			}
		}
		return null;
	}
}
