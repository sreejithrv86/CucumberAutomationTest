package com.org.stepDefClass;

import java.util.List;
import java.util.Map;

import com.org.enums.Context;
import com.org.enums.StoreValues;
import com.org.pageClass.CommonClass.CommonPage;
import com.org.utilityClass.TestContext;

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
