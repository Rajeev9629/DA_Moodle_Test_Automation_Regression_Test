package com.moodle.modularisedRegression1;

import java.util.LinkedHashMap;

import org.testng.annotations.Test;

import com.framework.utils.Utility;
import com.moodle.tlh.tests.BaseTest;
import com.netsuite.tlh.operations.Navigator;
import com.netsuite.tlh.testdata.CreateBackupData;

public class Regression_TCS7 extends BaseTest {
	
	@Test(description = "MFD-246 ::MFD-244::MFD-260::Verify dashboard views and functionality for different roles, Filter Criterias", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void VerifyDashboardViewsFunctionalityForDifferentRoles(LinkedHashMap<String, ?> testData) throws Throwable {
		loggingStartReport("MFD-246 ::MFD-244::MFD-260");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		System.out.println("7");
		
		//Login as Facilitator
		rightNavOperations.searchAndGetCoursePage(createBackupData).getEnrollParticipantsPage()
		.loginAsRespectiveUser(createBackupData.getRole2(),createBackupData.getUserName2());
		rightNavOperations.getFacilitationDashboard();
		Navigator.FacilitationDashboardOperations().verifyFilters(createBackupData);
		menuBarOperations.doLogOutAndLogin();
		
		//Login as Facilitation Manager
		rightNavOperations.getCoursePage(createBackupData).getEnrollParticipantsPage()
		.loginAsRespectiveUser(createBackupData.getRole3(),createBackupData.getUserName6());
		rightNavOperations.getFacilitationManagerDashboard()
		.verifyDateGradedFilter(createBackupData).verifyFilters(createBackupData);
		}	

}
