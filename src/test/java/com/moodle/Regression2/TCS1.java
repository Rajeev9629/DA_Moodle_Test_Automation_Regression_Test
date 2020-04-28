package com.moodle.Regression2;

import java.util.LinkedHashMap;
import org.testng.annotations.Test;
import com.framework.utils.Utility;
import com.moodle.tlh.tests.BaseTest;
import com.netsuite.tlh.operations.FacilitationDashboardOperations;
import com.netsuite.tlh.operations.Navigator;
import com.netsuite.tlh.testdata.CreateBackupData;


public class TCS1 extends BaseTest{
	
	@Test(description = "Sample-1 ::Create a backup and Restore for the course", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void BackupAndRestoreTheCourse(LinkedHashMap<String, ?> testData) throws Throwable {
		logger=extent.createTest("13.Sample-1 ::Create a backup and Restore for the course");
		System.out.println("TCS 1");
		
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		rightNavOperations.getRestoreCoursePage();
		Navigator.doRestore(createBackupData);	
		rightNavOperations.clickHome();
		logger.info("Sample-1 ::Create a backup and Restore for the course Passed" );
	}
	
}
