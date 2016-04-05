package com.milleapplis.ovh.api.sms;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Outgoing {

	@JsonProperty
	private String receiver;
	@JsonProperty
	private String tariffCode;
	@JsonProperty
	private long deliveryReceipt;
	@JsonProperty
	private long messageLength;
	@JsonProperty
	private long differedDelivery;
	@JsonProperty
	private double credits;
	@JsonProperty
	private String message;
	@JsonProperty
	private long ptt;
	@JsonProperty
	private String sender;
	@JsonProperty
	private long numberOfSms;
	@JsonProperty
	private Date creationDatetime;
	@JsonProperty
	private long id;
	@JsonProperty
	private String tag;
	
	public String toString() {
		return String.format("[Credit : %s][Sender : %s][Creation date : ‰s][Tag : %s][Message : %s]", credits, sender, creationDatetime, tag, message);
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getTariffCode() {
		return tariffCode;
	}

	public void setTariffCode(String tariffCode) {
		this.tariffCode = tariffCode;
	}

	public long getDeliveryReceipt() {
		return deliveryReceipt;
	}

	public void setDeliveryReceipt(long deliveryReceipt) {
		this.deliveryReceipt = deliveryReceipt;
	}

	public long getMessageLength() {
		return messageLength;
	}

	public void setMessageLength(long messageLength) {
		this.messageLength = messageLength;
	}

	public long getDifferedDelivery() {
		return differedDelivery;
	}

	public void setDifferedDelivery(long differedDelivery) {
		this.differedDelivery = differedDelivery;
	}

	public double getCredits() {
		return credits;
	}

	public void setCredits(double credits) {
		this.credits = credits;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getPtt() {
		return ptt;
	}

	public void setPtt(long ptt) {
		this.ptt = ptt;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public long getNumberOfSms() {
		return numberOfSms;
	}

	public void setNumberOfSms(long numberOfSms) {
		this.numberOfSms = numberOfSms;
	}

	public Date getCreationDatetime() {
		return creationDatetime;
	}

	public void setCreationDatetime(Date creationDatetime) {
		this.creationDatetime = creationDatetime;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	
	
}
