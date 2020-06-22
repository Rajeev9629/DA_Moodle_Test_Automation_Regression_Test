package com.moodle.DashboardTest;

import java.util.LinkedHashMap;
import org.testng.annotations.Test;
import com.framework.utils.Utility;
import com.moodle.tlh.tests.BaseTest;
import com.netsuite.tlh.operations.Navigator;
import com.netsuite.tlh.testdata.CreateBackupData;


public class TCS6 extends BaseTest{
	
	@Test(priority=6,description = "MFD-226 :: MFD-270::MFD-259:: Sign Off the assignment, Verify the Sign Off Button,sign-off button and process", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
		public void FacilitationDashboardSignOffTheAssignment(LinkedHashMap<String, ?> testData) throws Throwable {
		loggingStartReport("MFD-226 :: MFD-270::MFD-259:: Sign Off the assignment");
			System.out.println("TCS 6");
			CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
			rightNavOperations.getFacilitationManagerDashboard().verifySignOffFunctionality().dashboardSignOff(createBackupData);		
		}

}
