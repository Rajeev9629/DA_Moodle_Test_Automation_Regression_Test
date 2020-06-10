package com.netsuite.tlh.operations;

import com.framework.exceptions.DriverNotInitializedException;
import com.netsuite.tlh.factory.NetsuiteTLHPageFactory;
import com.netsuite.tlh.factory.OperationFactory;
import com.netsuite.tlh.pages.RightNavBar;
import com.netsuite.tlh.testdata.CreateBackupData;

public class RightNavOperations extends BaseOperations {

	public FacilitationManagerReportOperations getFacilitationManagerReportPage() throws DriverNotInitializedException, Throwable {
		try {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("getFacilitationManagerReportPage");
		NetsuiteTLHPageFactory.getPage(RightNavBar.class).clickOnFacilitationManagerReportLink();
		}
		catch(Exception e) {
			System.out.println("getFacilitationManagerReportPage failed");
			e.printStackTrace();
		}
		return OperationFactory.getOperation(FacilitationManagerReportOperations.class);	
	}
	
	public RightNavOperations getFitnessPovCoursePage() throws DriverNotInitializedException, Throwable {
		try {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("getFitnessPovCoursePage");
		NetsuiteTLHPageFactory.getPage(RightNavBar.class).clickOnFitnessPovCourse();
		}
		catch(Exception e) {
			System.out.println("getFitnessPovCoursePage failed");
			e.printStackTrace();
		}
		return this;	
	}
	
	public RightNavOperations getBackUpPage() throws DriverNotInitializedException, Throwable {
		try {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("getBackUpPage");
		NetsuiteTLHPageFactory.getPage(RightNavBar.class).clickOnBackupLink().verifyUserIsOnBackupCoursePage();
		}
		catch(Exception e) {
			System.out.println("getBackUpPage failed");
			e.printStackTrace();
		}
		return this;	
	}
	public RightNavOperations searchAndGetCoursePage(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		try {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("searchAndGetCoursePage");
		NetsuiteTLHPageFactory.getPage(RightNavBar.class).clickOnCourses().searchAndGoToCourse(createBackupData.getCourseName());
		}
		catch(Exception e) {
			System.out.println("searchAndGetCoursePage failed");
			e.printStackTrace();
		}
		return this;	
	}
	
	public RightNavOperations searchAndGetNewCoursePage(CreateBackupData createBackupData, String courseName) throws DriverNotInitializedException, Throwable {
		try {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("searchAndGetCoursePage");
		NetsuiteTLHPageFactory.getPage(RightNavBar.class).clickOnCourses().searchAndGoToCourse(courseName);
		}
		catch(Exception e) {
			System.out.println("searchAndGetCoursePage failed");
			e.printStackTrace();
		}
		return this;	
	}
	
	
	public ParticipantsPageOperations getEnrollParticipantsPage1() throws DriverNotInitializedException, Throwable {
		try {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("getEnrollParticipantsPage");
		NetsuiteTLHPageFactory.getPage(RightNavBar.class).clickOnParticipants1();
		}
		catch(Exception e) {
			System.out.println("getEnrollParticipantsPage failed");
			e.printStackTrace();
		}
		return OperationFactory.getOperation(ParticipantsPageOperations.class);	
	}
	
	
	public ParticipantsPageOperations getEnrollParticipantsPage() throws DriverNotInitializedException, Throwable {
		try {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("getEnrollParticipantsPage");
		NetsuiteTLHPageFactory.getPage(RightNavBar.class).clickOnParticipants();
		}
		catch(Exception e) {
			System.out.println("getEnrollParticipantsPage failed");
			e.printStackTrace();
		}
		return OperationFactory.getOperation(ParticipantsPageOperations.class);	
	}
	
	public RightNavOperations getEnrollParticipantsOnlyPage() throws DriverNotInitializedException, Throwable {
		try {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("getEnrollParticipantsOnlyPage");
		NetsuiteTLHPageFactory.getPage(RightNavBar.class).clickOnParticipantsOnly();
		}
		catch(Exception e) {
			System.out.println("getEnrollParticipantsOnlyPage failed");
			e.printStackTrace();
		}
		return this;	
	}
	
	public RightNavOperations clickCourseCompletion() throws DriverNotInitializedException, Throwable {
		try {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("clickCourseCompletion");
		NetsuiteTLHPageFactory.getPage(RightNavBar.class).clickcourseCompletionLink();
		}
		catch(Exception e) {
			System.out.println("clickCourseCompletion failed");
			e.printStackTrace();
		}
		return this;	
	}
	
	
	public RightNavOperations getApostopheCoursesPage() throws DriverNotInitializedException, Throwable {
		try {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("getApostopheCoursesPage");
		NetsuiteTLHPageFactory.getPage(RightNavBar.class).clickOnApostopheCourse();
		}
		catch(Exception e) {
			System.out.println("getApostopheCoursesPage failed");
			e.printStackTrace();
		}
		return this;	
	}
	
	public RightNavOperations searchForCourse(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		try {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("getCoursePage");
		NetsuiteTLHPageFactory.getPage(RightNavBar.class).clickOnCourse(createBackupData.getCourseSearch());
		}
		catch(Exception e) {
			System.out.println("getCoursePage failed");
			e.printStackTrace();
		}
		return this;	
	}
	
	
	public RightNavOperations getCoursePage(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		try {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("getCoursePage");
		NetsuiteTLHPageFactory.getPage(RightNavBar.class).clickOnCourse(createBackupData.getCourseShortName());
		}
		catch(Exception e) {
			System.out.println("getCoursePage failed");
			e.printStackTrace();
		}
		return this;	
	}
	
	public RightNavOperations clickCoursesLink() throws DriverNotInitializedException, Throwable {
		try {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("clickCoursesLink");
		NetsuiteTLHPageFactory.getPage(RightNavBar.class).clickOnCourses();
		}
		catch(Exception e) {
			System.out.println("clickCoursesLink failed");
			e.printStackTrace();
		}
		return this;	
	}
	
	public RightNavOperations clickAllCoursesLink() throws DriverNotInitializedException, Throwable {
		try {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("clickAllCoursesLink");
		NetsuiteTLHPageFactory.getPage(RightNavBar.class).clickOnAllCourses();
		}
		catch(Exception e) {
			System.out.println("clickAllCoursesLink failed");
			e.printStackTrace();
		}
		return this;	
	}
	
	public AssignmentsOperations getAssignmentsPage() throws DriverNotInitializedException, Throwable {
		try {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("getAssignmentsPage");
		NetsuiteTLHPageFactory.getPage(RightNavBar.class).clickOnAssignments();
		}
		catch(Exception e) {
			System.out.println("getAssignmentsPage failed");
			e.printStackTrace();
		}
		return OperationFactory.getOperation(AssignmentsOperations.class);	
	}
	
	public RightNavOperations getQuizzesPage() throws DriverNotInitializedException, Throwable {
		try {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("getQuizzesPage");
		NetsuiteTLHPageFactory.getPage(RightNavBar.class).clickOnQuizzesLink();
		}
		catch(Exception e) {
			System.out.println("getQuizzesPage failed");
			e.printStackTrace();
		}
		return this;	
	}
	
	public FacilitationManagerDashboardOperations getFacilitationManagerDashboard() throws DriverNotInitializedException, Throwable {
		try {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("getFacilitationManagerDashboard");
		NetsuiteTLHPageFactory.getPage(RightNavBar.class).clickOnFacilitationManagerDashboardLink();
		}
		catch(Exception e) {
			System.out.println("getFacilitationManagerDashboard failed");
			e.printStackTrace();
		}
		return OperationFactory.getOperation(FacilitationManagerDashboardOperations.class);	
	}
	
	public RightNavOperations getFacilitationDashboard() throws DriverNotInitializedException, Throwable {
		try {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("getFacilitationDashboard");
		NetsuiteTLHPageFactory.getPage(RightNavBar.class).clickOnFacilitationDashboardLink();
		}
		catch(Exception e) {
			System.out.println("getFacilitationDashboard failed");
			e.printStackTrace();
		}
		return this;	
	}
	
	public RightNavOperations verifyFacilitationManagerDashboard() throws DriverNotInitializedException, Throwable {
		try {
	
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("verifyFacilitationManagerDashboard");
		NetsuiteTLHPageFactory.getPage(RightNavBar.class).verifyFacilitationManagerDashboardLink()
		;
	}
	catch(Exception e) {
		System.out.println("verifyFacilitationManagerDashboard failed");
		e.printStackTrace();
	}
		return this;	
	}
	
	public RightNavOperations getHome() throws DriverNotInitializedException, Throwable {
		try {
	
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("getHome");
		NetsuiteTLHPageFactory.getPage(RightNavBar.class);
		}
		catch(Exception e) {
			System.out.println("getHome failed");
			e.printStackTrace();
		}
		return this;	
	}
	
	public RightNavOperations clickHome() throws DriverNotInitializedException, Throwable {
		try {
	
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("clickHome");
		NetsuiteTLHPageFactory.getPage(RightNavBar.class).clickOnHomeLink();
		}
		catch(Exception e) {
			System.out.println("clickHome failed");
			e.printStackTrace();
		}
		return this;	
	}
	
	public RightNavOperations clickHamburgerItem() throws DriverNotInitializedException, Throwable {
		try {
	
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("clickHamburgerItem");
		NetsuiteTLHPageFactory.getPage(RightNavBar.class).clickOnHamburgerItem()
		;
		}
		catch(Exception e) {
			System.out.println("clickHamburgerItem failed");
			e.printStackTrace();
		}
		return this;	
	}
	
	public RightNavOperations acceptSitePolicyAgreement() throws DriverNotInitializedException, Throwable {
		try {
	
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("acceptSitePolicyAgreement");
		NetsuiteTLHPageFactory.getPage(RightNavBar.class).acceptSitePolicyAgreement()
		;
		}
		catch(Exception e) {
			System.out.println("acceptSitePolicyAgreement failed");
			e.printStackTrace();
		}
		return this;	
	}
	
	public RightNavOperations getRestoreCoursePage() throws DriverNotInitializedException, Throwable {
		try {
	
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("getRestoreCoursePage");
		NetsuiteTLHPageFactory.getPage(RightNavBar.class).clickOnSiteAdministrationLink().clickOnSiteAdministrationCourseLink()
		.clickOnSiteAdministrationRestoreCourseLink();
		}
		catch(Exception e) {
			System.out.println("getRestoreCoursePage failed");
			e.printStackTrace();
		}
		return this;	
	}
	
	public FacilitationSignOffReportOperations getSignOffPage() throws DriverNotInitializedException, Throwable {
		try {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("getSignOffPage");
		NetsuiteTLHPageFactory.getPage(RightNavBar.class).clickOnFacilitationSignOffReportLink()
		;
		}
		catch(Exception e) {
			System.out.println("getSignOffPage failed");
			e.printStackTrace();
		}
		return OperationFactory.getOperation(FacilitationSignOffReportOperations.class);	
	}
	
	public ManageConfigValueOperations getManageConfigurationValuePage() throws DriverNotInitializedException, Throwable {
		try {
	
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("getManageConfigurationValuePage");
		NetsuiteTLHPageFactory.getPage(RightNavBar.class).clickOnManageConfigurationValuePage();
		}
		catch(Exception e) {
			System.out.println("getManageConfigurationValuePage failed");
			e.printStackTrace();
		}
		return OperationFactory.getOperation(ManageConfigValueOperations.class);	
	}
	
	public DashboardOperations getDashboardPage() throws DriverNotInitializedException, Throwable {
		try {
	
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("getDashboardPage");
		NetsuiteTLHPageFactory.getPage(RightNavBar.class).clickdashboardLink();
		}
		catch(Exception e) {
			System.out.println("getDashboardPage failed");
			e.printStackTrace();
		}
		return OperationFactory.getOperation(DashboardOperations.class);	
	}
	
}