package com.moodle.modularisedRegression1;

import java.util.LinkedHashMap;

import org.testng.annotations.Test;

import com.framework.utils.Utility;
import com.moodle.tlh.tests.BaseTest;
import com.netsuite.tlh.operations.Navigator;
import com.netsuite.tlh.testdata.CreateBackupData;

public class Regression_TCS9_1 extends BaseTest {
	
	@Test(description = "MFD-433:: MFD-434::Verify student signoff Page Details", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void FacilitationDashboardSignOffTheAssignment(LinkedHashMap<String, ?> testData) throws Throwable {
		loggingStartReport("MFD-433:: MFD-434::Verify student signoff Page Details");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		System.out.println("9_1");
		rightNavOperations.getSignOffPage().verifySignOffPageDetails();
		
	
		
	}

}
