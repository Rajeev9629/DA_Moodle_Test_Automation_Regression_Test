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
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("DatabaseOperationsverifyCreditTypeColumnFunctionality");
		NetsuiteTLHPageFactory.getPage(DatabasePage.class).verifyCreditTypeColumnFunctionality(databaseData.getId1(),databaseData.getCreditType1())
		.verifyCreditTypeColumnFunctionality(databaseData.getId2(),databaseData.getCreditType2())
		.verifyCreditTypeColumnFunctionality(databaseData.getId3(),databaseData.getCreditType2())
		.verifyCreditTypeColumnFunctionality(databaseData.getId4(),databaseData.getCreditType2())
		.verifyCreditTypeColumnFunctionality(databaseData.getId5(),databaseData.getCreditType2())
		.verifyCreditTypeColumnFunctionality(databaseData.getId6(),databaseData.getCreditType2())
		.verifyCreditTypeColumnFunctionality(databaseData.getId7(),databaseData.getCreditType3())
		
		;
		
		return this;	
	}



	
}
