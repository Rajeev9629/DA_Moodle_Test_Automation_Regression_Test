package com.netsuite.tlh.operations;

import com.netsuite.tlh.factory.OperationFactory;
import com.netsuite.tlh.testdata.CreateBackupData;

public class Navigator extends BaseOperations {

	
	public static BackUpPageOperations gotoBackUpPage() throws Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("getRestoreCoursePage");
		return OperationFactory.getOperation(BackUpPageOperations.class).DoTheBackup();
	}
	
	public static RestorePageOperations doRestore(CreateBackupData createBackupData) throws Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("doRestore");
		return OperationFactory.getOperation(RestorePageOperations.class).DoTheRestore2(createBackupData);
	}
	
	public static RestorePageOperations doRestore2(CreateBackupData createBackupData) throws Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("doRestore");
		return OperationFactory.getOperation(RestorePageOperations.class).DoTheRestore(createBackupData);
	}
	
	public static ParticipantsPageOperations GetParticipationOperationsPage() throws Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("GetParticipationOperationsPage");
		return OperationFactory.getOperation(ParticipantsPageOperations.class);
	}
	public static CoursePageOperations GetCoursePageOperations() throws Throwable {	
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("GetCoursePageOperations");
		return OperationFactory.getOperation(CoursePageOperations.class);
	}
	
	public static AssignmentsOperations GetAssignmentsOperations() throws Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("GetAssignmentsOperations");
		return OperationFactory.getOperation(AssignmentsOperations.class);
	}
	
	public static FacilitationManagerDashboardOperations FacilitationManagerDashboardOperations() throws Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("FacilitationManagerDashboardOperations");
		return OperationFactory.getOperation(FacilitationManagerDashboardOperations.class);
	}
	
	public static FacilitationDashboardOperations FacilitationDashboardOperations() throws Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("FacilitationDashboardOperations");
		return OperationFactory.getOperation(FacilitationDashboardOperations.class);
	}
	
	public static FacilitationManagerReportOperations FacilitationManagerReportOperations() throws Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("FacilitationManagerReportOperations");
		return OperationFactory.getOperation(FacilitationManagerReportOperations.class);
	}
	
}
