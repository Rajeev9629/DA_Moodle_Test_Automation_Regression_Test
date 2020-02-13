package com.netsuite.tlh.pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.framework.exceptions.DriverNotInitializedException;
import com.framework.utils.SystemConfigurations;
import com.framework.utils.Utility;
import com.moodle.tlh.tests.DatabaseTest;
import com.netsuite.tlh.factory.NetsuiteTLHPageFactory;
import com.netsuite.tlh.factory.OperationFactory;
import com.netsuite.tlh.testdata.Database;


public class DatabasePage extends BasePage {

	public DatabasePage() throws DriverNotInitializedException {
		super();
	}
	
	public DatabasePage verifyCreditTypeColumnFunctionality(String id, String expectedCreditType) throws Throwable {
		
		Class.forName("com.mysql.jdbc.Driver");
	    Connection con=DriverManager.getConnection(DatabaseTest.DB_URL,DatabaseTest.user,DatabaseTest.password); 
	    Statement statement = con.createStatement();
	    String query = "SELECT credit_type_id FROM mdl_ccategories_credit_types where id =" + "\"" + id + "\"";
	    ResultSet resultSet = statement.executeQuery(query);
	    resultSet.next();
	    String creditTypeId=resultSet.getString(1);
	     
	    Statement statement2 = con.createStatement();
	    String query2 = "SELECT credit_type FROM mdl_credit_types where id =" + "\"" + creditTypeId + "\"";
	    ResultSet resultSet2 = statement2.executeQuery(query2);
	    resultSet2.next();
	    String creditType=resultSet2.getString(1);
	    System.out.println(creditType);
	     
	    Assert.assertEquals(expectedCreditType,creditType);	
		
		return this;
	}

	
	

}
