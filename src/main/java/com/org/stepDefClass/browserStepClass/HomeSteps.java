package com.org.stepDefClass.browserStepClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.*;
import com.org.pageClass.browseClass.HomePage;
import com.org.stepDefClass.commonSteps;
import com.org.utilityClass.TestContext;

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
