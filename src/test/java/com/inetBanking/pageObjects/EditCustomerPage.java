package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage {
	WebDriver rdriver;

	public EditCustomerPage(WebDriver ldriver) {
		rdriver = ldriver;
		PageFactory.initElements(ldriver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Edit Customer')]")
	WebElement editCustLink;

	@FindBy(name = "cusid")
	WebElement txtCustID;

	@FindBy(name = "AccSubmit")
	WebElement btnSubmit;

	@FindBy(name = "city")
	WebElement txtCity;

	@FindBy(name = "state")
	WebElement txtState;

	@FindBy(name = "pinno")
	WebElement txtPin;

	@FindBy(name = "sub")
	WebElement btnnSubmit;

	public void clickOnEditCustLink() {
		editCustLink.click();
	}

	public void enterCustID(String id) {
		txtCustID.sendKeys(id);
	}

	public void clickOnSubmit() {
		btnSubmit.click();
	}

	public void editCity(String city2) {
		txtCity.clear();
		txtCity.sendKeys(city2);
	}

	public void editState(String state2) {
		txtState.clear();
		txtState.sendKeys(state2);
	}

	public void editPin(String pinn) {
		txtPin.clear();
		txtPin.sendKeys(pinn);
	}

	public void clickEditSubmit() {
		btnnSubmit.click();
	}
}
