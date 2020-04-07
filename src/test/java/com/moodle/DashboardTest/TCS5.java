package com.moodle.DashboardTest;

import java.util.LinkedHashMap;
import org.testng.annotations.Test;
import com.framework.utils.Utility;
import com.moodle.tlh.tests.BaseTest;
import com.netsuite.tlh.operations.Navigator;
import com.netsuite.tlh.testdata.CreateBackupData;


public class TCS5 extends BaseTest{
	
	@Test(priority=5,description = "MFD-225 ::MFD-245::MFD-267::Facilitation Dashboard :Grading,Verify Rubic View, Grading Filters", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void FacilitationDashboardGradingTheAssignment(LinkedHashMap<String, ?> testData) throws Throwable {
		loggingStartReport("MFD-225 ::MFD-245::MFD-267::Facilitation Dashboar");
		System.out.println("TCS 5");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		
		rightNavOperations.searchAndGetCoursePage(createBackupData).getFacilitationManagerDashboard().gradeAssigment(createBackupData);	
		
	}

}
