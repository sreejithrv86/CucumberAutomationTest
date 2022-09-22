package com.org.page.Browse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.org.page.Common.CommonPage;

public class LoginPage extends CommonPage {

	@FindBy(className = "bt-split-screen__header")
	private WebElement loginHeaderTitle;

	@FindBy(id = "email")
	private WebElement emailField;

	@FindBy(id = "next")
	private WebElement selanjutnyaButton;

	@FindBy(xpath = "//div[@class='bt-social-group']//button[1]")
	private WebElement loginFacebookButton;

	@FindBy(id = "btnGoogle")
	private WebElement loginGoogleButton;

	@FindBy(className = "bt-question-register")
	private WebElement registerQuestionText;

	@FindBy(xpath = "//a[@href='/register']")
	private WebElement registerLink;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public boolean emailLoginPageIsDisplayed() {
		loginHeaderTitle.isDisplayed();
		emailField.isDisplayed();
		selanjutnyaButton.isDisplayed();
		loginFacebookButton.isDisplayed();
		loginGoogleButton.isDisplayed();
		registerQuestionText.isDisplayed();
		registerLink.isDisplayed();
		return true;
	}

	public String getLoginHeaderTitle() {
		loginHeaderTitle.isDisplayed();
		return loginHeaderTitle.getText();
	}

	public String getQuestionRegisterText() {
		registerQuestionText.isDisplayed();
		return registerQuestionText.getText();
	}

	public void fillEmailData(String email) {
		emailField.isEnabled();
		emailField.clear();
		emailField.sendKeys(email);
	}

	public void clickSelanjutnyaButton() {
		selanjutnyaButton.isEnabled();
		selanjutnyaButton.click();
	}
}
