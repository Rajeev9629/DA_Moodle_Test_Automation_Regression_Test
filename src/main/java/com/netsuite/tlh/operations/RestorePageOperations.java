package com.netsuite.tlh.operations;

import com.framework.exceptions.DriverNotInitializedException;
import com.netsuite.tlh.factory.NetsuiteTLHPageFactory;
import com.netsuite.tlh.factory.OperationFactory;
import com.netsuite.tlh.pages.RestorePage;
import com.netsuite.tlh.testdata.CreateBackupData;


public class RestorePageOperations extends BaseOperations {

	public RestorePageOperations DoTheRestore(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		try {OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("DoTheRestore");
		NetsuiteTLHPageFactory.getPage(RestorePage.class).clickOnRestoreLink().clickbackupPageRestore()
		.clickOnBottomContinueButton().clickOnMiscellaneousOption().clickOnContinueButton().clickOnNextButton().enterCourseName(createBackupData.getCourseName())
		.enterCourseShortName(createBackupData.getCourseShortName()).clickOnNextButton().clickOnPerformRestore().clickOnBottomContinueButton();
		}
		catch(Exception e) {
			System.out.println("DoTheRestore failed");
			e.printStackTrace();
		}return this;
		
	}
	
	public RestorePageOperations DoTheRestore2(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		try {OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("DoTheRestore2");
		NetsuiteTLHPageFactory.getPage(RestorePage.class).clickOnchooseFileButton().uploadFile().clickOnUploadThisFileButton()
		.clickOnRestoreButton().clickOnBottomContinueButton().clickOnMiscellaneousOption().clickOnContinueButton()
		.removeEnrolledUser()
		.clickOnNextButton().enterCourseName(createBackupData.getCourseName()).enterCourseShortName(createBackupData.getCourseShortName())
		.clickOnNextButton().clickOnPerformRestore().clickOnBottomContinueButton().verifyCourseIsNotEmpty()
		;
		}
		catch(Exception e) {
			System.out.println("DoTheRestore2 failed");
			e.printStackTrace();
		}return this;
		
	}
	
	
		
	
	
	
	
	
}