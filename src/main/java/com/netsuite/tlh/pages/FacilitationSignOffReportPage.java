package com.netsuite.tlh.pages;

import static org.testng.Assert.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.framework.base.BrowserFactory;
import com.framework.exceptions.DriverNotInitializedException;
import com.netsuite.tlh.factory.NetsuiteTLHPageFactory;

public class FacilitationSignOffReportPage extends MenuBarPage {

	public FacilitationSignOffReportPage() throws DriverNotInitializedException {
		super();
	}
	
	@FindBy(xpath = "//h1[text()='Facilitation Sign-off Report']")
	private WebElement pageHeading;
	
	@FindBy(css = "label[for='courseId']")
	private WebElement courseID;

	@FindBy(css = "label[for='courseCode']")
	private WebElement facilitatorID;
	
	@FindBy(css = "label[for='facilitatorName']")
	private WebElement studentID;
	
	@FindBy(css = "label[for='courseName']")
	private WebElement signOffDate;
	
	@FindBy(xpath = "//a[text()='Course ID']")
	private WebElement courseIDTable;
	
	@FindBy(xpath = "//a[text()='Student ID']")
	private WebElement studentIDTable;
	
	@FindBy(xpath = "//a[text()='Grade']")
	private WebElement gradeTable;
	
	@FindBy(xpath = "//a[text()='Facilitator ID']")
	private WebElement facilitatorIDTable;
	
	@FindBy(xpath = "//a[text()='Sign-off date']")
	private WebElement signOffDateTable;
	
	@FindBy(xpath = "//a[text()='Created']")
	private WebElement createdDateTable;
	
	@FindBy(name = "course_id")
	private WebElement courseIdInput;
	
	@FindBy(id = "filterButton")
	private WebElement filterButton;
	
	@FindBy(xpath = "//table[@class='table']//tbody/tr//td[last()]")
	private WebElement createdDate;
	
	@FindBy(xpath = "//table[@class='table']//tbody/tr//td[last()-1]")
	private WebElement signOffDateDetails;
		
	public FacilitationSignOffReportPage verifyPageLabels() throws Throwable {
		waitForElementToBeVisibile(pageHeading);
		waitForElementToBeClickable(pageHeading);
		
		waitForElementToBeVisibile(courseID);
		waitForElementToBeClickable(courseID);
		
		waitForElementToBeVisibile(facilitatorID);
		waitForElementToBeClickable(facilitatorID);
		
		waitForElementToBeVisibile(studentID);
		waitForElementToBeClickable(studentID);
		
		waitForElementToBeVisibile(signOffDate);
		waitForElementToBeClickable(signOffDate);
		
		waitForElementToBeVisibile(courseIDTable);
		waitForElementToBeClickable(courseIDTable);
		
		waitForElementToBeVisibile(studentIDTable);
		waitForElementToBeClickable(studentIDTable);
		
		waitForElementToBeVisibile(gradeTable);
		waitForElementToBeClickable(gradeTable);
		
		waitForElementToBeVisibile(facilitatorIDTable);
		waitForElementToBeClickable(facilitatorIDTable);
		
		waitForElementToBeVisibile(signOffDateTable);
		waitForElementToBeClickable(signOffDateTable);
		
		waitForElementToBeVisibile(createdDateTable);
		waitForElementToBeClickable(createdDateTable);
		
		return this;
	}
	
	public FacilitationSignOffReportPage verifyFilters() throws Throwable {
		verifycourseIDFilters();
		
		return this;
	}
	
	
	public FacilitationSignOffReportPage verifycourseIDFilters() throws Throwable {
		waitForElementToBeVisibile(courseIdInput);
		waitForElementToBeClickable(courseIdInput);
		courseIdInput.sendKeys(RightNavBar.courseID);
		clickFilterButton();
		verifyCreatedDate();
		verifySignOffDate();
		return this;
	}
	
	public FacilitationSignOffReportPage clickFilterButton() throws Throwable {
		waitForElementToBeVisibile(filterButton);
		waitForElementToBeClickable(filterButton);
		filterButton.click();
		
		return this;
	}
	
	public FacilitationSignOffReportPage verifyCreatedDate() throws Throwable {
		waitForElementToBeVisibile(createdDate);
		waitForElementToBeClickable(createdDate);
		String createdDateTextt= createdDate.getText();
		String createdDateText=createdDateTextt.substring(0,10);
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		String createdDateTextExpected= dateFormat.format(date);
		
		Assert.assertEquals(createdDateText, createdDateTextExpected);
		return this;
	}
	
	public FacilitationSignOffReportPage verifySignOffDate() throws Throwable {
		waitForElementToBeVisibile(signOffDateDetails);
		waitForElementToBeClickable(signOffDateDetails);
		String signOffDateDetailst= signOffDateDetails.getText();
		String signOffDateDetails=signOffDateDetailst.substring(0,10);
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		String createdDateTextExpected= dateFormat.format(date);
		
		Assert.assertEquals(signOffDateDetails, createdDateTextExpected);
		return this;
	}
}