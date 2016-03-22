package com.milleapplis.ovh.api.sms.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.milleapplis.ovh.api.sms.enums.SMSTodoGeneralPublicFunctionsEnum;
import com.milleapplis.ovh.api.sms.enums.SMSTodoGeneralPublicStepsEnum;
import com.milleapplis.ovh.api.sms.enums.TelephonyTaskStatusEnum;

public class SMSTask {
	@JsonProperty
	private SMSTodoGeneralPublicStepsEnum step;
	@JsonProperty
	private long taskId;
	@JsonProperty
	private SMSTodoGeneralPublicFunctionsEnum function;
	@JsonProperty
	private TelephonyTaskStatusEnum status;

	public String toString() {
		return String.format("[Step : %s][Task id : %s][Function : %s][Status : %s]", step, taskId, function, status);
	}

	public SMSTodoGeneralPublicStepsEnum getStep() {
		return step;
	}

	public void setStep(SMSTodoGeneralPublicStepsEnum step) {
		this.step = step;
	}

	public long getTaskId() {
		return taskId;
	}

	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}

	public SMSTodoGeneralPublicFunctionsEnum getFunction() {
		return function;
	}

	public void setFunction(SMSTodoGeneralPublicFunctionsEnum function) {
		this.function = function;
	}

	public TelephonyTaskStatusEnum getStatus() {
		return status;
	}

	public void setStatus(TelephonyTaskStatusEnum status) {
		this.status = status;
	}
	
	
}
