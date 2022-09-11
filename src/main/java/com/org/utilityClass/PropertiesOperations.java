package com.org.utilityClass;

import java.io.FileInputStream;
import java.util.Properties;

import io.netty.util.internal.StringUtil;

public class PropertiesOperations {

	public static Properties prop = new Properties();

	public static String getPropertyValueByKey(String key, String application, String env) {
		try {
			String propFilePath = System.getProperty("user.dir")+"\\src\\main\\resources\\properties\\"+application+"_"+env+".properties";
            System.out.println("propFilePath = " + propFilePath);
			prop.load(new FileInputStream(propFilePath));
			if (StringUtil.isNullOrEmpty(prop.get(key).toString()))
				throw new CommonException("Given key : {0} does not exists or Empty in property file :  {1}", key, propFilePath);

		} catch (Exception e) {
			new CommonException("Unable to read data from property file");
		}
		return prop.get(key).toString();
	}

}
