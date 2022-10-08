package com.org.generic.Utility;

import io.cucumber.java.Scenario;

public class ScenarioFactory {
	
	private ScenarioFactory() {

	}

	private static ScenarioFactory instance = new ScenarioFactory();

	public static ScenarioFactory getInstance() {
		return instance;
	}

	ThreadLocal<Scenario> scenario = new ThreadLocal<Scenario>();
	
	public void setScenario(Scenario scn) {
		scenario.set(scn);
	}

	public Scenario getScenario() {
		return scenario.get();
	}

	public void clearScenario() {
		scenario.remove();
		
	}

}
