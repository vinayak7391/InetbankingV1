package com.inetbanking.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobject.Loginpage;

public class TC_Logintest001 extends BaseClass {
    
	@Test
	public void LoginTest() {
		driver.get(BaseURL);
		logger.info("URL is opened");
		Loginpage LP = new Loginpage(driver);
		LP.SetUserName(Username);
		logger.info("entered username");
		LP.Setpassword(Password);
		logger.info("entered password");
		LP.LoginButton();
		
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}
	
	
}
