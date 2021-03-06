package com.moodle.Regression1;

import java.util.LinkedHashMap;

import org.testng.annotations.Test;

import com.framework.utils.Utility;
import com.moodle.tlh.tests.BaseTest;
import com.netsuite.tlh.testdata.CreateBackupData;

public class TCS2  extends BaseTest{
	
	@Test(description = "MFD-223 ::MFD-264 ::Enrolling the Users", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void EnrollingTheUsers(LinkedHashMap<String, ?> testData) throws Throwable {
		loggingStartReport("TCS2:MFD-223 ::MFD-264 ::Enrolling the Users");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		System.out.println("2");
		
		rightNavOperations.searchAndGetCoursePage(createBackupData).getEnrollParticipantsPage()
		.enrollStudent(createBackupData,createBackupData.getUserName1())
		.enrollFacilitator(createBackupData,createBackupData.getUserName2())
		.enrollFacilitator(createBackupData,createBackupData.getUserName5())
		.enrollFacilitationManager(createBackupData,createBackupData.getUserName3())
		.enrollFacilitationManager(createBackupData,createBackupData.getUserName6());
	}

}
