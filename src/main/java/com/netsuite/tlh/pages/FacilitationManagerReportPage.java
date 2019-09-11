package com.netsuite.tlh.pages;


import org.testng.Assert;

import static org.testng.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;


import com.aventstack.extentreports.ExtentTest;
import com.framework.base.BrowserFactory;
import com.framework.exceptions.DriverNotInitializedException;
import com.framework.utils.FileUtils;
import com.moodle.tlh.tests.FullRegressionTest;


public class FacilitationManagerReportPage extends MenuBarPage {

	public FacilitationManagerReportPage() throws DriverNotInitializedException {
		super();
	}
	ExtentTest logger=FullRegressionTest.logger;
	
	@FindBy(css = "label[for='courseId']")
	private WebElement courseIdField;
	
	@FindBy(css = "label[for='facilitatorName']")
	private WebElement facilitatorField;
	
	@FindBy(css = "label[for='courseCode']")
	private WebElement courseCodeField;
	
	@FindBy(css = "label[for='courseName']")
	private WebElement courseTitle;
	
	@FindBy(xpath = "//label[text()='Client Institution']")
	private WebElement clientInstitution;
	
	@FindBy(css = "label[for='category']")
	private WebElement categoryName;
	
	
	@FindBy(xpath = "//a[text()='Course ID']")
	private WebElement courseIdTable;
	
	@FindBy(xpath = "//a[text()='Facilitators']")
	private WebElement facilitatorTable;
	
	@FindBy(xpath = "//a[text()='Course Title']")
	private WebElement courseTitleTable;
	
	@FindBy(xpath = "//a[text()='Client Institution']")
	private WebElement clientInstitutionTable;
	
	@FindBy(xpath = "//a[text()='Category Name']")
	private WebElement categoryNameTable;
	
	@FindBy(xpath = "//a[text()='Enrolled Users']")
	private WebElement enrolledUsers;
	
	
	@FindBy(name = "courseId")
	private WebElement courseIdInputBox;
	
	@FindBy(name = "facilitatorName")
	private WebElement FacilitatorInputBox;
	
	@FindBy(name = "courseCode")
	private WebElement courseCodeInputBox;
	
	@FindBy(name = "courseName")
	private WebElement courseTitleInputBox;
	
	@FindBy(name = "clientInstitute")
	private WebElement clientInstutionInputBox;
	
	@FindBy(name = "category")
	private WebElement categoryNameInputBox;
	
	@FindBy(id = "filterButton")
	private WebElement filterButton;
	
	@FindBy(css = "table[class='table']")
	private WebElement filterTable;
	
	@FindBy(id = "resetButton")
	private WebElement resetButton;
	
	@FindBy(name = "facilitatorName")
	private WebElement facilitatorNameInputBox;
	
	@FindBy(name = "courseName")
	private WebElement facilitatorTitleInputBox;
	
	@FindBy(css = "table[class=table]>tbody>tr>td")
	private WebElement tableDataCsv;
	
	public FacilitationManagerReportPage verifyingCSVData() throws Throwable {
		waitForElementToBeVisibile(resetButton);
		waitForElementToBeEnabled(resetButton);
		List<WebElement> ele=BrowserFactory.getDriver().findElements(By.cssSelector("table[class=table]>tbody>tr>td"));
		String []webText =new String[ele.size()];
		int i=0;
		//Storing List elements text into String array
		for(WebElement a: ele)
		{
			webText[i]=a.getText().replaceAll("\\s", "");
		   i++;}
		String []fileText = FileUtils.ReadCsvFile();
		//traversing webtext
		System.out.println(Arrays.toString(webText));
		//traversing fileText
		System.out.println(Arrays.toString(fileText));
		
		if (Arrays.equals(webText, fileText)) {
			System.out.println("Excel Sheet Data has been verified");
		}
		
		return this;
	}
	
	
	public FacilitationManagerReportPage entercategoryNameFilter(String categoryName) throws Throwable {
		waitForElementToBeVisibile(categoryNameInputBox);
		waitForElementToBeEnabled(categoryNameInputBox);
		categoryNameInputBox.sendKeys(categoryName);
		return this;
	}
	
	public FacilitationManagerReportPage verifycategoryNameFilter(String categoryName) throws Throwable {
		waitForElementToBeVisibile(filterTable);
		WebElement ele= BrowserFactory.getDriver().findElement(By.xpath("//table[@class='table']//tbody//tr//td[text()='" + categoryName + "']"));
		Assert.assertTrue(ele.isDisplayed());
		logger.pass("categoryNameFilter has been verified");
		return this;
	}
	
	public FacilitationManagerReportPage enterfacilitatorTitleFilter(String courseTitle) throws Throwable {
		waitForElementToBeVisibile(facilitatorTitleInputBox);
		waitForElementToBeEnabled(facilitatorTitleInputBox);
		facilitatorTitleInputBox.sendKeys(courseTitle);
		return this;
	}
	
	public FacilitationManagerReportPage verifyfacilitatorTitleFilter(String courseTitle) throws Throwable {
		waitForElementToBeVisibile(filterTable);
		WebElement ele= BrowserFactory.getDriver().findElement(By.xpath("//table[@class='table']//tbody//tr//td[text()='" + courseTitle + "']"));
		Assert.assertTrue(ele.isDisplayed());
		logger.pass("facilitatorTitleFilter has been verified");
		return this;
	}
	
	public FacilitationManagerReportPage enterCourseIdFilter(String courseId) throws Throwable {
		waitForElementToBeVisibile(courseIdInputBox);
		waitForElementToBeEnabled(courseIdInputBox);
		courseIdInputBox.sendKeys(courseId);
		return this;
	}
	
	public FacilitationManagerReportPage verifyCourseIdFilter(String courseId) throws Throwable {
		waitForElementToBeVisibile(filterTable);
		WebElement ele= BrowserFactory.getDriver().findElement(By.xpath("//table[@class='table']//tbody//tr//td[text()='" + courseId + "']"));
		Assert.assertTrue(ele.isDisplayed());
		logger.pass("CourseIdFilter has been verified");
		return this;
	}
	
	public FacilitationManagerReportPage enterFacilitatorNameFilter(String courseId) throws Throwable {
		waitForElementToBeVisibile(facilitatorNameInputBox);
		waitForElementToBeEnabled(facilitatorNameInputBox);
		facilitatorNameInputBox.sendKeys(courseId);
		return this;
	}
	
	public FacilitationManagerReportPage verifyFacilitatorNameFilter(String Facilitator) throws Throwable {
		waitForElementToBeVisibile(filterTable);
		WebElement ele= BrowserFactory.getDriver().findElement(By.xpath("//table[@class='table']//tbody//tr//td[text()='" + Facilitator + "']"));
		Assert.assertTrue(ele.isDisplayed());
		logger.pass("FacilitatorNameFilter has been verified");
		return this;
	}
	
	public FacilitationManagerReportPage clickFilterButton() throws Throwable {
		waitForElementToBeVisibile(filterButton);
		waitForElementToBeEnabled(filterButton);
		filterButton.click();
		return this;
	}
	
	public FacilitationManagerReportPage clickResetButton() throws Throwable {
		waitForElementToBeVisibile(resetButton);
		waitForElementToBeEnabled(resetButton);
		resetButton.click();
		return this;
	}
	
	public FacilitationManagerReportPage verifyFiltersName() throws Throwable {
		waitForElementToBeVisibile(courseIdField);
		Assert.assertTrue(courseIdField.isDisplayed());
		logger.pass("courseIdField has been verified");
		waitForElementToBeVisibile(facilitatorField);
		Assert.assertTrue(facilitatorField.isDisplayed());
		logger.pass("facilitatorField has been verified");
		waitForElementToBeVisibile(courseCodeField);
		Assert.assertTrue(courseCodeField.isDisplayed());
		logger.pass("courseCodeField has been verified");
		waitForElementToBeVisibile(courseTitle);
		Assert.assertTrue(courseTitle.isDisplayed());
		logger.pass("courseTitle has been verified");
		waitForElementToBeVisibile(clientInstitution);
		Assert.assertTrue(clientInstitution.isDisplayed());
		logger.pass("clientInstitution has been verified");
		waitForElementToBeVisibile(categoryName);
		Assert.assertTrue(categoryName.isDisplayed());
		logger.pass("categoryName has been verified");
		
		return this;
	}
	
	public FacilitationManagerReportPage verifyTableHeadings() throws Throwable {
		waitForElementToBeVisibile(courseIdTable);
		Assert.assertTrue(courseIdTable.isDisplayed());
		logger.pass("courseIdTable has been verified");
		waitForElementToBeVisibile(facilitatorTable);
		Assert.assertTrue(facilitatorTable.isDisplayed());
		logger.pass("facilitatorTable has been verified");
		waitForElementToBeVisibile(courseTitleTable);
		Assert.assertTrue(courseTitleTable.isDisplayed());
		logger.pass("courseTitleTable has been verified");
		waitForElementToBeVisibile(clientInstitutionTable);
		Assert.assertTrue(clientInstitutionTable.isDisplayed());
		logger.pass("clientInstitutionTable has been verified");
		waitForElementToBeVisibile(categoryNameTable);
		Assert.assertTrue(categoryNameTable.isDisplayed());
		logger.pass("categoryNameTable has been verified");
		waitForElementToBeVisibile(enrolledUsers);
		Assert.assertTrue(enrolledUsers.isDisplayed());
		logger.pass("enrolledUsers has been verified");
		return this;
	}
	
	
}
