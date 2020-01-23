package com.moodle.modularisedRegression1;

import java.util.LinkedHashMap;

import org.testng.annotations.Test;

import com.framework.utils.Utility;
import com.moodle.tlh.tests.BaseTest;
import com.netsuite.tlh.operations.Navigator;
import com.netsuite.tlh.testdata.CreateBackupData;

public class CreateNormalNameCourse  extends BaseTest{
	
	@Test(description = "MFD-221 ::MFD-222 ::TLHMFD-446::Create a backup and Restore for the course,Verify FM Dashboard Link", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void CreateABackupAndRestoreTheCourse(LinkedHashMap<String, ?> testData) throws Throwable {
		loggingStartReport("MFD-221 ::MFD-222 ::Create a backup and Restore");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		
		rightNavOperations.verifyFacilitationManagerDashboard().getRestoreCoursePage();
		Navigator.doRestore(createBackupData);
		rightNavOperations.clickHome();
		
		
	}

}
