package com.netsuite.tlh.operations;

import com.framework.exceptions.DriverNotInitializedException;
import com.netsuite.tlh.factory.NetsuiteTLHPageFactory;
import com.netsuite.tlh.factory.OperationFactory;
import com.netsuite.tlh.pages.RightNavBar;
import com.netsuite.tlh.testdata.CreateBackupData;

public class RightNavOperations extends BaseOperations {

	public RightNavOperations getFacilitationManagerReportPage() throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("getFacilitationManagerReportPage");
		NetsuiteTLHPageFactory.getPage(RightNavBar.class).clickOnFacilitationManagerReportLink();
		return this;	
	}
	
	public RightNavOperations getFitnessPovCoursePage() throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("getFitnessPovCoursePage");
		NetsuiteTLHPageFactory.getPage(RightNavBar.class).clickOnFitnessPovCourse();
		return this;	
	}
	
	public RightNavOperations getBackUpPage() throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("getBackUpPage");
		NetsuiteTLHPageFactory.getPage(RightNavBar.class).clickOnBackupLink().verifyUserIsOnBackupCoursePage();
		return this;	
	}
	
	public RightNavOperations getEnrollParticipantsPage() throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("getEnrollParticipantsPage");
		NetsuiteTLHPageFactory.getPage(RightNavBar.class).clickOnParticipants();
		return this;	
	}
	
	public RightNavOperations getEnrollParticipantsOnlyPage() throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("getEnrollParticipantsOnlyPage");
		NetsuiteTLHPageFactory.getPage(RightNavBar.class).clickOnParticipantsOnly();
		return this;	
	}
	
	public RightNavOperations clickCourseCompletion() throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("clickCourseCompletion");
		NetsuiteTLHPageFactory.getPage(RightNavBar.class).clickcourseCompletionLink();
		return this;	
	}
	
	
	public RightNavOperations getApostopheCoursesPage() throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("getApostopheCoursesPage");
		NetsuiteTLHPageFactory.getPage(RightNavBar.class).clickOnApostopheCourse();
		return this;	
	}
	
	public RightNavOperations getCoursePage(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("getCoursePage");
		NetsuiteTLHPageFactory.getPage(RightNavBar.class).clickOnCourse(createBackupData.getCourseShortName());
		return this;	
	}
	
	public RightNavOperations clickCoursesLink() throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("clickCoursesLink");
		NetsuiteTLHPageFactory.getPage(RightNavBar.class).clickOnCourses();
		return this;	
	}
	
	public RightNavOperations clickAllCoursesLink() throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("clickAllCoursesLink");
		NetsuiteTLHPageFactory.getPage(RightNavBar.class).clickOnAllCourses();
		return this;	
	}
	
	public RightNavOperations getAssignmentsPage() throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("getAssignmentsPage");
		NetsuiteTLHPageFactory.getPage(RightNavBar.class).clickOnAssignments();
		return this;	
	}
	
	public RightNavOperations getQuizzesPage() throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("getQuizzesPage");
		NetsuiteTLHPageFactory.getPage(RightNavBar.class).clickOnQuizzesLink();
		return this;	
	}
	
	public RightNavOperations getFacilitationManagerDashboard() throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("getFacilitationManagerDashboard");
		NetsuiteTLHPageFactory.getPage(RightNavBar.class).clickOnFacilitationManagerDashboardLink();
		return this;	
	}
	
	public RightNavOperations getFacilitationDashboard() throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("getFacilitationDashboard");
		NetsuiteTLHPageFactory.getPage(RightNavBar.class).clickOnFacilitationDashboardLink();
		return this;	
	}
	
	public RightNavOperations getHome() throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("getHome");
		NetsuiteTLHPageFactory.getPage(RightNavBar.class);
		return this;	
	}
	
	public RightNavOperations clickHome() throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("clickHome");
		NetsuiteTLHPageFactory.getPage(RightNavBar.class).clickOnHomeLink();
		return this;	
	}
	
	public RightNavOperations clickHamburgerItem() throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("clickHamburgerItem");
		NetsuiteTLHPageFactory.getPage(RightNavBar.class).clickOnHamburgerItem()
		;
		return this;	
	}
	
	public RightNavOperations acceptSitePolicyAgreement() throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("acceptSitePolicyAgreement");
		NetsuiteTLHPageFactory.getPage(RightNavBar.class).acceptSitePolicyAgreement()
		;
		return this;	
	}
	
	public RightNavOperations getRestoreCoursePage() throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("getRestoreCoursePage");
		NetsuiteTLHPageFactory.getPage(RightNavBar.class).clickOnSiteAdministrationLink().clickOnSiteAdministrationCourseLink()
		.clickOnSiteAdministrationRestoreCourseLink();
		return this;	
	}
	
}