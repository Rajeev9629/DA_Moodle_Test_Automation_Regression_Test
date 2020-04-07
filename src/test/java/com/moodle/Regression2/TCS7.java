package com.moodle.Regression2;

import java.util.LinkedHashMap;
import org.testng.annotations.Test;
import com.framework.utils.Utility;
import com.moodle.tlh.tests.BaseTest;
import com.netsuite.tlh.operations.FacilitationDashboardOperations;
import com.netsuite.tlh.operations.Navigator;
import com.netsuite.tlh.testdata.CreateBackupData;


public class TCS7 extends BaseTest{
	
		@Test(description = "MFD-495::MFD-498::Sign-off button doesn't populate when assignments graded out of order, ParticipationAgreement", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
		public void SignOffButtonNotPopulateWhenAssignmentsgradedoutOfOrder(LinkedHashMap<String, ?> testData) throws Throwable {
			logger=extent.createTest("MFD-495::Sign-off button doesn't populate when assignments graded out of order");
			System.out.println("TCS 7");
			CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
			rightNavOperations.getFacilitationManagerDashboard().gradeFinalAsignment(createBackupData).gradeAssigment3_1(createBackupData)
			.gradeAssigment2_1(createBackupData)
			.verifySignOfButtonMFD_495(createBackupData);
			
			//participationAgreement
			rightNavOperations.searchAndGetNewCoursePage(createBackupData,createBackupData.getCourseName2());
			Navigator.GetCoursePageOperations().clickTurnEditingOn().changeParticipationAcknowledgementName().clickTurnEditingOff();
			
			
			
			logger.info("MFD-495::SignOffButtonNotPopulateWhenAssignmentsgradedoutOfOrder Passed" );
			
		}

}
