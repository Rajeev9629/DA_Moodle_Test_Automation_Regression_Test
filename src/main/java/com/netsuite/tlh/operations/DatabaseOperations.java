package com.netsuite.tlh.operations;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.framework.exceptions.DriverNotInitializedException;
import com.framework.utils.SystemConfigurations;
import com.netsuite.tlh.base.INetsuiteTLHParams;
import com.netsuite.tlh.factory.NetsuiteTLHPageFactory;
import com.netsuite.tlh.factory.OperationFactory;
import com.netsuite.tlh.pages.DatabasePage;
import com.netsuite.tlh.pages.FacilitationSignOffReportPage;
import com.netsuite.tlh.pages.HomePage;
import com.netsuite.tlh.pages.ParticipantsPage;
import com.netsuite.tlh.testdata.Database;

public class DatabaseOperations extends BaseOperations {
	
	public DatabaseOperations verifyCreditTypeColumnFunctionality(Database databaseData) throws DriverNotInitializedException, Throwable {
		try {OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("DatabaseOperationsverifyCreditTypeColumnFunctionality");
		NetsuiteTLHPageFactory.getPage(DatabasePage.class).verifyCreditTypeColumnFunctionality(databaseData.getId1(),databaseData.getCreditType1())
		.verifyCreditTypeColumnFunctionality(databaseData.getId2(),databaseData.getCreditType2())
		.verifyCreditTypeColumnFunctionality(databaseData.getId3(),databaseData.getCreditType2())
		.verifyCreditTypeColumnFunctionality(databaseData.getId4(),databaseData.getCreditType2())
		.verifyCreditTypeColumnFunctionality(databaseData.getId5(),databaseData.getCreditType2())
		.verifyCreditTypeColumnFunctionality(databaseData.getId6(),databaseData.getCreditType2())
		.verifyCreditTypeColumnFunctionality(databaseData.getId7(),databaseData.getCreditType3())
		;
		}
		catch(Exception e) {
			System.out.println("verifyCreditTypeColumnFunctionality failed");
			e.printStackTrace();
		}
		return this;	
	}
	
	public DatabaseOperations VerifyRecordsToMdl_assignment_typeTable(Database databaseData) throws DriverNotInitializedException, Throwable {
		try {OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("VerifyRecordsToMdl_assignment_typeTable");
		NetsuiteTLHPageFactory.getPage(DatabasePage.class)
		.VerifyRecordsToMdl_assignment_typeTable(databaseData)
		;
		}
		catch(Exception e) {
			System.out.println("VerifyRecordsToMdl_assignment_typeTable failed");
			e.printStackTrace();
		}
		return this;	
	}
	
	public DatabaseOperations verifymdl_dashboard_data(Database databaseData, String courseID) throws DriverNotInitializedException, Throwable {
		try {OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("verifymdl_dashboard_data");
		NetsuiteTLHPageFactory.getPage(DatabasePage.class)
		.verifymdl_dashboard_data(databaseData,courseID)
		;
		}
		catch(Exception e) {
			System.out.println("verifymdl_dashboard_data failed");
			e.printStackTrace();
		}
		return this;	
	}

	public DatabaseOperations verifymdl_assigned_facilitators(Database databaseData, String courseID) throws DriverNotInitializedException, Throwable {
		try {OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("verifymdl_assigned_facilitators");
		NetsuiteTLHPageFactory.getPage(DatabasePage.class)
		.verifymdl_assigned_facilitators(databaseData,courseID)
		;
		
		}
		catch(Exception e) {
			System.out.println("verifymdl_assigned_facilitators failed");
			e.printStackTrace();
		}
		return this;	
	}
	
	public DatabaseOperations verifyConfigurationValue(String name, String value, String module) throws DriverNotInitializedException, Throwable {
		try {OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("verifyConfigurationValue");
		NetsuiteTLHPageFactory.getPage(DatabasePage.class)
		.verifyConfigurationValue(name,value , module)
		;
		
		}
		catch(Exception e) {
			System.out.println("verifyConfigurationValue failed");
			e.printStackTrace();
		}
		return this;	
	}
	
	public DatabaseOperations deleteConfigValue(String name, String value, String module) throws DriverNotInitializedException, Throwable {
		try {OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("deleteConfigValue");
		NetsuiteTLHPageFactory.getPage(DatabasePage.class).verifyConfigurationValueDeleted(name, value, module)
		
		;
		
		}
		catch(Exception e) {
			System.out.println("deleteConfigValue failed");
			e.printStackTrace();
		}
		return this;	
	}



	
}
