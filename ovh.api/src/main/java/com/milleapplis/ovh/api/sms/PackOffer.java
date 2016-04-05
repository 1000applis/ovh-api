package com.milleapplis.ovh.api.sms;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PackOffer {

	@JsonProperty
	private double smsQuantity;
	@JsonProperty
	private double giftQuantity;
	@JsonProperty
	private String language;
	@JsonProperty
	private Double totalPrice;
	@JsonProperty
	private long quantity;
	@JsonProperty
	private Double giftPrice;
	@JsonProperty
	private String countryDestination;
	@JsonProperty
	private double price;
	
	
	public double getSmsQuantity() {
		return smsQuantity;
	}
	public void setSmsQuantity(double smsQuantity) {
		this.smsQuantity = smsQuantity;
	}
	public double getGiftQuantity() {
		return giftQuantity;
	}
	public void setGiftQuantity(double giftQuantity) {
		this.giftQuantity = giftQuantity;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public Double getGiftPrice() {
		return giftPrice;
	}
	public void setGiftPrice(Double giftPrice) {
		this.giftPrice = giftPrice;
	}
	public String getCountryDestination() {
		return countryDestination;
	}
	public void setCountryDestination(String countryDestination) {
		this.countryDestination = countryDestination;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
