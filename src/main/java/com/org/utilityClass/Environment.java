package com.org.utilityClass;

import io.netty.util.internal.StringUtil;

public class Environment {
	
	private String browserName;
	private String environmentName;
	private String applicationName;
	
	public String getBrowserName() {
		return (StringUtil.isNullOrEmpty(browserName)) ? "chrome" : browserName;
	}
	public void setBrowserName(String browserName) {
		this.browserName = browserName;
	}
	public String getEnvironmentName() {
		return (StringUtil.isNullOrEmpty(environmentName)) ? "uat" : environmentName;
	}
	public void setEnvironmentName(String environmentName) {
		this.environmentName = environmentName;
	}
	public String getApplicationName() {
		return (StringUtil.isNullOrEmpty(applicationName)) ? "phptravels" : applicationName;
	}
	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

}
