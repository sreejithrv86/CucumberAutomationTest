package com.org.page.Browse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.org.generic.Utility.Wait;
import com.org.page.Common.CommonPage;

import java.time.Duration;
import java.util.List;

public class ProductListPage extends CommonPage {

	public ProductListPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@class = 'Toastify']//following-sibling::div//h1[not(contains(text(),'Halo'))]")
	private WebElement resultTitle;

	@FindBy(className = "select-wrapper")
	private WebElement urutkanOptionButton;

	@FindBy(xpath = "//i[@name='property']//parent::button")
	private WebElement listViewButton;

	@FindBy(xpath = "//i[@name='grid-view']//parent::button")
	private WebElement gridViewButton;

	@FindBy(xpath = "//div[@class='product-title']//parent::div//parent::a")
	private List<WebElement> allProductList;

	@FindBy(xpath = "//div[@class='product-title']//p")
	private List<WebElement> allProductTitle;

	public boolean searchResultPageIsDisplayed() {
		return true;
	}

	public String getResultTitle() {
		resultTitle.isDisplayed();
		return resultTitle.getText();
	}

	public String getProductAmount() {
		return String.valueOf(allProductList.size());
	}

	public String getAllProductTitle(int index) {

		return "";
	}

	public void selectProductInList(int list) {
		int index = list - 1;

		allProductList.get(index).isDisplayed();
		allProductList.get(index).isEnabled();
		allProductList.get(index).click();
	}
}
