package com.milleapplis.ovh.api.sms.result;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SMSHlr {

	@JsonProperty
	private String country;
	@JsonProperty
	private String operator;
	@JsonProperty
	private String network;
	@JsonProperty
	private String region;
	@JsonProperty
	private String countryCode;
	
	public String toString() {
		return String.format("[Country : %s][Operator : %s][Network : %s][Region : %s][Country code : %S]", country, operator, network, region, countryCode);
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	
}
