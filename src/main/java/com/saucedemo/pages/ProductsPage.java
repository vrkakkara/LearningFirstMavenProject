package com.saucedemo.pages;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.saucedemo.TestBase.TestBase;
import com.saucedemo.utility.Utility;

public class ProductsPage extends TestBase {

	public ProductsPage() {
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(css = "select.product_sort_container")

	WebElement sortBtn;
	
	@FindBy(css = "button#add-to-cart-sauce-labs-bolt-t-shirt")

	WebElement item1tAddToCartBtn;
	
	@FindBy(css = "button.btn.btn_primary.btn_small.btn_inventory[id*='red']")

	WebElement item2tAddToCartBtn;
	
	@FindBy(css = "div#shopping_cart_container>a")

	WebElement shoppingCartBtn;
	
	
	@FindBy(css = "button#react-burger-menu-btn")

	WebElement mainBtn;
	
	
	
	@FindBy(css = "a#logout_sidebar_link")

	WebElement logoutBtn;

	

	private void selectLowToHigh() {
		Utility.selectDropdownByValue(sortBtn, "lohi");

	}
	
	private void clickItem1() {
		Utility.clickElement(item1tAddToCartBtn);

	}
	
	private void clickItem2() {
		Utility.clickElement(item2tAddToCartBtn);

	}
	
	private void clickShoppingCartBtn() {
		Utility.clickElement(shoppingCartBtn);

	}
	
	private void clickmainBtn() {
		Utility.clickElement(mainBtn);

	}
	
	private void clickLogoutBtn() {
		Utility.clickElement(logoutBtn);

	}
	
	
	
	public  YourCartPage addingToCart() {
		selectLowToHigh();
		clickItem1();
		clickItem2();
		clickShoppingCartBtn();
		return new YourCartPage();
	}
	
	public  AccountLoginPage logoutFlow() {
		clickmainBtn();
		clickLogoutBtn();
		return new AccountLoginPage();
			}

	
}
