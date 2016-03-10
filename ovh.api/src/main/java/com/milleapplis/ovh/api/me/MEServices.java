package com.milleapplis.ovh.api.me;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.milleapplis.ovh.api.core.AbstractService;
import com.milleapplis.ovh.api.core.OVHApiException;
import com.milleapplis.ovh.api.credential.Credential;
import com.milleapplis.ovh.api.me.enums.MECredentialStateEnum;
import com.milleapplis.ovh.api.me.result.MEApplication;
import com.milleapplis.ovh.api.me.result.MECredential;
import com.milleapplis.ovh.api.me.result.MENichandle;
import com.milleapplis.ovh.api.sms.result.SMSBlacklist;
import com.milleapplis.ovh.api.util.Method;

public class MEServices extends AbstractService {

	public MEServices(Credential credential) {
		super(credential);
	}

	public MENichandle getME() throws OVHApiException {
		String url = String.format("me");
		String result = executeService(Method.GET, url, "");
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(result, MENichandle.class);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Unable to call service me"), e);
		}
	}
	
	
	public List<Long> getMEApiApplication() throws OVHApiException {
		String url = String.format("me/api/application");
		String result = executeService(Method.GET, url, "");
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(result, List.class);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Unable to call service me/api/application"), e);
		}
	}

	
	public MEApplication getMEApiApplication(long applicationId) throws OVHApiException {
		String url = String.format("me/api/application/%s", applicationId);
		String result = executeService(Method.GET, url, "");
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(result, MEApplication.class);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Unable to call service me/api/application/%s", applicationId), e);
		}
	}

	public void DeleteMEApiApplication(long applicationId) throws OVHApiException {
		String url = String.format("me/api/application/%s", applicationId);
		executeService(Method.DELETE, url, "");
	}

	public List<Long> getMEApiCredential(long applicationId, MECredentialStateEnum status) throws OVHApiException {
		String url = String.format("me/api/credential?applicationId=%s", applicationId);
		if (status != null) {
			url += "&status=" + status;
		}

		String result = executeService(Method.GET, url, "");
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(result, List.class);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("me/api/credential?applicationId=%s", applicationId), e);
		}
	}
	
	public MECredential getMEApiCredential(long credentialId) throws OVHApiException {
		String url = String.format("me/api/credential/%s", credentialId);
		String result = executeService(Method.GET, url, "");
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(result, MECredential.class);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("me/api/credential/%s", credentialId), e);
		}
	}
	
	
}
