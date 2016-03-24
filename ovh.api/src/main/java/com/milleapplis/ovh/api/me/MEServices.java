package com.milleapplis.ovh.api.me;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.milleapplis.ovh.api.core.AbstractService;
import com.milleapplis.ovh.api.core.OVHApiException;
import com.milleapplis.ovh.api.credential.Credential;
import com.milleapplis.ovh.api.me.enums.MECredentialStateEnum;
import com.milleapplis.ovh.api.me.result.MEApplication;
import com.milleapplis.ovh.api.me.result.MEBill;
import com.milleapplis.ovh.api.me.result.MEBillDetail;
import com.milleapplis.ovh.api.me.result.MECredential;
import com.milleapplis.ovh.api.me.result.MEPayment;
import com.milleapplis.ovh.api.nichandle.Nichandle;
import com.milleapplis.ovh.api.util.Method;

public class MEServices extends AbstractService {

	private static final Logger LOG = LoggerFactory.getLogger(MEServices.class);

	public MEServices(Credential credential) {
		super(credential);
	}

	public Nichandle getME() throws OVHApiException {
		String url = String.format("me");
		String result = executeService(Method.GET, url, "");

		LOG.debug(String.format("%s ==> %s" , url, result));

		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(result, Nichandle.class);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Unable to call service me"), e);
		}
	}
	
	
	public List<Long> getMEApiApplication() throws OVHApiException {
		String url = String.format("me/api/application");
		String result = executeService(Method.GET, url, "");

		LOG.debug(String.format("%s ==> %s" , url, result));

		ObjectMapper mapper = new ObjectMapper();
		try {
			TypeReference<List<Long>> typeRef = new TypeReference<List<Long>>() {};
			return mapper.readValue(result, typeRef);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Unable to call service me/api/application"), e);
		}
	}

	
	public MEApplication getMEApiApplication(long applicationId) throws OVHApiException {
		String url = String.format("me/api/application/%s", applicationId);
		String result = executeService(Method.GET, url, "");

		LOG.debug(String.format("%s ==> %s" , url, result));

		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(result, MEApplication.class);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Unable to call service me/api/application/%s", applicationId), e);
		}
	}

	public void deleteMEApiApplication(long applicationId) throws OVHApiException {
		String url = String.format("me/api/application/%s", applicationId);
		LOG.debug(String.format("%s" , url));
		executeService(Method.DELETE, url, "");
	}

	public List<Long> getMEApiCredential(long applicationId, MECredentialStateEnum status) throws OVHApiException {
		String url = String.format("me/api/credential?applicationId=%s", applicationId);
		if (status != null) {
			url += "&status=" + status;
		}
		String result = executeService(Method.GET, url, "");

		LOG.debug(String.format("%s ==> %s" , url, result));
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			TypeReference<List<Long>> typeRef = new TypeReference<List<Long>>() {};
			return mapper.readValue(result, typeRef);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("me/api/credential?applicationId=%s", applicationId), e);
		}
	}
	
	public MECredential getMEApiCredential(long credentialId) throws OVHApiException {
		String url = String.format("me/api/credential/%s", credentialId);
		String result = executeService(Method.GET, url, "");
		
		LOG.debug(String.format("%s ==> %s" , url, result));

		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(result, MECredential.class);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("me/api/credential/%s", credentialId), e);
		}
	}
	
	public void deleteMEApiCredential(long credentialId) throws OVHApiException {
		String url = String.format("me/api/credential//%s", credentialId);
		LOG.debug(String.format("%s" , url));
		executeService(Method.DELETE, url, "");
	}
	
	public MEApplication getMEApiCredentialApplication(long credentialId) throws OVHApiException {
		String url = String.format("me/api/credential/%s/application", credentialId);
		String result = executeService(Method.GET, url, "");

		LOG.debug(String.format("%s ==> %s" , url, result));

		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(result, MEApplication.class);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("me/api/credential/%s/application", credentialId), e);
		}
	}
	
	
	public List<String> getMEBill(Date from, Date to) throws OVHApiException {
		String url = String.format("me/bill");
		String separator = "?";
		if (from != null) {
			url += separator + "date.from=" + from;
			separator  = "&";
		}
		if (to != null) {
			url += separator + "date.to=" + to;
		}
		String result = executeService(Method.GET, url, "");

		LOG.debug(String.format("%s ==> %s" , url, result));
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			TypeReference<List<String>> typeRef = new TypeReference<List<String>>() {};
			return mapper.readValue(result, typeRef);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("me/bill"), e);
		}
	}

	public MEBill getMEBill(String billId) throws OVHApiException {
		String url = String.format("me/bill/%s", billId);
		String result = executeService(Method.GET, url, "");
		
		LOG.debug(String.format("%s ==> %s" , url, result));

		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(result, MEBill.class);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("me/bill/%s", billId), e);
		}
	}

	public List<String> getMEBillDetails(String billId) throws OVHApiException {
		String url = String.format("me/bill/%s/details", billId);
		String result = executeService(Method.GET, url, "");
		
		LOG.debug(String.format("%s ==> %s" , url, result));

		ObjectMapper mapper = new ObjectMapper();
		try {
			TypeReference<List<String>> typeRef = new TypeReference<List<String>>() {};
			return mapper.readValue(result, typeRef);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("me/bill/%s/details", billId), e);
		}
	}

	public MEBillDetail getMEBillDetails(String billId, String detailId) throws OVHApiException {
		String url = String.format("me/bill/%s/details/%s", billId, detailId);
		String result = executeService(Method.GET, url, "");
		
		LOG.debug(String.format("%s ==> %s" , url, result));

		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(result, MEBillDetail.class);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("me/bill/%s/details/%s", billId, detailId), e);
		}
	}

	public MEPayment getMEBillPayment(String billId) throws OVHApiException {
		String url = String.format("me/bill/%s/payment", billId);
		String result = executeService(Method.GET, url, "");
		
		LOG.debug(String.format("%s ==> %s" , url, result));
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(result, MEPayment.class);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("me/bill/%s/payment", billId), e);
		}
	}
	
	
}
