package com.org.generic.Utility;

import java.util.Map;
import com.org.generic.Enums.Context;

public class DataFactory {

	private DataFactory() {

	}

	private static DataFactory dataFactory = new DataFactory();

	public static DataFactory getInstance() {
		return dataFactory;
	}

	ThreadLocal<Map<Context, Object>> dataContext = new ThreadLocal<Map<Context, Object>>();
	
	public void setData(Context key, Object value) {
		dataContext.get().put(key, value);
	}

	public Object getData(Context key) {
		return dataContext.get().get(key);
	}

    public Boolean isContains(Context key) {
        return dataContext.get().containsKey(key);
    }
}
