package com.netsuite.tlh.operations;

import com.aventstack.extentreports.ExtentTest;
import com.framework.exceptions.DriverNotInitializedException;
import com.moodle.tlh.tests.FullRegressionTest;
import com.netsuite.tlh.factory.NetsuiteTLHPageFactory;
import com.netsuite.tlh.factory.OperationFactory;
import com.netsuite.tlh.pages.FacilitationManagerDashboardPage;
import com.netsuite.tlh.testdata.CreateBackupData;

public class FacilitationManagerDashboardOperations extends BaseOperations {
	
	ExtentTest logger=FullRegressionTest.logger;
	
	public FacilitationManagerDashboardOperations verifyCreatedAndUpdatedDate() throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("verifyCreatedAndUpdatedDate");
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).verifyCreatedUpdatedDate();
		logger.pass("Assignment created and updated date has been verified");
		
		return this;	
	}
	
	public FacilitationManagerDashboardOperations VerificationOfUnenrolledFacilitatorNameFunctionality(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("VerificationOfUnenrolledFacilitatorNameFunctionality");
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).enterFacilitatorName(createBackupData.getUserName7())
		.enterCourseCode(createBackupData.getCourseShortName()).selectAssignmentStatus(createBackupData.getStatus()).selectDateSubmitted()
		.clickFilterButton().verifyTableIspresent().verifyFacilitatorDetails(createBackupData.getUserName7())
		;
		logger.pass("VerificationOfUnenrolledFacilitatorNameFunctionality has been verified");
		
		return this;	
	}
	
	public FacilitationManagerDashboardOperations SmokeTest(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("SmokeTest");
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).selectAssignmentStatus(createBackupData.getStatus())
		.clickFilterButton().verifyTableIspresent()
		.clickResetButton().selectAssignmentStatus(createBackupData.getStatusUngraded()).clickFilterButton().verifyTableIspresent()
		;
		return this;	
	}
	
	public FacilitationManagerDashboardOperations verifyDeleteSubmissionButton(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("verifyDeleteSubmissionButton");
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class)
		.selectDateSubmitted().enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton().clickOnDeleteSubmissionButton()
		;
		logger.pass("DeleteSubmissionButton has been verified");
		return this;	
	}
	
	
	
	public FacilitationManagerDashboardOperations gradeAssigment(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("gradeAssigment");
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class)
		.selectDateSubmitted().enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton()
		.openAssigmentsLink(createBackupData,3)
		.selectAssignmentStatus(createBackupData.getStatus()).clickFilterButton().checkIfGraded().verifyGradedUngradedFilters();
		logger.pass("Assignment has been graded");
		
		return this;	
	}
	
	public FacilitationManagerDashboardOperations gradeAssigment3(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("gradeAssigment3");
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).selectDateSubmitted().enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton()
		.openAssigmentsLink( createBackupData,2)
		.selectAssignmentStatus(createBackupData.getStatus()).clickFilterButton().checkIfGraded()
		;
		logger.pass("gradeAssigment3 has been verified");
		return this;	
	}
	
	public FacilitationManagerDashboardOperations gradeOneAssigment(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("gradeAssigment3");
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).selectDateSubmitted().enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton()
		.openAssigmentsLink( createBackupData,2)
		.selectAssignmentStatus(createBackupData.getStatus()).clickFilterButton()
		;
		logger.pass("gradeAssigment3 has been verified");
		return this;	
	}
	
	public FacilitationManagerDashboardOperations gradeAssigment2(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("gradeAssigment2");
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).selectDateSubmitted().enterCourseCode(createBackupData.getCourseShortName())
		.selectAssignmentStatus(createBackupData.getStatusResubmitted()).clickFilterButton()
		.openAssigmentsLink2().selectAssignmentStatus(createBackupData.getStatus()).clickFilterButton().checkIfGraded()
		;
		logger.pass("gradeAssigment2 has been verified");
		return this;	
	}
	
	public FacilitationManagerDashboardOperations getRefreshDashboardPerformance() throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("getRefreshDashboardPerformance");
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).getDashboardRefreshTimeStamp();
		logger.pass("getRefreshDashboardPerformance has been verified");
		return this;	
	}
	
	
	public FacilitationManagerDashboardOperations getGradedFilterDashboardPerformance(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("getGradedFilterDashboardPerformance");
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).selectAssignmentStatus(createBackupData.getStatus())
		.getGradedFilterTimeStamp();
		logger.pass("getGradedFilterDashboardPerformance has been verified");
		return this;	
	}
	
	public FacilitationManagerDashboardOperations getLoadingDashboardPerformance() throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("getLoadingDashboardPerformance");
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).getDashboardLoadingTimeStamp();
		logger.pass("getLoadingDashboardPerformance has been verified");
		return this;	
	}
	
	public FacilitationManagerDashboardOperations signOff(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("signOff");
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).selectDateSubmitted().selectAssignmentStatus(createBackupData.getStatus())
		.enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton().checkIfGraded()
		.clickOnSignOffButton().selectAssignmentStatus(createBackupData.getStatus())
		.enterStudentName(createBackupData.getUserName1())
		
		.enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton().verifyUserSignedOff()
		;
		logger.pass("User has been signed Off");
		;
		return this;	
	}
	
	public FacilitationManagerDashboardOperations verifySignOffFunctionality() throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("verifySignOffFunctionality");
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).verifySignOffButtonIsNotPresent();
		logger.pass("SignOffFunctionality has been verified");
		return this;	
	}
	
	public FacilitationManagerDashboardOperations verifyResubmittedAssignment(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("verifyResubmittedAssignment");
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).verifyTableIspresent()
		.selectAssignmentStatus(createBackupData.getStatusResubmitted()).clickFilterButton()
		.verifyResubmitedAssignment()
		;
		logger.pass("ResubmittedAssignment has been verified");
		
		return this;	
	}
	
	
	public FacilitationManagerDashboardOperations verifyDateGradedFilter(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("verifyDateGradedFilter");
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).selectDateGraded()
		.selectAssignmentStatus(createBackupData.getStatus()).clickFilterButton()
		.verifyDateGraded()
		;
		logger.pass("DateGradedFilter has been verified");
		return this;	
	}
	
	public FacilitationManagerDashboardOperations verifyAssignmentIsGraded(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("verifyAssignmentIsGraded");
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).selectDateSubmitted().enterCourseCode(createBackupData.getCourseShortName())
		.selectAssignmentStatus(createBackupData.getStatusAll()).clickFilterButton()
		.verifyAssignmentIsGraded(createBackupData.getUserName4());
		logger.pass("Assignment has been Graded");
		return this;	
	}
	
	public FacilitationManagerDashboardOperations verifyGrader(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("verifyGrader");
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).clickResetButton().enterCourseCode(createBackupData.getCourseShortName())
		.selectAssignmentStatus(createBackupData.getStatus()).clickFilterButton()
		.verifyGrader(createBackupData.getUserName4(), createBackupData.getUserName5());
		logger.pass("Grader has been verified");
		return this;	
	}
	
	public FacilitationManagerDashboardOperations verifyOriginalGraderFilter(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("verifyOriginalGraderFilter");
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).selectAssignmentStatus(createBackupData.getStatusAll())
		.enterOriginalGraderName(createBackupData.getUserName3()).enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton()
		.verifyOriginalGraderFilter(createBackupData.getStatus())
		.verifyGradedUngradedFilters();
		logger.pass("Original Grader has been verified");
		return this;	
	}
	
	public FacilitationManagerDashboardOperations verifyCourseCodeFilter(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("verifyCourseCodeFilter");
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).clickResetButton().enterCourseCode(createBackupData.getCourseShortName()).selectAssignmentStatus(createBackupData.getStatusAll())
		.clickFilterButton().verifyTableIspresent().verifyCourseCodeValidations()
		;
		logger.pass("CourseCodeFilter has been verified");
		return this;	
	}
	
	public FacilitationManagerDashboardOperations verifyDashboardaAssignmentsCount(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("verifyDashboardaAssignmentsCount");
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class)
		.selectAssignmentStatus(createBackupData.getStatus()).clickFilterButton().getDashboardAssignmentCount().getGradedAssignmentCount()
		.clickResetButton().selectAssignmentStatus(createBackupData.getStatusUngraded()).clickFilterButton().getDashboardAssignmentCount()
		.getUnGradedAssignmentCount().verifyDashboardErrorReading();
		logger.pass("Dashboard AssignmentsCount has been verified");
		return this;	
	}
	
	public FacilitationManagerDashboardOperations verifyRubricGrades(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("verifyRubricGrades");
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).clickResetButton().enterCourseCode(createBackupData.getCourseShortName())
		.selectAssignmentStatus(createBackupData.getStatusAll()).enterStudentName(createBackupData.getUserName1())
		.clickFilterButton().verifyTableIspresent()
		.verifyRubricGrading()
		;
		logger.pass("RubricGrades has been verified");
		return this;	
	}
	
	public FacilitationManagerDashboardOperations verifyApostopheFilters(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("verifyApostopheFilters");
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class)
		
		.enterStudentName(createBackupData.getUserName1()).enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton()
		.verifyTableIspresent().clickResetButton()
		
		.enterCourseName(createBackupData.getCourseName()).enterStudentName(createBackupData.getUserName1()).enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton()
		.verifyTableIspresent().clickResetButton()
		
		.enterAssignmentName(createBackupData.getModule2Newname()).enterStudentName(createBackupData.getUserName1()).enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton()
		.verifyTableIspresent().clickResetButton()
		
		.enterAssignmentName(createBackupData.getModule3NewName()).enterStudentName(createBackupData.getUserName1()).enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton()
		.verifyTableIspresent().clickResetButton()
		
		.enterStudentName(createBackupData.getUserName4()).enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton()
		.verifyTableIspresent().clickResetButton()
		
		;
		logger.pass("ApostopheFilters has been verified");
		return this;	
	}
	
	public FacilitationManagerDashboardOperations verifyApostopheFilters2(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("verifyApostopheFilters2");
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class)
		.enterCourseName(createBackupData.getCourseName2()).enterStudentName(createBackupData.getUserName1()).enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton()
		.verifyTableIspresent().clickResetButton()
		;
		logger.pass("ApostopheFilters2 has been verified");
		return this;	
	}
	
	public FacilitationManagerDashboardOperations verifyFilters(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("verifyFilters");
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class)
		
		.enterFacilitatorName(createBackupData.getFacilitatorName()).enterCourseCode(createBackupData.getCourseShortName()).selectAssignmentStatus(createBackupData.getStatusAll()).clickFilterButton()
		.verifyTableIspresent().verifyFacilitatorIsEnrolled().clickResetButton()
		
		.enterStudentName(createBackupData.getUserName1()).enterCourseCode(createBackupData.getCourseShortName()).selectAssignmentStatus(createBackupData.getStatusAll()).clickFilterButton()
		.verifyTableIspresent().clickResetButton()
		
		.enterAssignmentName(createBackupData.getAssignmentName()).enterCourseCode(createBackupData.getCourseShortName()).selectAssignmentStatus(createBackupData.getStatusAll())
		.clickFilterButton().verifyTableIspresent().clickResetButton()
		
		.selectDateSubmitted().enterCourseCode(createBackupData.getCourseShortName()).selectAssignmentStatus(createBackupData.getStatusAll()).clickFilterButton()
		.verifyTableIspresent().clickResetButton()
		
		.enterCourseCode(createBackupData.getCourseShortName()).enterCourseCode(createBackupData.getCourseShortName()).selectAssignmentStatus(createBackupData.getStatusAll())
		.clickFilterButton().verifyTableIspresent().verifyCourseCodeValidation().clickResetButton()
		
		.enterCourseName(createBackupData.getCourseName()).enterCourseCode(createBackupData.getCourseShortName()).selectAssignmentStatus(createBackupData.getStatusAll())
		.clickFilterButton().verifyTableIspresent().clickResetButton()
		
		.selectSignOffStatus(createBackupData.getSignOffStatusAll()).enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton().verifyTableIspresent()
		.verifyProperSignOffStatus(createBackupData.getSignOffStatusAll()).clickResetButton()
		
		.selectSignOffStatus(createBackupData.getSignOffStatusAwaiting()).enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton().verifyTableIspresent()
		.verifyProperSignOffStatus(createBackupData.getSignOffStatusAwaiting()).clickResetButton()
		
		.selectSignOffStatus(createBackupData.getSignOffStatusSigned()).enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton().verifyTableIspresent()
		.verifyProperSignOffStatus(createBackupData.getSignOffStatusSigned()).clickResetButton()
		
		.selectAssignmentStatus(createBackupData.getStatus()).enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton().verifyTableIspresent().clickResetButton()
		
		.selectAssignmentStatus(createBackupData.getStatusResubmitted()).enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton().verifyTableIspresent().clickResetButton()
		
		.selectAssignmentStatus(createBackupData.getStatusUngraded()).enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton().verifyTableIspresent()
		.verifyNoGradedAssignmentIspresent().clickResetButton()
		
		.expectedCompletionDateInput().enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton().verifyTableIspresent().clickResetButton()
		
		.enterOriginalGraderName(createBackupData.getOriginalGraderName()).enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton().verifyTableIspresent().clickResetButton()
		
		.selectCourseStartDate().enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton().verifyTableIspresent().clickResetButton()
		
		;
		logger.pass("Facilitation Manager Dashborad filters has been verified");
		
		return this;	
	}
	
}
