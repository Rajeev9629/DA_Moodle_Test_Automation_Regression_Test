package com.moodle.modularisedRegression1;

import java.util.LinkedHashMap;

import org.testng.annotations.Test;

import com.framework.utils.Utility;
import com.moodle.tlh.tests.BaseTest;
import com.netsuite.tlh.operations.Navigator;
import com.netsuite.tlh.testdata.CreateBackupData;

public class Regression_TCS10 extends BaseTest{
	
	@Test(description = "MFD-319::VerifyRubricView", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void VerifyRubricView(LinkedHashMap<String, ?> testData) throws Throwable {
		loggingStartReport("TCS10:MFD-319::VerifyRubricView");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		System.out.println("10");
		//Facilitation Manager
		rightNavOperations.getFacilitationManagerDashboard().verifyRubricGrades(createBackupData);
		//Facilitator
		rightNavOperations.searchAndGetCoursePage(createBackupData).getEnrollParticipantsPage()
		.loginAsRespectiveUser(createBackupData.getRole2(), createBackupData.getUserName2());
		rightNavOperations.getFacilitationDashboard();
		Navigator.FacilitationManagerDashboardOperations().verifyRubricGrades(createBackupData);
		
			
	}

}
