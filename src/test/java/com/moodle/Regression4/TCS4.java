package com.moodle.Regression4;

import java.util.LinkedHashMap;
import org.testng.annotations.Test;
import com.framework.utils.Utility;
import com.moodle.tlh.tests.BaseTest;
import com.netsuite.tlh.operations.MenuBarOperations;
import com.netsuite.tlh.operations.Navigator;
import com.netsuite.tlh.testdata.CreateBackupData;


public class TCS4 extends BaseTest{
	
	@Test(description = "MFD-487::MFD-577::VerifyNoNegativeGradesDashboardDasboardLink", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void VerifyNoNegativeGradesDashboard(LinkedHashMap<String, ?> testData) throws Throwable {
		logger=extent.createTest("MFD-487::VerifyNoNegativeGradesDashboard");
		System.out.println("4");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		
		rightNavOperations.getDashboardPage();
		rightNavOperations.getFacilitationManagerDashboard().gradeAssigment2_1(createBackupData).gradeAssigment3_1(createBackupData)
		.provideFeedbackOnFinalAssignment(createBackupData);
		
		logger.info("MFD-487 ::VerifyNoNegativeGradesDashboard passed");
	}

}
