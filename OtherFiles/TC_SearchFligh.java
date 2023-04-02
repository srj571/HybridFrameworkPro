package com.clearTrip.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.clearTrip.pageObjects.HomePage;

public class TC_SearchFligh extends BaseClass {
	@Test
	public void searchFlight() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		hp.closePopup();
		Thread.sleep(8000);
		
		hp.enterCityWhereFrom("Delhi");
		logger.info("Delhi entered in text field.");
		Thread.sleep(3000);
		
		hp.selectFirstCityFrom();
		Thread.sleep(3000);
		
		hp.enterCityWhereTo("Leh");
		logger.info("Leh entered in text field.");
		Thread.sleep(3000);
		
		hp.selectFirstCityTo();
		Thread.sleep(3000);
		
		hp.clickOnSearch();
		logger.info("Clicked on Search Flights button.");
		Thread.sleep(6000);
		
		logger.info("Searching for date of flights which has price less than 5000 Rs. ");
		hp.getText();
		
		WebDriverWait wait =new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-testid='chevRight']")));
	}
}
