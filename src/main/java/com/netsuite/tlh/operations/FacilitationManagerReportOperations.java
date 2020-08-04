package com.netsuite.tlh.operations;

import com.framework.exceptions.DriverNotInitializedException;
import com.netsuite.tlh.factory.NetsuiteTLHPageFactory;
import com.netsuite.tlh.factory.OperationFactory;
import com.netsuite.tlh.pages.FacilitationManagerReportPage;
import com.netsuite.tlh.testdata.CreateBackupData;

public class FacilitationManagerReportOperations extends BaseOperations {
	 
	
	public FacilitationManagerReportOperations verifyFilters(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("VerifyFilters");
		
		NetsuiteTLHPageFactory.getPage(FacilitationManagerReportPage.class).verifyFiltersName().verifyTableHeadings()
		.enterCourseIdFilter(createBackupData.getCourseId()).clickFilterButton().verifyCourseIdFilter(createBackupData.getCourseId())
		.verifyingCSVData().clickResetButton()
		.enterFacilitatorNameFilter(createBackupData.getFacilitator()).clickFilterButton().verifyFacilitatorNameFilter(createBackupData.getFacilitator()).clickResetButton()
		.enterfacilitatorTitleFilter(createBackupData.getCourseTitle()).clickFilterButton().verifyfacilitatorTitleFilter(createBackupData.getCourseTitle()).clickResetButton()
		.entercategoryNameFilter(createBackupData.getCategoryName()).clickFilterButton().verifycategoryNameFilter(createBackupData.getCategoryName()).clickResetButton()
		;
		
		return this;	
	}
	
	
	
}
