package com.milleapplis.ovh.api.sms.param;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.milleapplis.ovh.api.sms.enums.SMSCodingEnum;

public class POSTSmsJobParam {
	@JsonProperty
	private String charset;
	@JsonProperty("class")
	private String clazz; //: "phoneDisplay",
	@JsonProperty
	private SMSCodingEnum coding; //: "7bit",
	@JsonProperty
	private Long   differedPeriod; //": 0,
	@JsonProperty
	private String message;
	@JsonProperty
	private Boolean noStopClause;
	@JsonProperty
	private String priority;
	@JsonProperty
	private List<String> receivers;
	@JsonProperty
	private String receiversDocumentUrl;
	@JsonProperty
	private String receiversSlotId;
	@JsonProperty
	private String sender;
	@JsonProperty
	private Boolean senderForResponse;
	@JsonProperty
	private String tag;
	@JsonProperty
	private Long validityPeriod;
	
	public String getCharset() {
		return charset;
	}
	public void setCharset(String charset) {
		this.charset = charset;
	}
	public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	public SMSCodingEnum getCoding() {
		return coding;
	}
	public void setCoding(SMSCodingEnum coding) {
		this.coding = coding;
	}
	public Long getDifferedPeriod() {
		return differedPeriod;
	}
	public void setDifferedPeriod(Long differedPeriod) {
		this.differedPeriod = differedPeriod;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Boolean getNoStopClause() {
		return noStopClause;
	}
	public void setNoStopClause(Boolean noStopClause) {
		this.noStopClause = noStopClause;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public List<String> getReceivers() {
		return receivers;
	}
	public void setReceivers(List<String> receivers) {
		this.receivers = receivers;
	}
	public String getReceiversDocumentUrl() {
		return receiversDocumentUrl;
	}
	public void setReceiversDocumentUrl(String receiversDocumentUrl) {
		this.receiversDocumentUrl = receiversDocumentUrl;
	}
	public String getReceiversSlotId() {
		return receiversSlotId;
	}
	public void setReceiversSlotId(String receiversSlotId) {
		this.receiversSlotId = receiversSlotId;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public Boolean getSenderForResponse() {
		return senderForResponse;
	}
	public void setSenderForResponse(Boolean senderForResponse) {
		this.senderForResponse = senderForResponse;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public Long getValidityPeriod() {
		return validityPeriod;
	}
	public void setValidityPeriod(Long validityPeriod) {
		this.validityPeriod = validityPeriod;
	}
}
