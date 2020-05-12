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

public class TCS3 extends BaseTestDatabase {
	
	public static String DB_URL;
	public static String user;
	public static String password;
	
	@Test(description = "MFD-533::AddEditDelete functionality on Manage Configuration Values", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void AddEditDeleteFunctionalityManageConfigurationValues(LinkedHashMap<String, ?> testData) throws Throwable {
		logger=extent.createTest("MFD-533::AddEditDelete functionality on Manage Configuration Values");
		System.out.println("3");
		Database databaseData = Utility.getDataPojo(testData.get("Form"), Database.class);
		
		DB_URL= "jdbc:mysql://"+databaseData.getHostName()+":"+databaseData.getPort()+"/"+databaseData.getDatabaseName();
		user=databaseData.getUser();
		password=databaseData.getPassword();
		
		rightNavOperations.getManageConfigurationValuePage().addConfigValue(databaseData);
		databaseOperations.verifyConfigurationValue(databaseData.getNameText(),databaseData.getValueText(),databaseData.getModuleText());
		
		rightNavOperations.getManageConfigurationValuePage().editConfigValue(databaseData);
		databaseOperations.verifyConfigurationValue(databaseData.getNameTextNew(),databaseData.getValueTextNew(),databaseData.getModuleTextNew());
		
		rightNavOperations.getManageConfigurationValuePage().deleteConfigValue();
		databaseOperations.deleteConfigValue(databaseData.getNameTextNew(),databaseData.getValueTextNew(),databaseData.getModuleTextNew());
		
		logger.info("MFD-533::AddEditDelete functionality on Manage Configuration Values");
		
	}
	
	

}
