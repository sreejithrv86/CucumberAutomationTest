package com.org.stepDef.Browse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.org.generic.Enums.Context;
import com.org.generic.Utility.CommonOtherFunctions;
import com.org.generic.Utility.DataFactory;
import com.org.generic.Utility.ScenarioFactory;
import com.org.generic.Utility.TestContext;
import com.org.page.Browse.ProductListPage;
import com.org.stepDef.Common.commonSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class ProductListSteps  extends commonSteps{
	ProductListPage productListPage;
	 CommonOtherFunctions comofun = new CommonOtherFunctions();
	 
	 public ProductListSteps(TestContext testContext) {
		 super(testContext);
	        productListPage = testContext.getPageObjectManager().getProductListPage();
	    }
	 
	 @Given("user navigates to the website javatpoint.com")
		public void user_navigates_to_the_website_javatpoint_com() {
		 comofun.logInfoMessage("Sample Text Message");
		 testContext.getDataContext().getInstance().setData(Context.SEARCH_HEADER, "SAMPLE TEXT CONTEXT MESSAGE");
		 testContext.getDataContext().getInstance().setData(Context.SEARCH_VALUE, "SAMPLE SEARCH CONTEXT VALUE MESSAGE");
		 testContext.getDataContext().getInstance().setData(Context.SEARCH_RESULT, "SAMPLE SEARCH RESULT CONTEXT VALUE MESSAGE");
		 
		 Map<String, Integer> map = new HashMap<String, Integer>();
		 map.put("Sreejith", 12345);
		 map.put("Arya", 54321);
		 map.put("Sriya", 67890);
		 DataFactory.getInstance().setData(Context.DATA_MAP, map);
		 List<String> list = new ArrayList<String>();
		 list.add("Ravi");
		 list.add("Radha");
		 map.put("Sriya", 67890);
		 DataFactory.getInstance().setData(Context.DATA_LIST, list);
		 
		   System.out.println("STEP 1"); 
		}

		@Given("there user logs in through Login Window by using Username as {string} and Password as {string}")
		public void there_user_logs_in_through_login_window_by_using_username_as_and_password_as(String string, String string2) {
			   System.out.println("STEP 2");
			   comofun.logInfoMessage((String)testContext.getDataContext().getInstance().getData(Context.SEARCH_HEADER));
			   comofun.logInfoMessage((String)testContext.getDataContext().getInstance().getData(Context.SEARCH_VALUE));
			   comofun.logInfoMessage((String)testContext.getDataContext().getInstance().getData(Context.SEARCH_RESULT));
			   System.out.println(DataFactory.getInstance().getData(Context.DATA_MAP));
			   System.out.println(DataFactory.getInstance().getData(Context.DATA_LIST));
			   
			   
		    
		}

		@Then("login must be successful")
		public void login_must_be_successful() {
			   System.out.println("STEP 3"); 
		    
		}
		
	 


	 
}
