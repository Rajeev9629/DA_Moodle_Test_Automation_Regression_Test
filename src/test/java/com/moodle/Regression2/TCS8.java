package com.moodle.Regression2;

import java.util.LinkedHashMap;

import org.testng.annotations.Test;

import com.framework.utils.Utility;
import com.moodle.tlh.tests.BaseTest;
import com.netsuite.tlh.operations.Navigator;
import com.netsuite.tlh.testdata.CreateBackupData;

public class TCS8 extends BaseTest{
	
	@Test(description = "MFD-319::MFD-516::VerifyRubricView", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void VerifyRubricView(LinkedHashMap<String, ?> testData) throws Throwable {
		loggingStartReport("MFD-319::VerifyRubricView");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		System.out.println("TCS 8");
		//complete Quiz
		rightNavOperations.searchAndGetNewCoursePage(createBackupData,createBackupData.getCourseName2()).getEnrollParticipantsPage().loginAsRespectiveApostopheUser(createBackupData.getRole1(),"2");
		rightNavOperations.searchAndGetNewCoursePage(createBackupData,createBackupData.getCourseName2()).getQuizzesPage();
		Navigator.GetCoursePageOperations().completeParticipationAgreement();
		menuBarOperations.doLogOutAndLogin();
		
		//Facilitation Manager
		rightNavOperations.getFacilitationManagerDashboard().verifyRubricGradesAnd516(createBackupData);
		
		//Facilitator
		rightNavOperations.searchAndGetNewCoursePage(createBackupData,createBackupData.getCourseName2()).getEnrollParticipantsPage()
		.loginAsRespectiveApostopheUser(createBackupData.getRole2(),"1");
		rightNavOperations.getFacilitationDashboard();
		Navigator.FacilitationManagerDashboardOperations().verifyRubricGradesAnd516(createBackupData);
		
		
		
		
			
	}

}
