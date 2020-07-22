package com.moodle.SanityTest;

import java.util.LinkedHashMap;
import org.testng.annotations.Test;

import com.moodle.tlh.tests.BaseTest;

public class SanityTest extends BaseTest{
	
	@Test(priority=1,description = "MFD-0000::SanityTest", dataProvider = "getData", dataProviderClass = com.netsuite.tlh.dataprovider.NetsuiteTLHTestDataProvider.class)
	public void VerifySiteLoadsAndlogin(LinkedHashMap<String, ?> testData) throws Throwable {
		loggingStartReport("MFD-0000::SanityTest");
		System.out.println("1");
		rightNavOperations.clickHome();
			
	}
	
	
}
