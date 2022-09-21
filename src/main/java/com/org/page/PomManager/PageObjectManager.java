package com.org.page.PomManager;
import org.openqa.selenium.WebDriver;

import com.org.page.Browse.HomePage;
import com.org.page.Browse.LoginPage;
import com.org.page.Browse.ProductDetailPage;
import com.org.page.Browse.ProductListPage;
import com.org.page.Common.CommonPage;
public class PageObjectManager {
	
	 private final WebDriver webDriver;
	    private HomePage homePage;
	    private LoginPage loginPage;
	    private ProductListPage productListPage;
	    private ProductDetailPage productDetailPage;
	    private CommonPage commonPage;

	    public PageObjectManager(WebDriver webDriver) {
	        this.webDriver = webDriver;
	    }

	    public HomePage getHomePage() {
	        return (homePage == null) ? homePage = new HomePage(webDriver) : homePage;
	    }

	    public LoginPage getLoginPage() {
	    	return (loginPage == null) ? loginPage = new LoginPage(webDriver) : loginPage;
	    }

	    public ProductListPage getProductListPage() {
	        return (productListPage == null) ? productListPage = new ProductListPage(webDriver) : productListPage;
	    }

	    public ProductDetailPage getProductDetailPage() {
	    	 return (productDetailPage == null) ? productDetailPage = new ProductDetailPage(webDriver) : productDetailPage;
	    }
	    public CommonPage getCommonPage() {
	    	 return (commonPage == null) ? commonPage = new CommonPage(webDriver) : commonPage;
	    }
}
