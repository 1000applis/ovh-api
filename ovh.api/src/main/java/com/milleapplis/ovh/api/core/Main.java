package com.milleapplis.ovh.api.core;

import java.util.ArrayList;
import java.util.List;

import com.milleapplis.ovh.api.credential.Credential;
import com.milleapplis.ovh.api.sms.SMSService;
import com.milleapplis.ovh.api.sms.enums.SMSPriorityEnum;
import com.milleapplis.ovh.api.sms.param.POSTSmsJobParam;
import com.milleapplis.ovh.api.sms.param.POSTSmsSendersParam;
import com.milleapplis.ovh.api.sms.result.SMSSender;

public class Main {

	public static void main(String[] args) throws Exception {

		String ak = "atyFRie58oYAdqy2";
		String as = "zuMsbMdJMpb9VkrGh7jBCxUOQWZTtPP7";
		String ck = "X5NO3kW04iFsKE8XakKxXLaL6diTwDvq";
		String smsServiceName = "sms-sm422809-1";
		Credential credential = new Credential(ak, as, ck);
		
		SMSService service = new SMSService();
		System.out.println("Services list : " + service.getSMS(credential));
		System.out.println("Result : " + service.getSMSServiceName(credential, smsServiceName).getCreditsLeft());
		
		POSTSmsJobParam smsJobParam = new POSTSmsJobParam();
		smsJobParam.setCharset("utf8");
		smsJobParam.setMessage("Test de SMS");
		smsJobParam.setPriority(SMSPriorityEnum.HIGH.toString());
		List<String> telList = new ArrayList<String>();
		telList.add("0623106435");
		smsJobParam.setReceivers(telList);
		//System.out.println(service.postSMSServiceNameJobs(credential, smsServiceName, smsJobParam));
		
		//get sms senders
		System.out.println("Senders : " + service.getSMSSenders(credential, smsServiceName));
		
		System.out.println("Sender SKYLINE : " + service.GetSMSSender(credential, smsServiceName, "SKYLINE"));

		//service.DeleteSMSSender(credential, smsServiceName, "SKYLINE-2");
		
		POSTSmsSendersParam postSmsSender = new POSTSmsSendersParam();
		postSmsSender.setSender("SKYLINE-2");
		postSmsSender.setDescription("Sender id 2 of Skyline");
		postSmsSender.setReason("Sender id 2 of Skyline");
		service.PostSMSSenders(credential, smsServiceName, postSmsSender);

		System.out.println("Senders : " + service.getSMSSenders(credential, smsServiceName));
		
		System.out.println("Sender SKYLINE : " + service.GetSMSSender(credential, smsServiceName, "SKYLINE-2"));
		
		service.DeleteSMSSender(credential, smsServiceName, "SKYLINE-2");
		
	}

}
