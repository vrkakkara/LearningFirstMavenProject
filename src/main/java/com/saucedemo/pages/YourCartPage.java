package com.saucedemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.saucedemo.TestBase.TestBase;
import com.saucedemo.utility.Utility;

public class YourCartPage extends TestBase{
	
	public YourCartPage() {
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(css = "button#checkout")

	WebElement checkoutBtn;
	
	
	@FindBy(css = "a#item_1_title_link>div")

	WebElement item1InCart;
	
	@FindBy(css = "a#item_3_title_link>div")

	WebElement item2InCart;
	
	private void clickCheckout() {
		Utility.clickElement(checkoutBtn);

	}
	
	public String getItem1Name() {
		String item1Text=Utility.getTextOfElement(item1InCart);
		//Assert.assertEquals(item1Text,
		//"Sauce Labs Bolt T-Shirt");
		return item1Text;
}
	
	public String getItem2Name() {
		String item2Text=Utility.getTextOfElement(item2InCart);
		//Assert.assertEquals(item2Text,
		//"Test.allTheThings() T-Shirt (Red)");
		return item2Text;
}
	
	public  CheckoutPage checkingOut() {
		clickCheckout();
		//validateitem1();
		//validateitem2();
		return new CheckoutPage();
	}

}
