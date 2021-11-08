package com.revature.log;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class EmailLog {
public final Logger emailLog = Logger.getLogger(EmailLog.class);
	
	public void exceptionLog(Exception e) {
		emailLog.setLevel(Level.DEBUG);
        e.printStackTrace();
        emailLog.debug(e);
	}
	
	public void infoLogger(String i) {
		emailLog.setLevel(Level.INFO);
		emailLog.info(i);
    }
	
	public void errorLogger(String e) {
		emailLog.setLevel(Level.DEBUG);
		emailLog.debug(e);
	}
}
