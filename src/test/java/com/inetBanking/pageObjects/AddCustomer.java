package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomer {
	WebDriver rdriver;

	public AddCustomer(WebDriver ldriver) {
		rdriver = ldriver;
		PageFactory.initElements(ldriver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'New Customer')]")
	WebElement newCustLink;
	

	@FindBy(xpath = "//tbody/tr[4]/td[2]/input[1]")
	WebElement txtCustName;

	@FindBy(name = "dob")
	WebElement dateOfBirth;

	@FindBy(xpath = "//tbody/tr[5]/td[2]/input[1]")
	WebElement maleRadio;

	@FindBy(name = "addr")
	WebElement txtAddrs;

	@FindBy(name = "city")
	WebElement txtCity;

	@FindBy(name = "state")
	WebElement txtState;

	@FindBy(name = "pinno")
	WebElement txtPin;

	@FindBy(name = "telephoneno")
	WebElement txtTele;

	@FindBy(name = "emailid")
	WebElement txtemail;

	@FindBy(name = "password")
	WebElement txtPassword;

	@FindBy(name = "sub")
	WebElement btnSubmit;

	public void clickOnNewCustLink() {
		newCustLink.click();
	}

	public void enterCustName(String custname) {
		txtCustName.sendKeys(custname);
	}

	public void selectMale() {
		maleRadio.click();
	}

	public void enterDOB(String dd, String mm, String yy) {
		dateOfBirth.sendKeys(dd);
		dateOfBirth.sendKeys(mm);
		dateOfBirth.sendKeys(yy);
	}

	public void enterAddress(String address) {
		txtAddrs.sendKeys(address);
	}

	public void enterCity(String city) {
		txtCity.sendKeys(city);
	}

	public void enterState(String state) {
		txtState.sendKeys(state);
	}

	public void enterPin(int pin) {
		txtPin.sendKeys(String.valueOf(pin));
	}

	public void enterMobileNum(String telephone) {
		txtTele.sendKeys(telephone);
	}

	public void enterPassword(String password) {
		txtPassword.sendKeys(password);
	}

	public void enterEmail(String email) {
		txtemail.sendKeys(email);
	}

	public void clickSubmit() {
		btnSubmit.click();
	}

}
