package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import jakarta.annotation.PostConstruct;

@Service
public class SmsService {
	 @Value("${twilio.account.sid}")
	    private String accountSid;

	    @Value("${twilio.auth.token}")
	    private String authToken;

	    @Value("${twilio.phone.number}")
	    private String fromPhoneNumber;

	    @PostConstruct
	    private void initTwilio() {
	        Twilio.init(accountSid, authToken);
	    }

	    public boolean sendSms(String toPhoneNumber, String messageContent) {
	        try {
	            Message message = Message.creator(
	                    new PhoneNumber(toPhoneNumber),
	                    new PhoneNumber(fromPhoneNumber),
	                    messageContent).create();
	            return message.getSid() != null;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
}
