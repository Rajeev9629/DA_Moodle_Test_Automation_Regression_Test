package com.moodle.Regression3;

import java.util.LinkedHashMap;

import org.testng.annotations.Test;

import com.framework.utils.Utility;
import com.moodle.tlh.tests.BaseTest;
import com.netsuite.tlh.operations.Navigator;
import com.netsuite.tlh.testdata.CreateBackupData;

public class Regression_TCS1 extends BaseTest  {
	
	@Test(description = "MFD-505::Issue with grades not saving to the dashboard", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void IssueWithGradesNotSavingToDashboard(LinkedHashMap<String, ?> testData) throws Throwable {
		loggingStartReport("MFD-505::IssueWithGradesNotSavingToDashboard");
		System.out.println("1");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		rightNavOperations.getRestoreCoursePage();
		Navigator.doRestore(createBackupData);
		
		rightNavOperations.getEnrollParticipantsPage()
		.enrollStudent(createBackupData,createBackupData.getUserName1())
		.enrollFacilitator(createBackupData,createBackupData.getUserName2())
		.enrollFacilitationManager(createBackupData,createBackupData.getUserName3());
		
		rightNavOperations.getEnrollParticipantsPage()
		.loginAsRespectiveUser(createBackupData.getRole1(),createBackupData.getUserName1(),createBackupData.getCourseShortName());
		rightNavOperations.getAssignmentsPage().completeAssingments();
		
		menuBarOperations.doLogOut();	
		loginOperations.doSecondLogin(userName, passWord);
		rightNavOperations.getEnrollParticipantsPage();
		Navigator.GetParticipationOperationsPage().loginAsRespectiveApostopheUser(createBackupData.getRole2(),"1");
		rightNavOperations.getFacilitationDashboard();
		Navigator.FacilitationManagerDashboardOperations().gradeAssigmentRegression4(createBackupData);
		;
		
		
	}

}
