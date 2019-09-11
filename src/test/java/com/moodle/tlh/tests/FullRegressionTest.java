package com.moodle.tlh.tests;

import java.util.LinkedHashMap;
import org.testng.annotations.Test;
import com.framework.utils.Utility;
import com.netsuite.tlh.operations.Navigator;
import com.netsuite.tlh.testdata.CreateBackupData;


public class FullRegressionTest extends BaseTest{
	
	
	@Test(priority=1,description = "MFD-357 ::MFD-358 ::Moodle facilitator manager report feature", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
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
	/*
	@Test(priority=2,description = "MFD-221 ::MFD-222 ::Create a backup and Restore for the course", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void CreateABackupAndRestoreTheCourse(LinkedHashMap<String, ?> testData) throws Throwable {
		logger=extent.createTest("2.MFD-221 ::MFD-222 ::Create a backup and Restore for the course");
		System.out.println("TCS 2");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		
		rightNavOperations.getRestoreCoursePage();
		Navigator.doRestore(createBackupData);	
		logger.pass("Course has been created succesfully");
		logger.info("MFD-221 ::MFD-222 ::Create a backup and Restore for the course Passed" );
		
	}
	
	@Test(priority=3,description = "MFD-223 ::MFD-264 ::Enrolling the Users", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void EnrollingTheUsers(LinkedHashMap<String, ?> testData) throws Throwable {
		logger=extent.createTest("3.MFD-223 ::MFD-264 ::Enrolling the Users");
		System.out.println("TCS 3");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		rightNavOperations.getEnrollParticipantsPage();
		Navigator.GetParticipationOperationsPage().enrollStudent(createBackupData,createBackupData.getUserName1())
		.enrollFacilitator(createBackupData,createBackupData.getUserName2())
		.enrollFacilitator(createBackupData,createBackupData.getUserName5())
		.enrollFacilitationManager(createBackupData,createBackupData.getUserName3())
		.enrollFacilitationManager(createBackupData,createBackupData.getUserName6())
		.clickOnRespectiveCourseFromLeftNav(createBackupData);	
		
		rightNavOperations.getFacilitationManagerReportPage();
		logger.info("MFD-223 ::MFD-264 ::Enrolling the Users Passed" );
	}
	
	@Test(priority=4,description = "MFD-266 ::Activity completion settings for the course", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void ActivityCompletionSettingsforCourse(LinkedHashMap<String, ?> testData) throws Throwable {
		logger=extent.createTest("4.MFD-266 ::Activity completion settings for the course");
		System.out.println("TCS 4");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		
		Navigator.GetCoursePageOperations().clickTurnEditingOn().
		doActivityCompletion(createBackupData.getModule2(),createBackupData)
		.doActivityCompletion(createBackupData.getModule3(),createBackupData)
		.doActivityCompletion(createBackupData.getFinalProjectSubmission(),createBackupData)
		.doParticipationAcknowledgement(createBackupData.getParticipationAcknowledgement(),createBackupData);
		rightNavOperations.clickCourseCompletion();
		Navigator.GetCoursePageOperations().doCourseCompletion(createBackupData).clickTurnEditingOff();
		logger.info("MFD-266 ::Activity completion settings for the course has been Completed" );
		
	}
	
	
	@Test(priority=5,description = "MFD-224 ::Login as student and Complete the assignment", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void LoginAsStudentAndCompleteAssignment(LinkedHashMap<String, ?> testData) throws Throwable {
		logger=extent.createTest("5.MFD-224 ::Login as student and Complete the assignment");
		System.out.println("TCS 5");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		rightNavOperations.getEnrollParticipantsPage();
		Navigator.GetParticipationOperationsPage().loginAsRespectiveUser(createBackupData.getRole1(),createBackupData.getUserName1());
		rightNavOperations.acceptSitePolicyAgreement();
		rightNavOperations.getCoursePage(createBackupData);
		
		
		rightNavOperations.getAssignmentsPage();
		Navigator.GetAssignmentsOperations().completeAssingments();
		rightNavOperations.getCoursePage(createBackupData);
		menuBarOperations.doLogOut();
		loginOperations.doSecondLogin(userName, passWord);
		
		logger.info("MFD-224 ::Login as student and Complete the assignment Passed" );
		
	}
	
	@Test(priority=6,description = "MFD-225 ::MFD-245::MFD-267::MFD-356 ::Facilitation Dashboard :Grading,Verify Rubic View, Grading Filters,verifyCreatedAndUpdatedDate", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
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
		menuBarOperations.doLogOut();
		loginOperations.doSecondLogin(userName, passWord);
		rightNavOperations.getEnrollParticipantsPage();
		Navigator.GetParticipationOperationsPage().loginAsRespectiveUser(createBackupData.getRole2(),createBackupData.getUserName2());
		rightNavOperations.getFacilitationDashboard();
		Navigator.FacilitationManagerDashboardOperations().verifyResubmittedAssignment(createBackupData).gradeAssigment2(createBackupData);
		menuBarOperations.doLogOut();
		loginOperations.doSecondLogin(userName, passWord);
		
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
			//add course code tomorrow
			Navigator.FacilitationDashboardOperations().verifyFilters(createBackupData);
			menuBarOperations.doLogOut();
			loginOperations.doSecondLogin(userName, passWord);
			
			//Login as Facilitation Manager
			rightNavOperations.getCoursePage(createBackupData).getEnrollParticipantsPage();
			Navigator.GetParticipationOperationsPage().loginAsRespectiveUser(createBackupData.getRole3(),createBackupData.getUserName6());
			rightNavOperations.getFacilitationManagerDashboard();
			Navigator.FacilitationManagerDashboardOperations().verifyDateGradedFilter(createBackupData).verifyFilters(createBackupData);
			menuBarOperations.doLogOut();
			loginOperations.doSecondLogin(userName, passWord);
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
		menuBarOperations.doLogOut();
		loginOperations.doSecondLogin(userName, passWord);
		
		rightNavOperations.getCoursePage(createBackupData).getEnrollParticipantsPage();
		Navigator.GetParticipationOperationsPage().loginAsRespectiveUser(createBackupData.getRole2(),createBackupData.getUserName5());
		rightNavOperations.getFacilitationDashboard();
		Navigator.FacilitationManagerDashboardOperations().gradeAssigment3(createBackupData);
		menuBarOperations.doLogOut();
		loginOperations.doSecondLogin(userName, passWord);
		rightNavOperations.getCoursePage(createBackupData).getEnrollParticipantsPage();
		Navigator.GetParticipationOperationsPage().UnenrollUser(createBackupData.getUserName5())
		.loginAsRespectiveUser(createBackupData.getRole2(),createBackupData.getUserName2());
		rightNavOperations.getFacilitationDashboard();
		Navigator.FacilitationManagerDashboardOperations().verifyAssignmentIsGraded(createBackupData);
		menuBarOperations.doLogOut();
		loginOperations.doSecondLogin(userName, passWord);
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
			menuBarOperations.doLogOut();
			loginOperations.doSecondLogin(userName, passWord);
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
			Navigator.FacilitationManagerDashboardOperations().verifyRubricGrades(createBackupData);
			//Facilitator
			rightNavOperations.getCoursePage(createBackupData).getEnrollParticipantsPage();
			Navigator.GetParticipationOperationsPage().loginAsRespectiveUser(createBackupData.getRole2(), createBackupData.getUserName2());
			rightNavOperations.getFacilitationDashboard();
			Navigator.FacilitationManagerDashboardOperations().verifyRubricGrades(createBackupData);
			menuBarOperations.doLogOut();
			loginOperations.doSecondLogin(userName, passWord);
			//Student (functionality removed)
			//rightNavOperations.getCoursePage(createBackupData).getEnrollParticipantsPage();
			//Navigator.GetParticipationOperationsPage().loginAsRespectiveUser(createBackupData.getRole1(), createBackupData.getUserName1());
			//rightNavOperations.getAssignmentsPage();
			//Navigator.GetAssignmentsOperations().verifyStudentRubricView();
			//menuBarOperations.doLogOut();
			//loginOperations.doSecondLogin(userName, passWord);
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
	
	
	//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
	
	//@Test(priority=13,description = "Sample-1 ::Create a backup and Restore for the course", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
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
	
	//@Test(priority=14,description = "Sample-2::Enrolling the Users", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
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
	
	//@Test(priority=15,description = "MFD-316 ::VerifyAssignmentCountsOnDashboard", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void VerifyAssignmentCountsOnDashboard(LinkedHashMap<String, ?> testData) throws Throwable {
		logger=extent.createTest("15.MFD-316 ::VerifyAssignmentCountsOnDashboard");
		System.out.println("TCS 15");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		rightNavOperations.getEnrollParticipantsPage();
		Navigator.GetParticipationOperationsPage().loginAsRespectiveApostopheUser(createBackupData.getRole3(),"3");
		rightNavOperations.getFacilitationManagerDashboard();
		Navigator.FacilitationManagerDashboardOperations().verifyDashboardaAssignmentsCount(createBackupData);
		menuBarOperations.doLogOut();	
		loginOperations.doSecondLogin(userName, passWord);
		rightNavOperations.getApostopheCoursesPage();
		rightNavOperations.getEnrollParticipantsPage();
		Navigator.GetParticipationOperationsPage().UnenrollUser(createBackupData.getPerformanceUserName());
		logger.info("MFD-316 ::VerifyAssignmentCountsOnDashboard Passed" );
				
	}
	
	//@Test(priority=16,description = "Sample-3 ::Complete the assignment, Change Course Name", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void LoginAsStudentCompleteAssignment(LinkedHashMap<String, ?> testData) throws Throwable {
		logger=extent.createTest("16.Sample-3 ::Complete the assignment, Change Course Name");
		System.out.println("TCS 16");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		
		Navigator.GetParticipationOperationsPage().loginAsRespectiveApostopheUser(createBackupData.getRole1(),"1");
		rightNavOperations.getAssignmentsPage();
		Navigator.GetAssignmentsOperations().completeAssingments();
		
		menuBarOperations.doLogOut();	
		loginOperations.doSecondLogin(userName, passWord);
		
		rightNavOperations.getEnrollParticipantsPage();
		Navigator.GetParticipationOperationsPage().loginAsRespectiveApostopheUser(createBackupData.getRole1(),"2");
		
		rightNavOperations.getAssignmentsPage();
		Navigator.GetAssignmentsOperations().completeAssingments();
		menuBarOperations.doLogOut();	
		loginOperations.doSecondLogin(userName, passWord);
		Navigator.GetCoursePageOperations().clickTurnEditingOn().changeAssignmentName(createBackupData.getModule2(),createBackupData.getModule2Newname())
		.changeAssignmentName(createBackupData.getModule3(),createBackupData.getModule3NewName());
		Navigator.GetCoursePageOperations().clickTurnEditingOff();
		logger.info("Sample-3 ::Complete the assignment, Change Course Name Passed" );
			
	}
	
	//@Test(priority=17,description = "MFD-289 ::MFD-288::Apostrophe in Facilitation Dashboard filter criteria, verify deleting submitted assignment", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
		public void VerifyDashboardFunctionalityForDifferentRoles(LinkedHashMap<String, ?> testData) throws Throwable {
		logger=extent.createTest("17.MFD-289 ::MFD-288::Apostrophe in Facilitation Dashboard filter criteria, verify deleting submitted assignment");	
		System.out.println("TCS 17");
			CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
			rightNavOperations.getEnrollParticipantsPage();
			Navigator.GetParticipationOperationsPage().loginAsRespectiveApostopheUser(createBackupData.getRole2(),"1");
			rightNavOperations.getFacilitationManagerDashboard();
			Navigator.FacilitationManagerDashboardOperations().verifyApostopheFilters(createBackupData);
			
			menuBarOperations.doLogOut();	
			loginOperations.doSecondLogin(userName, passWord);
			rightNavOperations.getApostopheCoursesPage();
			Navigator.GetCoursePageOperations().changeCourseName( createBackupData);
			rightNavOperations.getEnrollParticipantsPage();
			Navigator.GetParticipationOperationsPage().loginAsRespectiveApostopheUser(createBackupData.getRole2(),"1");
			rightNavOperations.getFacilitationManagerDashboard();
			Navigator.FacilitationManagerDashboardOperations().verifyApostopheFilters2(createBackupData);
			
			menuBarOperations.doLogOut();	
			loginOperations.doSecondLogin(userName, passWord);
			rightNavOperations.getFacilitationManagerDashboard();
			Navigator.FacilitationManagerDashboardOperations().verifyDeleteSubmissionButton(createBackupData);
			logger.info("MFD-289 ::MFD-288::Apostrophe in Facilitation Dashboard filter criteria, verify deleting submitted assignment Passed" );
			
		}	
	
	//@Test(priority=18,description = "MFD-227 :: Deleting the respective course", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void DeletingTheCourse(LinkedHashMap<String, ?> testData) throws Throwable {
		logger=extent.createTest("18.MFD-227 :: Deleting the respective course");
		System.out.println("TCS 18");
		rightNavOperations.clickHome();
		rightNavOperations.clickAllCoursesLink();
		Navigator.GetCoursePageOperations().deleteRespectiveApostophieCourse();
		
		menuBarOperations.doLogOut();
		logger.info("MFD-227 :: Deleting the respective course Passed" );
		
	}*/

}
