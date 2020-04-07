package com.moodle.Regression2;

import java.util.LinkedHashMap;
import org.testng.annotations.Test;
import com.framework.utils.Utility;
import com.moodle.tlh.tests.BaseTest;
import com.netsuite.tlh.operations.FacilitationDashboardOperations;
import com.netsuite.tlh.operations.Navigator;
import com.netsuite.tlh.testdata.CreateBackupData;


public class TCS3 extends BaseTest{
	
	@Test(description = "Sample-3 ::Complete the assignment, Change Course Name", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void LoginAsStudentCompleteAssignment(LinkedHashMap<String, ?> testData) throws Throwable {
		logger=extent.createTest("15.Sample-3 ::Complete the assignment, Change Course Name");
		System.out.println("TCS 3");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		
		rightNavOperations.searchAndGetCoursePage(createBackupData).getEnrollParticipantsPage().loginAsRespectiveApostopheUser(createBackupData.getRole1(),"1");
		rightNavOperations.searchAndGetCoursePage(createBackupData).getAssignmentsPage().completeAssingments();
		menuBarOperations.doLogOutAndLogin();	
		
		rightNavOperations.getEnrollParticipantsPage().loginAsRespectiveApostopheUser(createBackupData.getRole1(),"2");
		rightNavOperations.searchAndGetCoursePage(createBackupData).getAssignmentsPage().completeAssingments();
		menuBarOperations.doLogOutAndLogin();
		
		Navigator.GetCoursePageOperations().clickTurnEditingOn().changeAssignmentName(createBackupData.getModule2(),createBackupData.getModule2Newname())
		.changeAssignmentName(createBackupData.getModule3(),createBackupData.getModule3NewName());
		
		Navigator.GetCoursePageOperations().clickTurnEditingOff();
		logger.info("Sample-3 ::Complete the assignment, Change Course Name Passed" );
			
	}
	
}
