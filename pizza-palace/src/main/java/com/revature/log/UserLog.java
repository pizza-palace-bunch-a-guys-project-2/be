package com.revature.log;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class UserLog {
public final Logger userLog = Logger.getLogger(UserLog.class);
	
	public void exceptionLog(Exception e) {
		userLog.setLevel(Level.DEBUG);
        e.printStackTrace();
        userLog.debug(e);
	}
	
	public void infoLogger(String i) {
		userLog.setLevel(Level.INFO);
		userLog.info(i);
    }
	
	public void errorLogger(String e) {
		userLog.setLevel(Level.DEBUG);
		 userLog.debug(e);
	}
}
