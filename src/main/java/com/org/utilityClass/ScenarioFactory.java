package com.org.utilityClass;

import com.org.enums.Context;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

public class ScenarioFactory {

	private ScenarioFactory() {

	}

	private static ScenarioFactory scenarioFactory = new ScenarioFactory();

	public static ScenarioFactory getInstance() {
		return scenarioFactory;
	}

	ThreadLocal<Map<Context, Object>> scenarioContext = new ThreadLocal<Map<Context, Object>>();
	
	public void setData(Context key, Object value) {
		scenarioContext.get().put(key, value);
	}

	public Object getData(Context key) {
		return scenarioContext.get().get(key);
	}

    public Boolean isContains(Context key) {
        return scenarioContext.get().containsKey(key);
    }
}
