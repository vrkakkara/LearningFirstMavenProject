package com.saucedemo.pages;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.TestBase.TestBase;
import com.saucedemo.utility.Utility;

public class CheckoutPage extends TestBase{
	
	public CheckoutPage() {
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(css = "input#first-name")

	WebElement firstName;
	
	@FindBy(css = "input#last-name")

	WebElement lastName;
	
	@FindBy(css = "input#postal-code")

	WebElement postCode;
	
	@FindBy(css = "input#continue")

	WebElement continueBtn;
	
	
	
	private void enterFirstNAme() {
		Utility.enterText(firstName, Utility.generateRandomName());
	}
	
	private void enterLastNAme() {
		Utility.enterText(lastName, Utility.generateRandomName());
	}
	
	private void enterPostCode() {
		Utility.enterText(postCode, "m3a1y1");
	}
	
	private void clickContinue() {
		Utility.submitClickElement(continueBtn);
	}
	
	public  OverviewPage enterCheckoutDetails() {
		enterFirstNAme();
		enterLastNAme();
		enterPostCode();
		clickContinue();
		return new OverviewPage();
	}
	
	
	
	

}
