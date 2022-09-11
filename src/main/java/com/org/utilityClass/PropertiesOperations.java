package com.org.utilityClass;

import java.io.FileInputStream;
import java.util.Properties;

import io.netty.util.internal.StringUtil;

public class PropertiesOperations {

	public static Properties prop = new Properties();
	public static String baseDir = System.getProperty("user. dir").replace("/target", "");

	public static String getPropertyValueByKey(String key, String application, String env) {
		try {
			String propFilePath = baseDir+"//src//main//resources//properties//"+application+"_"+env+"properties";
            prop.load(new FileInputStream(propFilePath));
			if (StringUtil.isNullOrEmpty(prop.get(key).toString()))
				throw new CommonException("Given key : {0} does not exists or Empty in property file :  {1}", key, propFilePath);

		} catch (Exception e) {
			new CommonException("Unable to read data from property file");
		}
		return prop.get(key).toString();
	}

}
