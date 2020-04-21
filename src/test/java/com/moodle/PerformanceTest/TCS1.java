package com.moodle.PerformanceTest;

import java.util.LinkedHashMap;
import org.testng.annotations.Test;
import com.framework.utils.Utility;
import com.moodle.tlh.tests.BaseTest;
import com.netsuite.tlh.operations.MenuBarOperations;
import com.netsuite.tlh.operations.Navigator;
import com.netsuite.tlh.testdata.CreateBackupData;


public class TCS1 extends BaseTest{
	
	@Test(description = "MFD-221 ::MFD-222 ::Create a backup and Restore for the course", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void CreateABackupAndRestoreTheCourse(LinkedHashMap<String, ?> testData) throws Throwable {
		logger=extent.createTest("MFD-221 ::MFD-222 ::Create a backup and Restore for the course");
		System.out.println("1");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		//rightNavOperations.acceptSitePolicyAgreement();
		rightNavOperations.getRestoreCoursePage();
		Navigator.doRestore(createBackupData);	
		logger.info("MFD-221 ::MFD-222 ::Create a backup and Restore for the course Passed" );
	}

}
