package com.milleapplis.ovh.api.sms.services;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.milleapplis.ovh.api.core.AbstractService;
import com.milleapplis.ovh.api.core.OVHApiException;
import com.milleapplis.ovh.api.credential.Credential;
import com.milleapplis.ovh.api.reference.CountryEnum;
import com.milleapplis.ovh.api.services.Service;
import com.milleapplis.ovh.api.sms.Account;
import com.milleapplis.ovh.api.sms.Blacklist;
import com.milleapplis.ovh.api.sms.Hlr;
import com.milleapplis.ovh.api.sms.Incoming;
import com.milleapplis.ovh.api.sms.Job;
import com.milleapplis.ovh.api.sms.Outgoing;
import com.milleapplis.ovh.api.sms.PackOffer;
import com.milleapplis.ovh.api.sms.PttDetails;
import com.milleapplis.ovh.api.sms.Receiver;
import com.milleapplis.ovh.api.sms.ReceiversAsynchronousCleanReport;
import com.milleapplis.ovh.api.sms.Sender;
import com.milleapplis.ovh.api.sms.SmsSendingReport;
import com.milleapplis.ovh.api.sms.Task;
import com.milleapplis.ovh.api.sms.TemplateControl;
import com.milleapplis.ovh.api.sms.Users;
import com.milleapplis.ovh.api.sms.enums.SMSCountryEnum;
import com.milleapplis.ovh.api.sms.enums.SMSPackQuantityEnum;
import com.milleapplis.ovh.api.sms.enums.SMSWayTypeEnum;
import com.milleapplis.ovh.api.sms.param.POSTSmsJobParam;
import com.milleapplis.ovh.api.sms.param.POSTSmsReceiversParam;
import com.milleapplis.ovh.api.sms.param.POSTSmsSendersParam;
import com.milleapplis.ovh.api.telephony.TaskStatusEnum;
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

		LOG.debug(String.format("%s ==> %s" , url, result));

		ObjectMapper mapper = new ObjectMapper();
		try {
			TypeReference<List<String>> typeRef = new TypeReference<List<String>>() {};
			return mapper.readValue(result, typeRef);
		}
		catch (Exception e) {
			throw new OVHApiException("Impossible d'appeler le service /sms", e);
		}
	}

	public PttDetails getSMSPtts(String ptt) throws OVHApiException {
		String url =String.format("sms/ptts?ptt=%", ptt);
		String result = executeService(Method.GET, url, "");
		
		LOG.debug(String.format("%s ==> %s" , url, result));

		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(result, PttDetails.class);
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
	public Account getSMSServiceName(String serviceName) throws OVHApiException {
		String url = String.format("sms/%s/", serviceName);
		String result = executeService(Method.GET, url, "");
		
		LOG.debug(String.format("%s ==> %s" , url, result));

		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(result, Account.class);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Impossible d'appeler le service /sms/%s", serviceName), e);
		}
	}

	public void putSMSServiceName(String serviceName, Account account) throws OVHApiException {
		throw new OVHApiException("Not implemented in java API");
	}
	
	public List<String> getSMSBlacklists(String serviceName) throws OVHApiException {
		String url = String.format("sms/%s/blacklists", serviceName);
		String result = executeService(Method.GET, url, "");
		
		LOG.debug(String.format("%s ==> %s" , url, result));

		ObjectMapper mapper = new ObjectMapper();
		try {
			TypeReference<List<String>> typeRef = new TypeReference<List<String>>() {};
			return mapper.readValue(result, typeRef);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Unable to call service /sms/%s/blacklists", serviceName), e);
		}
	}

	public Blacklist getSMSBlacklistsNumber(String serviceName, String number) throws OVHApiException {
		String url = String.format("sms/%s/blacklists/%s", serviceName, number);
		String result = executeService(Method.GET, url, "");
		
		LOG.debug(String.format("%s ==> %s" , url, result));

		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(result, Blacklist.class);
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
	public void deleteSMSBlacklistsNumber(String serviceName, String number) throws OVHApiException {
		String url = String.format("sms/%s/blacklists/%s", serviceName, number);
		LOG.debug(String.format("%s ==> %s" , url));
		executeService(Method.DELETE, url, "");
	}

	public Long getSMSDocument(String serviceName, Date creationDateTimeFrom, Date creationDateTimeTo, String tag, SMSWayTypeEnum wayType) throws OVHApiException {
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
		
		LOG.debug(String.format("%s ==> %s" , url, result));

		try {
			return Long.parseLong(result);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Unable to call service /sms/%s/document", serviceName), e);
		}
	}
	
	public Long getSMSException(String serviceName, String receiver) throws OVHApiException {
		String url = String.format("sms/%s/exception?receiver=%d", serviceName, receiver);
		
		throw new OVHApiException(String.format("Service not implemented in java Api [%s].", url));
	}
	
	public List<Long> getSMSIncoming(String serviceName, Date creationDateTimeFrom, Date creationDateTimeTo, String sender, String tag) throws OVHApiException {
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
		
		LOG.debug(String.format("%s ==> %s" , url, result));

		ObjectMapper mapper = new ObjectMapper();
		try {
			TypeReference<List<Long>> typeRef = new TypeReference<List<Long>>() {};
			return mapper.readValue(result, typeRef);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Unable to call service %s", url), e);
		}
	}
	
	public Incoming getSMSIncoming(String serviceName, String smsId) throws OVHApiException {
		String url = String.format("sms/%s/incoming/%s", serviceName, smsId);
		String result = executeService(Method.GET, url, "");
		
		LOG.debug(String.format("%s ==> %s" , url, result));

		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(result, Incoming.class);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Unable to call service /sms/%s/incoming/%s", serviceName, smsId), e);
		}
	}

	public void deleteSMSIncoming(String serviceName, String smsId) throws OVHApiException {
		String url = String.format("sms/%s/incoming/%s", serviceName, smsId);
		LOG.debug(String.format("%s ==> %s" , url));
		executeService(Method.DELETE, url, "");
	}

	public List<Long> getSMSJobs(String serviceName) throws OVHApiException {
		String url = String.format("sms/%s/jobs", serviceName);
		String result = executeService(Method.GET, url, "");
		
		LOG.debug(String.format("%s ==> %s" , url, result));

		ObjectMapper mapper = new ObjectMapper();
		try {
			TypeReference<List<Long>> typeRef = new TypeReference<List<Long>>() {};
			return mapper.readValue(result, typeRef);
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
	public SmsSendingReport postSMSJobs(String serviceName, POSTSmsJobParam smsJobParam) throws OVHApiException {
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
			return mapper.readValue(result, SmsSendingReport.class);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Unable to call service /sms/%s/jobs", serviceName), e);
		}
	}

	public List<Job> getSMSJobs(String serviceName, String id) throws OVHApiException {
		String url = String.format("sms/%s/jobs/%s", serviceName, id);
		String result = executeService(Method.GET, url, "");
		
		LOG.debug(String.format("%s ==> %s" , url, result));

		ObjectMapper mapper = new ObjectMapper();
		try {
			TypeReference<Job> typeRef = new TypeReference<Job>() {};
			return mapper.readValue(result, typeRef);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Unable to call service %s", url), e);
		}
	}

	public void deleteSMSJobs(String serviceName, String id) throws OVHApiException {
		String url = String.format("sms/%s/jobs/%s", serviceName, id);
		LOG.debug(String.format("%s" , url));
		executeService(Method.DELETE, url, "");
	}

	
	public List<Long> getSMSOutgoing(String serviceName, Date creationDateTimeFrom, Date creationDateTimeTo, Long deliveryReceipt, Long differedDelivery, Long ptt, String receiver, String sender, String tag) throws OVHApiException {
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
		
		LOG.debug(String.format("%s ==> %s" , url, result));

		ObjectMapper mapper = new ObjectMapper();
		try {
			TypeReference<List<Long>> typeRef = new TypeReference<List<Long>>() {};
			return mapper.readValue(result, typeRef);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Unable to call service %s", url), e);
		}
	}
	
	public Outgoing getSMSOutgoing(String serviceName, long smsId) throws OVHApiException {
		String url = String.format("sms/%s/outgoing/%s", serviceName, smsId);
		String result = executeService(Method.GET, url, "");
		
		LOG.debug(String.format("%s ==> %s" , url, result));

		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(result, Outgoing.class);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Unable to call service /sms/%s/outgoing/%s", serviceName, smsId), e);
		}
	}

	public void deleteSMSOutgoing(String serviceName, long smsId) throws OVHApiException {
		String url = String.format("sms/%s/outgoing/%s", serviceName, smsId);
		LOG.debug(String.format("%s ==> %s" , url));
		executeService(Method.DELETE, url, "");
	}
	

	public Hlr getSMSOutgoingHlr(String serviceName, long smsId) throws OVHApiException {
		String url = String.format("sms/%s/outgoing/%s/hlr", serviceName, smsId);
		String result = executeService(Method.GET, url, "");
		
		LOG.debug(String.format("%s ==> %s" , url, result));
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(result, Hlr.class);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Unable to call service /sms/%s/outgoing/%s/hlr", serviceName, smsId), e);
		}
	}

	public List<Long> getSMSReceivers(String serviceName) throws OVHApiException {
		String url = String.format("sms/%s/receivers", serviceName);
		String result = executeService(Method.GET, url, "");
		
		LOG.debug(String.format("%s ==> %s" , url, result));
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			TypeReference<List<Long>> typeRef = new TypeReference<List<Long>>() {};
			return mapper.readValue(result, typeRef);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("sms/%s/receivers", serviceName), e);
		}
	}

	public Receiver postSMSReceivers(String serviceName, POSTSmsReceiversParam smsReceiverParam) throws OVHApiException {
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
			return mapper.readValue(result, Receiver.class);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Unable to call service /sms/%s/receivers", serviceName), e);
		}
	}

	public Receiver getSMSReceiversSlotId(String serviceName, long slotId) throws OVHApiException {
		String url = String.format("sms/%s/receivers/%s", serviceName, slotId);
		String result = executeService(Method.GET, url, "");
		
		LOG.info(String.format("%s ==> %s" , url, result));
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(result, Receiver.class);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("sms/%s/receivers/%s", serviceName, slotId), e);
		}
	}
	
	public void deleteSMSSlotId(String serviceName, long slotId) throws OVHApiException {
		String url = String.format("sms/%s/receivers/%s", serviceName, slotId);
		LOG.info(String.format("%s ==> %s" , url));
		executeService(Method.DELETE, url, "");
	}

	public ReceiversAsynchronousCleanReport postSMSReceiversSlotIdClean(String serviceName, long slotId) throws OVHApiException {
		String url = String.format("sms/%s/receivers/%s/clean", serviceName, slotId);
		String result = executeService(Method.POST, url, "");
		
		LOG.info(String.format("%s ==> %s" , url, result));

		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(result, ReceiversAsynchronousCleanReport.class);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Unable to call service /sms/%s/receivers/%s/clean", serviceName, slotId), e);
		}
	}

	public String getSMSReceiversSlotIdCsv(String serviceName, long slotId) throws OVHApiException {
		String url = String.format("sms/%s/receivers/%s/csv", serviceName, slotId);
		String result = executeService(Method.GET, url, "");
		
		LOG.info(String.format("%s ==> %s" , url, result));

		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(result, String.class);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Unable to call service /sms/%s/receivers/%s/csv", serviceName, slotId), e);
		}
	}

	public List<PackOffer> getSMSSeeOffers(String serviceName, CountryEnum countryCurrencyPrice, SMSCountryEnum countryDestination, SMSPackQuantityEnum quantity) throws OVHApiException {
		String url = String.format("sms/%s/seeOffers?countryCurrencyPrice=%s&countryDestination=%s&quantity=%s", serviceName, countryCurrencyPrice.toString(), countryDestination.toString(), quantity.toString());
		String result = executeService(Method.GET, url, "");
		
		LOG.info(String.format("%s ==> %s" , url, result));

		ObjectMapper mapper = new ObjectMapper();
		try {
			TypeReference<List<PackOffer>> typeRef = new TypeReference<List<PackOffer>>() {};
			return mapper.readValue(result, typeRef);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Unable to call service %s", url), e);
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

		LOG.debug(String.format("%s ==> %s" , url, result));

		ObjectMapper mapper = new ObjectMapper();
		try {
			TypeReference<List<String>> typeRef = new TypeReference<List<String>>() {};
			return mapper.readValue(result, typeRef);
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
	public String postSMSSenders(String serviceName, POSTSmsSendersParam smsSenders) throws OVHApiException {
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
	public Sender getSMSSender(String serviceName, String sender) throws OVHApiException {
		String url = String.format("sms/%s/senders/%s", serviceName, sender);
		String result = executeService(Method.GET, url, "");

		LOG.debug(String.format("%s ==> %s" , url, result));
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(result, Sender.class);
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
	public void putSMSSenders(String serviceName, String sender, Sender smsSender) throws OVHApiException {
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
		
		executeService(Method.PUT, url, body);
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
	public void deleteSMSSender(String serviceName, String sender) throws OVHApiException {
		String url = String.format("sms/%s/senders/%s", serviceName, sender);
		LOG.debug(String.format("%s ==> %s" , url));
		executeService(Method.DELETE, url, "");
	}

	/**
	 * Valide un sender id pas rapport � un code de validation
	 * 
	 */
	public void postSMSSendersValidate(String serviceName, String sender, String code) throws OVHApiException {
		if (code == null) {
			throw new OVHApiException("Validation code cannot be null.");
		}
		
		String url = String.format("sms/%s/senders/%s/validate", serviceName, sender);
		String body = null;
		body = String.format("{\"code\":\"%s\"}", code);
		executeService(Method.POST, url, body);
	}

	public Service getSMSServiceInfo(String serviceName) throws OVHApiException {
		String url = String.format("sms/%s/serviceInfos", serviceName);
		String result = executeService(Method.GET, url, "");

		//System.out.println("Result : " + result);
		LOG.debug(String.format("%s ==> %s" , url, result));
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(result, Service.class);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Impossible d'appeler le service GET sms/%s/serviceInfos", serviceName), e);
		}
	}
	
	public void putSMSServiceInfos(String serviceName, Service service) throws OVHApiException {
		String url = String.format("sms/%s/serviceInfos", serviceName);
		ObjectMapper mapper = new ObjectMapper();
		String body = null;
		try {
			body = mapper.writeValueAsString(service);
			System.out.println(body);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Impossible d'appeler le service /sms/%s/serviceInfos", serviceName), e);
		}
		executeService(Method.PUT, url, body);
	}

	public List<Long> getSMSTask(String serviceName, TaskStatusEnum status) throws OVHApiException {
		String url = String.format("sms/%s/task", serviceName);
		if (status != null) {
			url = url + "?status=" + status.toString();
		}
		String result = executeService(Method.GET, url, "");

		LOG.debug(String.format("%s ==> %s" , url, result));
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			TypeReference<List<Long>> typeRef = new TypeReference<List<Long>>() {};
			return mapper.readValue(result, typeRef);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Impossible d'appeler le service GET sms/%s/task", serviceName), e);
		}
	}

	public Task getSMSTask(String serviceName, long taskId) throws OVHApiException {
		String url = String.format("sms/%s/task/%s", serviceName, taskId);
		String result = executeService(Method.GET, url, "");

		LOG.debug(String.format("%s ==> %s" , url, result));
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(result, Task.class);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Impossible d'appeler le service GET sms/%s/task/%s", serviceName, taskId), e);
		}
	}

	public List<String> getSMSTemplatesControl(String serviceName) throws OVHApiException {
		String url = String.format("sms/%s/templatesControl", serviceName);
		String result = executeService(Method.GET, url, "");

		LOG.debug(String.format("%s ==> %s" , url, result));
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			TypeReference<List<String>> typeRef = new TypeReference<List<String>>() {};
			return mapper.readValue(result, typeRef);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Impossible d'appeler le service GET sms/%s/templateControl", serviceName), e);
		}
	}
	
	public void postSMSTemplatesControl(String serviceName, TemplateControl templateControl) throws OVHApiException {
		String url = String.format("sms/%s/templatesControl", serviceName);
		ObjectMapper mapper = new ObjectMapper();
		String body = null;
		try {
			body = mapper.writeValueAsString(templateControl);
			System.out.println(body);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Impossible d'appeler le service /sms/%s/templateControl", serviceName), e);
		}
		executeService(Method.POST, url, body);
	}
	
	public TemplateControl getSMSTemplatesControl(String serviceName, String name) throws OVHApiException {
		String url = String.format("sms/%s/templatesControl/%s", serviceName, name);
		String result = executeService(Method.GET, url, "");

		LOG.debug(String.format("%s ==> %s" , url, result));
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			TypeReference<TemplateControl> typeRef = new TypeReference<TemplateControl>() {};
			return mapper.readValue(result, typeRef);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Impossible d'appeler le service GET sms/%s/templateControl/%s", serviceName, name), e);
		}
	}
	
	public void postSMSTransferCredits(String serviceName, double credits, String smsAccountTarget) throws OVHApiException {
		String url = String.format("sms/%s/transferCredits", serviceName);
		String body = String.format("{\"credits\":%s, \"smsAccountTarget\":\"%s\"}", credits, smsAccountTarget);
		
		LOG.debug(String.format("%s ==> %s" , url, body));
		
		executeService(Method.POST, url, body);
	}

	public List<String> getSMSUsers(String serviceName) throws OVHApiException {
		String url = String.format("sms/%s/users", serviceName);
		String result = executeService(Method.GET, url, "");

		LOG.debug(String.format("%s ==> %s" , url, result));
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			TypeReference<List<String>> typeRef = new TypeReference<List<String>>() {};
			return mapper.readValue(result, typeRef);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Impossible d'appeler le service GET sms/%s/users", serviceName), e);
		}
	}
	
	public void postSMSUsers(String serviceName, String login, String password) throws OVHApiException {
		String url = String.format("sms/%s/users", serviceName);
		String body = String.format("{\"login\":\"%s\", \"password\":\"%s\"}", login, password);
		
		LOG.debug(String.format("%s ==> %s" , url, body));
		
		executeService(Method.POST, url, body);
	}
	
	public Users getSMSUsers(String serviceName, String login) throws OVHApiException {
		String url = String.format("sms/%s/users/%s", serviceName, login);
		String result = executeService(Method.GET, url, "");
		//System.out.println("result : " + result);

		LOG.debug(String.format("%s ==> %s" , url, result));
		ObjectMapper mapper = new ObjectMapper();
		try {
			TypeReference<Users> typeRef = new TypeReference<Users>() {};
			return mapper.readValue(result, typeRef);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Impossible d'appeler le service GET sms/%s/users", serviceName), e);
		}
	}
	
	public void putSMSUsers(String serviceName, String login, Users smsUsers) throws OVHApiException {
		String url = String.format("sms/%s/users/%s", serviceName, login);
		ObjectMapper mapper = new ObjectMapper();
		String body = null;
		try {
			body = mapper.writeValueAsString(smsUsers);
			//System.out.println(body);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Impossible d'appeler le service /sms/%s/users/%s", serviceName, login), e);
		}
		
		executeService(Method.PUT, url, body);
	}

	public void deleteSMSUsers(String serviceName, String login) throws OVHApiException {
		String url = String.format("sms/%s/users/%s", serviceName, login);
		LOG.debug(String.format("%s" , url));
		executeService(Method.DELETE, url, "");
	}
	
	public String getSMSUsersDocument(String serviceName, String login, Date creationDateFrom, Date creationDateTo, String tag, SMSWayTypeEnum wayType) throws OVHApiException {
		String url = String.format("sms/%s/users/%s/document", serviceName, login);
		String separator = "?";
		
		if (creationDateFrom != null) {
			url += separator + String.format("creationDatetime.from=%s", creationDateFrom);
			separator = "&";
		}
		if (creationDateTo != null) {
			url += separator + String.format("creationDatetime.to=%s", creationDateTo);
			separator = "&";
		}
		if (tag != null) {
			url += separator + String.format("tag=%s", tag);
			separator = "&";
		}
		if (wayType != null) {
			url += separator + String.format("wayType=%s", wayType);
		}
		
		String result = executeService(Method.GET, url, "");
		//System.out.println("result : " + result);

		LOG.debug(String.format("%s ==> %s" , url, result));
		ObjectMapper mapper = new ObjectMapper();
		try {
			TypeReference<String> typeRef = new TypeReference<String>() {};
			return mapper.readValue(result, typeRef);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Impossible d'appeler le service GET %s", url), e);
		}
	}
	
	public List<Long> getSMSUsersIncoming(String serviceName, String login, String sender, String tag) throws OVHApiException {
		String url = String.format("sms/%s/users/%s/incoming", serviceName, login);
		String separator = "?";
		
		if (sender != null) {
			url += separator + String.format("sender=%s", sender);
			separator = "&";
		}
		if (tag != null) {
			url += separator + String.format("tag=%s", tag);
		}
		
		String result = executeService(Method.GET, url, "");
		//System.out.println("result : " + result);

		LOG.debug(String.format("%s ==> %s" , url, result));
		ObjectMapper mapper = new ObjectMapper();
		try {
			TypeReference<List<Long>> typeRef = new TypeReference<List<Long>>() {};
			return mapper.readValue(result, typeRef);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Impossible d'appeler le service GET %s", url), e);
		}
	}
	
	public Incoming getSMSUsersIncoming(String serviceName, String login, String id) throws OVHApiException {
		String url = String.format("sms/%s/users/%s/incoming/%s", serviceName, login, id);
		
		String result = executeService(Method.GET, url, "");
		//System.out.println("result : " + result);

		LOG.debug(String.format("%s ==> %s" , url, result));
		ObjectMapper mapper = new ObjectMapper();
		try {
			TypeReference<Incoming> typeRef = new TypeReference<Incoming>() {};
			return mapper.readValue(result, typeRef);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Impossible d'appeler le service GET %s", url), e);
		}
	}

	public void deleteSMSUserIncoming(String serviceName, String login, String id) throws OVHApiException {
		String url = String.format("sms/%s/user/%s/incoming/%s", serviceName, login, id);
		LOG.debug(String.format("%s" , url));
		executeService(Method.DELETE, url, "");
	}

	public List<Long> getSMSUsersJobs(String serviceName, String login) throws OVHApiException {
		String url = String.format("sms/%s/users/%s/jobs", serviceName, login);
		
		String result = executeService(Method.GET, url, "");
		//System.out.println("result : " + result);

		LOG.debug(String.format("%s ==> %s" , url, result));
		ObjectMapper mapper = new ObjectMapper();
		try {
			TypeReference<List<Long>> typeRef = new TypeReference<List<Long>>() {};
			return mapper.readValue(result, typeRef);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Impossible d'appeler le service GET %s", url), e);
		}
	}
	
	public SmsSendingReport postSMSUsersJobs(String serviceName, String login, POSTSmsJobParam smsJobParam) throws OVHApiException {
		String url = String.format("sms/%s/users/%s/jobs", serviceName, login);
		ObjectMapper mapper = new ObjectMapper();
		String body = null;
		try {
			body = mapper.writeValueAsString(smsJobParam);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Unable to call service /sms/%s/users/%s/jobs", serviceName, login), e);
		}
		try {
			String result = executeService(Method.POST, url, body);
			return mapper.readValue(result, SmsSendingReport.class);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Unable to call service /sms/%s/users/%s/jobs", serviceName, login), e);
		}

	}

	public List<Job> getSMSUsersJobs(String serviceName, String login, String id) throws OVHApiException {
		String url = String.format("sms/%s/users/%s/jobs/%s", serviceName, login, id);
		String result = executeService(Method.GET, url, "");
		
		LOG.debug(String.format("%s ==> %s" , url, result));

		ObjectMapper mapper = new ObjectMapper();
		try {
			TypeReference<Job> typeRef = new TypeReference<Job>() {};
			return mapper.readValue(result, typeRef);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Unable to call service %s", url), e);
		}
	}

	public void deleteSMSUsersJobs(String serviceName, String login, String id) throws OVHApiException {
		String url = String.format("sms/%s/users/%s/jobs/%s", serviceName, login, id);
		LOG.debug(String.format("%s" , url));
		executeService(Method.DELETE, url, "");
	}
	
	public List<Long> getSMSUsersOutgoing(String serviceName, String login, Long deliveryReceipt, Long differedDelivery, Long ptt, String receiver, String sender, String tag) throws OVHApiException {
		String url = String.format("sms/%s/users/%s/outgoing", serviceName, login);
		String separator = "?";
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
		if (sender != null) {
			url += separator + "sender=" + sender.toString();
			separator = "&";
		}
		if (tag != null) {
			url += separator + "tag=" + tag;
			separator = "&";
		}
		String result = executeService(Method.GET, url, "");
		
		LOG.debug(String.format("%s ==> %s" , url, result));

		ObjectMapper mapper = new ObjectMapper();
		try {
			TypeReference<List<Long>> typeRef = new TypeReference<List<Long>>() {};
			return mapper.readValue(result, typeRef);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Unable to call service %s", url), e);
		}
	}
	
	public Outgoing getSMSUsersOutgoing(String serviceName, String login, long smsId) throws OVHApiException {
		String url = String.format("sms/%s/users/%s/outgoing/%s", serviceName, login, smsId);
		String result = executeService(Method.GET, url, "");
		
		LOG.debug(String.format("%s ==> %s" , url, result));

		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(result, Outgoing.class);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Unable to call service /sms/%s/users/%s/outgoing/%s", serviceName, login, smsId), e);
		}
	}

	public void deleteSMSUsersOutgoing(String serviceName, String login, long smsId) throws OVHApiException {
		String url = String.format("sms/%s/users/%s/outgoing/%s", serviceName, login, smsId);
		LOG.debug(String.format("%s ==> %s" , url));
		executeService(Method.DELETE, url, "");
	}
	
	public Hlr getSMSUsersOutgoingHlr(String serviceName, String login, long smsId) throws OVHApiException {
		String url = String.format("sms/%s/users/%s/outgoing/%s/hlr", serviceName, login, smsId);
		String result = executeService(Method.GET, url, "");
		
		LOG.debug(String.format("%s ==> %s" , url, result));

		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(result, Hlr.class);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Unable to call service /sms/%s/users/%s/outgoing/%s/hlr", serviceName, login, smsId), e);
		}
	}
	
	public List<Long> getSMSUsersReceivers(String serviceName, String login) throws OVHApiException {
		String url = String.format("sms/%s/users/%s/receivers", serviceName, login);
		String result = executeService(Method.GET, url, "");
		
		LOG.debug(String.format("%s ==> %s" , url, result));

		ObjectMapper mapper = new ObjectMapper();
		try {
			TypeReference<List<Long>> typeRef = new TypeReference<List<Long>>() {};
			return mapper.readValue(result, typeRef);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Unable to call service /sms/%s/users/%s/receivers", serviceName, login), e);
		}
	}
	
	public Receiver postSMSUsersReceivers(String serviceName, String login, POSTSmsReceiversParam smsReceiversParam) throws OVHApiException {
		String url = String.format("sms/%s/users/%s/receivers", serviceName, login);
		ObjectMapper mapper = new ObjectMapper();
		String body = null;
		try {
			body = mapper.writeValueAsString(smsReceiversParam);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Unable to call service /sms/%s/users/%s/receivers", serviceName, login), e);
		}
		try {
			String result = executeService(Method.POST, url, body);
			return mapper.readValue(result, Receiver.class);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Unable to call service /sms/%s/users/%s/receivers", serviceName, login), e);
		}

	}

	public Receiver getSMSUsersReceivers(String serviceName, String login, long slotId) throws OVHApiException {
		String url = String.format("sms/%s/users/%s/receivers/%s", serviceName, login, slotId);
		String result = executeService(Method.GET, url, "");
		
		LOG.debug(String.format("%s ==> %s" , url, result));

		ObjectMapper mapper = new ObjectMapper();
		try {
			TypeReference<Receiver> typeRef = new TypeReference<Receiver>() {};
			return mapper.readValue(result, typeRef);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Unable to call service /sms/%s/users/%s/receivers/%s", serviceName, login, slotId), e);
		}
	}

	public void deleteSMSUsersReceivers(String serviceName, String login, long slotId) throws OVHApiException {
		String url = String.format("sms/%s/users/%s/receivers/%s", serviceName, login, slotId);
		LOG.debug(String.format("%s ==> %s" , url));
		executeService(Method.DELETE, url, "");
	}

	public ReceiversAsynchronousCleanReport postSMSUsersReceiversClean(String serviceName, String login, long slotId) throws OVHApiException {
		String url = String.format("sms/%s/users/%s/receivers/%s/clean", serviceName, login, slotId);
		ObjectMapper mapper = new ObjectMapper();
		try {
			String result = executeService(Method.POST, url, "");
			return mapper.readValue(result, ReceiversAsynchronousCleanReport.class);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Unable to call service /sms/%s/users/%s/receivers", serviceName, login), e);
		}

	}

	public String getSMSUsersReceiversCsv(String serviceName, String login, long slotId) throws OVHApiException {
		String url = String.format("sms/%s/users/%s/receivers/%s/csv", serviceName, login, slotId);
		String result = executeService(Method.GET, url, "");
		
		LOG.debug(String.format("%s ==> %s" , url, result));

		ObjectMapper mapper = new ObjectMapper();
		try {
			TypeReference<String> typeRef = new TypeReference<String>() {};
			return mapper.readValue(result, typeRef);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Unable to call service /sms/%s/users/%s/receivers/%s/csv", serviceName, login, slotId), e);
		}
	}

	
}
