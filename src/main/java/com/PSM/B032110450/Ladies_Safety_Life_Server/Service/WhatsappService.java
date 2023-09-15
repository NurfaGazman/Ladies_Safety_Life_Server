package com.PSM.B032110450.Ladies_Safety_Life_Server.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumberCapabilities;

public class WhatsappService {
	public static final String ACCOUNT_SID = "AC5ac0d75557d2b8dd97d2df206a2f0fcf";
	public static final String AUTH_TOKEN = "f14d1cf448d495d76621f180cc45ad5a";
	
	public static void send(String sendReceive, String sendMessage) {
		Twilio.init(ACCOUNT_SID,AUTH_TOKEN);
		Message message = Message.creator(
				new com.twilio.type.PhoneNumber("whatsapp:+6" + sendReceive),
				new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
				sendMessage).create();
				
				
				System.out.println(message.getSid());
				
	}
}

//testtttttttttttttt