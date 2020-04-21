package com.netsuite.tlh.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.framework.base.BrowserFactory;
import com.framework.exceptions.DriverNotInitializedException;
import com.framework.utils.SystemConfigurations;
import com.netsuite.tlh.factory.NetsuiteTLHPageFactory;
import com.netsuite.tlh.factory.OperationFactory;


public class ManageConfigValuesPage extends BasePage {

	public ManageConfigValuesPage() throws DriverNotInitializedException {
		super();
	}

	@FindBy(css = "label[for='name']")
	private WebElement nameInputText;
	
	@FindBy(css = "label[for='value']")
	private WebElement valueInputText;
	
	@FindBy(css = "label[for='module']")
	private WebElement moduleInputText;
	
	@FindBy(xpath = "//a[text()='Name']")
	private WebElement nameTableText;
	
	@FindBy(xpath = "//a[text()='Value']")
	private WebElement valueTableText;
	
	@FindBy(xpath = "//a[text()='Module']")
	private WebElement moduleTableText;
	
	@FindBy(xpath = "//a[text()='Action']")
	private WebElement actionTableText;
	
	@FindBy(id = "addconfiguration")
	private WebElement addConfigurationValueButton;
	
	@FindBy(id = "savename")
	private WebElement nameInput;
	
	@FindBy(id = "savevalue")
	private WebElement valueInput;
	
	@FindBy(id = "savemodule")
	private WebElement moduleInput;
	
	@FindBy(id = "save")
	private WebElement saveButton;
	
	@FindBy(xpath = "//table//tbody//tr//td[1]")
	private WebElement nameFirsTable;
	
	@FindBy(xpath = "//table//tbody//tr//td[2]")
	private WebElement valueFirsTable;
	
	@FindBy(xpath = "//table//tbody//tr//td[3]")
	private WebElement moduleFirsTable;
	
	@FindBy(xpath = "//a[text()='Edit']")
	private WebElement editLink;
	
	@FindBy(xpath = "//a[text()='Delete']")
	private WebElement deleteLink;
	
	public ManageConfigValuesPage clickDeleteLink() throws Throwable {
		waitForElementToBeVisibile(deleteLink);
		deleteLink.click();
		Thread.sleep(2000);
		BrowserFactory.getDriver().switchTo().alert().accept();
		Thread.sleep(2000);
		return this;
	}
	
	
	public ManageConfigValuesPage clickEditLink() throws Throwable {
		waitForElementToBeVisibile(editLink);
		editLink.click();
		return this;
	}
	
	public ManageConfigValuesPage verifyEnteredValues(String Name, String Value, String Module) throws Throwable {
		waitForElementToBeVisibile(nameFirsTable);
		waitForElementToBeVisibile(valueFirsTable);
		waitForElementToBeVisibile(moduleFirsTable);
		String nameActual=nameFirsTable.getText();
		Assert.assertEquals(nameActual,Name);
		String valueActual=valueFirsTable.getText();
		Assert.assertEquals(valueActual,Value);
		String moduleActual=moduleFirsTable.getText();
		Assert.assertEquals(moduleActual,Module);
		
		
		return this;
	}
	
	public ManageConfigValuesPage clickSaveButton() throws Throwable {
		waitForElementToBeVisibile(saveButton);
		waitForElementToBeClickable(saveButton);
		saveButton.click();
		Thread.sleep(2000);
		BrowserFactory.getDriver().switchTo().alert().accept();
		Thread.sleep(2000);
		
		return this;
	}
	
	public ManageConfigValuesPage enterName(String name) throws Throwable {
		waitForElementToBeVisibile(nameInput);
		waitForElementToBeClickable(nameInput);
		nameInput.clear();
		Thread.sleep(2000);
		nameInput.sendKeys(name);	
		return this;
	}
	
	
	public ManageConfigValuesPage enterValue(String value) throws Throwable {
		waitForElementToBeVisibile(valueInput);
		waitForElementToBeClickable(valueInput);
		valueInput.clear();
		Thread.sleep(2000);
		valueInput.sendKeys(value);	
		return this;
	}
	
	
	public ManageConfigValuesPage enterModule(String module) throws Throwable {
		waitForElementToBeVisibile(moduleInput);
		waitForElementToBeClickable(moduleInput);
		moduleInput.clear();
		Thread.sleep(2000);
		moduleInput.sendKeys(module);	
		return this;
	}
	
	
	public ManageConfigValuesPage clickAddConfigValueButton() throws Throwable {
		waitForElementToBeVisibile(addConfigurationValueButton);
		waitForElementToBeClickable(addConfigurationValueButton);
		addConfigurationValueButton.click();
		
		return this;
	}
	
	
	public ManageConfigValuesPage verifyInputText() throws Throwable {
		waitForElementToBeVisibile(nameInputText);
		waitForElementToBeVisibile(valueInputText);
		waitForElementToBeVisibile(moduleInputText);
		String nameActual=nameInputText.getText();
		Assert.assertEquals(nameActual,"Name");
		String valueActual=valueInputText.getText();
		Assert.assertEquals(valueActual,"Value");
		String moduleActual=moduleInputText.getText();
		Assert.assertEquals(moduleActual,"Module");
		
		return this;
	}
	
	public ManageConfigValuesPage verifycolumnText() throws Throwable {
		waitForElementToBeVisibile(nameTableText);
		waitForElementToBeVisibile(valueTableText);
		waitForElementToBeVisibile(moduleTableText);
		waitForElementToBeVisibile(actionTableText);
		String nameActual=nameTableText.getText();
		Assert.assertEquals(nameActual,"Name");
		String valueActual=valueTableText.getText();
		Assert.assertEquals(valueActual,"Value");
		String moduleActual=moduleTableText.getText();
		Assert.assertEquals(moduleActual,"Module");
		String actionActual=actionTableText.getText();
		Assert.assertEquals(actionActual,"Action");
		return this;
	}
	
	
	
	
	

}
