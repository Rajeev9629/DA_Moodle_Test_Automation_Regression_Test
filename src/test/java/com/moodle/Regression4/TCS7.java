package com.moodle.Regression4;

import java.util.LinkedHashMap;

import org.testng.annotations.Test;

import com.framework.utils.Utility;
import com.moodle.tlh.tests.BaseTest;
import com.netsuite.tlh.operations.Navigator;
import com.netsuite.tlh.testdata.CreateBackupData;

public class TCS7 extends BaseTest{
	
	@Test(priority=6,description = "MFD-4_0 :: Deleting the respective course", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void DeletingTheRespectiveCourse(LinkedHashMap<String, ?> testData) throws Throwable {
		logger=extent.createTest("MFD-3_0 :: Deleting the respective course");
		System.out.println("7");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		Navigator.GetCoursePageOperations().deleteRespectiveCourse(createBackupData.getCourseName());
		logger.info("MFD-227 :: Deleting the respective course passed");
		
	}

}
