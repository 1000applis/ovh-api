package com.milleapplis.ovh.api.nichandle;

import com.fasterxml.jackson.annotation.JsonValue;

public enum OvhSubsidiaryEnum {
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
	
	private OvhSubsidiaryEnum(String priority) {
		this.priority = priority;
	}
	
	@JsonValue
	public String toString() {
		return priority;
	}
	
	@JsonValue
	public OvhSubsidiaryEnum fromString(String value) {
		if (value == null) {
			return null;
		}
		for (OvhSubsidiaryEnum currentPriority : OvhSubsidiaryEnum.values()) {
			if (value.equals(currentPriority.toString())) {
				return currentPriority;
			}
		}
		return null;
	}
}
