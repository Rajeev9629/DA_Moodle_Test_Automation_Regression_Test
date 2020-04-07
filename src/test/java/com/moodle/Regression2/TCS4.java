package com.moodle.Regression2;

import java.util.LinkedHashMap;
import org.testng.annotations.Test;
import com.framework.utils.Utility;
import com.moodle.tlh.tests.BaseTest;
import com.netsuite.tlh.operations.FacilitationDashboardOperations;
import com.netsuite.tlh.operations.Navigator;
import com.netsuite.tlh.testdata.CreateBackupData;


public class TCS4 extends BaseTest{
	
	@Test(description = "MFD-316 ::TLHMFD-442::VerifyAssignmentCountsOnDashboard", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void VerifyAssignmentCountsOnDashboard(LinkedHashMap<String, ?> testData) throws Throwable {
		logger=extent.createTest("MFD-316 ::VerifyAssignmentCountsOnDashboard");
		System.out.println("TCS 4");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		
		rightNavOperations.searchAndGetCoursePage(createBackupData).getEnrollParticipantsPage().loginAsRespectiveApostopheUser(createBackupData.getRole3(),"3");
		rightNavOperations.getFacilitationManagerDashboard().gradeOneAssigment(createBackupData).verifyDashboardaAssignmentsCount(createBackupData);
		menuBarOperations.doLogOutAndLogin();
		rightNavOperations.searchAndGetCoursePage(createBackupData).getEnrollParticipantsPage().loginAsRespectiveApostopheUser(createBackupData.getRole2(),"1");
		rightNavOperations.getFacilitationDashboard();
		Navigator.FacilitationManagerDashboardOperations().verifyDashboardaAssignmentsCount(createBackupData);
		menuBarOperations.doLogOutAndLogin();
		
		rightNavOperations.searchAndGetCoursePage(createBackupData).getEnrollParticipantsPage().UnenrollUser(createBackupData.getPerformanceUserName());
		logger.info("MFD-316 ::VerifyAssignmentCountsOnDashboard Passed" );
				
	}
	

}
