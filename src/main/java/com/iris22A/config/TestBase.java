package com.iris22A.config;
/**
 * @author radhi
 * com.iris22A.config package contains all the test cases related to configuration of a website
 * i.e. --> open and close browser  
 */
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.iris22A.keywords.UIKeyword;

public class TestBase {
	
	@Parameters("browser-Name")
	@BeforeMethod
	public void setUp(@Optional String browserName) throws Exception {
		if (browserName == null) {
			browserName = "Chrome";
		}
		if (browserName.isEmpty()) {
			browserName = "Chrome";
			System.out.println("Setting Default Browser as Chrome..!");
		}
		UIKeyword.openBrowser(browserName);
	}
	@AfterMethod
	public void tearDown() throws Exception {
		UIKeyword.closeBrowser();
	}
}
