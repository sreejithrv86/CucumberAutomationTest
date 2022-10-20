package com.org.stepDef.Common;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.org.generic.Enums.Context;
import com.org.generic.Enums.StoreValues;
import com.org.generic.Utility.DataFactory;
import com.org.generic.Utility.DriverFactory;
import com.org.generic.Utility.TestContext;
import com.org.page.PomManager.PageObjectManager;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class commonSteps {
	
	public TestContext testContext;
    
	public commonSteps(TestContext context) {
		this.testContext=context;
    }
	public void setDataTable(DataTable dt) {
		testContext.getDataContext().getInstance().setData(Context.DATA_TABLE, dt.asMap(StoreValues.class, String.class));
		}
	
	public List<Map<Context, String>> getDataTable(){
		return (List<Map<Context, String>>) testContext.getDataContext().getInstance().getData(Context.DATA_TABLE);
	}
	
	public Map<Context, String> getDataTable(int item){
		
		return getDataTable().get(item);
	}
	public void setPageData(List<LinkedHashMap<String, String>> value) {
		testContext.getDataContext().getInstance().setData(Context.PAGE_DATA, value);
	}
	
	public List<LinkedHashMap<String, String>> getPageData() {
		return (List<LinkedHashMap<String, String>>) testContext.getDataContext().getInstance().getData(Context.PAGE_DATA);
	}

}
