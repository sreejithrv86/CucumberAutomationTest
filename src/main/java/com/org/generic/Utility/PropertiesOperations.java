package com.org.generic.Utility;

import java.io.FileInputStream;
import java.util.Properties;

import io.netty.util.internal.StringUtil;

public class PropertiesOperations {

	public static Properties prop = new Properties();

	public static String getPropertyValueByKey(String key, String application, String env) {
		String value = "";
		String baseDir = "";
		String propFilePath = "";
		try {
			baseDir = System.getProperty("user.dir").replace("\\target", "");
			propFilePath = baseDir+"\\src\\main\\resources\\properties\\"+application+"_"+env+".properties";
			prop.load(new FileInputStream(propFilePath));
			value = prop.get(key).toString();
			if ((value.equals("") || 
				 value.isBlank()  ||
				 value.isEmpty()  ||
				 value==null))
				throw new CommonException("Given key : {0} does not exists or Empty in property file :  {1}", key, propFilePath);

		} catch (Exception e) {
			new CommonException("Unable to read data from property file");
		}
		return value;
	}

}