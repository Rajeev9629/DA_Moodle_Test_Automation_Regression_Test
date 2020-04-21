package com.moodle.PerformanceTest;

import java.util.LinkedHashMap;
import org.testng.annotations.Test;
import com.framework.utils.Utility;
import com.moodle.tlh.tests.BaseTest;
import com.netsuite.tlh.operations.MenuBarOperations;
import com.netsuite.tlh.operations.Navigator;
import com.netsuite.tlh.testdata.CreateBackupData;


public class TCS6 extends BaseTest{
	
	//@Test(priority=6,description = "MFD-227 :: Deleting the respective course", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void DeletingTheRespectiveCourse(LinkedHashMap<String, ?> testData) throws Throwable {
		logger=extent.createTest("MFD-258 ::MFD-299::MFD-320::MFD-321:: Dashboard performance test script, Fetch Datat button functionality and its performance");
		System.out.println("6");
		rightNavOperations.clickHamburgerItem().clickHome().clickAllCoursesLink();
		Navigator.GetCoursePageOperations().deleteRespectiveCourse();
		logger.info("MFD-227 :: Deleting the respective course passed");
		
	}

}
