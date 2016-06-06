package com.milleapplis.ovh.api.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.milleapplis.ovh.api.me.enums.MEApplicationStatusEnum;

public class Application {

	@JsonProperty
	private MEApplicationStatusEnum status;
	@JsonProperty
	private String name;
	@JsonProperty
	private long applicationId;
	@JsonProperty
	private String description;
	@JsonProperty
	private String applicationKey;
	
	public MEApplicationStatusEnum getStatus() {
		return status;
	}
	public void setStatus(MEApplicationStatusEnum status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(long applicationId) {
		this.applicationId = applicationId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getApplicationKey() {
		return applicationKey;
	}
	public void setApplicationKey(String applicationKey) {
		this.applicationKey = applicationKey;
	}
	
	public String toString() {
		return String.format("[Id : %s][Status : %s][Name : %s][Description : %s]", applicationId, status, name, description);
	}
	
}
