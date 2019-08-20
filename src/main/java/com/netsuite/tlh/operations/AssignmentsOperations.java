package com.netsuite.tlh.operations;

import com.aventstack.extentreports.ExtentTest;
import com.framework.exceptions.DriverNotInitializedException;
import com.moodle.tlh.tests.FullRegressionTest;
import com.netsuite.tlh.factory.NetsuiteTLHPageFactory;
import com.netsuite.tlh.factory.OperationFactory;
import com.netsuite.tlh.pages.AssignmentsPage;

public class AssignmentsOperations extends BaseOperations {
	ExtentTest logger=FullRegressionTest.logger;
	
	public AssignmentsOperations completeAssingments() throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("completeAssingments");
		NetsuiteTLHPageFactory.getPage(AssignmentsPage.class).openAssigmentsLink()/*.completeAssignment()*/.refreshPage();
		logger.pass("Assignment Submission is Completed");
		return this;	
	}
	
	public AssignmentsOperations completeAssingmentModule2() throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("completeAssingmentModule2");
		NetsuiteTLHPageFactory.getPage(AssignmentsPage.class).openAssigmentsLinkModule2().refreshPage();
		logger.pass("Assignment Module 2 Submission is Completed");
		return this;	
	}
	
	public AssignmentsOperations completeAssingmentModule3() throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("completeAssingmentModule3");
		NetsuiteTLHPageFactory.getPage(AssignmentsPage.class).openAssigmentsLinkModule3().refreshPage();
		logger.pass("Assignment Module 3 Submission is Completed");
		return this;	
	}
	
	public AssignmentsOperations verifyStudentRubricView() throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("verifyStudentRubricView");
		NetsuiteTLHPageFactory.getPage(AssignmentsPage.class).verifyStudentRubricView()
		;
		return this;	
	}
	
	
}
