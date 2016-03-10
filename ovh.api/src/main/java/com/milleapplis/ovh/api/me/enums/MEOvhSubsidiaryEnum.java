package com.milleapplis.ovh.api.me.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum MEOvhSubsidiaryEnum {
    CA("CA"),
    CZ("CZ"),
    DE("DE"),
    ES("ES"),
    EU("EU"),
    FI("FI"),
    FR("FR"),
    GB("GB"),
    IE("IE"),
    IT("IT"),
    LT("LT"),
    MA("MA"),
    NL("NL"),
    PL("PL"),
    PT("PT"),
    QC("QC"),
    SN("SN"),
    TN("TN"),
    WE("WE"),
    WS("WS");
	
	private String priority; 
	
	private MEOvhSubsidiaryEnum(String priority) {
		this.priority = priority;
	}
	
	@JsonValue
	public String toString() {
		return priority;
	}
	
	@JsonValue
	public MEOvhSubsidiaryEnum fromString(String value) {
		if (value == null) {
			return null;
		}
		for (MEOvhSubsidiaryEnum currentPriority : MEOvhSubsidiaryEnum.values()) {
			if (value.equals(currentPriority.toString())) {
				return currentPriority;
			}
		}
		return null;
	}
}
