package com.moodle.DashboardTest;

import java.util.LinkedHashMap;
import org.testng.annotations.Test;
import com.framework.utils.Utility;
import com.moodle.tlh.tests.BaseTest;
import com.netsuite.tlh.operations.Navigator;
import com.netsuite.tlh.testdata.CreateBackupData;


public class TCS7 extends BaseTest{
	
	@Test(priority=7,description = "MFD-227 :: Deleting the respective course", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void DeletingTheRespectiveCourse(LinkedHashMap<String, ?> testData) throws Throwable {
		loggingStartReport("MFD-227 :: Deleting the respective course");
		System.out.println("TCS 7");
		
		rightNavOperations.clickAllCoursesLink();
		Navigator.GetCoursePageOperations().deleteRespectiveCourse();
		
	}

}
