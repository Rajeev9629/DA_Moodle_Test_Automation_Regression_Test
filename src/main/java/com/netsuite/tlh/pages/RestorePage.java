package com.netsuite.tlh.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.framework.base.BrowserFactory;
import com.framework.exceptions.DriverNotInitializedException;
import com.framework.utils.SystemConfigurations;
import com.netsuite.tlh.factory.NetsuiteTLHPageFactory;
import com.netsuite.tlh.factory.OperationFactory;
import com.netsuite.tlh.operations.Navigator;
import com.netsuite.tlh.operations.RightNavOperations;


public class RestorePage extends BasePage {

	public RestorePage() throws DriverNotInitializedException {
		super();
	}

	@FindBy(xpath = "//p[@role=\"treeitem\"]//following::*[contains(text(),'Restore')]")
	private WebElement restoreLink;
	
	@FindBy(css = "button[type='submit']")
	private WebElement bottomcontinueButton;
	
	@FindBy(css = "input[value='Continue']")
	private WebElement continueButton;
	
	@FindBy(css = "input[name='targetid'][value='1']")
	private WebElement miscellaneousOption;
	
	@FindBy(css = "input[id='id_submitbutton']")
	private WebElement nextButton;
	
	@FindBy(css = "input[id='id_setting_course_course_fullname_value']")
	private WebElement courseNameInput;
	
	@FindBy(css = "input[id='id_setting_course_course_shortname_value']")
	private WebElement courseShortNameInput;
	
	@FindBy(css = "input[value='Perform restore']")
	private WebElement performRestoreButton;
	
	@FindBy(css = "input[name='backupfilechoose']")
	private WebElement chooseFileButton;
	
	@FindBy(css = "input[name='repo_upload_file']")
	private WebElement uploadFileOption;
	
	@FindBy(xpath = "//span[contains(text(),'Upload a file')]")
	private WebElement uploadFileLink;
	
	@FindBy(css = "button[class='fp-upload-btn btn-primary btn']")
	private WebElement uploadThisFileButton;
	
	@FindBy(css = "input[name='submitbutton']")
	private WebElement restoreButton;
	
	@FindBy(css = "input[id='id_setting_root_users']")
	private WebElement enrolledUserCheckBox;
	
	@FindBy(css = "div[class='fp-content-center']>i")
	private WebElement loadingSign;
	
	@FindBy(xpath = "//span[text()='Module 2 Project Checkpoint']")
	private WebElement module2Checkpoint;
	
	@FindBy(xpath = "//td//a[text()='Restore']")
	private WebElement backupPageRestore;
	
	public static String courseID;
	
	
	public RestorePage clickbackupPageRestore() throws Throwable {
		waitForElementToBeClickable(backupPageRestore);
		waitForElementToBeVisibile(backupPageRestore);
		Thread.sleep(2000);
		backupPageRestore.click();
		return this;
	}
	
	public RestorePage verifyCourseIsNotEmpty() throws Throwable {
		waitForElementToBeClickable(module2Checkpoint);
		waitForElementToBeVisibile(module2Checkpoint);
		Thread.sleep(3000);
		String url=BrowserFactory.getDriver().getCurrentUrl();
		String[] split = url.split("id=");
		courseID = split[1];
		if(module2Checkpoint.isDisplayed()==false) {
			OperationFactory.getOperation(RightNavOperations.class).clickHome().clickAllCoursesLink();
			Navigator.GetCoursePageOperations().deleteRespectiveApostophieCourse();
			BrowserFactory.getDriver().quit();
		}
		
		return this;
	}
	
	public RestorePage clickOnRestoreButton() throws Throwable {
		waitForElementToBeVisibile(loadingSign);
		Thread.sleep(2000);
        waitForElementToBeInVisibile(loadingSign);

		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
        public Boolean apply(WebDriver driver) {
         return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
            }};
            WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), 30);
    		wait.until(expectation);
    		Thread.sleep(3000);
		waitForElementToBeVisibile(restoreButton);
		waitForElementToBeClickable(restoreButton);
		
		restoreButton.click();
		return this;
	}
	
	public RestorePage clickOnchooseFileButton() throws Throwable {
		waitForElementToBeClickable(chooseFileButton);
		waitForElementToBeVisibile(chooseFileButton);
		Thread.sleep(3000);
		chooseFileButton.click();
		return this;
	}
	
	public RestorePage uploadFile() throws Throwable {
		waitForElementToBeClickable(uploadFileLink);
		waitForElementToBeVisibile(uploadFileLink);
		uploadFileLink.click();
		Thread.sleep(4000);
		waitForElementToBeClickable(uploadFileOption);
		waitForElementToBeVisibile(uploadFileOption);
		uploadFileOption.sendKeys(System.getProperty("user.dir")+"/src/test/resources/testdata/backup-moodle2-course-1401-thepsychofspor-ce-pov-20190107-1229.mbz");
		Thread.sleep(2000);
		uploadFileOption.sendKeys(System.getProperty("user.dir")+"/src/test/resources/testdata/backup-moodle2-course-1401-thepsychofspor-ce-pov-20190107-1229.mbz");
		
		return this;
	}
	
	
	
	public RestorePage clickOnUploadThisFileButton() throws Throwable {
		Thread.sleep(2000);
		waitForElementToBeClickable(uploadThisFileButton);
		waitForElementToBeVisibile(uploadThisFileButton);
		uploadThisFileButton.click();
		return this;
	}
	
	public RestorePage clickOnRestoreLink() throws Throwable {
		waitForElementToBeClickable(restoreLink);
		waitForElementToBeVisibile(restoreLink);
		Thread.sleep(2000);
		restoreLink.click();
		return this;
	}
	
	public RestorePage clickOnBottomContinueButton() throws Throwable {
		waitForElementToBeClickable(bottomcontinueButton);
		waitForElementToBeVisibile(bottomcontinueButton);
		bottomcontinueButton.click();
		return this;
	}
	
	public RestorePage clickOnMiscellaneousOption() throws Throwable {
		waitForElementToBeClickable(miscellaneousOption);
		waitForElementToBeVisibile(miscellaneousOption);
		miscellaneousOption.click();
		return this;
	}
	
	
	public RestorePage clickOnContinueButton() throws Throwable {
		waitForElementToBeClickable(continueButton);
		waitForElementToBeVisibile(continueButton);
		continueButton.click();
		return this;
	}
	
	public RestorePage clickOnNextButton() throws Throwable {
		Thread.sleep(3000);
		waitForElementToBeClickable(nextButton);
		waitForElementToBeVisibile(nextButton);
		nextButton.click();
		return this;
	}
	
	public RestorePage enterCourseName(String CourseName) throws Throwable {
		waitForElementToBeClickable(courseNameInput);
		waitForElementToBeVisibile(courseNameInput);
		courseNameInput.clear();
		courseNameInput.sendKeys(CourseName);
		return this;
	}

	public RestorePage enterCourseShortName(String CourseShortName) throws Throwable {
		waitForElementToBeClickable(courseShortNameInput);
		waitForElementToBeVisibile(courseShortNameInput);
		courseShortNameInput.clear();
		courseShortNameInput.sendKeys(CourseShortName);
		return this;
	}
	
	public RestorePage clickOnPerformRestore() throws Throwable {
		waitForElementToBeClickable(performRestoreButton);
		waitForElementToBeVisibile(performRestoreButton);
		performRestoreButton.click();
		return this;
	}
	
	public RestorePage removeEnrolledUser() throws Throwable {
		waitForElementToBeClickable(enrolledUserCheckBox);
		waitForElementToBeVisibile(enrolledUserCheckBox);
		enrolledUserCheckBox.click();
		return this;
	}
	
}
