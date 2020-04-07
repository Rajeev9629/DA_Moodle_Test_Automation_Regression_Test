package com.moodle.DashboardTest;

import java.util.LinkedHashMap;
import org.testng.annotations.Test;
import com.framework.utils.Utility;
import com.moodle.tlh.tests.BaseTest;
import com.netsuite.tlh.operations.Navigator;
import com.netsuite.tlh.testdata.CreateBackupData;


public class TCS4 extends BaseTest{
	

	@Test(priority=4,description = "MFD-224 ::Login as student and Complete the assignment", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void LoginAsStudentAndCompleteAssignment(LinkedHashMap<String, ?> testData) throws Throwable {
		loggingStartReport("MFD-224 ::Login as student and Complete the assignment");
		System.out.println("TCS 4");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		
		rightNavOperations.searchAndGetCoursePage(createBackupData).getEnrollParticipantsPage()
		.loginAsRespectiveUser(createBackupData.getRole1(),createBackupData.getUserName1(),createBackupData.getCourseShortName());
		rightNavOperations.getQuizzesPage();
		Navigator.GetCoursePageOperations().completeParticipationAcknowledgement2();
		rightNavOperations.searchAndGetCoursePage(createBackupData).getAssignmentsPage().completeAssingments();
	
	}
}
