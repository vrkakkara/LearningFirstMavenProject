package com.saucedemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.saucedemo.TestBase.TestBase;
import com.saucedemo.utility.Utility;

public class AccountLoginPage extends TestBase {

	public AccountLoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input#user-name")
	WebElement username;
	
	@FindBy(css = "input#password")
	WebElement password;
	
	@FindBy(css = "div#login_credentials>br:first-of-type")
	WebElement loginCredential;
	
	@FindBy(css = "div.login_password>h4")
	WebElement passwordCredential;
	
	@FindBy(css = "input#login-button")
	WebElement loginBtn;
	String defaultUsername;
	String defaultPassword;
	private void getUsername() {
		defaultUsername=Utility.getTextOfElement(loginCredential);
	}
	
	private void enterUsername() {
		Utility.enterText(username, "standard_user");
	}
	
	private void getPassword() {
		defaultUsername=Utility.getTextOfElement(passwordCredential);
	}
	
	private void enterPassword() {
		Utility.enterText(password, "secret_sauce");
	}
	
	private void clickLoginBtn() {
		Utility.submitClickElement(loginBtn);
	}
		private void validateLogout() {
			String logoutText=Utility.getTextOfElement(loginBtn);
			Assert.assertEquals(logoutText,
					"Login");
	}
	
		

		public  ProductsPage loggingIn() {
		enterUsername();
		enterPassword();
		clickLoginBtn();
        return new ProductsPage();
	}
		
		public  void ValidateLogoutFlow() {
			validateLogout();
		}
		
		

	
}
