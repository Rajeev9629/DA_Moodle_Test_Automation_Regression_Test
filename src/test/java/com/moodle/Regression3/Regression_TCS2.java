package com.moodle.Regression3;

import java.util.LinkedHashMap;

import org.testng.annotations.Test;

import com.framework.utils.Utility;
import com.moodle.tlh.tests.BaseTest;
import com.netsuite.tlh.operations.Navigator;
import com.netsuite.tlh.testdata.CreateBackupData;

public class Regression_TCS2 extends BaseTest  {
	
	@Test(description = "MFD-531::Manage Configuration Values", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void ManageConfigurationValues(LinkedHashMap<String, ?> testData) throws Throwable {
		loggingStartReport("MFD-531::Manage Configuration Values");
		System.out.println("2");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		rightNavOperations.getManageConfigurationValuePage().verifyManageConfigPage();
		
		
	}

}
