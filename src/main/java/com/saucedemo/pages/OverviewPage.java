package com.saucedemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.saucedemo.TestBase.TestBase;
import com.saucedemo.utility.Utility;

public class OverviewPage extends TestBase{
	
	public OverviewPage() {
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(css = "div>div.summary_value_label:nth-of-type(2)")

	WebElement paymentCard;
	
		
	@FindBy(css = "div div.summary_info_label.summary_total_label")

	WebElement totalCost;
		
	
	@FindBy(xpath = "//button[@class='btn btn_action btn_medium cart_button']")

	WebElement finishBtn;
	
	@FindBy(css = "button#back-to-products")

	WebElement backToHome;
	
	
	
	String paymentDetails;
	
	String totalCostValue;
	
	public String getPaymentMethodText() {
		return paymentDetails=Utility.getTextOfElement(paymentCard);
	}
	
	public String getCostText() {
		return totalCostValue=Utility.getTextOfElement(totalCost);
	}
	
	private void clickFinishBtn() {
		Utility.sleep(5);
		finishBtn.submit();
	}
	
	
	/*
	 * public void validatePaymentCard() { Assert.assertEquals(paymentDetails,
	 * "SauceCard #31337"); }
	 */
	 
	
	/*
	 * public void validateTotalPrice(){
	 * 
	 * if(totalCostValue.contains("34.54")); {Assert.assertTrue(true);} }
	 */
		 
	
	private void clickBackToHomeBtn() {
		Utility.submitClickElement(backToHome);
	}
	
	
	
	public  ProductsPage completePurchase() {
		//validatePaymentCard();
		//validateTotalPrice();
		clickFinishBtn();
		clickBackToHomeBtn();
		return new ProductsPage();
		
	}
	
	

}
