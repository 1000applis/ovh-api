package com.milleapplis.ovh.api.core;

import com.milleapplis.ovh.api.credential.Credential;
import com.milleapplis.ovh.api.me.MEServices;
import com.milleapplis.ovh.api.me.enums.MECredentialStateEnum;

public class Main {

	public static void main(String[] args) throws Exception {

		Credential credential = new Credential("QRpjAsbGDmzNCMZQ","7VikprxRLxLlJ9YlqDtrzbHFcDrq8tME","G5p2UZl04RSz1So0p9i866SQYo7rFxUx");
		
		MEServices meServices = new MEServices(credential);
		
		System.out.println("Bill : " + meServices.getMEBill(null, null));
		
		System.out.println("Applications : " + meServices.getMEApiApplication());
		
		//[16161, 16219, 16220]
		System.out.println("Application : " + meServices.getMEApiApplication(16161));
		
		System.out.println("Credential : " + meServices.getMEApiCredential(16161, MECredentialStateEnum.VALIDATED));
		
		System.out.println("Credential detail : " + meServices.getMEApiCredential(41775832));
		
		System.out.println("Application from credential : " + meServices.getMEApiCredentialApplication(41775832));
	}

}
