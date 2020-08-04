package com.netsuite.tlh.operations;

import com.aventstack.extentreports.ExtentTest;
import com.framework.exceptions.DriverNotInitializedException;
import com.moodle.Regression1.FullRegressionTest;
import com.netsuite.tlh.factory.NetsuiteTLHPageFactory;
import com.netsuite.tlh.factory.OperationFactory;
import com.netsuite.tlh.pages.CoursePage;
import com.netsuite.tlh.testdata.CreateBackupData;


public class CoursePageOperations extends BaseOperations {
	ExtentTest logger=FullRegressionTest.logger;
	
	public CoursePageOperations deleteRespectiveCourse(String courseName) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("deleteRespectiveCourse");
		NetsuiteTLHPageFactory.getPage(CoursePage.class).getManageCoursePage()
		.clickDeleteCourseButton(courseName).clickDeleteButton()
		.clickContinueButton();
		
		return this;	
	}
	public CoursePageOperations deleteRespectiveApostophieCourse() throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("deleteRespectiveApostophieCourse");
		NetsuiteTLHPageFactory.getPage(CoursePage.class).getApostropheCourseDeletePage().clickDeleteButton().clickContinueButton();
		logger.pass("deleteRespectiveApostophieCourse has been deleted");
		
		return this;	
	}
	public CoursePageOperations submitQuiz() throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("submitQuiz");
		NetsuiteTLHPageFactory.getPage(CoursePage.class).clickquizzesLink();
		logger.pass("submitQuiz completed");
		return this;	
	}
	
	public CoursePageOperations clickTurnEditingOn() throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("clickTurnEditingOn");
		NetsuiteTLHPageFactory.getPage(CoursePage.class).clickturnEditingOnLink();
		return this;	
	}
	
	public CoursePageOperations changeCourseName(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("changeCourseName");
		NetsuiteTLHPageFactory.getPage(CoursePage.class).clickOncourseNameSettings().clickOncourseNameEditSettings()
		.changeCourseFullNameInputBox(createBackupData.getCourseName2()).clickSaveAndDisplayButton();
		logger.pass("Course name has been changed");
		return this;	
	}
	
	public CoursePageOperations changeAssignmentName(String Module,String NewName) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("changeAssignmentName");
		NetsuiteTLHPageFactory.getPage(CoursePage.class).clickOnEditLinkforCourse(Module).clickOnEditSettings(Module)
		.changeAssignmentName(NewName).clicksaveAndReturnCourseButton()
		;
		logger.pass("Assignment name has been changed");
		return this;	
	}
	
	public CoursePageOperations verifyCheckPoints() throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("verifyCheckPoints");
		NetsuiteTLHPageFactory.getPage(CoursePage.class).verifyCheckPoints().clickModule2ProjectCheckpointLink()
		.clickEditSubmissionButton().clickAddButton().uploadAFile();
		logger.pass("Checkpoints has been verified");
		
		return this;	
	}
	
	public CoursePageOperations clickTurnEditingOff() throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("clickTurnEditingOff");
		NetsuiteTLHPageFactory.getPage(CoursePage.class).clickturnEditingOffLink();
		return this;	
	}
	
	public CoursePageOperations doActivityCompletion(String Module,CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("doActivityCompletion");
		NetsuiteTLHPageFactory.getPage(CoursePage.class).clickOnEditLinkforCourse(Module).
		clickOnEditSettings(Module).clickActivityCompletionHeader().selectCompletionTracking(createBackupData.getActivityDetails())
		.clickcompleteGradeCheckBox().clicksubmitActivityCheckBox().clicksaveAndReturnCourseButton();
		return this;	
	}
	
	public CoursePageOperations changeParticipationAcknowledgementName() throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("changeParticipationAcknowledgementName");
		NetsuiteTLHPageFactory.getPage(CoursePage.class).changeParticipationAcknowledgementName().clicksaveAndReturnCourseButton()
		;
		return this;	
	}
	
	public CoursePageOperations doParticipationAcknowledgement(String Module,CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("doParticipationAcknowledgement");
		NetsuiteTLHPageFactory.getPage(CoursePage.class).clickOnEditLinkforCourse(Module).
		clickOnEditSettings(Module).clickActivityCompletionHeader().selectCompletionTracking(createBackupData.getActivityDetails())
		.clickcompleteGradeCheckBox().clicksaveAndReturnCourseButton();
		return this;	
	}
	
	public CoursePageOperations doCourseCompletion(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("doCourseCompletion");
		NetsuiteTLHPageFactory.getPage(CoursePage.class).selectCompletionRequirements(createBackupData.getCompletionRequirement())
		.clickActivityCompletionHeader2().clickSelectAll().clickSaveChangesButton1()
		;
		return this;	
	}
	
	public CoursePageOperations completeParticipationAcknowledgement(CreateBackupData createBackupData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("completeParticipationAcknowledgement");
		NetsuiteTLHPageFactory.getPage(CoursePage.class).clickparticipationAcknowledgementLink().clickattemptQuizNowButton()
		.clickQuizAnswerOption().clickfinishAttemptButton().clicksubmitAllAndFinishButton().clickfinishReviewLink()
		;
		logger.pass("ParticipationAcknowledgement has been completed");
		return this;	
	}
	
	public CoursePageOperations completeParticipationAcknowledgement2() throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("completeParticipationAcknowledgement2");
		NetsuiteTLHPageFactory.getPage(CoursePage.class).clickParticipationAcknowledgementLink().clickattemptQuizNowButton()
		.clickQuizAnswerOption().clickfinishAttemptButton().clicksubmitAllAndFinishButton().clickfinishReviewLink()
		;
		logger.pass("ParticipationAcknowledgement2 has been completed");
		
		return this;	
	}
	
	public CoursePageOperations completeParticipationAgreement() throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("clickParticipationAgreementLink");
		NetsuiteTLHPageFactory.getPage(CoursePage.class).clickParticipationAgreementLink().clickattemptQuizNowButton()
		.clickQuizAnswerOption().clickfinishAttemptButton().clicksubmitAllAndFinishButton().clickfinishReviewLink()
		;
		logger.pass("ParticipationAcknowledgement2 has been completed");
		
		return this;	
	}
	
}
