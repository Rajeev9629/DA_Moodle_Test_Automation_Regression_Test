package com.moodle.Regression2;

import java.util.LinkedHashMap;
import org.testng.annotations.Test;
import com.framework.utils.Utility;
import com.moodle.tlh.tests.BaseTest;
import com.netsuite.tlh.operations.FacilitationDashboardOperations;
import com.netsuite.tlh.operations.Navigator;
import com.netsuite.tlh.testdata.CreateBackupData;


public class TCS9 extends BaseTest{
	
	//@Test(description = "MFD-227 :: Deleting the respective course", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	  public void DeletingTheCourse(LinkedHashMap<String, ?> testData) throws Throwable {
		logger=extent.createTest("MFD-227 :: Deleting the respective course");
		System.out.println("TCS 8");
		rightNavOperations.clickHome().clickAllCoursesLink();
		Navigator.GetCoursePageOperations().deleteRespectiveApostophieCourse();
		logger.info("MFD-227 :: Deleting the respective course Passed" );
		
	}


}
