package com.revature.log;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class ItemLog {
	
	public final Logger itemLog = Logger.getLogger(ItemLog.class);
	
	public void ExceptionLog(Exception e) {
		itemLog.setLevel(Level.DEBUG);
        e.printStackTrace();
        itemLog.debug(e);
	}
	
	public void infoLogger(String i) {
        itemLog.setLevel(Level.INFO);
        itemLog.info(i);
    }

}
