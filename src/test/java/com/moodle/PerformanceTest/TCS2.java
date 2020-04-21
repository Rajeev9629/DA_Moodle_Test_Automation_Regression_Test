package com.moodle.PerformanceTest;

import java.util.LinkedHashMap;
import org.testng.annotations.Test;
import com.framework.utils.Utility;
import com.moodle.tlh.tests.BaseTest;
import com.netsuite.tlh.operations.MenuBarOperations;
import com.netsuite.tlh.operations.Navigator;
import com.netsuite.tlh.testdata.CreateBackupData;


public class TCS2 extends BaseTest{
	
	@Test(description = "MFD-223 ::MFD-264 ::Enrolling the Users", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void EnrollingTheUsers(LinkedHashMap<String, ?> testData) throws Throwable {
		logger=extent.createTest("MFD-223 ::MFD-264 ::Enrolling the Users");
		System.out.println("2");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		
		rightNavOperations.searchAndGetCoursePage(createBackupData).getEnrollParticipantsPage()
		.enrollStudent(createBackupData,createBackupData.getUserName1())
		.enrollFacilitationManager(createBackupData,createBackupData.getUserName3())
		.enrollFacilitationManager(createBackupData,createBackupData.getPerformanceUserName());
		logger.info("MFD-223 ::MFD-264 ::Enrolling the Users passed");
		
	}

}
