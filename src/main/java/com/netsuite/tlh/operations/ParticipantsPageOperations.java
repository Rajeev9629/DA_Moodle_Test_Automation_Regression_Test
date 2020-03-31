package com.netsuite.tlh.operations;

import org.openqa.selenium.By;

import com.aventstack.extentreports.ExtentTest;
import com.framework.base.BrowserFactory;
import com.framework.exceptions.DriverNotInitializedException;
import com.moodle.tlh.tests.FullRegressionTest;
import com.netsuite.tlh.factory.NetsuiteTLHPageFactory;
import com.netsuite.tlh.factory.OperationFactory;
import com.netsuite.tlh.pages.ParticipantsPage;
import com.netsuite.tlh.testdata.CreateBackupData;

public class ParticipantsPageOperations extends BaseOperations {
	ExtentTest logger=FullRegressionTest.logger;

	public ParticipantsPageOperations enrollStudent(CreateBackupData createBackupData, String Username) throws DriverNotInitializedException, Throwable {
		try {OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("enrollStudent");
		NetsuiteTLHPageFactory.getPage(ParticipantsPage.class).clickOnEnrolUsers().selectUsers(Username)
		.selectRoles(createBackupData.getRole1()).clickOnEnrolUsersSaveButton();
		}
		catch(Exception e) {
			System.out.println("enrollStudent failed");
			e.printStackTrace();
		}
		return this;
		
	}
	
	public ParticipantsPageOperations UnenrollUser(String UserName) throws DriverNotInitializedException, Throwable {
		try {OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("UnenrollUser");
		NetsuiteTLHPageFactory.getPage(ParticipantsPage.class).clickOnUnEnrolUsers(UserName);
		logger.pass("Student has been UnEnrolled");}
		catch(Exception e) {
			System.out.println("UnenrollUser failed");
			e.printStackTrace();
		}
		return this;
		
	}
	
	public ParticipantsPageOperations enrollFacilitator(CreateBackupData createBackupData, String Username) throws DriverNotInitializedException, Throwable {
		try {OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("enrollFacilitator");
		NetsuiteTLHPageFactory.getPage(ParticipantsPage.class).clickOnEnrolUsers().selectUsers(Username)
		.selectRoles(createBackupData.getRole2()).clickOnEnrolUsersSaveButton();
		}
		catch(Exception e) {
			System.out.println("enrollFacilitator failed");
			e.printStackTrace();
		}
		return this;
		
	}
	
	public ParticipantsPageOperations enrollFacilitationManager(CreateBackupData createBackupData, String Username) throws DriverNotInitializedException, Throwable {
		try {OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("enrollFacilitationManager");
		NetsuiteTLHPageFactory.getPage(ParticipantsPage.class).clickOnEnrolUsers().selectUsers(Username)
		.selectRoles(createBackupData.getRole3()).clickOnEnrolUsersSaveButton();
		}
		catch(Exception e) {
			System.out.println("enrollFacilitationManager failed");
			e.printStackTrace();
		}
		return this;
		
	}
	
	public ParticipantsPageOperations loginAsRespectiveUser(String Role, String Username, String coursecode) throws DriverNotInitializedException, Throwable {
		try {OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("loginAsRespectiveUser");
		NetsuiteTLHPageFactory.getPage(ParticipantsPage.class).clickOnRespectiveUser(Role,Username)
		.clickOnLoginAs().clickContinue();
		if (Role.equalsIgnoreCase("Student") && coursecode.equalsIgnoreCase(coursecode)) {
			Thread.sleep(3000);
			OperationFactory.getOperation(RightNavOperations.class).acceptSitePolicyAgreement();
			Thread.sleep(3000);
		
			BrowserFactory.getDriver().findElement(By.xpath("//span[text()='" + coursecode + "']")).click();
			Thread.sleep(3000);
		}
		}
		catch(Exception e) {
			System.out.println("loginAsRespectiveUser failed");
			e.printStackTrace();
		}
		return this;
		
	}
	
	public ParticipantsPageOperations loginAsRespectiveApostopheUser(String Role, String Count) throws DriverNotInitializedException, Throwable {
		try {OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("loginAsRespectiveApostopheUser");
		NetsuiteTLHPageFactory.getPage(ParticipantsPage.class).clickOnRespectiveApostopheUser(Role,Count)
		.clickOnLoginAs().clickContinue();
		
		}
		catch(Exception e) {
			System.out.println("loginAsRespectiveApostopheUser failed");
			e.printStackTrace();
		}
		return this;
		
	}
	
	public ParticipantsPageOperations clickOnRespectiveCourse(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		try {OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("clickOnRespectiveCourse");
		NetsuiteTLHPageFactory.getPage(ParticipantsPage.class).clickOnRespectiveCourse(createBackupData.getCourseShortName());}
		catch(Exception e) {
			System.out.println("clickOnRespectiveCourse failed");
			e.printStackTrace();
		}
		return this;
		
	}
	
	public ParticipantsPageOperations clickOnRespectiveCourseFromLeftNav(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		try {OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("clickOnRespectiveCourseFromLeftNav");
		NetsuiteTLHPageFactory.getPage(ParticipantsPage.class).clickOnRespectiveCourseLeftNav(createBackupData.getCourseShortName());}
		catch(Exception e) {
			System.out.println("clickOnRespectiveCourseFromLeftNav failed");
			e.printStackTrace();
		}
		return this;
		
	}
	
	public ParticipantsPageOperations getStudentName(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		
		try {OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("getStudentName");
		NetsuiteTLHPageFactory.getPage(ParticipantsPage.class).getStudentName();}
		catch(Exception e) {
			System.out.println("getStudentName failed");
			e.printStackTrace();
		}
		return this;
		
	}
	
	
}