package com.moodle.SmokeTest;

import java.util.LinkedHashMap;
import org.testng.annotations.Test;

import com.framework.utils.Utility;
import com.moodle.tlh.tests.BaseTest;
import com.netsuite.tlh.operations.Navigator;
import com.netsuite.tlh.testdata.CreateBackupData;

public class SmokeTest extends BaseTest{
	
	@Test(priority=1,description = "MFD-000 ::SmokeTest", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void VerifyDashBoard(LinkedHashMap<String, ?> testData) throws Throwable {
		System.out.println("1");
		loggingStartReport("MFD-000 ::SmokeTest");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		
		rightNavOperations.getFacilitationManagerDashboard();
		Navigator.FacilitationManagerDashboardOperations().SmokeTest(createBackupData);
			
	}
	
	
}
