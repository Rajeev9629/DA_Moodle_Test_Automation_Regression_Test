package com.moodle.modularisedRegression1;

import java.util.LinkedHashMap;

import org.testng.annotations.Test;

import com.framework.utils.Utility;
import com.moodle.tlh.tests.BaseTest;
import com.netsuite.tlh.operations.Navigator;
import com.netsuite.tlh.testdata.CreateBackupData;

public class Regression_TCS6 extends BaseTest{
	
	@Test(description = "MFD-268::MFD-496:: CourseCheckpointsAlongWithFilters", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void CourseCheckpointsAlongWithFilters(LinkedHashMap<String, ?> testData) throws Throwable {
		loggingStartReport("TCS6:MFD-268 :: CourseCheckpointsAlongWithFilters");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		System.out.println("6");
		
		rightNavOperations.searchAndGetCoursePage(createBackupData).getEnrollParticipantsPage()
		.loginAsRespectiveUser(createBackupData.getRole1(),createBackupData.getUserName1(),createBackupData.getCourseShortName());
		Navigator.GetCoursePageOperations().verifyCheckPoints();
		menuBarOperations.doLogOutAndLogin();
		rightNavOperations.getEnrollParticipantsPage().loginAsRespectiveUser(createBackupData.getRole2(),createBackupData.getUserName2(),createBackupData.getCourseShortName());
		rightNavOperations.getFacilitationDashboard();
		Navigator.FacilitationManagerDashboardOperations().verifyResubmittedAssignment(createBackupData).gradeAssigment2(createBackupData);
		menuBarOperations.doLogOutAndLogin();
		
		rightNavOperations.searchAndGetCoursePage(createBackupData).getEnrollParticipantsPage().getStudentName(createBackupData);
		rightNavOperations.getFacilitationManagerDashboard().verifyOriginalGraderFilter(createBackupData)
		.verifyCourseCodeFilter(createBackupData);
		
	}
	

}
