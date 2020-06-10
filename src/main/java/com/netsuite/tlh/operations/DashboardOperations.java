package com.netsuite.tlh.operations;

import com.framework.exceptions.DriverNotInitializedException;
import com.netsuite.tlh.factory.NetsuiteTLHPageFactory;
import com.netsuite.tlh.factory.OperationFactory;
import com.netsuite.tlh.pages.ManageConfigValuesPage;
import com.netsuite.tlh.testdata.Database;

public class DashboardOperations extends BaseOperations {

	public DashboardOperations verifyManageConfigPage() throws DriverNotInitializedException, Throwable {
		try {OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("verifyManageConfigPage");
		NetsuiteTLHPageFactory.getPage(ManageConfigValuesPage.class).verifyInputText().verifycolumnText()
		;}
		catch(Exception e) {
			System.out.println("verifyManageConfigPage failed");
			e.printStackTrace();
		}
		return this;	
	}
	

	
	
}