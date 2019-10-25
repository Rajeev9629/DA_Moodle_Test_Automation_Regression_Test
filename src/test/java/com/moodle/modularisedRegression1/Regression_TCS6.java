package com.moodle.modularisedRegression1;

import java.util.LinkedHashMap;

import org.testng.annotations.Test;

import com.framework.utils.Utility;
import com.moodle.tlh.tests.BaseTest;
import com.netsuite.tlh.operations.Navigator;
import com.netsuite.tlh.testdata.CreateBackupData;

public class Regression_TCS6 extends BaseTest{
	
	@Test(description = "MFD-268 :: CourseCheckpointsAlongWithFilters", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void CourseCheckpointsAlongWithFilters(LinkedHashMap<String, ?> testData) throws Throwable {
		loggingStartReport("MFD-268 :: CourseCheckpointsAlongWithFilters");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		
		rightNavOperations.searchAndGetCoursePage(createBackupData).getEnrollParticipantsPage()
		.loginAsRespectiveUser(createBackupData.getRole1(),createBackupData.getUserName1());
		Navigator.GetCoursePageOperations().verifyCheckPoints();
		menuBarOperations.doLogOutAndLogin();
		rightNavOperations.getEnrollParticipantsPage().loginAsRespectiveUser(createBackupData.getRole2(),createBackupData.getUserName2());
		rightNavOperations.getFacilitationDashboard();
		Navigator.FacilitationManagerDashboardOperations().verifyResubmittedAssignment(createBackupData).gradeAssigment2(createBackupData);
		menuBarOperations.doLogOutAndLogin();
		
		rightNavOperations.searchAndGetCoursePage(createBackupData).getEnrollParticipantsPage()
		.getStudentName(createBackupData);
		rightNavOperations.getFacilitationManagerDashboard().verifyOriginalGraderFilter(createBackupData)
		.verifyCourseCodeFilter(createBackupData);
		
	}
	

}
