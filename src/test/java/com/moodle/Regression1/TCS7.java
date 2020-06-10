package com.moodle.Regression1;

import java.util.LinkedHashMap;

import org.testng.annotations.Test;

import com.framework.utils.Utility;
import com.moodle.tlh.tests.BaseTest;
import com.netsuite.tlh.operations.Navigator;
import com.netsuite.tlh.testdata.CreateBackupData;

public class TCS7 extends BaseTest {
	
	@Test(description = "MFD-246 ::MFD-244::MFD-260::MFD-494::MFD-576::Verify dashboard views and functionality for different roles, Filter Criterias", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void VerifyDashboardViewsFunctionalityForDifferentRoles(LinkedHashMap<String, ?> testData) throws Throwable {
		loggingStartReport("TCS7:MFD-246 ::MFD-244::MFD-260");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		System.out.println("7");
		
		//Login as Facilitator
		rightNavOperations.searchAndGetCoursePage(createBackupData).getEnrollParticipantsPage()
		.loginAsRespectiveUser(createBackupData.getRole2(),createBackupData.getUserName2(),createBackupData.getCourseShortName());
		rightNavOperations.getFacilitationDashboard();
		Navigator.FacilitationDashboardOperations().verifyFilters(createBackupData);
		menuBarOperations.doLogOutAndLogin();
		
		//Login as Facilitation Manager
		rightNavOperations.searchAndGetCoursePage(createBackupData).getEnrollParticipantsPage()
		.loginAsRespectiveUser(createBackupData.getRole3(),createBackupData.getUserName6(),createBackupData.getCourseShortName());
		rightNavOperations.getFacilitationManagerDashboard()
		.verifyDateGradedFilter(createBackupData).verifyFilters(createBackupData)
		.verifyCaseSensitiveFilters(createBackupData)
		;
		}	

}
