package com.milleapplis.ovh.api.telephony;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TaskStatusEnum {
	DOING("doing"),
	DONE("done"),
	ERROR("error"),
	PAUSE("pause"),
	TODO("todo");
	
	private String priority; 
	
	private TaskStatusEnum(String priority) {
		this.priority = priority;
	}
	
	@JsonValue
	public String toString() {
		return priority;
	}
	
	@JsonValue
	public TaskStatusEnum fromString(String value) {
		if (value == null) {
			return null;
		}
		for (TaskStatusEnum currentPriority : TaskStatusEnum.values()) {
			if (value.equals(currentPriority.toString())) {
				return currentPriority;
			}
		}
		return null;
	}
}
