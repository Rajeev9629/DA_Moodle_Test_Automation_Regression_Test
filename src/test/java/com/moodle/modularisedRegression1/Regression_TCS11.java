package com.moodle.modularisedRegression1;

import java.util.LinkedHashMap;

import org.testng.annotations.Test;

import com.moodle.tlh.tests.BaseTest;
import com.netsuite.tlh.operations.Navigator;

public class Regression_TCS11 extends BaseTest{
	
	@Test(description = "MFD-227 :: Deleting the respective course", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void DeletingTheRespectiveCourse(LinkedHashMap<String, ?> testData) throws Throwable {
		loggingStartReport("MFD-227 :: Deleting the respective course");
		
		rightNavOperations.clickHome().clickAllCoursesLink();
		Navigator.GetCoursePageOperations().deleteRespectiveCourse();
		
	}

}
