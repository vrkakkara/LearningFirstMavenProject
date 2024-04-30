package com.saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.saucedemo.TestBase.TestBase;
import com.saucedemo.pages.AccountLoginPage;
import com.saucedemo.pages.CheckoutPage;
import com.saucedemo.pages.OverviewPage;
import com.saucedemo.pages.ProductsPage;
import com.saucedemo.pages.YourCartPage;

public class AccountloginPageTest extends TestBase {
	

	AccountLoginPage login;
	OverviewPage overview;
	CheckoutPage checkout;
	ProductsPage product;
	YourCartPage yourCart;
	

	@BeforeMethod
	public void launchBrowser() {
		pageInitialisation();
		login=new AccountLoginPage();
	}

	@Test
	public void validateAddToCartFlow() {
		
		product=login.loggingIn();
		yourCart=product.addingToCart();
		System.out.println(yourCart.getItem1Name());
		System.out.println(yourCart.getItem2Name());
		Assert.assertEquals(yourCart.getItem1Name(),
				"Sauce Labs Bolt T-Shirt");
		Assert.assertEquals(yourCart.getItem2Name(),
				"Test.allTheThings() T-Shirt (Red)");
		checkout=yourCart.checkingOut();
	
		overview=checkout.enterCheckoutDetails();
		Assert.assertEquals(overview.getPaymentMethodText(),
				"SauceCard #31337");
		if(overview.getCostText().contains("34.54"));
		{Assert.assertTrue(true);}
		product=overview.completePurchase();
		product.logoutFlow();
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		pageQuit();
	}

	

	

}
