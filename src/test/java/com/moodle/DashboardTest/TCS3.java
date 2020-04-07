package com.moodle.DashboardTest;

import java.util.LinkedHashMap;
import org.testng.annotations.Test;
import com.framework.utils.Utility;
import com.moodle.tlh.tests.BaseTest;
import com.netsuite.tlh.operations.Navigator;
import com.netsuite.tlh.testdata.CreateBackupData;


public class TCS3 extends BaseTest{
	
	@Test(priority=3,description = "MFD-266 ::Activity completion settings for the course", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void ActivityCompletionSettingsforCourse(LinkedHashMap<String, ?> testData) throws Throwable {
		loggingStartReport("MFD-266 ::Activity completion settings for the course\"");
		System.out.println("TCS 3");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		
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
