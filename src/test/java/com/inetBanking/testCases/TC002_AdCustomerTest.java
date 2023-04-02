package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomer;
import com.inetBanking.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC002_AdCustomerTest extends BaseClass{
	
	@Test
	public void AddCustomerTest() throws IOException, InterruptedException {
		
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(username);
		logger.info("Username is Entered.");
		lp.setPassword(password);
		logger.info("Password is Entered.");
		lp.btnclick();
		
		
		AddCustomer ad=new AddCustomer(driver);
		ad.clickOnNewCustLink();
		logger.info("Entering Customer Details.");
		ad.enterCustName("Shubham");
		logger.info("Entering Customer Name");
		
		ad.selectMale();
		logger.info("Selecting Male Radio");
		
		ad.enterDOB("02", "05", "1997");
		logger.info("DOB Entered");
		Thread.sleep(3000);
		ad.enterAddress("Pune, Maharashtra");
		ad.enterCity("Pune");
		ad.enterState("MH");
		ad.enterPin(410501);
		logger.info("Pincode Entered");
		ad.enterMobileNum("9822856268");
		
		String val=BaseClass.getRandomString();
		String email=val+"@email.com";
		ad.enterEmail(email);
		logger.info("Email Entered");
		//ad.enterPassword("suraj@123");
		logger.info("Password Entered");
		ad.clickSubmit();	
		Thread.sleep(2000);
		
		boolean value=driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(value==true) {
			Assert.assertTrue(true);
			logger.info("AddCustomerTestCase Passed.");
		}
		else {
			captureScreen(driver, "AddCustomerTest");
			logger.info("AddCustomerTestCase Failed.");
			Assert.assertTrue(false);
		}
		
	}
	
}
