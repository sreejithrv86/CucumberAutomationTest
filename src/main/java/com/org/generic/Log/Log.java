package com.org.generic.Log;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Log {
	
	public static Logger getLogData(String className){
		String path = new File("").getAbsolutePath();
		DOMConfigurator.configure("log4j.xml");
		return Logger.getLogger(className);
	}

}
