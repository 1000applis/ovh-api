package com.milleapplis.ovh.api.sms.result;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SMSJob {

	@JsonProperty
	private String receiver;
	@JsonProperty
	private Long deliveryReceipt;
	@JsonProperty
	private Long messageLength;
	@JsonProperty
	private Long differedDelivery;
	@JsonProperty
	private Double credits;
	@JsonProperty
	private String message;
	@JsonProperty
	private Long ptt;
	@JsonProperty
	private String sender;
	@JsonProperty
	private Long numberOfSms;
	@JsonProperty
	private Date creationDatetime;
	@JsonProperty
	private Long id;
	
	
	
	public String toString() {
		return String.format("[Receiver : %s][Message length up to : %s][Credits : %s][Message : %s][Sender : %s][Number of sms : %s][Id : %s]",
				receiver, messageLength, credits, message, sender, numberOfSms, id);
	}



	public String getReceiver() {
		return receiver;
	}



	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}



	public Long getDeliveryReceipt() {
		return deliveryReceipt;
	}



	public void setDeliveryReceipt(Long deliveryReceipt) {
		this.deliveryReceipt = deliveryReceipt;
	}



	public Long getMessageLength() {
		return messageLength;
	}



	public void setMessageLength(Long messageLength) {
		this.messageLength = messageLength;
	}



	public Long getDifferedDelivery() {
		return differedDelivery;
	}



	public void setDifferedDelivery(Long differedDelivery) {
		this.differedDelivery = differedDelivery;
	}



	public Double getCredits() {
		return credits;
	}



	public void setCredits(Double credits) {
		this.credits = credits;
	}



	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public Long getPtt() {
		return ptt;
	}



	public void setPtt(Long ptt) {
		this.ptt = ptt;
	}



	public String getSender() {
		return sender;
	}



	public void setSender(String sender) {
		this.sender = sender;
	}



	public Long getNumberOfSms() {
		return numberOfSms;
	}



	public void setNumberOfSms(Long numberOfSms) {
		this.numberOfSms = numberOfSms;
	}



	public Date getCreationDatetime() {
		return creationDatetime;
	}



	public void setCreationDatetime(Date creationDatetime) {
		this.creationDatetime = creationDatetime;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}

	
}
