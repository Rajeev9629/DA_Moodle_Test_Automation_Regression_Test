package com.moodle.modularisedRegression1;

import java.util.LinkedHashMap;

import org.testng.annotations.Test;

import com.framework.utils.Utility;
import com.moodle.tlh.tests.BaseTest;
import com.netsuite.tlh.testdata.CreateBackupData;

public class Regression_TCS2  extends BaseTest{
	
	@Test(description = "MFD-223 ::MFD-264 ::Enrolling the Users", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void EnrollingTheUsers(LinkedHashMap<String, ?> testData) throws Throwable {
		loggingStartReport("MFD-223 ::MFD-264 ::Enrolling the Users");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		
		rightNavOperations.searchAndGetCoursePage(createBackupData).getEnrollParticipantsPage()
		.enrollStudent(createBackupData,createBackupData.getUserName1())
		.enrollFacilitator(createBackupData,createBackupData.getUserName2())
		.enrollFacilitator(createBackupData,createBackupData.getUserName5())
		.enrollFacilitationManager(createBackupData,createBackupData.getUserName3())
		.enrollFacilitationManager(createBackupData,createBackupData.getUserName6());
	}

}
