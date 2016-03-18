package com.milleapplis.ovh.api.sms;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.milleapplis.ovh.api.core.AbstractService;
import com.milleapplis.ovh.api.core.OVHApiException;
import com.milleapplis.ovh.api.credential.Credential;
import com.milleapplis.ovh.api.sms.enums.SMSWayTypeEnum;
import com.milleapplis.ovh.api.sms.param.POSTSmsJobParam;
import com.milleapplis.ovh.api.sms.param.POSTSmsReceiversParam;
import com.milleapplis.ovh.api.sms.param.POSTSmsSendersParam;
import com.milleapplis.ovh.api.sms.result.SMSBlacklist;
import com.milleapplis.ovh.api.sms.result.SMSHlr;
import com.milleapplis.ovh.api.sms.result.SMSIncoming;
import com.milleapplis.ovh.api.sms.result.SMSOutgoing;
import com.milleapplis.ovh.api.sms.result.SMSPttDetails;
import com.milleapplis.ovh.api.sms.result.SMSReceiver;
import com.milleapplis.ovh.api.sms.result.SMSSender;
import com.milleapplis.ovh.api.sms.result.SMSSendingReport;
import com.milleapplis.ovh.api.sms.result.SMSServiceName;
import com.milleapplis.ovh.api.util.Method;

public class SMSService extends AbstractService {

	private static final Logger LOG = LoggerFactory.getLogger(SMSService.class);

	public SMSService(Credential credential) {
		super(credential);
	}
	
	/**
	 * Get all sms account from this credential
	 * 
	 * @param credential credential to use
	 * @return account list
	 * @throws OVHApiException If an error occurd
	 */
	public List<String> getSMS() throws OVHApiException {
		String url = String.format("sms/");
		String result = executeService( Method.GET, url, "");

		LOG.info(String.format("%s ==> %s" , url, result));

		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(result, List.class);
		}
		catch (Exception e) {
			throw new OVHApiException("Impossible d'appeler le service /sms", e);
		}
	}

	public SMSPttDetails getSMSPtts(String ptt) throws OVHApiException {
		String url =String.format("sms/ptts?ptt=%", ptt);
		String result = executeService(Method.GET, url, "");
		
		LOG.info(String.format("%s ==> %s" , url, result));

		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(result, SMSPttDetails.class);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Impossible d'appeler le service /sms/ptts.ptt=%s",ptt), e);
		}
	}
	
	
	/**
	 * Retourne les informations associ�es � un service de SMS (tel aus le nombre de sms restant par exemple).
	 * 
	 * @param credential Cl�s � utiliser pour l'acc�s aux comptes
	 * @param serviceName nom du service pour lequel on souhaite r�cup�rer les informations
	 * @return l'objet OVH contenant les infotmations du service.
	 * 
	 * @throws OVHApiException Si une erreur est identifi�e.
	 */
	public SMSServiceName getSMSServiceName(String serviceName) throws OVHApiException {
		String url = String.format("sms/%s/", serviceName);
		String result = executeService(Method.GET, url, "");
		
		LOG.info(String.format("%s ==> %s" , url, result));

		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(result, SMSServiceName.class);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Impossible d'appeler le service /sms/%s", serviceName), e);
		}
	}

	
	public List<String> getSMSServicenameBlacklists(String serviceName) throws OVHApiException {
		String url = String.format("sms/%s/blacklists", serviceName);
		String result = executeService(Method.GET, url, "");
		
		LOG.info(String.format("%s ==> %s" , url, result));

		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(result, List.class);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Unable to call service /sms/%s/blacklists", serviceName), e);
		}
	}

	public SMSBlacklist getSMSServicenameBlacklistsNumber(String serviceName, String number) throws OVHApiException {
		String url = String.format("sms/%s/blacklists/%s", serviceName, number);
		String result = executeService(Method.GET, url, "");
		
		LOG.info(String.format("%s ==> %s" , url, result));

		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(result, SMSBlacklist.class);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Unable to call service /sms/%s/blacklists/%s", serviceName, number), e);
		}
	}
	
	/**
	 * Delete blacklist number
	 * 
	 * @param credential  credential Cl�s � utiliser pour l'acc�s aux comptes
	 * @param serviceName nom du service pour lequel on souhaite supprimer le sender id
	 * @param number nomber to remove from blacklist
	 * 
	 * @throws OVHApiException  Si une erreur est identifi�e.
	 */
	public void DeleteSMSServiceNameBlacklistsNumber(String serviceName, String number) throws OVHApiException {
		String url = String.format("sms/%s/blacklists/%s", serviceName, number);
		LOG.info(String.format("%s ==> %s" , url));
		executeService(Method.DELETE, url, "");
	}

	public Long getSMSServicenameDocument(String serviceName, Date creationDateTimeFrom, Date creationDateTimeTo, String tag, SMSWayTypeEnum wayType) throws OVHApiException {
		String url = String.format("sms/%s/document", serviceName);
		String separator = "?";
		if (creationDateTimeFrom != null) {
			url += separator + "creationDatetime.from=" + creationDateTimeFrom;
			separator = "&";
		}
		if (creationDateTimeTo != null) {
			url += separator + "creationDatetime.to=" + creationDateTimeTo;
			separator = "&";
		}
		if (tag != null) {
			url += separator + "tag=" + tag;
			separator = "&";
		}
		if (wayType != null) {
			url += separator + "wayType=" + wayType.toString();
			separator = "&";
		}
		String result = executeService(Method.GET, url, "");
		
		LOG.info(String.format("%s ==> %s" , url, result));

		try {
			return Long.parseLong(result);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Unable to call service /sms/%s/document", serviceName), e);
		}
	}
	
	public Long getSMSServicenameException(String serviceName, String receiver) throws OVHApiException {
		String url = String.format("sms/%s/exception?receiver=%d", serviceName, receiver);
		
		throw new OVHApiException(String.format("Service not implemented in java Api."));
	}
	
	public List<Long> getSMSServicenameIncoming(String serviceName, Date creationDateTimeFrom, Date creationDateTimeTo, String sender, String tag) throws OVHApiException {
		String url = String.format("sms/%s/incoming", serviceName);
		String separator = "?";
		if (creationDateTimeFrom != null) {
			url += separator + "creationDatetime.from=" + creationDateTimeFrom;
			separator = "&";
		}
		if (creationDateTimeTo != null) {
			url += separator + "creationDatetime.to=" + creationDateTimeTo;
			separator = "&";
		}
		if (tag != null) {
			url += separator + "tag=" + tag;
			separator = "&";
		}
		if (sender != null) {
			url += separator + "sender=" + sender.toString();
			separator = "&";
		}
		String result = executeService(Method.GET, url, "");
		
		LOG.info(String.format("%s ==> %s" , url, result));

		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(result, List.class);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Unable to call service %s", url), e);
		}
	}
	
	public SMSIncoming getSMSServicenameIncoming(String serviceName, String smsId) throws OVHApiException {
		String url = String.format("sms/%s/incoming/%s", serviceName, smsId);
		String result = executeService(Method.GET, url, "");
		
		LOG.info(String.format("%s ==> %s" , url, result));

		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(result, SMSIncoming.class);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Unable to call service /sms/%s/incoming/%s", serviceName, smsId), e);
		}
	}

	public void DeleteSMSServicenameIncoming(String serviceName, String smsId) throws OVHApiException {
		String url = String.format("sms/%s/incoming/%s", serviceName, smsId);
		LOG.info(String.format("%s ==> %s" , url));
		executeService(Method.DELETE, url, "");
	}

	public List<Long> getSMSServicenameJobs(String serviceName) throws OVHApiException {
		String url = String.format("sms/%s/jobs", serviceName);
		String result = executeService(Method.GET, url, "");
		
		LOG.info(String.format("%s ==> %s" , url, result));

		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(result, List.class);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Unable to call service %s", url), e);
		}
	}
	
	/**
	 * Service permettant d'envoyer des SMS
	 * 
	 * @param credential  Cl�s � utiliser pour l'acc�s aux comptes
	 * @param serviceName nom du service pour lequel on souhaite envoyer des sms
	 * @param smsJobParam informations n�cessaires � l'envoi des SMS
	 * @return ???
	 * @throws OVHApiException Si une erreur est identifi�e.
	 */
	public SMSSendingReport postSMSServiceNameJobs(String serviceName, POSTSmsJobParam smsJobParam) throws OVHApiException {
		String url = String.format("sms/%s/jobs", serviceName);
		ObjectMapper mapper = new ObjectMapper();
		String body = null;
		try {
			body = mapper.writeValueAsString(smsJobParam);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Unable to call service /sms/%s/jobs", serviceName), e);
		}
		try {
			String result = executeService(Method.POST, url, body);
			return mapper.readValue(result, SMSSendingReport.class);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Unable to call service /sms/%s/jobs", serviceName), e);
		}

	}

	public List<Long> getSMSServicenameOutgoing(String serviceName, Date creationDateTimeFrom, Date creationDateTimeTo, Long deliveryReceipt, Long differedDelivery, Long ptt, String receiver, String sender, String tag) throws OVHApiException {
		String url = String.format("sms/%s/outgoing", serviceName);
		String separator = "?";
		if (creationDateTimeFrom != null) {
			url += separator + "creationDatetime.from=" + creationDateTimeFrom;
			separator = "&";
		}
		if (creationDateTimeTo != null) {
			url += separator + "creationDatetime.to=" + creationDateTimeTo;
			separator = "&";
		}
		if (deliveryReceipt != null) {
			url += separator + "deliveryReceipt=" + deliveryReceipt;
			separator = "&";
		}
		if (differedDelivery != null) {
			url += separator + "differedDelivery=" + differedDelivery;
			separator = "&";
		}
		if (ptt != null) {
			url += separator + "ptt=" + ptt;
			separator = "&";
		}
		if (receiver != null) {
			url += separator + "receiver=" + receiver;
			separator = "&";
		}
		if (tag != null) {
			url += separator + "tag=" + tag;
			separator = "&";
		}
		if (sender != null) {
			url += separator + "sender=" + sender.toString();
			separator = "&";
		}
		String result = executeService(Method.GET, url, "");
		
		LOG.info(String.format("%s ==> %s" , url, result));

		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(result, List.class);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Unable to call service %s", url), e);
		}
	}
	
	public SMSOutgoing getSMSServicenameOutgoing(String serviceName, long smsId) throws OVHApiException {
		String url = String.format("sms/%s/outgoing/%s", serviceName, smsId);
		String result = executeService(Method.GET, url, "");
		
		LOG.info(String.format("%s ==> %s" , url, result));

		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(result, SMSOutgoing.class);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Unable to call service /sms/%s/outgoing/%s", serviceName, smsId), e);
		}
	}

	public void DeleteSMSServicenameOutgoing(String serviceName, long smsId) throws OVHApiException {
		String url = String.format("sms/%s/outgoing/%s", serviceName, smsId);
		LOG.info(String.format("%s ==> %s" , url));
		executeService(Method.DELETE, url, "");
	}
	

	public SMSHlr getSMSServicenameOutgoingHlr(String serviceName, long smsId) throws OVHApiException {
		String url = String.format("sms/%s/outgoing/%s/hlr", serviceName, smsId);
		String result = executeService(Method.GET, url, "");
		
		LOG.info(String.format("%s ==> %s" , url, result));
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(result, SMSHlr.class);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Unable to call service /sms/%s/outgoing/%s/hlr", serviceName, smsId), e);
		}
	}

	public List<Long> getSMSServicenameReceivers(String serviceName) throws OVHApiException {
		String url = String.format("sms/%s/receivers", serviceName);
		String result = executeService(Method.GET, url, "");
		
		LOG.info(String.format("%s ==> %s" , url, result));
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(result, List.class);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("sms/%s/receivers", serviceName), e);
		}
	}

	public SMSReceiver postSMSServicenameReceivers(String serviceName, POSTSmsReceiversParam smsReceiverParam) throws OVHApiException {
		String url = String.format("sms/%s/receivers", serviceName);
		ObjectMapper mapper = new ObjectMapper();
		String body = null;
		try {
			body = mapper.writeValueAsString(smsReceiverParam);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Unable to call service /sms/%s/receivers", serviceName), e);
		}
		String result = executeService(Method.POST, url, body);
		try {
			return mapper.readValue(result, SMSReceiver.class);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Unable to call service /sms/%s/receivers", serviceName), e);
		}
	}

	
	/**
	 * R�cup�re la liste des Sender ID pour un compte SMS
	 * 
	 * @param credential Cl�s � utiliser pour l'acc�s aux comptes
	 * @param serviceName nom du service pour lequel on souhaite r�cup�rer les sender id
	 * @return la liste des senders id configur�s sur ce compte
	 * 
	 * @throws OVHApiException Si une erreur est identifi�e.
	 */
	public List<String> getSMSSenders(String serviceName) throws OVHApiException {
		String url = String.format("sms/%s/senders", serviceName);
		String result = executeService(Method.GET, url, "");

		LOG.info(String.format("%s ==> %s" , url, result));

		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(result, List.class);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Impossible d'appeler le service GET /sms/%s/senders",serviceName), e);
		}
		
	}

	/**
	 * Ajoute un sernder id sur un compte
	 * 
	 * @param credential Cl�s � utiliser pour l'acc�s aux comptes
	 * @param serviceName nom du service pour lequel on souhaite r�cup�rer les sender id
	 * @param smsSenders nom du sender id � ajouter au compte (max 11 caract�res).
	 * @return
	 * @throws OVHApiException OVHApiException Si une erreur est identifi�e.
	 */
	public String PostSMSSenders(String serviceName, POSTSmsSendersParam smsSenders) throws OVHApiException {
		if (smsSenders == null || smsSenders.getSender() == null) {
			throw new OVHApiException("Sender ID cannot be null.");
		}
		
		if (smsSenders.getSender().length() > 11) {
			throw new OVHApiException("Sender ID cannot be greather than 11 characters.");
		}
		
		String url = String.format("sms/%s/senders", serviceName);
		ObjectMapper mapper = new ObjectMapper();
		String body = null;
		try {
			body = mapper.writeValueAsString(smsSenders);
			System.out.println(body);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Impossible d'appeler le service /sms/%s/jobs", serviceName), e);
		}
		//TODO
		return executeService(Method.POST, url, body);
	}
	
	/**
	 * Permet de r�cup�rer les informations sur un sender id
	 * 
	 * @param credential credential Cl�s � utiliser pour l'acc�s aux comptes
	 * @param serviceName nom du service pour lequel on souhaite r�cup�rer les informatins du sender id
	 * @param sender sender id
	 * @return les informations du sender id
	 * 
	 * @throws OVHApiException Si une erreur est identifi�e.
	 */
	public SMSSender GetSMSSender(String serviceName, String sender) throws OVHApiException {
		String url = String.format("sms/%s/senders/%s", serviceName, sender);
		String result = executeService(Method.GET, url, "");

		LOG.info(String.format("%s ==> %s" , url, result));
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(result, SMSSender.class);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Impossible d'appeler le service GET /sms/%s/senders/%s",serviceName, sender), e);
		}
	}
	
	/**
	 * Permet de modifier les informations du sender ID
	 * 
	 * @param credential credential Cl�s � utiliser pour l'acc�s aux comptes
	 * @param serviceName nom du service pour lequel on souhaite modifier les informatins du sender id
	 * @param sender sender id
	 * @param smsSender informations � modifier
	 * @return ??
	 * 
	 * @throws OVHApiException Si une erreur est identifi�e.
	 */
	public String PutSMSSenders(String serviceName, String sender, SMSSender smsSender) throws OVHApiException {
		String url = String.format("sms/%s/senders/%s", serviceName, sender);
		ObjectMapper mapper = new ObjectMapper();
		String body = null;
		try {
			body = mapper.writeValueAsString(smsSender);
			System.out.println(body);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Impossible d'appeler le service /sms/%s/jobs", serviceName), e);
		}
		//TODO
		return executeService(Method.PUT, url, body);
	}


	/**
	 * Supprime un sender id
	 * 
	 * @param credential  credential Cl�s � utiliser pour l'acc�s aux comptes
	 * @param serviceName nom du service pour lequel on souhaite supprimer le sender id
	 * @param sender sender id � supprimer
	 * 
	 * @throws OVHApiException  Si une erreur est identifi�e.
	 */
	public void DeleteSMSSender(String serviceName, String sender) throws OVHApiException {
		String url = String.format("sms/%s/senders/%s", serviceName, sender);
		LOG.info(String.format("%s ==> %s" , url));
		executeService(Method.DELETE, url, "");
	}

	/**
	 * Valide un sender id pas rapport � un code de validation
	 * 
	 */
	public String PostSMSSendersValidate(String serviceName, String sender, String code) throws OVHApiException {
		if (code == null) {
			throw new OVHApiException("Validation code cannot be null.");
		}
		
		String url = String.format("sms/%s/senders/%s/validate", serviceName, sender);
		String body = null;
		body = String.format("{\"code\":\"%s\"}", code);
		//TODO
		return executeService(Method.POST, url, body);
	}

	
}
