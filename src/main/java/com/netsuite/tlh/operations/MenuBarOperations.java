package com.netsuite.tlh.operations;

import com.framework.exceptions.DriverNotInitializedException;
import com.moodle.tlh.tests.BaseTest;
import com.netsuite.tlh.factory.NetsuiteTLHPageFactory;
import com.netsuite.tlh.factory.OperationFactory;
import com.netsuite.tlh.pages.BackUpPage;
import com.netsuite.tlh.pages.MenuBarPage;

public class MenuBarOperations extends BaseOperations  {

	public MenuBarOperations doLogOut() throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("doLogOut");
		NetsuiteTLHPageFactory.getPage(MenuBarPage.class).clickmenuBarDropDown().clicklogOut();
		
		return OperationFactory.getOperation(MenuBarOperations.class);
			
	}
	public MenuBarOperations doLogOutAndLogin() throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("doLogOut");
		NetsuiteTLHPageFactory.getPage(MenuBarPage.class).clickmenuBarDropDown().clicklogOut();
		OperationFactory.getOperation(LoginOperations.class).doSecondLogin(BaseTest.userName,BaseTest.passWord);
		return OperationFactory.getOperation(MenuBarOperations.class);
			
	}

	

	

}