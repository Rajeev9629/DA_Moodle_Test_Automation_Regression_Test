package com.netsuite.tlh.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.framework.base.BrowserFactory;
import com.framework.exceptions.DriverNotInitializedException;
import com.framework.utils.SystemConfigurations;
import com.netsuite.tlh.factory.NetsuiteTLHPageFactory;
import com.netsuite.tlh.factory.OperationFactory;


public class ParticipantsPage extends BasePage {

	public ParticipantsPage() throws DriverNotInitializedException {
		super();
	}
	public static String Name;

	@FindBy(xpath = "(//input[@type='submit'])[2]")
	private WebElement enrollUsersButton;
	
	@FindBy(css = "input[placeholder='Search']")
	private WebElement usersInputBox;
	
	@FindBy(css = "select[id='id_roletoassign']")
	private WebElement roleBox;
	
	@FindBy(xpath = "//button[text()='Enrol users']")
	private WebElement enrollUsersSaveButton;
	
	@FindBy(css = "div[data-region='header']")
	private WebElement header;
	
	@FindBy(css = "table[id='participants']")
	private WebElement participantsTable;
	
	@FindBy(xpath = "//a[contains(text(),'Log in as')]")
	private WebElement logInAsLink;
	
	@FindBy(css = "button[type='submit']")
	private WebElement continueButton;
	
	@FindBy(xpath = "//button[text()='Unenrol']")
	private WebElement unEnrollButton;
	
	public ParticipantsPage clickOnUnEnrolUsers(String UserName) throws Throwable {
		waitForElementToBeVisibile(participantsTable);
		waitForElementToBeClickable(participantsTable);
		BrowserFactory.getDriver().findElement(By.xpath("//a[contains(text(),'" + UserName + "')]/ancestor::tr//td//div//a[@title='Unenrol']")).click();
		
		
		waitForElementToBeVisibile(unEnrollButton);
		waitForElementToBeClickable(unEnrollButton);
		unEnrollButton.click();
		return this;
	}
		
	public ParticipantsPage clickOnEnrolUsers() throws Throwable {
		BrowserFactory.getDriver().navigate().refresh();
		Thread.sleep(3000);
		waitForElementToBeClickable(enrollUsersButton);
		waitForElementToBeVisibile(enrollUsersButton);
		enrollUsersButton.click();
		return this;
	}
	
	public ParticipantsPage selectUsers(String UserName) throws Throwable {
		waitForElementToBeVisibile(usersInputBox);
		waitForElementToBeClickable(usersInputBox);
		usersInputBox.sendKeys(UserName);
		
		waitForElementToBePresent(By.xpath("//li[contains(@id,'form_autocomplete_suggestions')]"));
		usersInputBox.sendKeys(Keys.ENTER);
		waitForElementToBeVisibile(header);
		header.click();
		Thread.sleep(3000);
		return this;
	}
	
	public ParticipantsPage selectRoles(String Role) throws Throwable {
		waitForElementToBeVisibile(roleBox);
		waitForElementToBeClickable(roleBox);
		Thread.sleep(2000);
		Select sel= new Select(roleBox);
		sel.selectByVisibleText(Role);
		Thread.sleep(1000);
		usersInputBox.sendKeys(Keys.ENTER);
		return this;
	}
	
	public ParticipantsPage clickOnEnrolUsersSaveButton() throws Throwable {
		Thread.sleep(2000);
		waitForElementToBeVisibile(enrollUsersSaveButton);
		waitForElementToBeClickable(enrollUsersSaveButton);
		enrollUsersSaveButton.click();
		return this;
	}
	
	public ParticipantsPage waitForParticipantsTable() throws Throwable {
		waitForElementToBeVisibile(participantsTable);
		waitForElementToBeClickable(participantsTable);
		return this;
	}
	
	public ParticipantsPage clickOnRespectiveUser(String Role, String Username) throws Throwable {
		BrowserFactory.getDriver().navigate().refresh();
		waitForElementToBeVisibile(participantsTable);
		waitForElementToBeClickable(participantsTable);
		WebElement ele=BrowserFactory.getDriver().findElement
		(By.xpath("//td//span//*[contains(text(),'" + Role + "') and @class='quickeditlink']/ancestor::tr//td//a//img[contains(@title, '" + Username + "')]"));
		JavascriptExecutor js = (JavascriptExecutor) BrowserFactory.getDriver(); 
		js.executeScript("arguments[0].click();", ele);
		return this;
	}
	
	public ParticipantsPage clickOnRespectiveApostopheUser(String Role, String count) throws Throwable {
		BrowserFactory.getDriver().navigate().refresh();
		waitForElementToBeVisibile(participantsTable);
		waitForElementToBeClickable(participantsTable);
		WebElement ele=BrowserFactory.getDriver().findElement
		(By.xpath("(//td//span//*[contains(text(),'"+ Role +"') and @class='quickeditlink']//ancestor::tr//td//a//img)["+ count +"]"));
		ele.click();
		return this;
	}
	
	public ParticipantsPage clickOnLoginAs() throws Throwable {
		waitForElementToBeVisibile(logInAsLink);
		waitForElementToBeClickable(logInAsLink);
		logInAsLink.click();
		return this;
	}
	
	public ParticipantsPage clickOnRespectiveCourse(String CourseName) throws Throwable {
		BrowserFactory.getDriver().navigate().refresh();
		waitForElementToBePresent(By.xpath("//p[@class='tree_item branch canexpand']//a"));
		waitForElementToBeClickable(By.xpath("//p[@class='tree_item branch canexpand']//a"));
		BrowserFactory.getDriver().findElement(By.xpath("//p[@class='tree_item branch canexpand']//a")).click();	
		return this;
	}

	public ParticipantsPage clickOnRespectiveCourseLeftNav(String CourseName) throws Throwable {
		BrowserFactory.getDriver().navigate().refresh();
		waitForElementToBePresent(By.xpath("//span[text()='" + CourseName + "']"));
		waitForElementToBeClickable(By.xpath("//span[text()='" + CourseName + "']"));
		WebElement ele= BrowserFactory.getDriver().findElement(By.xpath("//span[text()='" + CourseName + "']"));	
		JavascriptExecutor js = (JavascriptExecutor)BrowserFactory.getDriver();
		 js.executeScript("arguments[0].click();", ele);
		return this;
	}
	
	public ParticipantsPage getStudentName() throws Throwable {
		waitForElementToBeVisibile(participantsTable);
		waitForElementToBeClickable(participantsTable);
		Name=BrowserFactory.getDriver().findElement(By.xpath("//a[contains(text(),'Student')]/ancestor::tr//td[2]//a")).getText();
		return this;
	}
	
	public ParticipantsPage clickContinue() throws Throwable {
		waitForElementToBeVisibile(continueButton);
		waitForElementToBeClickable(continueButton);
		continueButton.click();
		return this;
	}
	
	
}