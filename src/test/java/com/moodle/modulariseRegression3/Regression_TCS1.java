package com.moodle.modulariseRegression3;

import java.util.LinkedHashMap;

import org.testng.annotations.Test;

import com.framework.utils.Utility;
import com.moodle.tlh.tests.BaseTest;
import com.netsuite.tlh.operations.Navigator;
import com.netsuite.tlh.testdata.CreateBackupData;

public class Regression_TCS1 extends BaseTest  {
	
	@Test(description = "MFD-494::Case Sensitivity Facilitation Dashboard", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void CaseSensitivityFacilitationDashboard(LinkedHashMap<String, ?> testData) throws Throwable {
		loggingStartReport("Regression_TCS1:MFD-494 ::CaseSensitivityFacilitationDashboard");
		System.out.println("1");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		
		
		
	}

}
