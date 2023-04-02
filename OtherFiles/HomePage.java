package com.clearTrip.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver rdriver;

	public HomePage(WebDriver ldriver) {
		rdriver = ldriver;
		PageFactory.initElements(ldriver, this);
	}

	@FindBy(xpath = "//div[@class='px-1   flex flex-middle nmx-1 pb-1']")
	WebElement closePopup;

	@FindBy(xpath = "//input[@placeholder='Where from?']")
	WebElement txtFromWhere;

	@FindBy(xpath = "//input[@placeholder='Where to?']")
	WebElement txtFromTo;

	@FindBy(xpath = "//div[@class='mr-4']/p")
	WebElement firstCityFrom;

	@FindBy(xpath = "//div[@class='mr-4']/p")
	WebElement firstCityTo;

	@FindBy(xpath = "//*[contains(text(),'Search flights')]")
	WebElement btnSearchFlight;

	@FindBy(xpath = "//p[contains(@class, 'm-0 fs-5 fw-700 c-neutral-900 false')]")
	List<WebElement> eachFlightPrice;

	@FindBy(xpath = "//p[contains(@class,'m-0 fs-caption-2 mb-1 c-')]")
	List<WebElement> allDates;

	@FindBy(xpath = "//p[contains(@class,'m-0 fs-caption-2 fw-600 c-')]")
	List<WebElement> allPrices;

	@FindBy(xpath = "//div[@role='button']")
	List<WebElement> eachFlightDate;

	@FindBy(xpath = "//span[@data-testid='chevRight']")
	WebElement btnNextDate;

	@FindBy(xpath = "// button[text()='Book']")
	List<WebElement> btnBook;

	@FindBy(xpath = "(//div[text()='30'])[1]")
	WebElement nextDate;

	@FindBy(xpath = "//div[text()='Wed, Mar 29']")
	WebElement txtDate;

	@FindBy(xpath = "//button[text()='Search']")
	WebElement btnSearch;

	public void closePopup() {
		closePopup.click();
	}

	public void enterCityWhereFrom(String cityFrom) {
		txtFromWhere.sendKeys(cityFrom);
	}

	public void enterCityWhereTo(String cityTo) {
		txtFromTo.sendKeys(cityTo);
	}

	public void selectFirstCityFrom() {
		firstCityFrom.click();
	}

	public void selectFirstCityTo() {
		firstCityTo.click();
	}

	public void clickOnSearch() throws InterruptedException {
		btnSearchFlight.click();
		Thread.sleep(5000);
	}

	public void getText() throws InterruptedException {

		if (rdriver.getPageSource().contains("No flights found for this search")) {
			txtDate.click();
			nextDate.click();
			btnSearch.click();
			Thread.sleep(4000);
		} else {
			for (WebElement eachDate : allDates) {
				for (WebElement eachPrice : allPrices) {
					String priceText = eachPrice.getText();
					String numericText = priceText.replaceAll("[^\\d]", "");
					int price = Integer.parseInt(numericText);
					if (price <= 5000) {
						eachDate.click();
						System.out.println(eachDate + " " + price);
						for (int i = 0; i < eachFlightPrice.size(); i++) {
							WebElement eachFlight = eachFlightPrice.get(i);
							String priceText2 = eachFlight.getText();
							String numericText2 = priceText2.replaceAll("[^\\d]", "");
							int price2 = Integer.parseInt(numericText2);
							if (price2 <= 5000) {
								WebElement button = rdriver
										.findElement(By.xpath("(//button[text()='Book'])[" + i + "]"));
								button.click();
							}
						}
					}
				}
				btnNextDate.click();
				Thread.sleep(1000);
			}
		}
	}
}
