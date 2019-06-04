package com.sawforgarden.myapp.CloudCommunicationPlatform;

import org.apache.log4j.Logger;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
//Twilio is cloud communication platform
// (334) 339-7208
//Your new Phone Number is +13343397208

public class SendSms {
	 
	private static final Logger logger = Logger
			.getLogger(SendSms.class);
		
	// Find your Account Sid and Auth Token at twilio.com/console
    public static final String ACCOUNT_SID = "****";
    public static final String AUTH_TOKEN = "**";

	public static void SendSmsWithTwillo(String PHONEMESSAGE,String phone) {
		
		try {
		
			Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

			logger.info(phone);
			
		    Message message = Message.creator(
		    	new PhoneNumber("*****"),
		        new PhoneNumber("+13343397208"), 
		        PHONEMESSAGE
		        ).create();

			
			
	    logger.info("That messsage from sendSMS---"+message.getSid());
		}
		catch(Exception e) {
			logger.info("There seems error ---"+e);
		}
	    
	    
	}
	
}
