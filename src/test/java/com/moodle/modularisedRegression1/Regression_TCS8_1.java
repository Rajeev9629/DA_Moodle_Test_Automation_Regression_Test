package com.moodle.modularisedRegression1;

import java.util.LinkedHashMap;

import org.testng.annotations.Test;

import com.framework.utils.Utility;
import com.moodle.tlh.tests.BaseTest;
import com.netsuite.tlh.operations.Navigator;
import com.netsuite.tlh.testdata.CreateBackupData;

public class Regression_TCS8_1 extends BaseTest {
	
	@Test(description = "MFD-486 :: Facilitator metrics report", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void  FacilitatorMetricsReport(LinkedHashMap<String, ?> testData) throws Throwable {
		loggingStartReport("TCS8_1:Facilitator metrics report");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		System.out.println("8");
		
		rightNavOperations.searchAndGetCoursePage(createBackupData).getEnrollParticipantsPage();
		
	}

}
