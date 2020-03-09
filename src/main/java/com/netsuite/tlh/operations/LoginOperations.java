package com.netsuite.tlh.operations;

import com.framework.exceptions.DriverNotInitializedException;
import com.netsuite.tlh.factory.NetsuiteTLHPageFactory;
import com.netsuite.tlh.factory.OperationFactory;
import com.netsuite.tlh.pages.LoginPage;

public class LoginOperations implements IOperations {

	public HomeOperations doLogin(String userName, String passWord) throws DriverNotInitializedException, Throwable {
		try {OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("doLogin");
		NetsuiteTLHPageFactory.getPage(LoginPage.class).doLogIn(userName, passWord);}
		catch(Exception e) {
			System.out.println("doLogin failed");
			e.printStackTrace();
		}
		return OperationFactory.getOperation(HomeOperations.class);
	}
	
	public HomeOperations doSecondLogin(String userName, String passWord) throws DriverNotInitializedException, Throwable {
		try {OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("doSecondLogin");
		NetsuiteTLHPageFactory.getPage(LoginPage.class).doSecondLogIn(userName, passWord);}
		catch(Exception e) {
			System.out.println("doSecondLogin failed");
			e.printStackTrace();
		}
		return OperationFactory.getOperation(HomeOperations.class);
	}

	
}
