package com.org.generic.Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {

	public static Properties prop = new Properties();

	public static Properties getProperty(String application, String env) {
		String baseDir = "";
		String propFilePath = "";
		try {
			baseDir = System.getProperty("user.dir").replace("\\target", "");
			propFilePath = baseDir+"\\src\\main\\resources\\properties\\"+application+"_"+env+".properties";
				prop.load(new FileInputStream(propFilePath));
			} catch (IOException e) {
				e.printStackTrace();
			}
			return prop;

	}

}
