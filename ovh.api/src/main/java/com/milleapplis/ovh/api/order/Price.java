package com.milleapplis.ovh.api.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.milleapplis.ovh.api.me.enums.MECurrencyCodeEnum;

public class Price {

	@JsonProperty
	private MECurrencyCodeEnum currencyCode;
	@JsonProperty
	private double value;
	@JsonProperty
	private String text;
	
	public MECurrencyCodeEnum getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(MECurrencyCodeEnum currencyCode) {
		this.currencyCode = currencyCode;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
}
