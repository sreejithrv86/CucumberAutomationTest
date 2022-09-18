package com.org.pageClass.pomManagerClass;
import org.openqa.selenium.WebDriver;

import com.org.pageClass.browseClass.HomePage;
import com.org.pageClass.browseClass.LoginPage;
import com.org.pageClass.browseClass.ProductDetailPage;
import com.org.pageClass.browseClass.ProductListPage;
public class PageObjectManager {
	
	 private final WebDriver webDriver;
	    private HomePage homePage;
	    private LoginPage loginPage;
	    private ProductListPage productListPage;
	    private ProductDetailPage productDetailPage;

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

}
