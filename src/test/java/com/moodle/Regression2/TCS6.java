package com.moodle.Regression2;

import java.util.LinkedHashMap;
import org.testng.annotations.Test;
import com.framework.utils.Utility;
import com.moodle.tlh.tests.BaseTest;
import com.netsuite.tlh.operations.FacilitationDashboardOperations;
import com.netsuite.tlh.operations.Navigator;
import com.netsuite.tlh.testdata.CreateBackupData;


public class TCS6 extends BaseTest{
		
	//eric rodrigo as facilitator, june as student(defect) 
	@Test(description = "MFD-406 :: VerificationOfUnenrolledFacilitatorNameFunctionality", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
		public void VerificationOfUnenrolledFacilitatorNameFunctionality(LinkedHashMap<String, ?> testData) throws Throwable {
			logger=extent.createTest("MFD-406 :: VerificationOfUnenrolledFacilitatorNameFunctionality");
			System.out.println("TCS 6");
			CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
			
			//enroll eric rodrigo
			rightNavOperations.searchAndGetNewCoursePage(createBackupData,createBackupData.getCourseName2()).getEnrollParticipantsPage().enrollFacilitator(createBackupData, createBackupData.getUserName8()).enrollStudent(createBackupData, createBackupData.getUserName7()).loginAsRespectiveApostopheUser(createBackupData.getRole1(),"1");
			rightNavOperations.searchAndGetNewCoursePage(createBackupData,createBackupData.getCourseName2()).getApostopheCoursesPage().getAssignmentsPage().completeAssingments();
			//June Assignment completed
			menuBarOperations.doLogOutAndLogin();
			//login as eric and grade assignment
			rightNavOperations.searchAndGetNewCoursePage(createBackupData,createBackupData.getCourseName2()).getEnrollParticipantsPage().loginAsRespectiveApostopheUser(createBackupData.getRole2(),"1");
			rightNavOperations.getFacilitationDashboard();
			Navigator.FacilitationDashboardOperations().filterStundentCourse(createBackupData);
				
			menuBarOperations.doLogOutAndLogin();
			
			rightNavOperations.searchAndGetNewCoursePage(createBackupData,createBackupData.getCourseName2()).getEnrollParticipantsPage().UnenrollUser(createBackupData.getUserName8());
			rightNavOperations.getFacilitationManagerDashboard();
			Navigator.FacilitationManagerDashboardOperations().VerificationOfUnenrolledFacilitatorNameFunctionality(createBackupData);
			

			logger.info("MFD-406 :: VerificationOfUnenrolledFacilitatorNameFunctionality Passed" );
			
		}
}
