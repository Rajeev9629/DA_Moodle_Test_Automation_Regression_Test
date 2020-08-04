package com.netsuite.tlh.operations;

import com.framework.exceptions.DriverNotInitializedException;
import com.netsuite.tlh.factory.NetsuiteTLHPageFactory;
import com.netsuite.tlh.factory.OperationFactory;
import com.netsuite.tlh.pages.ManageConfigValuesPage;
import com.netsuite.tlh.testdata.Database;

public class ManageConfigValueOperations extends BaseOperations {

	public ManageConfigValueOperations verifyManageConfigPage() throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("verifyManageConfigPage");
		NetsuiteTLHPageFactory.getPage(ManageConfigValuesPage.class).verifyInputText().verifycolumnText()
		;
		return this;	
	}
	
	public ManageConfigValueOperations addConfigValue(Database databaseData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("addConfigValue");
		NetsuiteTLHPageFactory.getPage(ManageConfigValuesPage.class).clickAddConfigValueButton().enterName(databaseData.getNameText())
		.enterValue(databaseData.getValueText()).enterModule(databaseData.getModuleText()).clickSaveButton()
		.verifyEnteredValues(databaseData.getNameText(),databaseData.getValueText(),databaseData.getModuleText())
		;
		return this;	
	}
	
	public ManageConfigValueOperations editConfigValue(Database databaseData) throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("editConfigValue");
		NetsuiteTLHPageFactory.getPage(ManageConfigValuesPage.class).clickEditLink().enterName(databaseData.getNameTextNew())
		.enterValue(databaseData.getValueTextNew()).enterModule(databaseData.getModuleTextNew()).clickSaveButton()
		.verifyEnteredValues(databaseData.getNameTextNew(),databaseData.getValueTextNew(),databaseData.getModuleTextNew())
		;
		return this;	
	}
	
	public ManageConfigValueOperations deleteConfigValue() throws DriverNotInitializedException, Throwable {
		OperationFactory.getOperation(MethodNameReportingOprations.class).setMethodName("deleteConfigValue");
		NetsuiteTLHPageFactory.getPage(ManageConfigValuesPage.class).clickDeleteLink()
		;
		return this;	
	}
	
	
	
	
}