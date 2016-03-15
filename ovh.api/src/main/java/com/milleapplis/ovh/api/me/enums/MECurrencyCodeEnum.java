package com.milleapplis.ovh.api.me.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum MECurrencyCodeEnum {
    CAD("CAD"),
    CZK("CZK"),
    EUR("EUR"),
    GBP("GBP"),
    LTL("LTL"),
    MAD("MAD"),
    NA("N/A"),
    PLN("PLN"),
    TND("TND"),
    USD("USD"),
    XOF("XOF"),
    POINTS("points");
	
	private String priority; 
	
	private MECurrencyCodeEnum(String priority) {
		this.priority = priority;
	}
	
	@JsonValue
	public String toString() {
		return priority;
	}
	
	@JsonValue
	public MECurrencyCodeEnum fromString(String value) {
		if (value == null) {
			return null;
		}
		for (MECurrencyCodeEnum currentPriority : MECurrencyCodeEnum.values()) {
			if (value.equals(currentPriority.toString())) {
				return currentPriority;
			}
		}
		return null;
	}
}
