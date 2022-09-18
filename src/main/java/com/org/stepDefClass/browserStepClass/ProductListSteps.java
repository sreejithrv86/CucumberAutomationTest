package com.org.stepDefClass.browserStepClass;

import com.org.pageClass.browseClass.ProductListPage;
import com.org.utilityClass.TestContext;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductListSteps {
	 ProductListPage productListPage;
	 TestContext testContext;
	 
	 public ProductListSteps(TestContext context) {
	        testContext = context;
	        productListPage = testContext.getPageObjectManager().getProductListPage();
	    }
	 


	 
}
