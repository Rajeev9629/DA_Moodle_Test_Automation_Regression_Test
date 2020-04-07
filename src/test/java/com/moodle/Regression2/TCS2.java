package com.moodle.Regression2;

import java.util.LinkedHashMap;
import org.testng.annotations.Test;
import com.framework.utils.Utility;
import com.moodle.tlh.tests.BaseTest;
import com.netsuite.tlh.operations.FacilitationDashboardOperations;
import com.netsuite.tlh.operations.Navigator;
import com.netsuite.tlh.testdata.CreateBackupData;


public class TCS2 extends BaseTest{
	
	
	@Test(description = "Sample-2::Enrolling the Users", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void EnrollTheUsers(LinkedHashMap<String, ?> testData) throws Throwable {
		logger=extent.createTest("Sample-2::Enrolling the Users");
		System.out.println("TCS 2");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		rightNavOperations.searchAndGetCoursePage(createBackupData).getEnrollParticipantsPage()
		.enrollStudent(createBackupData,createBackupData.getUserName1())
		.enrollStudent(createBackupData,createBackupData.getUserName4())
		.enrollFacilitator(createBackupData,createBackupData.getUserName2())
		.enrollFacilitator(createBackupData,createBackupData.getUserName5())
		.enrollFacilitationManager(createBackupData,createBackupData.getUserName3())
		.enrollFacilitationManager(createBackupData,createBackupData.getUserName6())
		.enrollFacilitationManager(createBackupData,createBackupData.getPerformanceUserName());
		
		logger.info("Sample-2::Enrolling the Users Passed" );
	}
	
}
