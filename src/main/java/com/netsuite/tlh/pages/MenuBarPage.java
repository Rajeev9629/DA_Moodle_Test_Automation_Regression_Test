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
	
	@FindBy(xpath = "//*[text()='Advancement Courses']")
	private WebElement loginPage2Heading;
	
	@FindBy(css = "button[type='Submit']")
	private WebElement sitePolicyYesButton;
	
	@FindBy(css = "button[data-action='toggle-drawer']")
	private WebElement hamburgerIcon;
	
	
	public MenuBarPage acceptSitePolicy() throws Throwable {
		Thread.sleep(2000);
		if(BrowserFactory.getDriver().getTitle().equalsIgnoreCase("Site policy agreement")) {
			waitForElementToBeVisibile(sitePolicyYesButton);
			waitForElementToBeClickable(sitePolicyYesButton);
			sitePolicyYesButton.click();
			waitForElementToBeVisibile(hamburgerIcon);
			waitForElementToBeClickable(hamburgerIcon);
			hamburgerIcon.click();
		}
		return this;
	}
	
	
	
	public MenuBarPage checkLoginPage() throws Throwable {
		Thread.sleep(2000);
		if(BrowserFactory.getDriver().getTitle().equalsIgnoreCase("Advancement Courses: Log in to the site")) {
			waitForElementToBeVisibile(loginPage2Heading);
			//System.out.println("XXXXXXXXX"+BrowserFactory.url);
			BrowserFactory.getDriver().get(BrowserFactory.url);
		}
		return this;
	}
	
	
	
	public MenuBarPage clickmenuBarDropDown() throws Throwable {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
            }};
            WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), 30);
            wait.until(expectation);
            Thread.sleep(3000);
		waitForElementToBeVisibile(menuBarDropdown);
		menuBarDropdown.click();Thread.sleep(3000);
		return this;
	}
	
	public MenuBarPage clicklogOut() throws Throwable {
		waitForElementToBeVisibile(logOut);
		waitForElementToBeClickable(logOut);
		logOut.click();
		return this;
	}
	
	
}
