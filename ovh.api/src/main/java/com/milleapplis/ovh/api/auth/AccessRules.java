package com.milleapplis.ovh.api.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.milleapplis.ovh.api.me.enums.MEAuthMethodEnum;

public class AccessRules {

	@JsonProperty
	private MEAuthMethodEnum method;
	@JsonProperty
	private String path;
	
	public String toString() {
		return String.format("[Method : %s][Path : %s]", method, path);
	}
	
	public MEAuthMethodEnum getMethod() {
		return method;
	}
	public void setMethod(MEAuthMethodEnum method) {
		this.method = method;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	
}
