package com.netsuite.tlh.operations;

import com.aventstack.extentreports.ExtentTest;
import com.framework.exceptions.DriverNotInitializedException;
import com.moodle.Regression1.FullRegressionTest;
import com.netsuite.tlh.factory.NetsuiteTLHPageFactory;
import com.netsuite.tlh.factory.OperationFactory;
import com.netsuite.tlh.pages.FacilitationManagerDashboardPage;
import com.netsuite.tlh.testdata.CreateBackupData;

public class FacilitationManagerDashboardOperations extends BaseOperations {
	
	ExtentTest logger=FullRegressionTest.logger;
	
	public FacilitationManagerDashboardOperations verifyMFD_536() throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("verifyMFD_536");
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).clickDownloadButton().clickFilterButton()
		.verifyTableIspresent()
		;
		return this;	
	}
	
	public FacilitationManagerDashboardOperations verifyFilterButton() throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("verifyFilterButton");
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).clickFilterButton().clickFilterButton()
		.verifyTableIspresent()
		;
		return this;	
	}
	
	public FacilitationManagerDashboardOperations verifyMFD_552(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("verifyMFD_552");
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).enterCourseCode(createBackupData.getCourseShortName())
		.selectAssignmentStatus(createBackupData.getStatus()).enterOriginalGraderName(createBackupData.getUserName3().toLowerCase())
		.clickFilterButton().verifyOriginalGrader(createBackupData.getUserName3()).clickResetButton()
		.enterCourseCode(createBackupData.getCourseShortName())
		.selectAssignmentStatus(createBackupData.getStatus()).enterOriginalGraderName(createBackupData.getUserName3().toUpperCase())
		.clickFilterButton().verifyOriginalGrader(createBackupData.getUserName3())
		;
		
		return this;	
	}
	
	public FacilitationManagerDashboardOperations verifyMFD_560(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("verifyMFD_560");
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).enterCourseCode(createBackupData.getCourseShortName())
		.selectAssignmentStatus(createBackupData.getStatusResubmitted()).clickFilterButton()
		.openAssigmentsLink2_1_1()
		;
		
		return this;	
	}
	
	public FacilitationManagerDashboardOperations verifyMFD_560_1(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("verifyMFD_560_1");
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).enterCourseCode(createBackupData.getCourseShortName()).selectAssignmentStatus(createBackupData.getStatus())
		.enterAssignmentName("2").clickFilterButton().verifyOriginalGrader(createBackupData.getUserName3())
		;
		
		return this;	
	}
	
	public FacilitationManagerDashboardOperations verifyMFD_517_519(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("verifyMFD_517_519");
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).clickResetButton()
		.enterCourseCode(createBackupData.getCourseShortName()).selectAssignmentStatus(createBackupData.getStatus())
		.enterStudentName(createBackupData.getUserName1()).clickFilterButton()
		.verifyPaginationDoesntBreak().verifyMFD517()
		;
		
		return this;	
	}
	
	public FacilitationManagerDashboardOperations verifyParticipationAgreement(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("verifyParticipationAgreement");
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton()
		.verifyParticipationAgreement()
		;
		
		return this;	
	}
	
	
	public FacilitationManagerDashboardOperations verifySignOfButtonMFD_495(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("verifySignOfButtonMFD_495");
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class)
		.enterAssignmentName(createBackupData.getFinalProjectSubmission()).enterCourseCode(createBackupData.getCourseShortName())
		.enterStudentName(createBackupData.getUserName4()).selectAssignmentStatus(createBackupData.getStatusAll()).clickFilterButton()
		.verifySignOffButtonIsPresent()
		;
		
		return this;	
	}
	
	public FacilitationManagerDashboardOperations gradeFinalAsignment(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("gradeFinalAsignment");
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class)
		.enterAssignmentName(createBackupData.getFinalProjectSubmission()).enterCourseCode(createBackupData.getCourseShortName())
		.selectAssignmentStatus(createBackupData.getStatusUngraded()).clickFilterButton().openAssigmentsLink(createBackupData,1)
		.selectAssignmentStatus(createBackupData.getStatus()).clickFilterButton().clickResetButton()
		;
		
		return this;	
	}
	
	public FacilitationManagerDashboardOperations provideFeedbackOnFinalAssignment(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("provideFeedbackOnFinalAssignment");
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).clickResetButton()
		.selectDateSubmitted().enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton()
		.giveFinalAssignmentFeedback(createBackupData).clickResetButton().enterCourseCode(createBackupData.getCourseShortName())
		.selectAssignmentStatus(createBackupData.getStatusUngraded()).clickFilterButton().verifyNoNegativeGrade()
		;
		
		return this;	
	}
	
	public FacilitationManagerDashboardOperations verifyStudentNameFilter(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("verifyStudentNameFilter");
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).clickResetButton()
		.enterStudentName(createBackupData.getUserName1()).clickFilterButton()
		.selectAssignmentStatus(createBackupData.getStatusAll())
		.verifyTableIspresent().verifyStudentNameInTable(createBackupData.getUserName1())
		;
		
		
		return this;	
	}
	public FacilitationManagerDashboardOperations verifyCreatedAndUpdatedDate() throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("verifyCreatedAndUpdatedDate");
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).verifyCreatedUpdatedDate();
	
		
		return this;	
	}
	
	public FacilitationManagerDashboardOperations VerificationOfUnenrolledFacilitatorNameFunctionality(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("VerificationOfUnenrolledFacilitatorNameFunctionality");
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).enterFacilitatorName(createBackupData.getUserName8())
		.enterCourseCode(createBackupData.getCourseShortName()).selectAssignmentStatus(createBackupData.getStatus()).selectDateSubmitted()
		.clickFilterButton().verifyTableIspresent().verifyFacilitatorDetails(createBackupData.getUserName8())
		;
		
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
		
		return this;	
	}
	
	
	
	public FacilitationManagerDashboardOperations gradeAssigment(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("gradeAssigment");
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class)
		.selectDateSubmitted().enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton()
		.openAssigmentsLink(createBackupData,3)
		.selectAssignmentStatus(createBackupData.getStatus()).clickFilterButton().checkIfGraded().verifyGradedUngradedFilters();
		
		
		return this;	
	}
	
	public FacilitationManagerDashboardOperations gradeAssigmentRegression4(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("gradeAssigmentRegression4");
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class)
		.selectDateSubmitted().enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton()
		.openAssigmentsLink(createBackupData,3)
		.selectAssignmentStatus(createBackupData.getStatus()).clickFilterButton().checkIfGraded();
		
		return this;	
	}
	
	public FacilitationManagerDashboardOperations gradeAssigment3(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("gradeAssigment3");
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).selectDateSubmitted().enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton()
		.openAssigmentsLink( createBackupData,2)
		.selectAssignmentStatus(createBackupData.getStatus()).clickFilterButton().checkIfGraded()
		;
		
		return this;	
	}
	
	public FacilitationManagerDashboardOperations gradeAssigment3_1(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("gradeAssigment3_1");
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).clickResetButton().selectAssignmentStatus(createBackupData.getStatusUngraded())
		.enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton()
		.openAssigmentsLink3_1()
		.selectAssignmentStatus(createBackupData.getStatus()).clickFilterButton().checkIfGradedNew()
		;
		
		return this;	
	}
	
	public FacilitationManagerDashboardOperations gradeOneAssigment(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("gradeOneAssigment");
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).selectDateSubmitted().enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton()
		.openAssigmentsLink( createBackupData,2)
		.selectAssignmentStatus(createBackupData.getStatus()).clickFilterButton()
		;
		
		return this;	
	}
	
	public FacilitationManagerDashboardOperations gradeAssigment2(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("gradeAssigment2");
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).selectDateSubmitted().enterCourseCode(createBackupData.getCourseShortName())
		.selectAssignmentStatus(createBackupData.getStatusResubmitted()).clickFilterButton()
		.openAssigmentsLink2().selectAssignmentStatus(createBackupData.getStatus()).clickFilterButton().checkIfGraded()
		;
		
		return this;	
	}
	
	public FacilitationManagerDashboardOperations gradeAssigment2_1(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("gradeAssigment2_1");
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).enterCourseCode(createBackupData.getCourseShortName())
		.selectAssignmentStatus(createBackupData.getStatusUngraded()).clickFilterButton().openAssigmentsLink2_1()
		;
		
		return this;	
	}
	
	public FacilitationManagerDashboardOperations getRefreshDashboardPerformance() throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("getRefreshDashboardPerformance");
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).getDashboardRefreshTimeStamp();
		
		return this;	
	}
	
	
	public FacilitationManagerDashboardOperations getGradedFilterDashboardPerformance(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("getGradedFilterDashboardPerformance");
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).selectAssignmentStatus(createBackupData.getStatus())
		.getGradedFilterTimeStamp();
		
		return this;	
	}
	
	public FacilitationManagerDashboardOperations getLoadingDashboardPerformance() throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("getLoadingDashboardPerformance");
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).getDashboardLoadingTimeStamp();
		
		return this;	
	}
	
	public FacilitationManagerDashboardOperations signOff(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("signOff");
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).selectAssignmentStatus(createBackupData.getStatus())
		.enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton().checkIfGraded()
		.verifyMFD_527()
		.clickOnSignOffButton().selectAssignmentStatus(createBackupData.getStatus())
		.enterStudentName(createBackupData.getUserName1())
		.enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton().verifyUserSignedOff()
		;
		
		return this;	
	}
	
	public FacilitationManagerDashboardOperations dashboardSignOff(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("dashboardSignOff");
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).selectAssignmentStatus(createBackupData.getStatus())
		.enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton()
		.clickOnSignOffButton().selectAssignmentStatus(createBackupData.getStatus())
		.enterStudentName(createBackupData.getUserName1())
		.enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton().verifyUserSignedOff()
		;
		
		return this;	
	}
	
	public FacilitationManagerDashboardOperations verifySignOffBehaviour(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("verifySignOffBehaviour");
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).selectDateSubmitted()
		
		.selectAssignmentStatus(createBackupData.getStatus()).enterCourseCode(createBackupData.getCourseShortName())
		.selectSignOffStatus(createBackupData.getSignOffStatusAwaiting()).clickFilterButton().verifySignOffButtonIsPresent()
		
		.clickResetButton().enterCourseCode(createBackupData.getCourseShortName())
		.selectDateSubmitted().selectAssignmentStatus(createBackupData.getStatusUngraded()).clickFilterButton().verifySignOffButtonIsNotPresent()
		
		.clickResetButton().enterCourseCode(createBackupData.getCourseShortName()).selectDateSubmitted().selectAssignmentStatus(createBackupData.getStatus())
		.selectSignOffStatus(createBackupData.getSignOffStatusAll()).clickFilterButton().verifySignOffButtonIsPresent()
		;
		
		return this;	
	}
	
	public FacilitationManagerDashboardOperations verifySignOffFunctionality() throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("verifySignOffFunctionality");
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).verifySignOffButtonIsNotPresent();
		
		return this;	
	}
	
	public FacilitationManagerDashboardOperations verifyResubmittedAssignment(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("verifyResubmittedAssignment");
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).verifyTableIspresent().enterCourseCode(createBackupData.getCourseShortName())
		.selectAssignmentStatus(createBackupData.getStatusResubmitted()).clickFilterButton()
		.verifyResubmitedAssignment().verifyResubmitedAssignmentDateSubmitted()
		;
		
		return this;	
	}
	
	
	public FacilitationManagerDashboardOperations verifyDateGradedFilter(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("verifyDateGradedFilter");
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).selectDateGraded()
		.selectAssignmentStatus(createBackupData.getStatus()).clickFilterButton()
		.verifyDateGraded()
		;
		
		return this;	
	}
	
	public FacilitationManagerDashboardOperations verifyAssignmentIsGraded(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("verifyAssignmentIsGraded");
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).selectDateSubmitted().enterCourseCode(createBackupData.getCourseShortName())
		.selectAssignmentStatus(createBackupData.getStatusAll()).clickFilterButton()
		.verifyAssignmentIsGraded(createBackupData.getUserName4());
		
		return this;	
	}
	
	public FacilitationManagerDashboardOperations verifyGrader(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("verifyGrader");
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).clickResetButton().enterCourseCode(createBackupData.getCourseShortName())
		.selectAssignmentStatus(createBackupData.getStatus()).clickFilterButton()
		.verifyGrader(createBackupData.getUserName4(), createBackupData.getUserName5());
		
		return this;	
	}
	
	public FacilitationManagerDashboardOperations verifyOriginalGraderFilter(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("verifyOriginalGraderFilter");
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).selectAssignmentStatus(createBackupData.getStatusAll())
		.enterOriginalGraderName(createBackupData.getUserName3()).enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton()
		.verifyOriginalGraderFilter(createBackupData.getStatus())
		.verifyGradedUngradedFilters();
		
		return this;	
	}
	
	public FacilitationManagerDashboardOperations verifyCourseCodeFilter(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("verifyCourseCodeFilter");
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).clickResetButton().enterCourseCode(createBackupData.getCourseShortName()).selectAssignmentStatus(createBackupData.getStatusAll())
		.clickFilterButton().verifyTableIspresent().verifyCourseCodeValidations()
		;
		
		return this;	
	}
	
	public FacilitationManagerDashboardOperations verifyDashboardaAssignmentsCount(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("verifyDashboardaAssignmentsCount");
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class)
		.selectAssignmentStatus(createBackupData.getStatus()).clickFilterButton().getDashboardAssignmentCount().getGradedAssignmentCount()
		.clickResetButton().selectAssignmentStatus(createBackupData.getStatusUngraded()).clickFilterButton().getDashboardAssignmentCount()
		.getUnGradedAssignmentCount().verifyDashboardErrorReading();
		
		return this;	
	}
	
	public FacilitationManagerDashboardOperations verifyRubricGradesAnd516(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("verifyRubricGradesAnd516");
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class).clickResetButton().enterCourseCode(createBackupData.getCourseShortName())
		.selectAssignmentStatus(createBackupData.getStatusAll()).enterStudentName(createBackupData.getUserName4())
		.clickFilterButton().verifyTableIspresent()
		.verifyMFD516(createBackupData.getModule2(),createBackupData.getModule3(),createBackupData.getFinalProjectSubmission())
		.verifyRubricGrading()
		;
		
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
		
		return this;	
	}
	
	public FacilitationManagerDashboardOperations verifyApostopheFilters2(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("verifyApostopheFilters2");
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class)
		.enterCourseName(createBackupData.getCourseName2()).enterStudentName(createBackupData.getUserName1()).enterCourseCode(createBackupData.getCourseShortName()).clickFilterButton()
		.verifyTableIspresent().clickResetButton()
		;
		
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
		
		
		return this;	
	}
	
	public FacilitationManagerDashboardOperations verifyCaseSensitiveFilters(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("verifyCaseSensitiveFilters");
		NetsuiteTLHPageFactory.getPage(FacilitationManagerDashboardPage.class)
		
		.enterCourseCode(createBackupData.getCourseShortName()).selectAssignmentStatus(createBackupData.getStatusAll())
		.enterAssignmentName("Final").clickFilterButton().verifyFinalprojectSubmission()
		
		.clickResetButton().enterCourseCode(createBackupData.getCourseShortName()).selectAssignmentStatus(createBackupData.getStatusAll())
		.enterAssignmentName("Final").enterOriginalGraderName("admin").clickFilterButton().verifyCourseName(createBackupData.getCourseName())
		
		.clickResetButton().selectAssignmentStatus(createBackupData.getStatusAll()).enterCourseCode(createBackupData.getCourseShortName()
		.toUpperCase()).enterAssignmentName("Final").clickFilterButton().verifyCourseName(createBackupData.getCourseName())
		
		.clickResetButton().selectAssignmentStatus(createBackupData.getStatusAll()).enterCourseName(createBackupData.getCourseName()
		.toUpperCase()).enterAssignmentName("Final").clickFilterButton().verifyCourseName(createBackupData.getCourseName())
		
		.clickResetButton().selectAssignmentStatus(createBackupData.getStatusAll()).verifyMFD371_1("Admin")
		.verifyMFD371_2(createBackupData.getUserName3())
		
		;
		
		
		return this;	
	}
	
	
}
