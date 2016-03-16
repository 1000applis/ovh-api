package com.milleapplis.ovh.api.me.result;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MEBillDetail {

	@JsonProperty
	private MEPrice totalPrice;
	@JsonProperty
	private Date periodStart;
	@JsonProperty
	private String quantity;
	@JsonProperty
	private MEPrice unitPrice;
	@JsonProperty
	private String description;
	@JsonProperty
	private String billDetailId;
	@JsonProperty
	private String domain;
	@JsonProperty
	private Date periodEnd;
	
	public String toString() {
		return String.format("[Total price : %s %s][Quantity : %s][Unit price : %s %s]", totalPrice.getValue(), totalPrice.getCurrencyCode().toString(), quantity, unitPrice.getValue(), unitPrice.getCurrencyCode());
	}
	
	public MEPrice getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(MEPrice totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Date getPeriodStart() {
		return periodStart;
	}
	public void setPeriodStart(Date periodStart) {
		this.periodStart = periodStart;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public MEPrice getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(MEPrice unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBillDetailId() {
		return billDetailId;
	}
	public void setBillDetailId(String billDetailId) {
		this.billDetailId = billDetailId;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public Date getPeriodEnd() {
		return periodEnd;
	}
	public void setPeriodEnd(Date periodEnd) {
		this.periodEnd = periodEnd;
	}

	
	
}
