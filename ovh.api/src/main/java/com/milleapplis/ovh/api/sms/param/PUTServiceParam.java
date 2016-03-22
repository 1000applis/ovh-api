package com.milleapplis.ovh.api.sms.param;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PUTServiceParam {
	@JsonProperty
	private ServiceRenew renew;

	public ServiceRenew getRenew() {
		return renew;
	}

	public void setRenew(ServiceRenew renew) {
		this.renew = renew;
	}

	
	
}
