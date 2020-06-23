package com.moodle.Regression4;

import java.util.LinkedHashMap;
import org.testng.annotations.Test;
import com.framework.utils.Utility;
import com.moodle.tlh.tests.BaseTest;
import com.netsuite.tlh.operations.MenuBarOperations;
import com.netsuite.tlh.operations.Navigator;
import com.netsuite.tlh.testdata.CreateBackupData;


public class TCS5 extends BaseTest{
	
	@Test(description = "MFD-552::OriginalGradeFilterIsCaseSensitive", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void OriginalGradeFilterIsCaseSensitive(LinkedHashMap<String, ?> testData) throws Throwable {
		logger=extent.createTest("MFD-552::OriginalGradeFilterIsCaseSensitive");
		System.out.println("5");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		
		rightNavOperations.getFacilitationManagerDashboard().verifyMFD_552(createBackupData);
		
		logger.info("MFD-552::OriginalGradeFilterIsCaseSensitive");
	}

}
