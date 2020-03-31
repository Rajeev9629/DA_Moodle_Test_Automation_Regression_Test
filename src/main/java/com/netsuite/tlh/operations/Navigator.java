package com.netsuite.tlh.operations;

import com.netsuite.tlh.factory.OperationFactory;
import com.netsuite.tlh.testdata.CreateBackupData;

public class Navigator extends BaseOperations {

	
	public static BackUpPageOperations gotoBackUpPage() throws Throwable {
		try {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("getRestoreCoursePage");}
		catch(Exception e) {
			System.out.println("gotoBackUpPage failed");
			e.printStackTrace();
		}
		return OperationFactory.getOperation(BackUpPageOperations.class).DoTheBackup();
	}
	
	public static RestorePageOperations doRestore(CreateBackupData createBackupData) throws Throwable {
		try {
	
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("doRestore");}
		catch(Exception e) {
			System.out.println("doRestore failed");
			e.printStackTrace();
		}
		return OperationFactory.getOperation(RestorePageOperations.class).DoTheRestore2(createBackupData);
	}
	
	public static RestorePageOperations doRestore2(CreateBackupData createBackupData) throws Throwable {
		try {
	
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("doRestore");}
		catch(Exception e) {
			System.out.println("doRestore failed");
			e.printStackTrace();
		}
		return OperationFactory.getOperation(RestorePageOperations.class).DoTheRestore(createBackupData);
	}
	
	public static ParticipantsPageOperations GetParticipationOperationsPage() throws Throwable {
		try {
	
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("GetParticipationOperationsPage");}
		catch(Exception e) {
			System.out.println("GetParticipationOperationsPage failed");
			e.printStackTrace();
		}
		return OperationFactory.getOperation(ParticipantsPageOperations.class);
	}
	public static CoursePageOperations GetCoursePageOperations() throws Throwable {	
		try {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("GetCoursePageOperations");}
		catch(Exception e) {
			System.out.println("GetCoursePageOperations failed");
			e.printStackTrace();
		}
		return OperationFactory.getOperation(CoursePageOperations.class);
	}
	
	public static AssignmentsOperations GetAssignmentsOperations() throws Throwable {
		try {
			OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("GetAssignmentsOperations");
		}
		catch(Exception e) {
			System.out.println("GetAssignmentsOperations failed");
			e.printStackTrace();
		}
		return OperationFactory.getOperation(AssignmentsOperations.class);
	}
	
	public static FacilitationManagerDashboardOperations FacilitationManagerDashboardOperations() throws Throwable {
		try {	OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("FacilitationManagerDashboardOperations");}
		catch(Exception e) {
			System.out.println("FacilitationManagerDashboardOperations failed");
			e.printStackTrace();
		}
		return OperationFactory.getOperation(FacilitationManagerDashboardOperations.class);
	}
	
	public static FacilitationDashboardOperations FacilitationDashboardOperations() throws Throwable {
		try {OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("FacilitationDashboardOperations");}
		catch(Exception e) {
			System.out.println("FacilitationDashboardOperations failed");
			e.printStackTrace();
		}
		return OperationFactory.getOperation(FacilitationDashboardOperations.class);
	}
	
	public static FacilitationManagerReportOperations FacilitationManagerReportOperations() throws Throwable {
		try {OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("FacilitationManagerReportOperations");}
		catch(Exception e) {
			System.out.println("FacilitationManagerReportOperations failed");
			e.printStackTrace();
		}
		return OperationFactory.getOperation(FacilitationManagerReportOperations.class);
	}
	
}
