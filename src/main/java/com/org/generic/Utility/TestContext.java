package com.org.generic.Utility;

import com.org.page.PomManager.PageObjectManager;

public class TestContext {

	private PageObjectManager pageObjectManager;
	private DataFactory dataContext;
	private DriverFactory driverManager;

	public TestContext() {
		pageObjectManager = new PageObjectManager(DriverFactory.getInstance().getDriver());
		dataContext = DataFactory.getInstance();
		driverManager = DriverFactory.getInstance();
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

}