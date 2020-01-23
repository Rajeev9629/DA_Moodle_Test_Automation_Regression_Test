package com.moodle.modularisedRegression1;

import java.util.LinkedHashMap;

import org.testng.annotations.Test;

import com.framework.utils.Utility;
import com.moodle.tlh.tests.BaseTest;
import com.netsuite.tlh.operations.Navigator;
import com.netsuite.tlh.testdata.CreateBackupData;

public class Regression_TCS3 extends BaseTest{
	
	@Test(description = "MFD-266 ::Activity completion settings for the course", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void ActivityCompletionSettingsforCourse(LinkedHashMap<String, ?> testData) throws Throwable {
		loggingStartReport("TCS3:MFD-266 ::Activity completion settings for the courses");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		System.out.println("3");
		
		rightNavOperations.searchAndGetCoursePage(createBackupData);
		Navigator.GetCoursePageOperations().clickTurnEditingOn().
		doActivityCompletion(createBackupData.getModule2(),createBackupData)
		.doActivityCompletion(createBackupData.getModule3(),createBackupData)
		.doActivityCompletion(createBackupData.getFinalProjectSubmission(),createBackupData)
		.doParticipationAcknowledgement(createBackupData.getParticipationAcknowledgement(),createBackupData);
		rightNavOperations.clickCourseCompletion();
		Navigator.GetCoursePageOperations().doCourseCompletion(createBackupData).clickTurnEditingOff();
		
	}

}
