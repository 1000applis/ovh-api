package com.milleapplis.ovh.api.nichandle.accessrestriction;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SOTPSecret {

	@JsonProperty
	private List<String> codes;
	
	public String toString() {
		return String.format("[codes : %s]", codes);
	}

	public List<String> getCodes() {
		return codes;
	}

	public void setCodes(List<String> codes) {
		this.codes = codes;
	}

	
	
	
}
