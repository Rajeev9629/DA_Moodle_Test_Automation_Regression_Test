package com.moodle.tlh.tests;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;

import javax.imageio.ImageIO;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.framework.base.Browser;
import com.framework.base.BrowserFactory;
import com.framework.dataprovider.BaseDataProvider;
import com.framework.exceptions.DriverNotInitializedException;
import com.framework.exceptions.NoDataAvailableInFile;
import com.framework.utils.SystemConfigurations;
import com.netsuite.tlh.factory.OperationFactory;
import com.netsuite.tlh.operations.DatabaseOperations;
import com.netsuite.tlh.operations.HomeOperations;
import com.netsuite.tlh.operations.LoginOperations;
import com.netsuite.tlh.operations.MenuBarOperations;
import com.netsuite.tlh.operations.MethodNameReportingOprations;
import com.netsuite.tlh.operations.RightNavOperations;
import com.netsuite.tlh.pages.RightNavBar;

public class BaseTest {
	private static final String LOGINDETAILS_FILENAME = "src/test/resources/testdata/login-data.json";
	protected HomeOperations homeOperations;
	protected MenuBarOperations menuBarOperations;
	protected LoginOperations loginOperations;
	protected RightNavOperations rightNavOperations;
	protected DatabaseOperations databaseOperations;
	private LinkedHashMap<String, ?> loginDataMap;
	public static String userName;
	public static String passWord;
	public static ExtentReports extent;
	public static ExtentTest logger;
	

	@BeforeSuite
	public void init() throws DriverNotInitializedException, Throwable {
		loginDataMap = BaseDataProvider.getDataAsMap(LOGINDETAILS_FILENAME);
		userName = (String) loginDataMap.get("userName");
		passWord = (String) loginDataMap.get("passWord");
		ExtentHtmlReporter reporter=new ExtentHtmlReporter(System.getProperty("user.dir") + "/src/test/resources/Reports/Report.html");
		extent = new ExtentReports();
	    extent.attachReporter(reporter);	    
	    
	}

	@BeforeClass
	public void login() throws InstantiationException, IllegalAccessException, DriverNotInitializedException, Throwable {
		BrowserFactory.initializeBrowser(Enum.valueOf(Browser.class, SystemConfigurations.getBrowserType()),
				SystemConfigurations.getApplicationUrl());
		menuBarOperations = OperationFactory.getOperation(MenuBarOperations.class);
		homeOperations = OperationFactory.getOperation(HomeOperations.class);
		loginOperations = OperationFactory.getOperation(LoginOperations.class);
		rightNavOperations = OperationFactory.getOperation(RightNavOperations.class);
		databaseOperations = OperationFactory.getOperation(DatabaseOperations.class);
		loginOperations.doLogin(userName, passWord).verifyUserLoggedInSuccessfully();
		
	}
	
	@BeforeMethod
	public void doMoodleLogin() {}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException, InstantiationException, IllegalAccessException, AWTException
	{
		logger.pass(result.getMethod().getMethodName()+" Completed");
		
	
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String MethodName=OperationFactory.getOperation(MethodNameReportingOprations.class).getMethodName();
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			result.getThrowable().printStackTrace(pw);
			logger.fail( MethodName+" Failed, Reason: "+result.getThrowable().getMessage() + "<br><b>StackTrace:</b> <pre>" + sw.toString() + "</pre>");
			Robot r = new Robot(); 
			String path = System.getProperty("user.dir") + "/src/test/resources/Reports/Shot.jpg";
			Rectangle capture =  new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()); 
			BufferedImage Image = r.createScreenCapture(capture); 
			ImageIO.write(Image, "jpg", new File(path)); 
			String dest = System.getProperty("user.dir") + "/src/test/resources/Reports/Shot.jpg";
			logger.addScreenCaptureFromPath(dest);

		}
		else {logger.info(result.getMethod().getMethodName()+" Passed");}
		extent.flush();
			
	}
	@AfterClass
	public void tearDown() throws DriverNotInitializedException, Throwable {
		menuBarOperations.doLogOut().navigateToMainloginScreen();
		
		//BrowserFactory.quitDriver();
	}
	

	static public void loggingStartReport(String testName) {
		logger=extent.createTest(testName);
		
	}

}