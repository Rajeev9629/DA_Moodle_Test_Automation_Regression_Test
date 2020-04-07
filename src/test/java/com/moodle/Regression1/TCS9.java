package com.moodle.Regression1;

import java.util.LinkedHashMap;

import org.testng.annotations.Test;

import com.framework.utils.Utility;
import com.moodle.tlh.tests.BaseTest;
import com.netsuite.tlh.operations.Navigator;
import com.netsuite.tlh.testdata.CreateBackupData;

public class TCS9 extends BaseTest {
	
	@Test(description = "MFD-226 :: MFD-270::MFD-259::MFD-475:: Sign Off the assignment, sign off behaviour, Verify the Sign Off Button,sign-off button and process", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void FacilitationDashboardSignOffTheAssignment(LinkedHashMap<String, ?> testData) throws Throwable {
		loggingStartReport("TCS9:MFD-226 :: MFD-270::MFD-259::");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		System.out.println("9");
        rightNavOperations.searchAndGetCoursePage(createBackupData).getEnrollParticipantsPage()
        .loginAsRespectiveUser(createBackupData.getRole1(),createBackupData.getUserName1(),createBackupData.getCourseShortName());

		rightNavOperations.searchAndGetCoursePage(createBackupData).getQuizzesPage();
		Navigator.GetCoursePageOperations().completeParticipationAcknowledgement2();
		menuBarOperations.doLogOutAndLogin();
		rightNavOperations.getFacilitationManagerDashboard().verifySignOffFunctionality().verifySignOffBehaviour(createBackupData).signOff(createBackupData);
		
	}

}
