package com.Rang.maven.Rang_SecurityForEveryone;
import java.net.URI;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
public class TextMessage 
{
	public static void sendText(String phoneNumberTo)
	{
	String ACCOUNT_SID = "ACbbfb73afc466e2a8838f1935036b1b90";
	String AUTH_TOKEN = "df00657a382bbaf0f8f13030066c2f6a";
	Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

	String to = phoneNumberTo;
	String from = "+18608542854";

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	LocalDateTime now = LocalDateTime.now();
	
	Message message = Message.creator(
	new PhoneNumber(to),
	new PhoneNumber(from),
	"Your Camera has Detected Motion")
	.create();
	
	Message message2 = Message.creator(
			new PhoneNumber(to),
			new PhoneNumber(from),
			"Watch video: " + dtf.format(now))
			.create();
	}

}
