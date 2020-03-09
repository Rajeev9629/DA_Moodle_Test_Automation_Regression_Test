package com.moodle.modularisedRegression1;

import java.util.LinkedHashMap;

import org.testng.annotations.Test;

import com.framework.utils.Utility;
import com.moodle.tlh.tests.BaseTest;
import com.netsuite.tlh.testdata.CreateBackupData;

public class Regression_TCS5 extends BaseTest{
	
	@Test(description = "MFD-225 ::MFD-245::MFD-267::MFD-356 ::MFD-484::Facilitation Dashboard :Grading,Verify Rubic View, Grading Filters,verifyCreatedAndUpdatedDate,Verify No error while searching records with Student name filter", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void FacilitationDashboardGradingTheAssignment(LinkedHashMap<String, ?> testData) throws Throwable {
		loggingStartReport("TCS5:MFD-225 ::MFD-245::MFD-267::MFD-356");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		System.out.println("5");
		
		rightNavOperations.getFacilitationManagerDashboard().gradeAssigment(createBackupData).verifyCreatedAndUpdatedDate()
		.verifyStudentNameFilter(createBackupData)
		;	
		
	}
}
