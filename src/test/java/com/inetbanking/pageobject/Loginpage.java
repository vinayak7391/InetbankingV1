package com.inetbanking.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
  WebDriver ldriver;

public Loginpage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
}
  @FindBy(name="uid")
  WebElement txtusernameElement;
  
  @FindBy(name="password")
  WebElement password;
  
  @FindBy(name="btnLogin")
  WebElement Loginbutton;
  
  @FindBy(xpath ="/html/body/div[3]/div/ul/li[15]/a")
  WebElement Logoutbutton;
  
  public void SetUserName(String Username) {
	txtusernameElement.sendKeys(Username);
}
  public void Setpassword(String pwd) {
	password.sendKeys(pwd);
}
  public void LoginButton() {
	Loginbutton.click();
}
  public void LogoutButton() {
		Logoutbutton.click();
	}
  
}
