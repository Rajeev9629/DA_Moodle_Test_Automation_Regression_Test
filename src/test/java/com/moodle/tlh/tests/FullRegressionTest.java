package com.moodle.tlh.tests;

import java.util.LinkedHashMap;
import org.testng.annotations.Test;
import com.framework.utils.Utility;
import com.netsuite.tlh.operations.Navigator;
import com.netsuite.tlh.testdata.CreateBackupData;


public class FullRegressionTest extends BaseTest{
	
	
	//@Test(priority=1,description = "MFD-357 ::MFD-358 ::MFD-390 ::MFD-400:: Moodle facilitator manager report feature", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void MoodleFacilitatorManagerReportFeature(LinkedHashMap<String, ?> testData) throws Throwable {
		logger=extent.createTest("1.MFD-357 ::MFD-358 ::Moodle facilitator manager report feature");
		System.out.println("FullRegressionTest1");
		System.out.println("TCS 1");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		rightNavOperations.acceptSitePolicyAgreement();
		
		rightNavOperations.getFacilitationManagerReportPage();
		Navigator.FacilitationManagerReportOperations().verifyFilters(createBackupData);
		rightNavOperations.clickHome();
		//download csv code
		
		
		logger.info("MFD-357 ::MFD-358 ::Moodle facilitator manager report feature Passed" );
		
	}
	
	//@Test(priority=2,description = "MFD-221 ::MFD-222 ::Create a backup and Restore for the course", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void CreateABackupAndRestoreTheCourse(LinkedHashMap<String, ?> testData) throws Throwable {
		logger=extent.createTest("2.MFD-221 ::MFD-222 ::Create a backup and Restore for the course");
		System.out.println("TCS 2");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		
		rightNavOperations.getRestoreCoursePage();
		Navigator.doRestore(createBackupData);	
		logger.pass("Course has been created succesfully");
		logger.info("MFD-221 ::MFD-222 ::Create a backup and Restore for the course Passed" );
		
	}
	
	//@Test(priority=3,description = "MFD-223 ::MFD-264 ::Enrolling the Users", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void EnrollingTheUsers(LinkedHashMap<String, ?> testData) throws Throwable {
		logger=extent.createTest("3.MFD-223 ::MFD-264 ::Enrolling the Users");
		System.out.println("TCS 3");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		rightNavOperations.getEnrollParticipantsPage();
		Navigator.GetParticipationOperationsPage().enrollStudent(createBackupData,createBackupData.getUserName1())
		.enrollFacilitator(createBackupData,createBackupData.getUserName2())
		.enrollFacilitator(createBackupData,createBackupData.getUserName5())
		.enrollFacilitationManager(createBackupData,createBackupData.getUserName3())
		.enrollFacilitationManager(createBackupData,createBackupData.getUserName6());
		//.clickOnRespectiveCourseFromLeftNav(createBackupData);	
		
		logger.info("MFD-223 ::MFD-264 ::Enrolling the Users Passed" );
	}
	
	//@Test(priority=4,description = "MFD-266 ::Activity completion settings for the course", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void ActivityCompletionSettingsforCourse(LinkedHashMap<String, ?> testData) throws Throwable {
		logger=extent.createTest("4.MFD-266 ::Activity completion settings for the course");
		System.out.println("TCS 4");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		
		Navigator.GetParticipationOperationsPage().clickOnRespectiveCourseFromLeftNav(createBackupData);
		Navigator.GetCoursePageOperations().clickTurnEditingOn().
		doActivityCompletion(createBackupData.getModule2(),createBackupData)
		.doActivityCompletion(createBackupData.getModule3(),createBackupData)
		.doActivityCompletion(createBackupData.getFinalProjectSubmission(),createBackupData)
		.doParticipationAcknowledgement(createBackupData.getParticipationAcknowledgement(),createBackupData);
		rightNavOperations.clickCourseCompletion();
		Navigator.GetCoursePageOperations().doCourseCompletion(createBackupData).clickTurnEditingOff();
		logger.info("MFD-266 ::Activity completion settings for the course has been Completed" );
		
	}
	
	
	//@Test(priority=5,description = "MFD-224 ::Login as student and Complete the assignment", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void LoginAsStudentAndCompleteAssignment(LinkedHashMap<String, ?> testData) throws Throwable {
		logger=extent.createTest("5.MFD-224 ::Login as student and Complete the assignment");
		System.out.println("TCS 5");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		rightNavOperations.getEnrollParticipantsPage();
		Navigator.GetParticipationOperationsPage().loginAsRespectiveUser(createBackupData.getRole1(),createBackupData.getUserName1());
		rightNavOperations.acceptSitePolicyAgreement().getCoursePage(createBackupData).getAssignmentsPage();
		Navigator.GetAssignmentsOperations().completeAssingments();
		rightNavOperations.getCoursePage(createBackupData);
		menuBarOperations.doLogOutAndLogin();
		
		logger.info("MFD-224 ::Login as student and Complete the assignment Passed" );
		
	}
	
	//@Test(priority=6,description = "MFD-225 ::MFD-245::MFD-267::MFD-356 ::Facilitation Dashboard :Grading,Verify Rubic View, Grading Filters,verifyCreatedAndUpdatedDate", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void FacilitationDashboardGradingTheAssignment(LinkedHashMap<String, ?> testData) throws Throwable {
		logger=extent.createTest("6.MFD-357 ::MFD-358 ::Moodle facilitator manager report feature");
		System.out.println("TCS 6");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		
		rightNavOperations.getFacilitationManagerDashboard();
		Navigator.FacilitationManagerDashboardOperations().gradeAssigment(createBackupData).verifyCreatedAndUpdatedDate();	
		logger.info("MFD-225 ::MFD-245::MFD-267::MFD-356 ::Facilitation Dashboard :Grading,Verify Rubic View, Grading Filters,verifyCreatedAndUpdatedDate Passed" );
		
	}
	
	
	@Test(priority=7,description = "MFD-268 :: CourseCheckpointsAlongWithFilters", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void CourseCheckpointsAlongWithFilters(LinkedHashMap<String, ?> testData) throws Throwable {
		logger=extent.createTest("7.MFD-268 :: CourseCheckpointsAlongWithFilters");
		System.out.println("TCS 7");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		
		rightNavOperations.getCoursePage(createBackupData).getEnrollParticipantsPage();
		Navigator.GetParticipationOperationsPage().loginAsRespectiveUser(createBackupData.getRole1(),createBackupData.getUserName1());
		Navigator.GetCoursePageOperations().verifyCheckPoints();
		menuBarOperations.doLogOutAndLogin();
		rightNavOperations.getEnrollParticipantsPage();
		Navigator.GetParticipationOperationsPage().loginAsRespectiveUser(createBackupData.getRole2(),createBackupData.getUserName2());
		rightNavOperations.getFacilitationDashboard();
		Navigator.FacilitationManagerDashboardOperations().verifyResubmittedAssignment(createBackupData).gradeAssigment2(createBackupData);
		menuBarOperations.doLogOutAndLogin();
		
		rightNavOperations.getCoursePage(createBackupData).getEnrollParticipantsPage();
		rightNavOperations.getEnrollParticipantsPage();
		Navigator.GetParticipationOperationsPage().getStudentName(createBackupData);
		rightNavOperations.getFacilitationManagerDashboard();
		Navigator.FacilitationManagerDashboardOperations().verifyOriginalGraderFilter(createBackupData)
		.verifyCourseCodeFilter(createBackupData);
		logger.info("MFD-268 :: CourseCheckpointsAlongWithFilters Passed" );
	}
	
	@Test(priority=8,description = "MFD-246 ::MFD-244::MFD-260::Verify dashboard views and functionality for different roles, Filter Criterias", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
		public void VerifyDashboardViewsFunctionalityForDifferentRoles(LinkedHashMap<String, ?> testData) throws Throwable {
		logger=extent.createTest("8.MFD-246 ::MFD-244::MFD-260::Verify dashboard views and functionality for different roles, Filter Criterias");	
		System.out.println("TCS 8");
			CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
			
			//Login as Facilitator
			rightNavOperations.getCoursePage(createBackupData).getEnrollParticipantsPage();
			Navigator.GetParticipationOperationsPage().loginAsRespectiveUser(createBackupData.getRole2(),createBackupData.getUserName2());
			rightNavOperations.getFacilitationDashboard();
			
			Navigator.FacilitationDashboardOperations().verifyFilters(createBackupData);
			menuBarOperations.doLogOutAndLogin();
			
			//Login as Facilitation Manager
			rightNavOperations.getCoursePage(createBackupData).getEnrollParticipantsPage();
			Navigator.GetParticipationOperationsPage().loginAsRespectiveUser(createBackupData.getRole3(),createBackupData.getUserName6());
			rightNavOperations.getFacilitationManagerDashboard();
			Navigator.FacilitationManagerDashboardOperations().verifyDateGradedFilter(createBackupData).verifyFilters(createBackupData);
			menuBarOperations.doLogOutAndLogin();
			logger.info("MFD-246 ::MFD-244::MFD-260::Verify dashboard views and functionality for different roles, Filter Criterias Passed" );
		}	
		
	@Test(priority=9,description = "MFD-269 ::Module 5: Student/FacilitatorAndFacilitationManagerFunctionality", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void  StudentFacilitatorAndFacilitationManagerFunctionality(LinkedHashMap<String, ?> testData) throws Throwable {
		logger=extent.createTest("9.MFD-269 ::Module 5: Student/FacilitatorAndFacilitationManagerFunctionality");
		System.out.println("TCS 9");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		
		
		rightNavOperations.getCoursePage(createBackupData).getEnrollParticipantsPage();
		Navigator.GetParticipationOperationsPage().enrollStudent(createBackupData,createBackupData.getUserName4()).
		loginAsRespectiveUser(createBackupData.getRole1(),createBackupData.getUserName4());
		rightNavOperations.getAssignmentsPage();
		Navigator.GetAssignmentsOperations().completeAssingmentModule2().completeAssingmentModule3();	
		menuBarOperations.doLogOutAndLogin();
		
		rightNavOperations.getCoursePage(createBackupData).getEnrollParticipantsPage();
		Navigator.GetParticipationOperationsPage().loginAsRespectiveUser(createBackupData.getRole2(),createBackupData.getUserName5());
		rightNavOperations.getFacilitationDashboard();
		Navigator.FacilitationManagerDashboardOperations().gradeAssigment3(createBackupData);
		menuBarOperations.doLogOutAndLogin();
		rightNavOperations.getCoursePage(createBackupData).getEnrollParticipantsPage();
		Navigator.GetParticipationOperationsPage().UnenrollUser(createBackupData.getUserName5())
		.loginAsRespectiveUser(createBackupData.getRole2(),createBackupData.getUserName2());
		rightNavOperations.getFacilitationDashboard();
		Navigator.FacilitationManagerDashboardOperations().verifyAssignmentIsGraded(createBackupData);
		menuBarOperations.doLogOutAndLogin();
		rightNavOperations.getFacilitationManagerDashboard();
		Navigator.FacilitationManagerDashboardOperations().verifyDateGradedFilter(createBackupData).verifyGrader(createBackupData);
		logger.info("MFD-269 ::Module 5: Student/FacilitatorAndFacilitationManagerFunctionality Passed" );
			
	}
		
		@Test(priority=10,description = "MFD-226 :: MFD-270::MFD-259:: Sign Off the assignment, Verify the Sign Off Button,sign-off button and process", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
		public void FacilitationDashboardSignOffTheAssignment(LinkedHashMap<String, ?> testData) throws Throwable {
			logger=extent.createTest("10.MFD-226 :: MFD-270::MFD-259:: Sign Off the assignment, Verify the Sign Off Button,sign-off button and process");
			System.out.println("TCS 10");
			CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
			
			Navigator.FacilitationManagerDashboardOperations().verifySignOffFunctionality();
			rightNavOperations.getCoursePage(createBackupData).getEnrollParticipantsPage();
			Navigator.GetParticipationOperationsPage().loginAsRespectiveUser(createBackupData.getRole1(),createBackupData.getUserName1());
			rightNavOperations.getQuizzesPage();
			//to write from here
			Navigator.GetCoursePageOperations().completeParticipationAcknowledgement2();
			menuBarOperations.doLogOutAndLogin();
			rightNavOperations.getFacilitationManagerDashboard();
			Navigator.FacilitationManagerDashboardOperations()
			.signOff(createBackupData);//sign off commented due to defect
			logger.info("MFD-226 :: MFD-270::MFD-259:: Sign Off the assignment Passed" );
		}
		
		@Test(priority=11,description = "MFD-319::VerifyRubricView", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
		public void VerifyRubricView(LinkedHashMap<String, ?> testData) throws Throwable {
			logger=extent.createTest("11.MFD-319::VerifyRubricView");
			System.out.println("TCS 11");
			CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
			//Facilitation Manager
			//to delete
			rightNavOperations.getFacilitationManagerDashboard();
			Navigator.FacilitationManagerDashboardOperations().verifyRubricGrades(createBackupData);
			//Facilitator
			rightNavOperations.getCoursePage(createBackupData).getEnrollParticipantsPage();
			Navigator.GetParticipationOperationsPage().loginAsRespectiveUser(createBackupData.getRole2(), createBackupData.getUserName2());
			rightNavOperations.getFacilitationDashboard();
			Navigator.FacilitationManagerDashboardOperations().verifyRubricGrades(createBackupData);
			menuBarOperations.doLogOutAndLogin();
			
			logger.info("MFD-319::VerifyRubricView Passed" );
				
		}	
	
	@Test(priority=12,description = "MFD-227 :: Deleting the respective course", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void DeletingTheRespectiveCourse(LinkedHashMap<String, ?> testData) throws Throwable {
		logger=extent.createTest("12.MFD-227 :: Deleting the respective course");
		System.out.println("TCS 12");
		rightNavOperations.clickHome();
		rightNavOperations.clickAllCoursesLink();
		Navigator.GetCoursePageOperations().deleteRespectiveCourse();
		logger.info("MFD-227 :: Deleting the respective course Passed" );
	}
	

}
