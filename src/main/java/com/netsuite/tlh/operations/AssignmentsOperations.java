package com.netsuite.tlh.operations;

import com.aventstack.extentreports.ExtentTest;
import com.framework.exceptions.DriverNotInitializedException;
import com.moodle.Regression1.FullRegressionTest;
import com.netsuite.tlh.factory.NetsuiteTLHPageFactory;
import com.netsuite.tlh.factory.OperationFactory;
import com.netsuite.tlh.pages.AssignmentsPage;
import com.netsuite.tlh.testdata.CreateBackupData;

public class AssignmentsOperations extends BaseOperations {
	ExtentTest logger=FullRegressionTest.logger;
	
	public AssignmentsOperations completeAssingments() throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("completeAssingments");
		NetsuiteTLHPageFactory.getPage(AssignmentsPage.class).openAssigmentsLink()/*.completeAssignment()*/.refreshPage();
		
		return this;	
	}
	
	public AssignmentsOperations resubmitAssignment() throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("resubmitAssignment");
		NetsuiteTLHPageFactory.getPage(AssignmentsPage.class).openAssigmentsLinkModule2_A().clickEdiSubmissionButton()
		.clickAddButton().uploadAFile();
		
		return this;	
	}
	
	public AssignmentsOperations completeAssingmentModule2() throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("completeAssingmentModule2");
		NetsuiteTLHPageFactory.getPage(AssignmentsPage.class).openAssigmentsLinkModule2().refreshPage();
		
		return this;	
	}
	
	public AssignmentsOperations completeAssingmentModule3() throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("completeAssingmentModule3");
		NetsuiteTLHPageFactory.getPage(AssignmentsPage.class).openAssigmentsLinkModule3().refreshPage();
		
		return this;	
	}
	
	public AssignmentsOperations verifyStudentRubricView() throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("verifyStudentRubricView");
		NetsuiteTLHPageFactory.getPage(AssignmentsPage.class).verifyStudentRubricView();
		
		return this;	
	}
	
	public AssignmentsOperations verifyAssignment3Feedback(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("verifyAssignment3Feedback");
		NetsuiteTLHPageFactory.getPage(AssignmentsPage.class).verifyAssigment3Feedback( createBackupData.getFeedbackComment())
		;
		return this;	
	}
	
}
