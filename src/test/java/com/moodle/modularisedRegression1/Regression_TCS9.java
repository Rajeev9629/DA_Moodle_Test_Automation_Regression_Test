package com.moodle.modularisedRegression1;

import java.util.LinkedHashMap;

import org.testng.annotations.Test;

import com.framework.utils.Utility;
import com.moodle.tlh.tests.BaseTest;
import com.netsuite.tlh.operations.Navigator;
import com.netsuite.tlh.testdata.CreateBackupData;

public class Regression_TCS9 extends BaseTest {
	
	@Test(description = "MFD-226 :: MFD-270::MFD-259:: Sign Off the assignment, Verify the Sign Off Button,sign-off button and process", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void FacilitationDashboardSignOffTheAssignment(LinkedHashMap<String, ?> testData) throws Throwable {
		loggingStartReport("MFD-226 :: MFD-270::MFD-259::");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		System.out.println("9");
		
		rightNavOperations.getFacilitationManagerDashboard().verifySignOffFunctionality();
		rightNavOperations.searchAndGetCoursePage(createBackupData).getEnrollParticipantsPage()
		.loginAsRespectiveUser(createBackupData.getRole1(),createBackupData.getUserName1());
		rightNavOperations.getQuizzesPage();
		Navigator.GetCoursePageOperations().completeParticipationAcknowledgement2();
		menuBarOperations.doLogOutAndLogin();
		rightNavOperations.getFacilitationManagerDashboard().signOff(createBackupData);
		
	}

}
