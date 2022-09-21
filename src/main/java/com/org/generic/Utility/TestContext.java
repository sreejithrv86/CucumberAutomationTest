package com.org.generic.Utility;

import com.org.generic.Utility.DriverFactory;
import com.org.page.PomManager.PageObjectManager;

public class TestContext {

    private final PageObjectManager pageObjectManager;
    private final ScenarioFactory scenarioContext;
    private final DriverFactory driverManager;
    
    public TestContext() {
        pageObjectManager = new PageObjectManager(DriverFactory.getInstance().getDriver());
        scenarioContext = ScenarioFactory.getInstance();
        driverManager = DriverFactory.getInstance();
    }

     public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }

    public ScenarioFactory getScenarioContext() {
        return scenarioContext;
    }
    
    public DriverFactory getDriverManager() {
        return driverManager;
    }
}