package com.org.generic.Utility;

import java.util.Properties;

public class FileReaderManager {
	
	private FileReaderManager() {

	}

	private static FileReaderManager instance = new FileReaderManager();

	public static FileReaderManager getInstance() {
		return instance;
	}

	ThreadLocal<Properties> prop = new ThreadLocal<Properties>();

	public void setFilePropery(Properties propParam) {
		prop.set(propParam);
	}

	public Properties getFileProperty() {
		return prop.get();
	}

	public void clearBrowser() {
		prop.remove();
		
	}
	
	public String getPropertyValueByKey(String key) {
		return getFileProperty().get(key).toString();
	}
	
	public String getReportConfigPath(){
		String reportConfigPath = getPropertyValueByKey("reportConfigPath");
		if(reportConfigPath!= null) return reportConfigPath;
		else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");		
	}

}
