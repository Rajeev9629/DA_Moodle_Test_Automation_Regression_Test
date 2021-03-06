package com.moodle.Regression1;

import java.util.LinkedHashMap;

import org.testng.annotations.Test;

import com.framework.utils.Utility;
import com.moodle.tlh.tests.BaseTest;
import com.netsuite.tlh.testdata.CreateBackupData;

public class TCS4 extends BaseTest{
	
	@Test(description = "MFD-224 ::Login as student and Complete the assignment", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void LoginAsStudentAndCompleteAssignment(LinkedHashMap<String, ?> testData) throws Throwable {
		loggingStartReport("TCS4:MFD-224 ::Login as student and Complete the assignment");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		System.out.println("4");
		
		rightNavOperations.searchAndGetCoursePage(createBackupData).getEnrollParticipantsPage()
		.loginAsRespectiveUser(createBackupData.getRole1(),createBackupData.getUserName1(),createBackupData.getCourseShortName());
		rightNavOperations.searchAndGetCoursePage(createBackupData).getAssignmentsPage().completeAssingments();

		
	}
}
