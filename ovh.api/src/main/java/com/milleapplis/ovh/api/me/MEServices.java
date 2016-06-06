package com.milleapplis.ovh.api.me;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.milleapplis.ovh.api.api.Application;
import com.milleapplis.ovh.api.billing.Bill;
import com.milleapplis.ovh.api.billing.BillDetail;
import com.milleapplis.ovh.api.billing.Payment;
import com.milleapplis.ovh.api.core.AbstractService;
import com.milleapplis.ovh.api.core.OVHApiException;
import com.milleapplis.ovh.api.credential.Credential;
import com.milleapplis.ovh.api.me.enums.MECredentialStateEnum;
import com.milleapplis.ovh.api.nichandle.Nichandle;
import com.milleapplis.ovh.api.nichandle.accessrestriction.SOTPAccount;
import com.milleapplis.ovh.api.nichandle.accessrestriction.SOTPSecret;
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
	
	public void putME(Nichandle nichandle) throws OVHApiException {
		String url = String.format("me");
		ObjectMapper mapper = new ObjectMapper();
		String body = null;
		try {
			body = mapper.writeValueAsString(nichandle);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Impossible d'appeler le service /me"), e);
		}
		
		executeService(Method.PUT, url, body);
	}

	public SOTPAccount getMEAccessRestrictionBackupCode() throws OVHApiException {
		String url = String.format("me/accessRestriction/backupCode");
		String result = executeService(Method.GET, url, "");

		LOG.debug(String.format("%s ==> %s" , url, result));

		ObjectMapper mapper = new ObjectMapper();
		try {
			TypeReference<SOTPAccount> typeRef = new TypeReference<SOTPAccount>() {};
			return mapper.readValue(result, typeRef);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Unable to call service /me/accessRestriction/backupCode"), e);
		}
	}

	public SOTPSecret postMEAccessRestrictionBackupCode() throws OVHApiException {
		String url = String.format("me/accessRestriction/backupCode");
		ObjectMapper mapper = new ObjectMapper();
		String result = executeService(Method.POST, url, "");
		try {
			return mapper.readValue(result, SOTPSecret.class);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Unable to call service /me/accessRestriction/backupCode"), e);
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

	
	public Application getMEApiApplication(long applicationId) throws OVHApiException {
		String url = String.format("me/api/application/%s", applicationId);
		String result = executeService(Method.GET, url, "");

		LOG.debug(String.format("%s ==> %s" , url, result));

		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(result, Application.class);
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
	
	public com.milleapplis.ovh.api.api.Credential getMEApiCredential(long credentialId) throws OVHApiException {
		String url = String.format("me/api/credential/%s", credentialId);
		String result = executeService(Method.GET, url, "");
		
		LOG.debug(String.format("%s ==> %s" , url, result));

		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(result, com.milleapplis.ovh.api.api.Credential.class);
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
	
	public Application getMEApiCredentialApplication(long credentialId) throws OVHApiException {
		String url = String.format("me/api/credential/%s/application", credentialId);
		String result = executeService(Method.GET, url, "");

		LOG.debug(String.format("%s ==> %s" , url, result));

		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(result, Application.class);
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

	public Bill getMEBill(String billId) throws OVHApiException {
		String url = String.format("me/bill/%s", billId);
		String result = executeService(Method.GET, url, "");
		
		LOG.debug(String.format("%s ==> %s" , url, result));

		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(result, Bill.class);
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

	public BillDetail getMEBillDetails(String billId, String detailId) throws OVHApiException {
		String url = String.format("me/bill/%s/details/%s", billId, detailId);
		String result = executeService(Method.GET, url, "");
		
		LOG.debug(String.format("%s ==> %s" , url, result));

		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(result, BillDetail.class);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("me/bill/%s/details/%s", billId, detailId), e);
		}
	}

	public Payment getMEBillPayment(String billId) throws OVHApiException {
		String url = String.format("me/bill/%s/payment", billId);
		String result = executeService(Method.GET, url, "");
		
		LOG.debug(String.format("%s ==> %s" , url, result));
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(result, Payment.class);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("me/bill/%s/payment", billId), e);
		}
	}
	
	
}
