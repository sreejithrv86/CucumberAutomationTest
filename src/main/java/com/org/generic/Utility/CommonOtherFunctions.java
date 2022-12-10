package com.org.generic.Utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CommonOtherFunctions {

	public void logInfoMessage(Object obj) {
		if (obj.getClass().getSimpleName().contains("Map")) {
			ObjectMapper oMapper = new ObjectMapper();
			Map<String, Object> map = oMapper.convertValue(obj, Map.class);
			for (Map.Entry<String, Object> entry : map.entrySet())
				ScenarioFactory.getInstance().getScenario().log(
						"<pre class=\"embedded-text\"><span style='color:black'><ul><li>{txt}</li></ul></span></pre>"
								.replace("{txt}",
										String.valueOf(entry.getKey()) + " : " + String.valueOf(entry.getValue())));
		} else if (obj.getClass().getSimpleName().contains("List")) {
			List<?> list = new ArrayList<>();
			if (obj.getClass().isArray()) {
				list = Arrays.asList((Object[]) obj);
			} else if (obj instanceof Collection) {
				list = new ArrayList<>((Collection<?>) obj);
			}
			for (Object ob : list) {
				ScenarioFactory.getInstance().getScenario().log(
						"<pre class=\"embedded-text\"><span style='color:black'><ul><li>{txt}</li></ul></span></pre>"
								.replace("{txt}", String.valueOf(ob)));
			}
		} else {
			ScenarioFactory.getInstance().getScenario()
					.log("<pre class=\"embedded-text\"><span style='color:black'><ul><li>{txt}</li></ul></span></pre>"
							.replace("{txt}", String.valueOf(obj)));
		}

	}

}
