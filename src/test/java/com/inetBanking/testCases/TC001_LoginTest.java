package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

public class TC001_LoginTest extends BaseClass
{
	@Test
	public void loginTest() throws IOException {
		
		logger.info("url is entered");
		
		LoginPage lp=new LoginPage(driver);
		
		lp.setUsername(username);
		logger.info("username is entered...");
		lp.setPassword(password);
		logger.info("password is entered");
		lp.btnclick();
		
		
		if(driver.getTitle().equals("GTPL Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}else {
			captureScreen(driver, "loginTest");
			logger.info("Login test failed");
			Assert.assertTrue(false);		
		}	
	}
}
