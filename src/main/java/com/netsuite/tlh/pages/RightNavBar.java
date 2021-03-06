package com.netsuite.tlh.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.framework.base.BrowserFactory;
import com.framework.exceptions.DriverNotInitializedException;
import com.framework.utils.SystemConfigurations;
import com.netsuite.tlh.factory.NetsuiteTLHPageFactory;
import com.netsuite.tlh.factory.OperationFactory;


public class RightNavBar extends BasePage {

	public RightNavBar() throws DriverNotInitializedException {
		super();
	}
	
	public static String courseID;

	@FindBy(css = "a[title='Understanding Our Universe: An Introduction to Astronomy']")
	private WebElement fitnessPovCourse;
	
	@FindBy(xpath = "//h1[text()='Health, Wellness, and Fitness: A New Look']")
	private WebElement fitnessPovCoursePageHeading;
	
	@FindBy(css = "i[class='icon fa fa-file-zip-o fa-fw navicon']")
	private WebElement backUpLink;
	
	@FindBy(xpath = "//h1[contains(text(),'Backup course:')]")
	private WebElement backUpCoursePageHeading;
	
	@FindBy(xpath = "(//span[text()='Participants'])[2]")
	private WebElement participantsLink;
	
	@FindBy(xpath = "(//span[text()='Participants'])")
	private WebElement participantsLink1;
	
	@FindBy(xpath = "//span[text()='Participants' and @class='media-body font-weight-bold']")
	private WebElement participantsLinkOnly;
	
	@FindBy(xpath = "//p//a[text()='Courses']")
	private WebElement coursesLink;
	
	@FindBy(xpath = "//a[text()='All courses']")
	private WebElement AllcoursesLink;
	
	@FindBy(xpath = "//a[contains(text(),'Assignments')]")
	private WebElement assignmentsLink;
	
	@FindBy(xpath = "//*[text()='Facilitation Manager Dashboard']")
	private WebElement facilitationManagerDashboardLink;
	
	@FindBy(xpath = "//span[text()='Facilitation Manager Dashboard']")
	private WebElement FMDLinkLeftNav;
	
	@FindBy(xpath = "//*[text()='Facilitation Dashboard']")
	private WebElement facilitationDashboardLink;
	
	@FindBy(xpath = "//span[contains(text(),'Site administration')]")
	private WebElement siteAdministrationLink;
	
	@FindBy(xpath = "//p[@id='courses_tree_item']//span[contains(text(),'Courses')]")
	private WebElement siteAdministrationCourseLink;
	
	@FindBy(xpath = "//span[contains(text(),'Restore course')]")
	private WebElement siteAdministrationRestoreCourseLink;
	
	@FindBy(xpath = "//p//a[contains(text(),'Course completion')]//i")
	private WebElement courseCompletionLink;
	
	@FindBy(xpath = "//a[contains(text(),'Quizzes')]")
	private WebElement quizzesLink;
	
	@FindBy(xpath = "//span[contains(text(),'Home')]")
	private WebElement HomeLink;
	
	@FindBy(css = "button[type='Submit']")
	private WebElement sitePolicuyYesButton;
	
	@FindBy(xpath = "//a[text()='Facilitation Manager Report']")
	private WebElement facilitationManagerReportLink;
	
	@FindBy(css = "span[class='sr-only']")
	private WebElement HamburgerItem;
	
	@FindBy(id = "coursesearchbox")
	private WebElement searchCoursesInput;
	
	@FindBy(xpath = "//button[text()='Go']")
	private WebElement goButton;
	
	@FindBy(xpath = "//a[text()='Facilitation Sign-off Report']")
	private WebElement facilitationSgnOffReportLink;
	
	@FindBy(xpath = "//a[text()='General']")
	private WebElement generalLink;
	
	@FindBy(xpath = "//a[text()='Manage Configuration Values']")
	private WebElement manageConfigurationValuePage;
	
	@FindBy(xpath = "//span[text()='Dashboard']/following::span[text()='Facilitation Manager Dashboard']")
	private WebElement FMDLinkLeftNav515;
	
	@FindBy(xpath = "//span[text()='Dashboard' and @class='media-body ']")
	private WebElement dashboardLink;
	
	public RightNavBar clickdashboardLink() throws Throwable {
		waitForElementToBeVisibile(dashboardLink);
		dashboardLink.click();
		return this;
		}
	
	public RightNavBar clickOnManageConfigurationValuePage() throws Throwable {
		waitForElementToBeVisibile(manageConfigurationValuePage);
		manageConfigurationValuePage.click();
		return this;
		}
	
	public RightNavBar clickOnFacilitationSignOffReportLink() throws Throwable {
		waitForElementToBeVisibile(facilitationSgnOffReportLink);
		waitForElementToBeClickable(facilitationSgnOffReportLink);
		facilitationSgnOffReportLink.click();
		return this;
	}
	
	public RightNavBar searchAndGoToCourse(String courseName) throws Throwable {
		
		waitForElementToBeVisibile(searchCoursesInput);
		waitForElementToBeClickable(searchCoursesInput);
		Thread.sleep(3000);
		searchCoursesInput.sendKeys(courseName);
		waitForElementToBeVisibile(goButton);
		waitForElementToBeClickable(goButton);
		goButton.click();
		
		waitForElementToBePresent(By.xpath("//a//*[contains(text(),'Automation')]"));
		waitForElementToBeClickable(By.xpath("//a//*[contains(text(),'Automation')]"));
		BrowserFactory.getDriver().findElement(By.xpath("//a//*[contains(text(),'Automation')]")).click();
		waitForElementToBeVisibile(generalLink);
		Thread.sleep(2000);
		String url=BrowserFactory.getDriver().getCurrentUrl();
		String[] split = url.split("id=");
		courseID = split[1];
		
		return this;
	}
	

	public RightNavBar clickOnHamburgerItem() throws Throwable {
		
		waitForElementToBeVisibile(HamburgerItem);
		waitForElementToBeClickable(HamburgerItem);
		HamburgerItem.click();
		return this;
	}
	public RightNavBar clickOnFacilitationManagerReportLink() throws Throwable {
		waitForElementToBeVisibile(facilitationManagerReportLink);
		facilitationManagerReportLink.click();
		return this;
	}
	
	
	public RightNavBar acceptSitePolicyAgreement() throws Throwable {
		wait.until(expectation);
		Thread.sleep(3000);
		if(BrowserFactory.getDriver().getTitle().equalsIgnoreCase("Site policy agreement")) {

		waitForElementToBeVisibile(sitePolicuyYesButton);
		waitForElementToBeClickable(sitePolicuyYesButton);
		sitePolicuyYesButton.click();
		Thread.sleep(3000);
		}
		return this;
	}
	
	public RightNavBar clickOnHomeLink() throws Throwable {
		Thread.sleep(2000);
		waitForElementToBeVisibile(HomeLink);
		waitForElementToBeClickable(HomeLink);
		HomeLink.click();
		return this;
	}
	
	public RightNavBar clickOnQuizzesLink() throws Throwable {	
		waitForElementToBeVisibile(quizzesLink);
		waitForElementToBeClickable(quizzesLink);
		quizzesLink.click();
		return this;
	}
	
	
	public RightNavBar clickcourseCompletionLink() throws Throwable {
		BrowserFactory.getDriver().navigate().refresh();
		Thread.sleep(3000);
		waitForElementToBeVisibile(courseCompletionLink);
		waitForElementToBeClickable(courseCompletionLink);
		courseCompletionLink.sendKeys(Keys.ENTER);
		return this;
	}

	public RightNavBar clickOnFitnessPovCourse() throws Throwable {
		waitForElementToBeVisibile(fitnessPovCourse);
		fitnessPovCourse.click();
		return this;
	}
	public RightNavBar verifyUserIsOnFitnessPovCoursePage() throws Throwable {
		waitForElementToBeVisibile(fitnessPovCourse);
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(isElementDisplayed(fitnessPovCoursePageHeading),
				"fitnessPovCoursePageHeading is NOT displayed");
		softAssert.assertAll();
		return this;
	}
	
	public RightNavBar clickOnBackupLink() throws Throwable {
		waitForElementToBeVisibile(backUpLink);
		backUpLink.click();
		return this;
	}

	public RightNavBar verifyUserIsOnBackupCoursePage() throws Throwable {
		waitForElementToBeVisibile(backUpCoursePageHeading);
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(isElementDisplayed(backUpCoursePageHeading),
				"backUpCoursePageHeading is NOT displayed");
		softAssert.assertAll();
		return this;
	}
	
	public RightNavBar clickOnParticipants() throws Throwable {
		Thread.sleep(2000);
		waitForElementToBeVisibile(participantsLink);
		waitForElementToBeClickable(participantsLink);
		JavascriptExecutor js = (JavascriptExecutor)BrowserFactory.getDriver();
		 js.executeScript("arguments[0].click();", participantsLink);
		return this;
	}
	
	public RightNavBar clickOnParticipants1() throws Throwable {
		Thread.sleep(2000);
		waitForElementToBeVisibile(participantsLink1);
		waitForElementToBeClickable(participantsLink1);
		JavascriptExecutor js = (JavascriptExecutor)BrowserFactory.getDriver();
		 js.executeScript("arguments[0].click();", participantsLink1);
		return this;
	}
	
	
	
	public RightNavBar clickOnParticipantsOnly() throws Throwable {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
            }};
            WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), 30);
    		wait.until(expectation);
		waitForElementToBeVisibile(participantsLinkOnly);
		waitForElementToBeClickable(participantsLinkOnly);
		JavascriptExecutor js = (JavascriptExecutor)BrowserFactory.getDriver();
		 js.executeScript("arguments[0].click();", participantsLinkOnly);
		return this;
	}
	
		public RightNavBar clickOnAllCourses() throws Throwable {
		BrowserFactory.getDriver().navigate().refresh();
		Thread.sleep(2000);
		waitForElementToBeVisibile(AllcoursesLink);
		waitForElementToBeClickable(AllcoursesLink);
		Actions act= new Actions(BrowserFactory.getDriver());
		act.moveToElement(AllcoursesLink).click().build().perform();
		return this;
		}
	
	public RightNavBar clickOnCourses() throws Throwable {
		BrowserFactory.getDriver().navigate().refresh();
		Thread.sleep(6000);
		waitForElementToBeVisibile(coursesLink);
		waitForElementToBeClickable(coursesLink);
		Actions act= new Actions(BrowserFactory.getDriver());
		act.moveToElement(coursesLink).click().build().perform();
		//coursesLink.click();
		return this;
	}
	
	public RightNavBar clickOnCourse(String course) throws Throwable {
		WebElement courseLink= BrowserFactory.getDriver().findElement(By.xpath("//p//a[text()='" + course + "']"));
		waitForElementToBeVisibile(courseLink);
		waitForElementToBeClickable(courseLink);
		courseLink.click();
		return this;
	}
	
	public RightNavBar clickOnApostopheCourse() throws Throwable {
		BrowserFactory.getDriver().navigate().refresh();
		waitForElementToBePresent(By.xpath("//span[contains(text(),'moodle')]"));
		waitForElementToBeClickable(By.xpath("//span[contains(text(),'moodle')]"));
		BrowserFactory.getDriver().findElement(By.xpath("//span[contains(text(),'moodle')]")).click();	
		return this;
	}

	public RightNavBar clickOnAssignments() throws Throwable {
		
		waitForElementToBeVisibile(assignmentsLink);
		waitForElementToBeClickable(assignmentsLink);
		assignmentsLink.sendKeys(Keys.ENTER);
		return this;
	}
	
	public RightNavBar clickOnFacilitationManagerDashboardLink() throws Throwable {
		Thread.sleep(3000);
		waitForElementToBeVisibile(facilitationManagerDashboardLink);
		waitForElementToBeClickable(facilitationManagerDashboardLink);
		facilitationManagerDashboardLink.click();
		return this;
	}
	
	public RightNavBar clickOnFacilitationDashboardLink() throws Throwable {
		wait.until(expectation);
		Thread.sleep(4000);
		waitForElementToBeVisibile(facilitationDashboardLink);
		waitForElementToBeClickable(facilitationDashboardLink);
		JavascriptExecutor js = (JavascriptExecutor)BrowserFactory.getDriver();
		js.executeScript("arguments[0].click();", facilitationDashboardLink);
		return this;
	}
	
	public RightNavBar verifyFacilitationManagerDashboardLink() throws Throwable {
		
		waitForElementToBeVisibile(FMDLinkLeftNav);
		waitForElementToBeClickable(FMDLinkLeftNav);
		//given functionality will check tha fm dashboard comes after dashboard in left nav
		waitForElementToBeVisibile(FMDLinkLeftNav515);
		waitForElementToBeClickable(FMDLinkLeftNav515);
		
		return this;
	}

	public RightNavBar clickOnSiteAdministrationLink() throws Throwable {
		waitForElementToBeVisibile(siteAdministrationLink);
		siteAdministrationLink.click();
		return this;
	}
	
	public RightNavBar clickOnSiteAdministrationCourseLink() throws Throwable {
		waitForElementToBeVisibile(siteAdministrationCourseLink);
		siteAdministrationCourseLink.click();
		return this;
		}
	
	public RightNavBar clickOnSiteAdministrationRestoreCourseLink() throws Throwable {
		waitForElementToBeVisibile(siteAdministrationRestoreCourseLink);
		siteAdministrationRestoreCourseLink.click();
		return this;
		}
	
}
