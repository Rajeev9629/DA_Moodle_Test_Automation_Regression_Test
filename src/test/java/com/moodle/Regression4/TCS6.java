package com.moodle.Regression4;

import java.util.LinkedHashMap;
import org.testng.annotations.Test;
import com.framework.utils.Utility;
import com.moodle.tlh.tests.BaseTest;
import com.netsuite.tlh.operations.MenuBarOperations;
import com.netsuite.tlh.operations.Navigator;
import com.netsuite.tlh.testdata.CreateBackupData;


public class TCS6 extends BaseTest{
	
	@Test(description = "MFD-560::IssueWithFilteringOriginalGrader", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void IssueWithFilteringOriginalGrader(LinkedHashMap<String, ?> testData) throws Throwable {
		logger=extent.createTest("MFD-560::IssueWithFilteringOriginalGrader");
		System.out.println("6");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		
		rightNavOperations.searchAndGetCoursePage(createBackupData).getEnrollParticipantsPage()
		.loginAsRespectiveUser(createBackupData.getRole1(),createBackupData.getUserName1(),createBackupData.getCourseShortName());
		rightNavOperations.getAssignmentsPage().resubmitAssignment();
		menuBarOperations.doLogOutAndLogin();
		rightNavOperations.searchAndGetCoursePage(createBackupData).getEnrollParticipantsPage().enrollFacilitator(createBackupData, createBackupData.getUserName2())
		.loginAsRespectiveUser(createBackupData.getRole2(),createBackupData.getUserName2(),createBackupData.getCourseShortName());
		rightNavOperations.getFacilitationDashboard();
		Navigator.FacilitationManagerDashboardOperations()
		.verifyMFD_560(createBackupData);
		menuBarOperations.doLogOutAndLogin();
		rightNavOperations.getFacilitationManagerDashboard().verifyMFD_560_1(createBackupData);
		
		logger.info("MFD-560::IssueWithFilteringOriginalGrader");
	}

}
