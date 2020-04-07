package com.moodle.PerformanceTest;

import java.util.LinkedHashMap;
import org.testng.annotations.Test;
import com.framework.utils.Utility;
import com.moodle.tlh.tests.BaseTest;
import com.netsuite.tlh.operations.MenuBarOperations;
import com.netsuite.tlh.operations.Navigator;
import com.netsuite.tlh.testdata.CreateBackupData;


public class FullPerformanceTest extends BaseTest{
	
	@Test(priority=1,description = "MFD-221 ::MFD-222 ::Create a backup and Restore for the course", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void CreateABackupAndRestoreTheCourse(LinkedHashMap<String, ?> testData) throws Throwable {
		logger=extent.createTest("MFD-221 ::MFD-222 ::Create a backup and Restore for the course");
		System.out.println("FullPerformanceTest");
		System.out.println("1");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		//rightNavOperations.acceptSitePolicyAgreement();
		rightNavOperations.getRestoreCoursePage();
		Navigator.doRestore(createBackupData);	
		logger.info("MFD-221 ::MFD-222 ::Create a backup and Restore for the course Passed" );
	}
	
	@Test(priority=2,description = "MFD-223 ::MFD-264 ::Enrolling the Users", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void EnrollingTheUsers(LinkedHashMap<String, ?> testData) throws Throwable {
		logger=extent.createTest("MFD-223 ::MFD-264 ::Enrolling the Users");
		System.out.println("2");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		rightNavOperations.getEnrollParticipantsPage();
		Navigator.GetParticipationOperationsPage()
		.enrollStudent(createBackupData,createBackupData.getUserName1())
		.enrollFacilitationManager(createBackupData,createBackupData.getUserName3())
		.enrollFacilitationManager(createBackupData,createBackupData.getPerformanceUserName());
		logger.info("MFD-223 ::MFD-264 ::Enrolling the Users passed");
		
	}
	
	@Test(priority=3,description = "MFD-224 ::Login as student and Complete the assignment", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void LoginAsStudentAndCompleteAssignment(LinkedHashMap<String, ?> testData) throws Throwable {
		logger=extent.createTest("MFD-224 ::Login as student and Complete the assignment");
		System.out.println("3");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		rightNavOperations.searchAndGetCoursePage(createBackupData).getEnrollParticipantsPage()
		.loginAsRespectiveUser(createBackupData.getRole1(),createBackupData.getUserName1(),createBackupData.getCourseShortName());
		rightNavOperations.acceptSitePolicyAgreement().searchAndGetCoursePage(createBackupData)
		.getAssignmentsPage().completeAssingments();
		menuBarOperations.doLogOut();
		loginOperations.doSecondLogin(userName, passWord);
		logger.info("MFD-224 ::Login as student and Complete the assignment passed");
	}
	
	@Test(priority=4,description = "MFD-389 ::VerifyNoNegativeGradesDashboard ", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void VerifyNoNegativeGradesDashboard(LinkedHashMap<String, ?> testData) throws Throwable {
		logger=extent.createTest("MFD-389 ::VerifyNoNegativeGradesDashboard");
		System.out.println("4");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		rightNavOperations.getFacilitationManagerDashboard()
		.gradeAssigment2_1(createBackupData)
		.gradeAssigment3_1(createBackupData)
		.provideFeedbackOnFinalAssignment(createBackupData)
		;
		
		logger.info("MFD-389 ::VerifyNoNegativeGradesDashboard passed");
	}
	
	@Test(priority=5,description = "MFD-258 ::MFD-299::MFD-320::MFD-321:: Dashboard performance test script, Fetch Datat button functionality and its performance", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
		public void DashboardPerformanceTestScript(LinkedHashMap<String, ?> testData) throws Throwable {
		logger=extent.createTest("MFD-258 ::MFD-299::MFD-320::MFD-321:: Dashboard performance test script, Fetch Datat button functionality and its performance");
		System.out.println("5");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		rightNavOperations.searchAndGetCoursePage(createBackupData).getEnrollParticipantsPage();
		Navigator.GetParticipationOperationsPage().loginAsRespectiveUser(createBackupData.getRole3(),createBackupData.getPerformanceUserName(),createBackupData.getCourseShortName());
		rightNavOperations.getFacilitationManagerDashboard();
		Navigator.FacilitationManagerDashboardOperations()
		.getLoadingDashboardPerformance()
		.getRefreshDashboardPerformance()
		.getGradedFilterDashboardPerformance(createBackupData)
			;	
		logger.info("MFD-258 ::MFD-299::MFD-320::MFD-321:: Dashboard performance test script, Fetch Datat button functionality and its performance passed");
		}
	
	//@Test(priority=6,description = "MFD-227 :: Deleting the respective course", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void DeletingTheRespectiveCourse(LinkedHashMap<String, ?> testData) throws Throwable {
		logger=extent.createTest("MFD-258 ::MFD-299::MFD-320::MFD-321:: Dashboard performance test script, Fetch Datat button functionality and its performance");
		System.out.println("6");
		rightNavOperations.clickHamburgerItem().clickHome();
		rightNavOperations.clickAllCoursesLink();
		Navigator.GetCoursePageOperations().deleteRespectiveCourse();
		logger.info("MFD-227 :: Deleting the respective course passed");
		
	}

}
