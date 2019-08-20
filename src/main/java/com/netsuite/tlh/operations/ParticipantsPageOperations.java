package com.netsuite.tlh.operations;

import com.aventstack.extentreports.ExtentTest;
import com.framework.exceptions.DriverNotInitializedException;
import com.moodle.tlh.tests.FullRegressionTest;
import com.netsuite.tlh.factory.NetsuiteTLHPageFactory;
import com.netsuite.tlh.factory.OperationFactory;
import com.netsuite.tlh.pages.ParticipantsPage;
import com.netsuite.tlh.testdata.CreateBackupData;

public class ParticipantsPageOperations extends BaseOperations {
	ExtentTest logger=FullRegressionTest.logger;

	public ParticipantsPageOperations enrollStudent(CreateBackupData createBackupData, String Username) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("enrollStudent");
		NetsuiteTLHPageFactory.getPage(ParticipantsPage.class).clickOnEnrolUsers().selectUsers(Username)
		.selectRoles(createBackupData.getRole1()).clickOnEnrolUsersSaveButton();
		logger.pass("Student has been Enrolled");
		return this;
		
	}
	
	public ParticipantsPageOperations UnenrollUser(String UserName) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("UnenrollUser");
		NetsuiteTLHPageFactory.getPage(ParticipantsPage.class).clickOnUnEnrolUsers(UserName);
		logger.pass("Student has been UnEnrolled");
		return this;
		
	}
	
	public ParticipantsPageOperations enrollFacilitator(CreateBackupData createBackupData, String Username) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("enrollFacilitator");
		NetsuiteTLHPageFactory.getPage(ParticipantsPage.class).clickOnEnrolUsers().selectUsers(Username)
		.selectRoles(createBackupData.getRole2()).clickOnEnrolUsersSaveButton();
		logger.pass("Facilitator has been Enrolled");
		return this;
		
	}
	
	public ParticipantsPageOperations enrollFacilitationManager(CreateBackupData createBackupData, String Username) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("enrollFacilitationManager");
		NetsuiteTLHPageFactory.getPage(ParticipantsPage.class).clickOnEnrolUsers().selectUsers(Username)
		.selectRoles(createBackupData.getRole3()).clickOnEnrolUsersSaveButton();
		logger.pass("Facilitation Manager has been Enrolled");
		return this;
		
	}
	
	public ParticipantsPageOperations loginAsRespectiveUser(String Role, String Username) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("loginAsRespectiveUser");
		NetsuiteTLHPageFactory.getPage(ParticipantsPage.class).clickOnRespectiveUser(Role,Username)
		.clickOnLoginAs().clickContinue();
		logger.pass("loginAsRespectiveUser Sucess");
		return this;
		
	}
	
	public ParticipantsPageOperations loginAsRespectiveApostopheUser(String Role, String Count) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("loginAsRespectiveApostopheUser");
		NetsuiteTLHPageFactory.getPage(ParticipantsPage.class).clickOnRespectiveApostopheUser(Role,Count)
		.clickOnLoginAs().clickContinue();
		logger.pass("loginAsRespectiveApostopheUser Sucess");
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