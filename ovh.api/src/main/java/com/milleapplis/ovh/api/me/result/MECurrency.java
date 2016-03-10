package com.milleapplis.ovh.api.me.result;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MECurrency {

	@JsonProperty
	private String symbol;
	@JsonProperty
	private String code;
	
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}
