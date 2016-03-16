package com.milleapplis.ovh.api.me.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum MEPaymentMeanEnum {
	CASH("cash"),
	CHARGEBACK("chargeback"),
	CHEQUE("cheque"),
	CREDITCARD("creditCard"),
	DEPOSIT("deposit"),
	DIGITAL_LAUNCH_PAD("digitalLaunchPad"),
	EDINAR("edinar"),
	FIDELITY_POINTS("fidelityPoints"),
	FREE("free"),
	IDEAL("ideal"),
	MANDAT("mandat"),
	MULTIBANCO("multibanco"),
	NONE("none"),
	OVH_ACCOUNT("ovhAccount"),
	PAYMENT_MANDATE("paymentMandate"),
	PAYPAL("paypal"),
	PLATNOSCI("platnosci"),
	REFUND("refund"),
	TRANSFERT("transfer"),
	WITHDRAWAL("withdrawal");
	
	private String priority; 
	
	private MEPaymentMeanEnum(String priority) {
		this.priority = priority;
	}
	
	@JsonValue
	public String toString() {
		return priority;
	}
	
	@JsonValue
	public MEPaymentMeanEnum fromString(String value) {
		if (value == null) {
			return null;
		}
		for (MEPaymentMeanEnum currentPriority : MEPaymentMeanEnum.values()) {
			if (value.equals(currentPriority.toString())) {
				return currentPriority;
			}
		}
		return null;
	}
}
