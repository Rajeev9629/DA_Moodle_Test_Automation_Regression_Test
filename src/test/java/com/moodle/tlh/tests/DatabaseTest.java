package com.moodle.tlh.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.utils.Utility;
import com.netsuite.tlh.operations.Navigator;
import com.netsuite.tlh.testdata.CreateBackupData;
import com.netsuite.tlh.testdata.Database;

public class DatabaseTest extends BaseTestDatabase {
	
	//https://jira.wiley.com/browse/TLHMFD-437
	
	public static String DB_URL;
	public static String user;
	public static String password;
	
	@Test(description = "MFD-444:: Credit type column functionality", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void MoodleFacilitatorManagerReportFeature(LinkedHashMap<String, ?> testData) throws Throwable {
		logger=extent.createTest("MFD-444:: Credit type column functionality");
		System.out.println("1");
		Database databaseData = Utility.getDataPojo(testData.get("Form"), Database.class);	
		DB_URL= "jdbc:mysql://"+databaseData.getHostName()+":"+databaseData.getPort()+"/"+databaseData.getDatabaseName();
		user=databaseData.getUser();
		password=databaseData.getPassword();
		databaseOperations.verifyCreditTypeColumnFunctionality(databaseData);
		logger.info("MFD-444:: Credit type column functionality Passed" );
		
	}

}
