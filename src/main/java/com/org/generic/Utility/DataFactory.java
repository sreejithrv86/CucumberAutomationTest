package com.org.generic.Utility;

import java.util.HashMap;
import java.util.Map;
import com.org.generic.Enums.Context;

public class DataFactory {

	private DataFactory() {

	}

	private static DataFactory dataFactory = new DataFactory();

	public static DataFactory getInstance() {
		  if(dataFactory == null){
			  dataFactory = new DataFactory();
	        }

		return dataFactory;
	}

	ThreadLocal<Map<String, Object>> dataContext = new ThreadLocal<Map<String, Object>>();
	
	public void setData(Context key, Object value) {
		if(dataContext.get()==null) {
		Map<String, Object> map = new HashMap<String, Object>(){{
			this.put(key.toString(), value);
		}};
		dataContext.set(map);
		}
		else {
			dataContext.get().put(key.toString(), value);
		}
	}

	public Object getData(Context key) {
		return dataContext.get().get(key.toString());
	}

    public Boolean isContains(Context key) {
        return dataContext.get().containsKey(key.toString());
    }
}
