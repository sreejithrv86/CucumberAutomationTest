package com.org.utilityClass;

import com.org.pageClass.pomManagerClass.PageObjectManager;
import com.org.utilityClass.DriverFactory;

public class TestContext {

    private final PageObjectManager pageObjectManager;
    private final ScenarioContext scenarioContext;
    private final DriverFactory driverManager;
    
    public TestContext() {
        pageObjectManager = new PageObjectManager(DriverFactory.getInstance().getDriver());
        scenarioContext = new ScenarioContext();
        driverManager = DriverFactory.getInstance();
    }

     public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }

    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }
    
    public DriverFactory getDriverManager() {
        return driverManager;
    }
}