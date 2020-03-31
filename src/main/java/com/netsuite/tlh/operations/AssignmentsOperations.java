package com.netsuite.tlh.operations;

import com.aventstack.extentreports.ExtentTest;
import com.framework.exceptions.DriverNotInitializedException;
import com.moodle.tlh.tests.FullRegressionTest;
import com.netsuite.tlh.factory.NetsuiteTLHPageFactory;
import com.netsuite.tlh.factory.OperationFactory;
import com.netsuite.tlh.pages.AssignmentsPage;
import com.netsuite.tlh.testdata.CreateBackupData;

public class AssignmentsOperations extends BaseOperations {
	ExtentTest logger=FullRegressionTest.logger;
	
	public AssignmentsOperations completeAssingments() throws DriverNotInitializedException, Throwable {
		try {OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("completeAssingments");
		NetsuiteTLHPageFactory.getPage(AssignmentsPage.class).openAssigmentsLink()/*.completeAssignment()*/.refreshPage();
		}
		catch(Exception e) {
			System.out.println("completeAssingments failed");
			e.printStackTrace();
		}
		return this;	
	}
	
	public AssignmentsOperations completeAssingmentModule2() throws DriverNotInitializedException, Throwable {
		try {OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("completeAssingmentModule2");
		NetsuiteTLHPageFactory.getPage(AssignmentsPage.class).openAssigmentsLinkModule2().refreshPage();
		logger.pass("Assignment Module 2 Submission is Completed");}
		catch(Exception e) {
			System.out.println("completeAssingmentModule2 failed");
			e.printStackTrace();
		}
		return this;	
	}
	
	public AssignmentsOperations completeAssingmentModule3() throws DriverNotInitializedException, Throwable {
		try {OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("completeAssingmentModule3");
		NetsuiteTLHPageFactory.getPage(AssignmentsPage.class).openAssigmentsLinkModule3().refreshPage();
		logger.pass("Assignment Module 3 Submission is Completed");}
		catch(Exception e) {
			System.out.println("completeAssingmentModule3 failed");
			e.printStackTrace();
		}
		return this;	
	}
	
	public AssignmentsOperations verifyStudentRubricView() throws DriverNotInitializedException, Throwable {
		try {OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("verifyStudentRubricView");
		NetsuiteTLHPageFactory.getPage(AssignmentsPage.class).verifyStudentRubricView()
		;}
		catch(Exception e) {
			System.out.println("verifyStudentRubricView failed");
			e.printStackTrace();
		}
		return this;	
	}
	
	public AssignmentsOperations verifyAssignment3Feedback(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		try {OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("verifyAssignment2Feedback");
		NetsuiteTLHPageFactory.getPage(AssignmentsPage.class).verifyAssigment3Feedback( createBackupData.getFeedbackComment())
		;}
		catch(Exception e) {
			System.out.println("verifyAssignment3Feedback failed");
			e.printStackTrace();
		}
		return this;	
	}
	
}
