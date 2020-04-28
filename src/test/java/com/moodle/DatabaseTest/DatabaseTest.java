package com.moodle.DatabaseTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.base.BrowserFactory;
import com.framework.utils.Utility;
import com.moodle.tlh.tests.BaseTestDatabase;
import com.netsuite.tlh.operations.Navigator;
import com.netsuite.tlh.pages.RightNavBar;
import com.netsuite.tlh.testdata.CreateBackupData;
import com.netsuite.tlh.testdata.Database;

public class DatabaseTest extends BaseTestDatabase {
	
	public static String DB_URL;
	public static String user;
	public static String password;
	
	@Test(description = "MFD-444:: Credit type column functionality", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void MoodleFacilitatorManagerReportFeature(LinkedHashMap<String, ?> testData) throws Throwable {
		//https://jira.wiley.com/browse/TLHMFD-437
		logger=extent.createTest("MFD-444:: Credit type column functionality");
		System.out.println("1");
		Database databaseData = Utility.getDataPojo(testData.get("Form"), Database.class);	
		DB_URL= "jdbc:mysql://"+databaseData.getHostName()+":"+databaseData.getPort()+"/"+databaseData.getDatabaseName();
		user=databaseData.getUser();
		password=databaseData.getPassword();
		databaseOperations.verifyCreditTypeColumnFunctionality(databaseData);
		logger.info("MFD-444:: Credit type column functionality Passed" );
		
	}
	
	@Test(description = "MFD-503::MFD-397:: VerifyRecordsToMdl_assignment_typeTableAndmdl_assigned_facilitators", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void VerifyRecordsToMdl_assignment_typeTable(LinkedHashMap<String, ?> testData) throws Throwable {
		
		
		loggingStartReport("MFD-503:: VerifyRecordsToMdl_assignment_typeTableAndmdl_assigned_facilitators");
		CreateBackupData createBackupData = Utility.getDataPojo(testData.get("Form"), CreateBackupData.class);
		System.out.println("2");
		
		rightNavOperations.getRestoreCoursePage();
		Navigator.doRestore(createBackupData);
		
		rightNavOperations.getEnrollParticipantsPage()
		.enrollStudent(createBackupData,createBackupData.getUserName1())
		.enrollFacilitator(createBackupData,createBackupData.getUserName2())
		.enrollFacilitationManager(createBackupData,createBackupData.getUserName3());
		
		rightNavOperations.getEnrollParticipantsPage()
		.loginAsRespectiveUser(createBackupData.getRole1(),createBackupData.getUserName1(),createBackupData.getCourseShortName());
		rightNavOperations.getAssignmentsPage().completeAssingments();
		
		menuBarOperations.doLogOut();	
		loginOperations.doSecondLogin(userName, passWord);
		rightNavOperations.getFacilitationManagerDashboard().gradeAssigment(createBackupData);
		rightNavOperations.searchAndGetCoursePage(createBackupData);
		rightNavOperations.getFacilitationManagerDashboard().signOff(createBackupData);

		String courseID=RightNavBar.courseID;
		Database databaseData = Utility.getDataPojo(testData.get("Form"), Database.class);	
		DB_URL= "jdbc:mysql://"+databaseData.getHostName()+":"+databaseData.getPort()+"/"+databaseData.getDatabaseName();
		user=databaseData.getUser();
		password=databaseData.getPassword();
		databaseOperations
		.VerifyRecordsToMdl_assignment_typeTable(databaseData)
		.verifymdl_dashboard_data(databaseData,courseID)
		//till 4 digit
		.verifymdl_assigned_facilitators(databaseData, courseID)
		;
		
		
		logger.info("MFD-503:: VerifyRecordsToMdl_assignment_typeTableAndmdl_assigned_facilitators");
		
	}

}
