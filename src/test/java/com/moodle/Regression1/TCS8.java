package com.moodle.Regression1;

import java.util.LinkedHashMap;

import org.testng.annotations.Test;

import com.framework.utils.Utility;
import com.moodle.tlh.tests.BaseTest;
import com.netsuite.tlh.operations.Navigator;
import com.netsuite.tlh.testdata.CreateBackupData;

public class TCS8 extends BaseTest {
	
	@Test(description = "MFD-269 ::Module 5: Student/FacilitatorAndFacilitationManagerFunctionality", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void  StudentFacilitatorAndFacilitationManagerFunctionality(LinkedHashMap<String, ?> testData) throws Throwable {
		loggingStartReport("TCS8:Regression_TCS8:MFD-269");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		System.out.println("8");
		
		rightNavOperations.searchAndGetCoursePage(createBackupData).getEnrollParticipantsPage()
		.enrollStudent(createBackupData,createBackupData.getUserName4()).loginAsRespectiveUser(createBackupData.getRole1(),createBackupData.getUserName4(),createBackupData.getCourseShortName());
		rightNavOperations.getAssignmentsPage().completeAssingmentModule2().completeAssingmentModule3();	
		menuBarOperations.doLogOutAndLogin();
		
		rightNavOperations.searchAndGetCoursePage(createBackupData).getEnrollParticipantsPage()
		.loginAsRespectiveUser(createBackupData.getRole2(),createBackupData.getUserName5(),createBackupData.getCourseShortName());
		rightNavOperations.getFacilitationDashboard();
		Navigator.FacilitationManagerDashboardOperations().gradeAssigment3(createBackupData);
		menuBarOperations.doLogOutAndLogin();
		rightNavOperations.getCoursePage(createBackupData).getEnrollParticipantsPage().UnenrollUser(createBackupData.getUserName5())
		.loginAsRespectiveUser(createBackupData.getRole2(),createBackupData.getUserName2(),createBackupData.getCourseShortName());
		rightNavOperations.getFacilitationDashboard();
		Navigator.FacilitationManagerDashboardOperations().verifyAssignmentIsGraded(createBackupData);
		menuBarOperations.doLogOutAndLogin();
		rightNavOperations.getFacilitationManagerDashboard().verifyDateGradedFilter(createBackupData).verifyGrader(createBackupData);
			
	}

}
