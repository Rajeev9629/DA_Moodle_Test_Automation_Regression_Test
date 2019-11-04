package com.moodle.modularisedRegression1;

import java.util.LinkedHashMap;

import org.testng.annotations.Test;

import com.framework.utils.Utility;
import com.moodle.tlh.tests.BaseTest;
import com.netsuite.tlh.testdata.CreateBackupData;

public class Regression_TCS1 extends BaseTest  {
	
	@Test(description = "MFD-357 ::MFD-358 ::MFD-390 ::MFD-400:: Moodle facilitator manager report feature", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void MoodleFacilitatorManagerReportFeature(LinkedHashMap<String, ?> testData) throws Throwable {
		loggingStartReport("MFD-357 ::MFD-358 ::MFD-390 ::MFD-400:: Moodle facilitator manager report feature");
		System.out.println("1");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		rightNavOperations.acceptSitePolicyAgreement().getFacilitationManagerReportPage()
		.verifyFilters(createBackupData);
		
		
	}

}
