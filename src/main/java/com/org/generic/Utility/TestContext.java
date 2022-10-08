package com.org.generic.Utility;

import com.org.page.PomManager.PageObjectManager;

public class TestContext {

	private final PageObjectManager pageObjectManager;
	private final DataFactory dataContext;
	private final DriverFactory driverManager;
	private final ScenarioFactory scnFactory;
	private final FileReaderManager fileManager;

	public TestContext() {
		pageObjectManager = new PageObjectManager(DriverFactory.getInstance().getDriver());
		dataContext = DataFactory.getInstance();
		driverManager = DriverFactory.getInstance();
		scnFactory = ScenarioFactory.getInstance();
		fileManager= FileReaderManager.getInstance();
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
	
	public ScenarioFactory getScenariorioManager() {
		return scnFactory;
	}
	
	public FileReaderManager getFileManager() {
		return fileManager;
	}

}