package com.org.page.Browse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.org.generic.Utility.Wait;
import com.org.page.Common.CommonPage;

import java.time.Duration;
import java.util.List;

public class ProductDetailPage  extends CommonPage{

    public ProductDetailPage(WebDriver driver) {
    	super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean defaultProductDetailPageIsDisplayed() {
       
        return true;
    }

    public boolean nonFisikProductDetailDataIsDisplayed() {
       
        return true;
    }

    public boolean fisikProductDetailDataIsDisplayed() {
        
        return true;
    }

    public String getAllBreadcrumbName(int index) {
        
        return "";
    }

    public boolean moreBreadcrumbIsDisplayed() {
        
        return true;
    }
}