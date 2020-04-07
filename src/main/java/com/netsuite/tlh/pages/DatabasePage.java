package com.netsuite.tlh.pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.framework.base.BrowserFactory;
import com.framework.exceptions.DriverNotInitializedException;
import com.framework.utils.SystemConfigurations;
import com.framework.utils.Utility;
import com.moodle.DatabaseTest.DatabaseTest;
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
	     
	    Assert.assertEquals(expectedCreditType,creditType, "Credit type failed");	
		
		return this;
	}

public DatabasePage VerifyRecordsToMdl_assignment_typeTable(Database databaseData) throws Throwable {
	//select * from mdl_dashboard_data WHERE course_id = 2347 AND userid= 6042
	//SELECT distinct(assignment_type), total FROM mdl_dashboard_data where course_id = 2347;
		String typeName1=databaseData.getTypeName1();
		String typeName2=databaseData.getTypeName2();
		String typeName3=databaseData.getTypeName3();
		String typeName4=databaseData.getTypeName4();
		String typeName5=databaseData.getTypeName5();
		String typeName6=databaseData.getTypeName6();
		String typeName7=databaseData.getTypeName7();
		
		
		Class.forName("com.mysql.jdbc.Driver");
	    Connection con=DriverManager.getConnection(DatabaseTest.DB_URL,DatabaseTest.user,DatabaseTest.password); 
	    
	    Statement statement = con.createStatement();
	    String query = "SELECT value FROM mdl_assignment_type where type_name=" + "\""+ typeName1 + "\"";
	    ResultSet resultSet = statement.executeQuery(query);
	    resultSet.next();
	    String ActualtypeNameValue1=resultSet.getString(1);
	    String ExpectedtypeNameValue1=databaseData.getTypeNameValue1();
	    Assert.assertEquals(ActualtypeNameValue1, ExpectedtypeNameValue1,"Value 1 Failed");
	     System.out.println("1 PASSED");
	     
	    Statement statement2 = con.createStatement();
	    String query2 = "SELECT value FROM mdl_assignment_type WHERE type_name="+"\"" + typeName2 + "\"";
	    ResultSet resultSet2 = statement2.executeQuery(query2);
	    resultSet2.next();
	    String ActualtypeNameValue2=resultSet2.getString(1);
	    String ExpectedtypeNameValue2=databaseData.getTypeNameValue2();
	    Assert.assertEquals(ActualtypeNameValue2, ExpectedtypeNameValue2,"Value 2 Failed");
	    System.out.println("2 PASSED");
	    
	    Statement statement3 = con.createStatement();
	    String query3 = "SELECT value FROM mdl_assignment_type WHERE type_name="+"\"" + typeName3 + "\"";
	    ResultSet resultSet3 = statement3.executeQuery(query3);
	    resultSet3.next();
	    String ActualtypeNameValue3=resultSet3.getString(1);
	    String ExpectedtypeNameValue3=databaseData.getTypeNameValue3();
	    Assert.assertEquals(ActualtypeNameValue3, ExpectedtypeNameValue3,"Value 3 Failed");
	    System.out.println("3 PASSED");
	    
	    Statement statement4 = con.createStatement();
	    String query4 = "SELECT value FROM mdl_assignment_type WHERE type_name="+"\"" + typeName4 + "\"";
	    ResultSet resultSet4 = statement4.executeQuery(query4);
	    resultSet4.next();
	    String ActualtypeNameValue4=resultSet4.getString(1);
	    String ExpectedtypeNameValue4=databaseData.getTypeNameValue4();
	    Assert.assertEquals(ActualtypeNameValue4, ExpectedtypeNameValue4,"Value 4 Failed");
	    System.out.println("4 PASSED");
	    
	    Statement statement5 = con.createStatement();
	    String query5 = "SELECT value FROM mdl_assignment_type WHERE type_name="+"\"" + typeName5 +"\"";
	    ResultSet resultSet5 = statement5.executeQuery(query5);
	    resultSet5.next();
	    String ActualtypeNameValue5=resultSet5.getString(1);
	    String ExpectedtypeNameValue5=databaseData.getTypeNameValue5();
	    Assert.assertEquals(ActualtypeNameValue5, ExpectedtypeNameValue5,"Value 5 Failed");
	    System.out.println("5 PASSED");
	    
	    Statement statement6 = con.createStatement();
	    String query6 = "SELECT value FROM mdl_assignment_type WHERE type_name="+"\"" + typeName6 +"\"";
	    ResultSet resultSet6 = statement6.executeQuery(query6);
	    resultSet6.next();
	    String ActualtypeNameValue6=resultSet6.getString(1);
	    String ExpectedtypeNameValue6=databaseData.getTypeNameValue6();
	    Assert.assertEquals(ActualtypeNameValue6, ExpectedtypeNameValue6,"Value 6 Failed");
	    System.out.println("6 PASSED");
	    
	    Statement statement7 = con.createStatement();
	    String query7 = "SELECT value FROM mdl_assignment_type WHERE type_name="+"\"" + typeName7 +"\"";
	    ResultSet resultSet7 = statement7.executeQuery(query7);
	    resultSet7.next();
	    String ActualtypeNameValue7=resultSet7.getString(1);
	    String ExpectedtypeNameValue7=databaseData.getTypeNameValue7();
	    Assert.assertEquals(ActualtypeNameValue7, ExpectedtypeNameValue7,"Value 7 Failed");
	    System.out.println("7 PASSED");
	   
		
		return this;
	}

public DatabasePage verifymdl_dashboard_data(Database databaseData, String courseID) throws Throwable {
	
	System.out.println("COURSE ID "+courseID);
	Class.forName("com.mysql.jdbc.Driver");
    Connection con=DriverManager.getConnection(DatabaseTest.DB_URL,DatabaseTest.user,DatabaseTest.password); 
    Statement statement = con.createStatement();
    String query = "SELECT total FROM mdl_dashboard_data where course_id ="+" \""+ courseID +"\" AND assignment_type=\"Final Project\"";
    ResultSet resultSet = statement.executeQuery(query);
    resultSet.next();
    String finalProjecCountAct=resultSet.getString(1);
    String finalProjecCountExp=databaseData.getTypeNameValue1()+".00";
    Assert.assertEquals(finalProjecCountAct, finalProjecCountExp,"Final project Count Failed");
    
    Statement statement2 = con.createStatement();
    String query2 = "SELECT total FROM mdl_dashboard_data where course_id ="+" \""+ courseID +"\" AND assignment_type=\"Project Checkpoint Activities\" order by total limit 1";
    ResultSet resultSet2 = statement2.executeQuery(query2);
    resultSet2.next();
    String checkpointCountAct=resultSet2.getString(1);
    String checkpointCountExp=databaseData.getTypeNameValue2()+".00";
    Assert.assertEquals(checkpointCountAct, checkpointCountExp,"Checkpoint count Failed");
    	
	
	return this;
}

/*public static  DatabasePage String verifymdl_assigned_facilitatorsInDatabase(Database databaseData, String courseID)  {
	
	Class.forName("com.mysql.jdbc.Driver");
    Connection con=DriverManager.getConnection(DatabaseTest.DB_URL,DatabaseTest.user,DatabaseTest.password); 
    Statement statement = con.createStatement();
    
    String query = "SELECT course_id FROM mdl_assigned_facilitators WHERE course_id ="+"\""+courseID +"\"  order by course_id limit 1;";
    ResultSet resultSet = statement.executeQuery(query);
    resultSet.next();
    String courseIDAct=resultSet.getString(1);
    Assert.assertEquals(courseIDAct, courseID, "CourseID didnt match");
     
    Statement statement2 = con.createStatement();
    String query2 = "SELECT course_id FROM mdl_assigned_facilitators WHERE course_id ="+"\""+courseID +"\"  order by course_id limit 1;";
    ResultSet resultSet2 = statement2.executeQuery(query2);
    resultSet2.next();
    String dateCreatedAct=resultSet2.getString(1);
    dateCreatedAct = dateCreatedAct.replaceAll(",", "").substring(0,4);
    
    return dateCreatedAct;
	
}*/

public static String verifymdl_assigned_facilitatorsInDatabase(Database databaseData, String courseID) throws Throwable {
	
	Class.forName("com.mysql.jdbc.Driver");
    Connection con=DriverManager.getConnection(DatabaseTest.DB_URL,DatabaseTest.user,DatabaseTest.password); 
    Statement statement = con.createStatement();
    
    String query = "SELECT course_id FROM mdl_assigned_facilitators WHERE course_id ="+"\""+courseID +"\"  order by course_id limit 1;";
    ResultSet resultSet = statement.executeQuery(query);
    resultSet.next();
    String courseIDAct=resultSet.getString(1);
    Assert.assertEquals(courseIDAct, courseID, "CourseID didnt match");
     
    Statement statement2 = con.createStatement();
    String query2 = "SELECT date_created FROM mdl_assigned_facilitators WHERE course_id ="+"\""+courseID +"\"  order by course_id limit 1;";
    ResultSet resultSet2 = statement2.executeQuery(query2);
    resultSet2.next();
    String dateCreatedAct=resultSet2.getString(1);
    dateCreatedAct = dateCreatedAct.replaceAll(",", "").substring(0,4);
	
	return dateCreatedAct;
}

public static String getDataBaseTimeStamp() throws DriverNotInitializedException, InterruptedException {
	BrowserFactory.getDriver().navigate().to("https://timestampgenerator.com/");
	Thread.sleep(3000);
	String timeStamp=BrowserFactory.getDriver().findElement(By.id("copyTimestamp")).getText();
	String timeStampFinal = timeStamp.substring(0,4);
	return timeStampFinal;
}

public DatabasePage verifymdl_assigned_facilitators(Database databaseData, String courseID) throws Throwable {
	String dbDateCreated=verifymdl_assigned_facilitatorsInDatabase(databaseData, courseID);
	String actualDateCreated=getDataBaseTimeStamp();
	System.out.println("dbDateCreated: "+dbDateCreated);
	System.out.println("actualDateCreated: "+actualDateCreated);
	Assert.assertEquals(dbDateCreated, actualDateCreated,"Date Created is different");
	BrowserFactory.getDriver().navigate().back();
    
	
	return this;
}

}
