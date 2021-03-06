package com.netsuite.tlh.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.framework.base.BrowserFactory;
import com.framework.exceptions.DriverNotInitializedException;


public class AssignmentsPage extends MenuBarPage {

	public AssignmentsPage() throws DriverNotInitializedException {
		super();
	}
	
	@FindBy(css = "table[class='generaltable']")
	private WebElement table;
	
	@FindBy(xpath = "//h1[contains(text(),'AutomationMoodleCourse')]")
	private WebElement automationMoodleCourseHeading;
	
	@FindBy(css = "button[type='submit']")
	private WebElement addSubmissionButton;
	
	@FindBy(css = "div[class='dndupload-message']>div[class='dndupload-arrow']")
	private WebElement dragAndDropButton;
	
	@FindBy(css = "input[name='repo_upload_file']")
	private WebElement fileUploadInput;
	
	@FindBy(css = "button[class='fp-upload-btn btn-primary btn']")
	private WebElement uploadThisFileButton;
	
	@FindBy(css = "input[id='id_submitbutton']")
	private WebElement saveChangesButton;
	
	@FindBy(xpath = "//td[text()='Submitted for grading']")
	private WebElement submittedForGradingText;
	
	@FindBy(xpath = "//span[contains(text(),'Upload a file')]")
	private WebElement uploadFileLink;
	
	@FindBy(xpath = "//a[text()='Module 2 Project Checkpoint']")
	private WebElement Module2Link;
	
	@FindBy(xpath = "//a[text()='Module 3 Project Checkpoint']")
	private WebElement Module3Link;
	
	@FindBy(xpath = "//a[text()='Final Project Submission']")
	private WebElement FinalProjectLink;
	
	@FindBy(xpath = "//th[text()='Grade']")
	private WebElement GradeHeading;
	
	@FindBy(xpath = "//h3[contains(text(),'Previous Grades')]")
	private WebElement previoudGrades;
	
	@FindBy(css = "table[class='criteria']>tbody>tr")
	private WebElement previoudGradesTable;
	
	@FindBy(xpath = "//td[text()='Required: Participation Acknowledgement']")
	private WebElement participationAcknowledgementText;
	
	@FindBy(xpath = "//td[text()='Module 2 Project Checkpoint']")
	private WebElement module2Checkpoint;
	
	@FindBy(xpath = "//td[text()='Module 3 Project Checkpoint']")
	private WebElement module3Checkpoint;
	
	@FindBy(xpath = "//td[text()='Final Project Submission']")
	private WebElement finalProjectSubmision;
	
	@FindBy(css = "div[class='fp-content']")
	private WebElement pageLoadingIcon;
	
	@FindBy(css = "i[title='View full']")
	private WebElement expandFeedback;
	
	@FindBy(xpath = "//button[text()='Edit submission']")
	private WebElement EdiSubmissionButton;
	
	@FindBy(css = "a[title='Add...']")
	private WebElement AddButton;
	
	@FindBy(xpath = "//span[text()='Upload a file']")
	private WebElement uploadAFileLink;
	
	@FindBy(css = "input[name='repo_upload_file']")
	private WebElement chooseFileOption;
	
	@FindBy(css = "div[class='fp-content']")
	private WebElement fileSubmissionBox;
	
	public AssignmentsPage uploadAFile() throws Throwable {
		waitForElementToBeVisibile(uploadAFileLink);
		waitForElementToBeClickable(uploadAFileLink);
		uploadAFileLink.click();
		waitForElementToBeVisibile(chooseFileOption);
		waitForElementToBeClickable(chooseFileOption);
		Thread.sleep(1000);
		chooseFileOption.sendKeys(System.getProperty("user.dir")+"/src/test/resources/testdata/TLH2.txt");
		waitForElementToBeVisibile(uploadThisFileButton);
		waitForElementToBeClickable(uploadThisFileButton);
		Thread.sleep(4000);
		uploadThisFileButton.click();
		clickSaveChangesButton();
		return this;
	}
	
	public AssignmentsPage clickSaveChangesButton() throws Throwable {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
            	}};
            	WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), 30);
            	wait.until(expectation);
            	
            	waitForElementToBeVisibile(fileSubmissionBox);  	
            	waitForElementToBeClickable(fileSubmissionBox);
            	
		waitForElementToBeVisibile(saveChangesButton);
		Thread.sleep(2000);
		JavascriptExecutor executor = (JavascriptExecutor)BrowserFactory.getDriver();
		executor.executeScript("arguments[0].click();", saveChangesButton);
		return this;
	}
	
	public AssignmentsPage clickAddButton() throws Throwable {
		wait.until(expectation);
		Thread.sleep(4000);
		waitForElementToBeVisibile(AddButton);
		waitForElementToBeClickable(AddButton);
		AddButton.click();
		return this;
	}
	
	public AssignmentsPage clickEdiSubmissionButton() throws Throwable {
		wait.until(expectation);
		Thread.sleep(2000);
		waitForElementToBeVisibile(EdiSubmissionButton);
		EdiSubmissionButton.click();
	   return this;
	}
	
	public AssignmentsPage verifyAssigment3Feedback(String feedBack) throws Throwable {
		waitForElementToBeVisibile(table);
		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
		Module3Link.sendKeys(selectLinkOpeninNewTab);
		verifyFeedback(feedBack);
		
	   return this;
	}
	
	public AssignmentsPage verifyFeedback(String feedBack) throws Throwable {
		Thread.sleep(3000);
		String currentWindow = BrowserFactory.getDriver().getWindowHandle();
		for(String winHandle : BrowserFactory.getDriver().getWindowHandles()){
			   if (BrowserFactory.getDriver().switchTo().window(winHandle).getTitle().equalsIgnoreCase("Assignment")) {
				   		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			            public Boolean apply(WebDriver driver) {
			                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
			            }};
			            WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), 30);
			            wait.until(expectation);
			     
			    waitForElementToBeVisibile(expandFeedback);
			     waitForElementToBeClickable(expandFeedback);
			     expandFeedback.click();
			     waitForElementToBePresent(By.xpath("//p[text()='" + feedBack + "']"));
			     
			     
			     
			     BrowserFactory.getDriver().close();
			     break;
			   } 
			   else {
				   BrowserFactory.getDriver().switchTo().window(currentWindow);
			   } 
	        
			   BrowserFactory.getDriver().switchTo().window(currentWindow);
	}
		BrowserFactory.getDriver().switchTo().window(currentWindow);
		return this;
	}
	
	public AssignmentsPage verifyStudentRubricView() throws Throwable {
		waitForElementToBeVisibile(Module2Link);
		Module2Link.click();
		waitForElementToBeVisibile(previoudGrades);
		waitForElementToBeVisibile(previoudGradesTable);
		Assert.assertEquals(participationAcknowledgementText.isDisplayed(), true);
		Assert.assertEquals(module2Checkpoint.isDisplayed(), true);
		Assert.assertEquals(module3Checkpoint.isDisplayed(), true);
		Assert.assertEquals(finalProjectSubmision.isDisplayed(), true);
		
	   return this;
	}
	
	public AssignmentsPage openAssigmentsLinkModule2() throws Throwable {
		waitForElementToBeVisibile(table);
		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
		Module2Link.sendKeys(selectLinkOpeninNewTab);
		completeAssignment(); 
	   return this;
	}
	
	public AssignmentsPage openAssigmentsLinkModule2_A() throws Throwable {
		wait.until(expectation);
		Thread.sleep(2000);
		waitForElementToBeVisibile(Module2Link);
		waitForElementToBeClickable(Module2Link);
		Module2Link.click();
		//String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
		//Module2Link.sendKeys(selectLinkOpeninNewTab); 
	   return this;
	}
	
	public AssignmentsPage openAssigmentsLinkModule3() throws Throwable {
		waitForElementToBeVisibile(table);
		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
		Module3Link.sendKeys(selectLinkOpeninNewTab);
		completeAssignment(); 
	   return this;
	}
	
	
	public AssignmentsPage openAssigmentsLink() throws Throwable {
		waitForElementToBeVisibile(table);
	   List<WebElement> elements=BrowserFactory.getDriver().findElements(By.xpath("//table[@class='generaltable']//tbody//tr//td[2]//a"));
	 for(int i=0;i<elements.size();i++){
		 String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
		  elements.get(i).sendKeys(selectLinkOpeninNewTab); 
		  completeAssignment(); 
	 }       
	   return this;
	}
	
	public AssignmentsPage completeAssignment() throws Throwable {
		Thread.sleep(3000);
		String currentWindow = BrowserFactory.getDriver().getWindowHandle();
		for(String winHandle : BrowserFactory.getDriver().getWindowHandles()){
			   if (BrowserFactory.getDriver().switchTo().window(winHandle).getTitle().equalsIgnoreCase("Assignment")) {
				   ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			            public Boolean apply(WebDriver driver) {
			                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
			            }};
			            WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), 30);
			            wait.until(expectation);
			     clickAddSubmissionButton();
			     clickDragAndDropButton();
			     uploadFile();
			     wait.until(expectation);
			     Thread.sleep(2000);
			     clickuploadThisFileButton();
			     wait.until(expectation);
			     clicksaveChangesButton();
			     wait.until(expectation);
			     verifySubmission();
			     wait.until(expectation);
			     BrowserFactory.getDriver().close();
			     break;
			   } 
			   else {
				   BrowserFactory.getDriver().switchTo().window(currentWindow);
			   } 
	        
			   BrowserFactory.getDriver().switchTo().window(currentWindow);
	}
		BrowserFactory.getDriver().switchTo().window(currentWindow);
		return this;
	}
	
	public AssignmentsPage clickAddSubmissionButton() throws Throwable {
		waitForElementToBeVisibile(addSubmissionButton);
		addSubmissionButton.click();
	   return this;
	}
	
	public AssignmentsPage clickDragAndDropButton() throws Throwable {
		waitForElementToBeVisibile(dragAndDropButton);
		dragAndDropButton.click();
	   return this;
	}
	
	public AssignmentsPage uploadFile() throws Throwable {
		Thread.sleep(2000);
		waitForElementToBeVisibile(uploadFileLink);
		waitForElementToBeClickable(uploadFileLink);
		uploadFileLink.click();
		waitForElementToBeClickable(fileUploadInput);
		Thread.sleep(4000);
		fileUploadInput.sendKeys(System.getProperty("user.dir")+"/src/test/resources/testdata/dummy.pdf");
		Thread.sleep(1000);
	   return this;
	}
	
	public AssignmentsPage clickuploadThisFileButton() throws Throwable {
		waitForElementToBeVisibile(uploadThisFileButton);
		uploadThisFileButton.click();
	   return this;
	}
	
	public AssignmentsPage clicksaveChangesButton() throws Throwable {
		//waitforloadingbuttontogo
		waitForElementToBeVisibile(pageLoadingIcon);
		waitForElementToBeClickable(pageLoadingIcon);
		Thread.sleep(2000);
		waitForElementToBeVisibile(saveChangesButton);
		saveChangesButton.click();
	   return this;
	}
	
	public AssignmentsPage verifySubmission() throws Throwable {
		Thread.sleep(4000);
		waitForElementToBeVisibile(submittedForGradingText);
		
	   return this;
	}
	
	public AssignmentsPage refreshPage() throws Throwable {
		BrowserFactory.getDriver().navigate().refresh();
		
	   return this;
	}
	
	
}
