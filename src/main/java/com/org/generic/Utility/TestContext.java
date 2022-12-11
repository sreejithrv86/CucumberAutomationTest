package com.org.generic.Utility;

import com.org.page.PomManager.PageObjectManager;

public class TestContext {

	private PageObjectManager pageObjectManager;
	private DataFactory dataContext;
	private DriverFactory driverManager;
	private LogFactory logManager;

	public TestContext() {
		pageObjectManager = new PageObjectManager(DriverFactory.getInstance().getDriver());
		dataContext = DataFactory.getInstance();
		driverManager = DriverFactory.getInstance();
		logManager = LogFactory.getInstance();
	}

	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}

	public DataFactory getDataContext() {
		return dataContext;
	}

	public DriverFactory getDriverManager() {
		return driverManager;
	}
	
	public LogFactory getLogManager() {
		return logManager;
	}

}