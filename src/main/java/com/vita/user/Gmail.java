package com.vita.user;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class Gmail extends Authenticator{
	
	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication("bobdylan0331@gmail.com", "vpafaogvgnfxzlgf" );
				
	}

}
