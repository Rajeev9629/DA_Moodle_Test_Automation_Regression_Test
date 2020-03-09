package com.netsuite.tlh.operations;

import com.framework.exceptions.DriverNotInitializedException;
import com.netsuite.tlh.factory.NetsuiteTLHPageFactory;
import com.netsuite.tlh.factory.OperationFactory;
import com.netsuite.tlh.pages.FacilitationManagerReportPage;
import com.netsuite.tlh.pages.FacilitationSignOffReportPage;
import com.netsuite.tlh.testdata.CreateBackupData;

public class FacilitationSignOffReportOperations extends BaseOperations {
	 
	
	public FacilitationSignOffReportOperations verifySignOffPageDetails() throws DriverNotInitializedException, Throwable {
		try {OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("VerifyFilters");
		
		NetsuiteTLHPageFactory.getPage(FacilitationSignOffReportPage.class).verifyPageLabels().verifyFilters()
		;
	}
	catch(Exception e) {
		System.out.println("verifySignOffPageDetails failed");
		e.printStackTrace();
	}
		return this;	
	}
	
	
	
}
