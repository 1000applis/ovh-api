package com.milleapplis.ovh.api.billing;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.milleapplis.ovh.api.order.Price;

public class BillDetail {

	@JsonProperty
	private Price totalPrice;
	@JsonProperty
	private Date periodStart;
	@JsonProperty
	private String quantity;
	@JsonProperty
	private Price unitPrice;
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
	
	public Price getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Price totalPrice) {
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
	public Price getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Price unitPrice) {
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
