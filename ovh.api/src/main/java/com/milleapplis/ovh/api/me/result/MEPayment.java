package com.milleapplis.ovh.api.me.result;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.milleapplis.ovh.api.me.enums.MEPaymentMeanEnum;

public class MEPayment {

	@JsonProperty
	private Date paymentDate;
	@JsonProperty
	private String paymentIdentifier;
	@JsonProperty
	private MEPaymentMeanEnum paymentType;
	
	public String toString() {
		return String.format("[Payment date : %s][Payment identifier : %s][Payment type : %s]", paymentDate, paymentIdentifier, paymentType);
	}
	
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public String getPaymentIdentifier() {
		return paymentIdentifier;
	}
	public void setPaymentIdentifier(String paymentIdentifier) {
		this.paymentIdentifier = paymentIdentifier;
	}
	public MEPaymentMeanEnum getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(MEPaymentMeanEnum paymentType) {
		this.paymentType = paymentType;
	}
	
	
}
