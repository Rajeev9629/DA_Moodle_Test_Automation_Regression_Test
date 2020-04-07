package com.moodle.Regression2;

import java.util.LinkedHashMap;
import org.testng.annotations.Test;
import com.framework.utils.Utility;
import com.moodle.tlh.tests.BaseTest;
import com.netsuite.tlh.operations.FacilitationDashboardOperations;
import com.netsuite.tlh.operations.Navigator;
import com.netsuite.tlh.testdata.CreateBackupData;


public class TCS5 extends BaseTest{
	
	@Test(description = "MFD-290 ::MFD-288::Apostrophe in Facilitation Dashboard filter criteria, verify deleting submitted assignment", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
		public void VerifyDashboardFunctionalityForDifferentRoles(LinkedHashMap<String, ?> testData) throws Throwable {
		logger=extent.createTest("MFD-290 ::MFD-288::Apostrophe in Facilitation Dashboard filter criteria, verify deleting submitted assignment");	
		System.out.println("TCS 5");
			CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
			
			rightNavOperations.searchAndGetCoursePage(createBackupData).getEnrollParticipantsPage().loginAsRespectiveApostopheUser(createBackupData.getRole2(),"1");
			rightNavOperations.getFacilitationDashboard();
			Navigator.FacilitationManagerDashboardOperations().verifyApostopheFilters(createBackupData);
			
			menuBarOperations.doLogOutAndLogin();
			
			rightNavOperations.searchAndGetCoursePage(createBackupData);
			Navigator.GetCoursePageOperations().changeCourseName( createBackupData);
			rightNavOperations.getEnrollParticipantsPage().loginAsRespectiveApostopheUser(createBackupData.getRole2(),"1");
			rightNavOperations.getFacilitationDashboard();
			Navigator.FacilitationManagerDashboardOperations().verifyApostopheFilters2(createBackupData);
			
			menuBarOperations.doLogOutAndLogin();
			rightNavOperations.getFacilitationManagerDashboard().verifyDeleteSubmissionButton(createBackupData);
			logger.info("MFD-290 ::MFD-288::Apostrophe in Facilitation Dashboard filter criteria, verify deleting submitted assignment Passed" );
			
		}	

}
