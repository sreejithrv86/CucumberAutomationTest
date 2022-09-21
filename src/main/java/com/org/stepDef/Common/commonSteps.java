package com.org.stepDef.Common;

import java.util.List;
import java.util.Map;

import com.org.generic.Enums.Context;
import com.org.generic.Enums.StoreValues;
import com.org.generic.Utility.TestContext;
import com.org.page.Common.CommonPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class commonSteps {
	CommonPage commonPage;
    TestContext testContext;
    
	public commonSteps(TestContext context) {
        testContext = context;
    }
	public void setDataTable(DataTable dt) {
		testContext.getScenarioContext().setData(Context.DATA_TABLE, dt.asMap(StoreValues.class, String.class));
		}
	
	public List<Map<Context, String>> getDataTable(){
		return (List<Map<Context, String>>) testContext.getScenarioContext().getData(Context.DATA_TABLE);
	}
	
	public Map<Context, String> getDataTable(int item){
		
		return getDataTable().get(item);
	}

}