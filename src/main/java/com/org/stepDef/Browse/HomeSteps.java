package com.org.stepDef.Browse;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.*;

import com.org.generic.Utility.TestContext;
import com.org.page.Browse.HomePage;
import com.org.stepDef.Common.commonSteps;

public class HomeSteps extends commonSteps{

    HomePage homePage;
    TestContext testContext;

    public HomeSteps(TestContext testContext) {
    	super(testContext);
        homePage = testContext.getPageObjectManager().getHomePage();
    }

    @Given("Home page without authorizations")
    public void homePageWithoutAuthorizations() {
    	Assertions.assertTrue(homePage.defaultHomePageIsDisplayed());
    }

    @Given("Login form in login page")
    public void goToLoginPage() {
        Assertions.assertTrue(homePage.defaultHomePageIsDisplayed());
        homePage.clickLoginButton();
    }

    @Then("This is for invalid locators")
    public void thisIsForInvalidLocators() {
        homePage.getInvalidLocators();
    }
}
