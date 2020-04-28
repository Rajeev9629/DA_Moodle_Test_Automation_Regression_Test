package com.moodle.PerformanceTest;

import java.util.LinkedHashMap;
import org.testng.annotations.Test;
import com.framework.utils.Utility;
import com.moodle.tlh.tests.BaseTest;
import com.netsuite.tlh.operations.MenuBarOperations;
import com.netsuite.tlh.operations.Navigator;
import com.netsuite.tlh.testdata.CreateBackupData;


public class TCS4 extends BaseTest{
	

	@Test(description = "MFD-258 ::MFD-299::MFD-320::MFD-321:: Dashboard performance test script, Fetch Datat button functionality and its performance", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
		public void DashboardPerformanceTestScript(LinkedHashMap<String, ?> testData) throws Throwable {
		logger=extent.createTest("MFD-258 ::MFD-299::MFD-320::MFD-321:: Dashboard performance test script, Fetch Datat button functionality and its performance");
		System.out.println("4");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		
		rightNavOperations.searchAndGetCoursePage(createBackupData).getEnrollParticipantsPage().loginAsRespectiveUser(createBackupData.getRole3(),createBackupData.getPerformanceUserName(),createBackupData.getCourseShortName());
		rightNavOperations.getFacilitationManagerDashboard().getLoadingDashboardPerformance()
		.getRefreshDashboardPerformance()
		.getGradedFilterDashboardPerformance(createBackupData)
			;	
		logger.info("MFD-258 ::MFD-299::MFD-320::MFD-321:: Dashboard performance test script, Fetch Datat button functionality and its performance passed");
		}

}
