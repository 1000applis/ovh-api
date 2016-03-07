package com.milleapplis.ovh.api.util;

public enum Method {
	GET("GET"),
	PUT("PUT"),
	POST("POST"),
	DELETE("DELETE");
	
	
	private String method;
	
	private Method(String method) {
		this.method = method; 
	}
	
	public String toString() {
		return method;
	}
}
