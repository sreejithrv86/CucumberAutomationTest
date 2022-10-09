package com.org.generic.Utility;

public class CommonOtherFunctions {
	
	
	public void logInfoMessage(String txt) {
		ScenarioFactory.getInstance().getScenario().log("<pre class=\"embedded-text\"><span style='color:black'><ul><li>{txt}</li></ul></span></pre>".replace("{txt}", txt));
	}
}
