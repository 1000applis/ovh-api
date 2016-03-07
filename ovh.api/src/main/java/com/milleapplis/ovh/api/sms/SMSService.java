package com.milleapplis.ovh.api.sms;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.milleapplis.ovh.api.core.AbstractService;
import com.milleapplis.ovh.api.core.OVHApiException;
import com.milleapplis.ovh.api.credential.Credential;
import com.milleapplis.ovh.api.sms.param.POSTSmsJobParam;
import com.milleapplis.ovh.api.sms.param.POSTSmsSendersParam;
import com.milleapplis.ovh.api.sms.result.SMSSender;
import com.milleapplis.ovh.api.sms.result.SMSServiceName;
import com.milleapplis.ovh.api.util.Method;

public class SMSService extends AbstractService {


	/**
	 * Retourne la liste des comptes SMS associés à ce credential
	 * 
	 * @param credential Clés à utiliser pour l'accès aux comptes
	 * @return une liste des comptes SMS associé à ce crendential
	 * @throws OVHApiException Si une erreur est identifiée.
	 */
	public List<String> getSMS(Credential credential) throws OVHApiException {
		String url = String.format("sms/");
		String result = executeService(credential, Method.GET, url, "");
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(result, List.class);
		}
		catch (Exception e) {
			throw new OVHApiException("Impossible d'appeler le service /sms", e);
		}
	}
	
	/**
	 * Retourne les informations associées à un service de SMS (tel aus le nombre de sms restant par exemple).
	 * 
	 * @param credential Clés à utiliser pour l'accès aux comptes
	 * @param serviceName nom du service pour lequel on souhaite récupérer les informations
	 * @return l'objet OVH contenant les infotmations du service.
	 * 
	 * @throws OVHApiException Si une erreur est identifiée.
	 */
	public SMSServiceName getSMSServiceName(Credential credential, String serviceName) throws OVHApiException {
		String url = String.format("sms/%s/", serviceName);
		String result = executeService(credential, Method.GET, url, "");
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(result, SMSServiceName.class);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Impossible d'appeler le service /sms/%s", serviceName), e);
		}
	}

	
	/**
	 * Service permettant d'envoyer des SMS
	 * 
	 * @param credential  Clés à utiliser pour l'accès aux comptes
	 * @param serviceName nom du service pour lequel on souhaite envoyer des sms
	 * @param smsJobParam informations nécessaires à l'envoi des SMS
	 * @return ???
	 * @throws OVHApiException Si une erreur est identifiée.
	 */
	public String postSMSServiceNameJobs(Credential credential, String serviceName, POSTSmsJobParam smsJobParam) throws OVHApiException {
		String url = String.format("sms/%s/jobs", serviceName);
		ObjectMapper mapper = new ObjectMapper();
		String body = null;
		try {
			body = mapper.writeValueAsString(smsJobParam);
		}
		catch (Exception e) {
			throw new OVHApiException(String.format("Impossible d'appeler le service /sms/%s/jobs", serviceName), e);
		}
		return executeService(credential, Method.POST, url, body);
	}

	/**
	 * Récupère la liste des Sender ID pour un compte SMS
	 * 
	 * @param credential Clés à utiliser pour l'accès aux comptes
	 * @param serviceName nom du service pour lequel on souhaite récupérer les sender id
	 * @return la liste des senders id configurés sur ce compte
	 * 
	 * @throws OVHApiException Si une erreur est identifiée.
	 */
	public List<String> getSMSSenders(Credential credential, String serviceName) throws OVHApiException {
		String url = String.format("sms/%s/senders", serviceName);
		String result = executeService(credential, Method.GET, url, "");

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
	 * @param credential Clés à utiliser pour l'accès aux comptes
	 * @param serviceName nom du service pour lequel on souhaite récupérer les sender id
	 * @param smsSenders nom du sender id à ajouter au compte (max 11 caractères).
	 * @return
	 * @throws OVHApiException OVHApiException Si une erreur est identifiée.
	 */
	public String PostSMSSenders(Credential credential, String serviceName, POSTSmsSendersParam smsSenders) throws OVHApiException {
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
		return executeService(credential, Method.POST, url, body);
	}
	
	/**
	 * Permet de récupérer les informations sur un sender id
	 * 
	 * @param credential credential Clés à utiliser pour l'accès aux comptes
	 * @param serviceName nom du service pour lequel on souhaite récupérer les informatins du sender id
	 * @param sender sender id
	 * @return les informations du sender id
	 * 
	 * @throws OVHApiException Si une erreur est identifiée.
	 */
	public SMSSender GetSMSSender(Credential credential, String serviceName, String sender) throws OVHApiException {
		String url = String.format("sms/%s/senders/%s", serviceName, sender);
		String result = executeService(credential, Method.GET, url, "");

		System.out.println("Result : " + result);
		
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
	 * @param credential credential Clés à utiliser pour l'accès aux comptes
	 * @param serviceName nom du service pour lequel on souhaite modifier les informatins du sender id
	 * @param sender sender id
	 * @param smsSender informations à modifier
	 * @return ??
	 * 
	 * @throws OVHApiException Si une erreur est identifiée.
	 */
	public String PutSMSSenders(Credential credential, String serviceName, String sender, SMSSender smsSender) throws OVHApiException {
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
		return executeService(credential, Method.PUT, url, body);
	}


	/**
	 * Supprime un sender id
	 * 
	 * @param credential  credential Clés à utiliser pour l'accès aux comptes
	 * @param serviceName nom du service pour lequel on souhaite supprimer le sender id
	 * @param sender sender id à supprimer
	 * 
	 * @throws OVHApiException  Si une erreur est identifiée.
	 */
	public void DeleteSMSSender(Credential credential, String serviceName, String sender) throws OVHApiException {
		String url = String.format("sms/%s/senders/%s", serviceName, sender);
		executeService(credential, Method.DELETE, url, "");
	}

	/**
	 * Valide un sender id pas rapport à un code de validation
	 * 
	 */
	public String PostSMSSendersValidate(Credential credential, String serviceName, String sender, String code) throws OVHApiException {
		if (code == null) {
			throw new OVHApiException("Validation code cannot be null.");
		}
		
		String url = String.format("sms/%s/senders/%s/validate", serviceName, sender);
		String body = null;
		body = String.format("{\"code\":\"%s\"}", code);
		return executeService(credential, Method.POST, url, body);
	}

	
}
