package com.inetBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.EditCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC003_EditCustomerTest extends BaseClass {

	@Test
	public void editCustomer() throws IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		lp.setPassword(password);
		lp.btnclick();

		EditCustomerPage ecp = new EditCustomerPage(driver);
		ecp.clickOnEditCustLink();
		ecp.enterCustID("69057");
		ecp.clickOnSubmit();
		logger.info("validate customer account");
		ecp.editCity("Pimpri");
		ecp.editState("Maha");
		ecp.editPin("111111");
		ecp.clickEditSubmit();

		Alert text = driver.switchTo().alert();
		String exp = text.getText();
		// boolean value=Assert.assertEquals(exp, "No Changes made to Customer
		// records");
		if (exp.equals("No Changes made to Customer records")) {
			Assert.assertTrue(true);
			text.accept();
		} else {
			captureScreen(driver, "editCustomer");
			Assert.assertTrue(false);
		}
	}
}
