package com.moodle.modulariseRegression3;

import java.util.LinkedHashMap;

import org.testng.annotations.Test;

import com.framework.utils.Utility;
import com.moodle.tlh.tests.BaseTest;
import com.netsuite.tlh.operations.Navigator;
import com.netsuite.tlh.testdata.CreateBackupData;

public class Regression_TCS3 extends BaseTest  {
	
	@Test(description = "MFD-536::Filter button issue after Download button hit", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void filterButtonIssueAfterDownloadButtonHit(LinkedHashMap<String, ?> testData) throws Throwable {
		loggingStartReport("MFD-531::Manage Configuration Values");
		System.out.println("2");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		//to write new code
		
		
	}

}
