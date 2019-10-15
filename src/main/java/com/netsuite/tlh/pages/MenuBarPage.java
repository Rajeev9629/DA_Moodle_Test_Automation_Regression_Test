package com.netsuite.tlh.pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.base.BrowserFactory;
import com.framework.exceptions.DriverNotInitializedException;


public class MenuBarPage extends BasePage {

	public MenuBarPage() throws DriverNotInitializedException {
		super();
	}
	
	@FindBy(css = "a[id='dropdown-1']")
	private WebElement menuBarDropdown;
	
	@FindBy(css = "i[title='Log out']")
	private WebElement logOut;
	
	
	public MenuBarPage clickmenuBarDropDown() throws Throwable {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
            }};
            WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), 30);
            wait.until(expectation);
            Thread.sleep(3000);
		waitForElementToBeVisibile(menuBarDropdown);
		menuBarDropdown.click();
		return this;
	}
	
	public MenuBarPage clicklogOut() throws Throwable {
		waitForElementToBeVisibile(logOut);
		waitForElementToBeClickable(logOut);
		logOut.click();
		return this;
	}
	
	
}
