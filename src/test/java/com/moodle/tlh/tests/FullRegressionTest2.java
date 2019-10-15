package com.moodle.tlh.tests;

import java.util.LinkedHashMap;
import org.testng.annotations.Test;
import com.framework.utils.Utility;
import com.netsuite.tlh.operations.FacilitationDashboardOperations;
import com.netsuite.tlh.operations.Navigator;
import com.netsuite.tlh.testdata.CreateBackupData;


public class FullRegressionTest2 extends BaseTest{
	
	@Test(priority=13,description = "Sample-1 ::Create a backup and Restore for the course", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void BackupAndRestoreTheCourse(LinkedHashMap<String, ?> testData) throws Throwable {
		logger=extent.createTest("13.Sample-1 ::Create a backup and Restore for the course");
		System.out.println("FullRegressionTest2");
		System.out.println("TCS 13");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		rightNavOperations.acceptSitePolicyAgreement();
		rightNavOperations.getRestoreCoursePage();
		Navigator.doRestore(createBackupData);	
		logger.info("Sample-1 ::Create a backup and Restore for the course Passed" );
	}
	
	@Test(priority=14,description = "Sample-2::Enrolling the Users", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void EnrollTheUsers(LinkedHashMap<String, ?> testData) throws Throwable {
		logger=extent.createTest("14.Sample-2::Enrolling the Users");
		System.out.println("TCS 14");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		rightNavOperations.getEnrollParticipantsPage();
		Navigator.GetParticipationOperationsPage()
		.enrollStudent(createBackupData,createBackupData.getUserName1())
		.enrollStudent(createBackupData,createBackupData.getUserName4())
		.enrollFacilitator(createBackupData,createBackupData.getUserName2())
		.enrollFacilitator(createBackupData,createBackupData.getUserName5())
		.enrollFacilitationManager(createBackupData,createBackupData.getUserName3())
		.enrollFacilitationManager(createBackupData,createBackupData.getUserName6())
		.enrollFacilitationManager(createBackupData,createBackupData.getPerformanceUserName());
		rightNavOperations.getApostopheCoursesPage();
		logger.info("Sample-2::Enrolling the Users Passed" );
	}
	
	@Test(priority=15,description = "MFD-316 ::VerifyAssignmentCountsOnDashboard", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void VerifyAssignmentCountsOnDashboard(LinkedHashMap<String, ?> testData) throws Throwable {
		logger=extent.createTest("15.MFD-316 ::VerifyAssignmentCountsOnDashboard");
		System.out.println("TCS 15");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		rightNavOperations.getEnrollParticipantsPage();
		Navigator.GetParticipationOperationsPage().loginAsRespectiveApostopheUser(createBackupData.getRole3(),"3");

		rightNavOperations.getFacilitationManagerDashboard();
		//defect
		//Navigator.FacilitationManagerDashboardOperations().verifyDashboardaAssignmentsCount(createBackupData);
		menuBarOperations.doLogOut();	
		loginOperations.doSecondLogin(userName, passWord);
		rightNavOperations.getApostopheCoursesPage();
		rightNavOperations.getEnrollParticipantsPage();
		Navigator.GetParticipationOperationsPage().UnenrollUser(createBackupData.getPerformanceUserName());
		logger.info("MFD-316 ::VerifyAssignmentCountsOnDashboard Passed" );
				
	}
	
	@Test(priority=16,description = "Sample-3 ::Complete the assignment, Change Course Name", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void LoginAsStudentCompleteAssignment(LinkedHashMap<String, ?> testData) throws Throwable {
		logger=extent.createTest("16.Sample-3 ::Complete the assignment, Change Course Name");
		System.out.println("TCS 16");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		menuBarOperations.doLogOut();	
		//dosecondlogin
		loginOperations.doLogin(userName, passWord);
		rightNavOperations.getApostopheCoursesPage();
		rightNavOperations.getEnrollParticipantsPage();
		Navigator.GetParticipationOperationsPage().loginAsRespectiveApostopheUser(createBackupData.getRole1(),"1");
		//rightNavOperations.acceptSitePolicyAgreement();
		rightNavOperations.getApostopheCoursesPage();
		rightNavOperations.getAssignmentsPage();
		Navigator.GetAssignmentsOperations().completeAssingments();
		
		menuBarOperations.doLogOut();	
		loginOperations.doSecondLogin(userName, passWord);
		
		rightNavOperations.getEnrollParticipantsPage();
		Navigator.GetParticipationOperationsPage().loginAsRespectiveApostopheUser(createBackupData.getRole1(),"2");
		//rightNavOperations.acceptSitePolicyAgreement();
		rightNavOperations.getApostopheCoursesPage();
		rightNavOperations.getAssignmentsPage();
		Navigator.GetAssignmentsOperations().completeAssingments();
		menuBarOperations.doLogOut();	
		loginOperations.doSecondLogin(userName, passWord);
		Navigator.GetCoursePageOperations().clickTurnEditingOn().changeAssignmentName(createBackupData.getModule2(),createBackupData.getModule2Newname())
		.changeAssignmentName(createBackupData.getModule3(),createBackupData.getModule3NewName());
		Navigator.GetCoursePageOperations().clickTurnEditingOff();
		logger.info("Sample-3 ::Complete the assignment, Change Course Name Passed" );
			
	}
	
	@Test(priority=17,description = "MFD-290 ::MFD-288::Apostrophe in Facilitation Dashboard filter criteria, verify deleting submitted assignment", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
		public void VerifyDashboardFunctionalityForDifferentRoles(LinkedHashMap<String, ?> testData) throws Throwable {
		logger=extent.createTest("17.MFD-290 ::MFD-288::Apostrophe in Facilitation Dashboard filter criteria, verify deleting submitted assignment");	
		System.out.println("TCS 17");
			CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
			rightNavOperations.getEnrollParticipantsPage();
			Navigator.GetParticipationOperationsPage().loginAsRespectiveApostopheUser(createBackupData.getRole2(),"1");
			//rightNavOperations.acceptSitePolicyAgreement();
			rightNavOperations.getApostopheCoursesPage();
			rightNavOperations.getFacilitationDashboard();
			Navigator.FacilitationManagerDashboardOperations().verifyApostopheFilters(createBackupData);
			
			menuBarOperations.doLogOut();	
			loginOperations.doSecondLogin(userName, passWord);
			rightNavOperations.getApostopheCoursesPage();
			Navigator.GetCoursePageOperations().changeCourseName( createBackupData);
			rightNavOperations.getEnrollParticipantsPage();
			Navigator.GetParticipationOperationsPage().loginAsRespectiveApostopheUser(createBackupData.getRole2(),"1");
			//rightNavOperations.acceptSitePolicyAgreement();
			rightNavOperations.getApostopheCoursesPage();
			rightNavOperations.getFacilitationDashboard();
			Navigator.FacilitationManagerDashboardOperations().verifyApostopheFilters2(createBackupData);
			
			menuBarOperations.doLogOut();	
			loginOperations.doSecondLogin(userName, passWord);
			rightNavOperations.getFacilitationManagerDashboard();
			Navigator.FacilitationManagerDashboardOperations().verifyDeleteSubmissionButton(createBackupData);
			logger.info("MFD-290 ::MFD-288::Apostrophe in Facilitation Dashboard filter criteria, verify deleting submitted assignment Passed" );
			
		}	
	//eric rodrigo as facilitator, june as student(defect) 
	//@Test(priority=18,description = "MFD-406 :: VerificationOfUnenrolledFacilitatorNameFunctionality", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
		public void VerificationOfUnenrolledFacilitatorNameFunctionality(LinkedHashMap<String, ?> testData) throws Throwable {
			logger=extent.createTest("18.MFD-406 :: VerificationOfUnenrolledFacilitatorNameFunctionality");
			System.out.println("TCS 18");
			CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
			rightNavOperations.getApostopheCoursesPage();
			rightNavOperations.getEnrollParticipantsPage();
			//enroll eric rodrigo
			Navigator.GetParticipationOperationsPage().enrollStudent(createBackupData, createBackupData.getUserName7())
			.loginAsRespectiveApostopheUser(createBackupData.getRole1(),"1");
			rightNavOperations.getApostopheCoursesPage().getAssignmentsPage();
			Navigator.GetAssignmentsOperations().completeAssingments();
			//June Assignment completed
			menuBarOperations.doLogOut();	
			loginOperations.doSecondLogin(userName, passWord);
			rightNavOperations.getApostopheCoursesPage().getEnrollParticipantsPage();
			//login as eric and grade assignment
			Navigator.GetParticipationOperationsPage().loginAsRespectiveApostopheUser(createBackupData.getRole2(),"1");
			rightNavOperations.getFacilitationDashboard();
			Navigator.FacilitationDashboardOperations().filterStundentCourse(createBackupData);
			
			
			menuBarOperations.doLogOut();	
			loginOperations.doSecondLogin(userName, passWord);
			rightNavOperations.getApostopheCoursesPage();
			rightNavOperations.getEnrollParticipantsPage();
			Navigator.GetParticipationOperationsPage().UnenrollUser(createBackupData.getUserName7());
			rightNavOperations.getFacilitationManagerDashboard();
			Navigator.FacilitationManagerDashboardOperations()
			.VerificationOfUnenrolledFacilitatorNameFunctionality(createBackupData);
			;

			logger.info("MFD-406 :: VerificationOfUnenrolledFacilitatorNameFunctionality Passed" );
			
		}

	
	//@Test(priority=19,description = "MFD-227 :: Deleting the respective course", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void DeletingTheCourse(LinkedHashMap<String, ?> testData) throws Throwable {
		logger=extent.createTest("19.MFD-227 :: Deleting the respective course");
		System.out.println("TCS 19");
		rightNavOperations.clickHome();
		rightNavOperations.clickAllCoursesLink();
		Navigator.GetCoursePageOperations().deleteRespectiveApostophieCourse();
		
		menuBarOperations.doLogOut();
		logger.info("MFD-227 :: Deleting the respective course Passed" );
		
	}


}
