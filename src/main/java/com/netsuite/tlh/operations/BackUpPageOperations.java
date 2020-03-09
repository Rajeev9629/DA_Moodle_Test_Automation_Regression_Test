package com.netsuite.tlh.operations;

import com.framework.exceptions.DriverNotInitializedException;
import com.netsuite.tlh.factory.NetsuiteTLHPageFactory;
import com.netsuite.tlh.factory.OperationFactory;
import com.netsuite.tlh.pages.BackUpPage;
import com.netsuite.tlh.pages.RightNavBar;

public class BackUpPageOperations extends BaseOperations {

	public BackUpPageOperations DoTheBackup() throws DriverNotInitializedException, Throwable {
		try {OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("DoTheBackup");
		NetsuiteTLHPageFactory.getPage(BackUpPage.class).removeEnrolledUser().clickOnJumpToFinalStep().clickOncontinueButton();}
		catch(Exception e) {
			System.out.println("gotoBackUpPage failed");
			e.printStackTrace();
		}
		return this;
		
	}
	
	
	
	
}