package com.moodle.Regression4;

import java.util.LinkedHashMap;
import org.testng.annotations.Test;
import com.framework.utils.Utility;
import com.moodle.tlh.tests.BaseTest;
import com.netsuite.tlh.operations.MenuBarOperations;
import com.netsuite.tlh.operations.Navigator;
import com.netsuite.tlh.testdata.CreateBackupData;


public class TCS3 extends BaseTest{
	
	@Test(description = "MFD-224 ::Login as student and Complete the assignment", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void LoginAsStudentAndCompleteAssignment(LinkedHashMap<String, ?> testData) throws Throwable {
		logger=extent.createTest("MFD-224 ::Login as student and Complete the assignment");
		System.out.println("3");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		
		rightNavOperations.searchAndGetCoursePage(createBackupData).getEnrollParticipantsPage()
		.loginAsRespectiveUser(createBackupData.getRole1(),createBackupData.getUserName1(),createBackupData.getCourseShortName());
		rightNavOperations.getAssignmentsPage().completeAssingments();
		
		logger.info("MFD-224 ::Login as student and Complete the assignment passed");
	}

}
