package com.org.stepDefClass.browserStepClass;

import org.junit.jupiter.api.Assertions;

import com.org.enums.Context;
import com.org.pageClass.browseClass.ProductDetailPage;
import com.org.utilityClass.TestContext;

import io.cucumber.java.en.Then;

public class ProductDetailSteps {
	
	TestContext testContext;
    ProductDetailPage productDetailPage;

    public ProductDetailSteps(TestContext context) {
        testContext = context;
        productDetailPage = testContext.getPageObjectManager().getProductDetailPage();
    }

    @Then("Product detail with {string} type is displayed")
    public void productDetailWithType(String type) {
    	Assertions.assertTrue(productDetailPage.defaultProductDetailPageIsDisplayed());

        switch (type) {
            case "non fisik":
            	Assertions.assertTrue(productDetailPage.nonFisikProductDetailDataIsDisplayed());
                break;
            case "fisik":
            	Assertions.assertTrue(productDetailPage.fisikProductDetailDataIsDisplayed());
                break;
        }

        String actualBreadcrumbName = productDetailPage.getAllBreadcrumbName(3).toLowerCase();
        String expectedBreadcrumbName = testContext.getScenarioContext().getData(Context.EXPECTED_DATA).toString().toLowerCase();
        Assertions.assertTrue(actualBreadcrumbName.contains(expectedBreadcrumbName));

        Assertions.assertTrue(productDetailPage.moreBreadcrumbIsDisplayed());
    }

}
