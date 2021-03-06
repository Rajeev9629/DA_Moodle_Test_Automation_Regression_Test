package com.netsuite.tlh.operations;

import org.openqa.selenium.By;

import com.aventstack.extentreports.ExtentTest;
import com.framework.base.BrowserFactory;
import com.framework.exceptions.DriverNotInitializedException;
import com.moodle.Regression1.FullRegressionTest;
import com.netsuite.tlh.factory.NetsuiteTLHPageFactory;
import com.netsuite.tlh.factory.OperationFactory;
import com.netsuite.tlh.pages.ParticipantsPage;
import com.netsuite.tlh.pages.RestorePage;
import com.netsuite.tlh.testdata.CreateBackupData;

public class ParticipantsPageOperations extends BaseOperations {
	ExtentTest logger=FullRegressionTest.logger;

	public ParticipantsPageOperations enrollStudent(CreateBackupData createBackupData, String Username) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("enrollStudent");
		NetsuiteTLHPageFactory.getPage(ParticipantsPage.class).clickOnEnrolUsers().selectUsers(Username)
		.selectRoles(createBackupData.getRole1()).clickOnEnrolUsersSaveButton();
		
		return this;
		
	}
	
	public ParticipantsPageOperations UnenrollUser(String UserName) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("UnenrollUser");
		NetsuiteTLHPageFactory.getPage(ParticipantsPage.class).clickOnUnEnrolUsers(UserName);
		
		return this;
		
	}
	
	public ParticipantsPageOperations enrollFacilitator(CreateBackupData createBackupData, String Username) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("enrollFacilitator");
		NetsuiteTLHPageFactory.getPage(ParticipantsPage.class).clickOnEnrolUsers().selectUsers(Username)
		.selectRoles(createBackupData.getRole2()).clickOnEnrolUsersSaveButton();
		return this;
		
	}
	
	public ParticipantsPageOperations enrollFacilitationManager(CreateBackupData createBackupData, String Username) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("enrollFacilitationManager");
		NetsuiteTLHPageFactory.getPage(ParticipantsPage.class).clickOnEnrolUsers().selectUsers(Username)
		.selectRoles(createBackupData.getRole3()).clickOnEnrolUsersSaveButton();
		return this;
		
	}
	
	public ParticipantsPageOperations loginAsRespectiveUser(String Role, String Username, String coursecode) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("loginAsRespectiveUser");
		NetsuiteTLHPageFactory.getPage(ParticipantsPage.class).clickOnRespectiveUser(Role,Username)
		.clickOnLoginAs().clickContinue();
		Thread.sleep(3000);
		if (Role.equalsIgnoreCase("Student")) {
			Thread.sleep(3000);
			OperationFactory.getOperation(RightNavOperations.class).acceptSitePolicyAgreement();
			Thread.sleep(3000);
			String courseID=RestorePage.courseID;
			String courseURL=BrowserFactory.url+"course/view.php?id="+courseID;
			BrowserFactory.getDriver().navigate().to(courseURL);
			Thread.sleep(3000);
		}
		
		return this;
		
	}
	
	public ParticipantsPageOperations loginAsRespectiveApostopheUser(String Role, String Count) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("loginAsRespectiveApostopheUser");
		NetsuiteTLHPageFactory.getPage(ParticipantsPage.class).clickOnRespectiveApostopheUser(Role,Count)
		.clickOnLoginAs().clickContinue();
		OperationFactory.getOperation(RightNavOperations.class).acceptSitePolicyAgreement();
		return this;
		
	}
	
	public ParticipantsPageOperations clickOnRespectiveCourse(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("clickOnRespectiveCourse");
		NetsuiteTLHPageFactory.getPage(ParticipantsPage.class).clickOnRespectiveCourse(createBackupData.getCourseShortName());
		return this;
		
	}
	
	public ParticipantsPageOperations clickOnRespectiveCourseFromLeftNav(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("clickOnRespectiveCourseFromLeftNav");
		NetsuiteTLHPageFactory.getPage(ParticipantsPage.class).clickOnRespectiveCourseLeftNav(createBackupData.getCourseShortName());
		return this;
		
	}
	
	public ParticipantsPageOperations getStudentName(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("getStudentName");
		NetsuiteTLHPageFactory.getPage(ParticipantsPage.class).getStudentName();
		return this;
		
	}
	
	
}