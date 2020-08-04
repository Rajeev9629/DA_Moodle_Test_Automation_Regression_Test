package com.netsuite.tlh.operations;

import com.aventstack.extentreports.ExtentTest;
import com.framework.exceptions.DriverNotInitializedException;
import com.moodle.Regression1.FullRegressionTest;
import com.netsuite.tlh.factory.NetsuiteTLHPageFactory;
import com.netsuite.tlh.factory.OperationFactory;
import com.netsuite.tlh.pages.FacilitationDashboardPage;
import com.netsuite.tlh.pages.FacilitationManagerDashboardPage;
import com.netsuite.tlh.testdata.CreateBackupData;

public class FacilitationDashboardOperations extends BaseOperations {
	
	ExtentTest logger=FullRegressionTest.logger;
	
	public FacilitationDashboardOperations verifyFilters(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("verifyFilters");
		NetsuiteTLHPageFactory.getPage(FacilitationDashboardPage.class)
		
		.enterStudentName(createBackupData.getUserName1()).enterCourseCode(createBackupData.getCourseShortName()).selectAssignmentStatus(createBackupData.getStatusAll()).clickFilterButton()
		.verifyTableIspresent().clickResetButton()
		
		.selectDateSubmitted().enterCourseCode(createBackupData.getCourseShortName()).selectAssignmentStatus(createBackupData.getStatusAll()).clickFilterButton()
		.verifyTableIspresent().clickResetButton()
		
		.enterCourseCode(createBackupData.getCourseShortName()).selectAssignmentStatus(createBackupData.getStatusAll()).clickFilterButton().verifyTableIspresent().clickResetButton()
		
		.enterCourseName(createBackupData.getCourseName()).enterCourseCode(createBackupData.getCourseShortName()).selectAssignmentStatus(createBackupData.getStatusAll())
		.clickFilterButton().verifyTableIspresent().clickResetButton()
		
		.enterAssignmentName(createBackupData.getAssignmentName()).enterCourseCode(createBackupData.getCourseShortName()).selectAssignmentStatus(createBackupData.getStatusAll())
		.clickFilterButton().verifyTableIspresent().clickResetButton()
		
		.selectAssignmentStatus(createBackupData.getStatus()).enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton().verifyTableIspresent().verifyPaginationDoesntBreak().clickResetButton()
		
		.selectAssignmentStatus(createBackupData.getStatusResubmitted()).enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton().verifyTableIspresent().clickResetButton()
		
		.selectAssignmentStatus(createBackupData.getStatusUngraded()).enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton().verifyTableIspresent().clickResetButton()
		
		.selectSignOffStatus(createBackupData.getSignOffStatusAll()).enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton().verifyTableIspresent().clickResetButton()
		
		.selectSignOffStatus(createBackupData.getSignOffStatusAwaiting()).enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton().verifyTableIspresent().clickResetButton()
		
		.selectSignOffStatus(createBackupData.getSignOffStatusSigned()).enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton().verifyTableIspresent().clickResetButton()
		
		.expectedCompletionDateInput().enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton().verifyTableIspresent().clickResetButton()
		
		;
		
		return this;	
	}
	
	
	public FacilitationDashboardOperations filterStundentCourse(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("filterStundentCourse");
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).selectDateSubmitted().enterCourseCode(createBackupData.getCourseShortName())
		.enterStudentName(createBackupData.getUserName7()).selectAssignmentStatus(createBackupData.getStatusUngraded())
		.clickFilterButton().openAssigmentsLink(createBackupData,3);
		
		return this;	
	}
	
}
