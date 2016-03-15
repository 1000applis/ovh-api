package com.milleapplis.ovh.api.me.result;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.milleapplis.ovh.api.me.enums.MEAuthMethodEnum;
import com.milleapplis.ovh.api.me.enums.MECurrencyCodeEnum;

public class MEBill {

	@JsonProperty
	private String pdfUrl;
	@JsonProperty
	private Date date;
	@JsonProperty
	private Price priceWithoutTax;
	@JsonProperty
	private Price tax;
	@JsonProperty
	private String billId;
	@JsonProperty
	private String password;
	@JsonProperty
	private long orderId;
	@JsonProperty
	private String url;
	@JsonProperty
	private Price priceWithTax;
	
	
	public String getPdfUrl() {
		return pdfUrl;
	}
	public void setPdfUrl(String pdfUrl) {
		this.pdfUrl = pdfUrl;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Price getPriceWithoutTax() {
		return priceWithoutTax;
	}
	public void setPriceWithoutTax(Price priceWithoutTax) {
		this.priceWithoutTax = priceWithoutTax;
	}
	public Price getTax() {
		return tax;
	}
	public void setTax(Price tax) {
		this.tax = tax;
	}
	public String getBillId() {
		return billId;
	}
	public void setBillId(String billId) {
		this.billId = billId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Price getPriceWithTax() {
		return priceWithTax;
	}
	public void setPriceWithTax(Price priceWithTax) {
		this.priceWithTax = priceWithTax;
	}
	
	
}
