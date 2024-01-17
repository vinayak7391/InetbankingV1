package com.inetbanking.testcases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageobject.Loginpage;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass{
     @Test(dataProvider = "LoginData")
	public void LoginDDT(String username,String Password) throws InterruptedException {
		Loginpage Lp = new Loginpage(driver);
		Lp.SetUserName(username);
		Lp.Setpassword(Password);
		Lp.LoginButton();
		Thread.sleep(3000);
		
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		}
		else {
			Assert.assertTrue(true);
			Lp.LogoutButton();
		    Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}
     
     
     public boolean isAlertPresent() {
     try
     { driver.switchTo().alert();
          return true;
     }
     catch(NoAlertPresentException e) {
         return false;
     }
     }
     
     @DataProvider(name="LoginData")
     String [][] getData() throws IOException{
     String path=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/utilityexcel.xlsx";
     int rownum=XLUtils.getRowCount(path, "Sheet1"); 
     int colcount=XLUtils.getCellCount(path, "Sheet1",1);
     String logindata[][]=new String[rownum][colcount];
     for(int i=1;i<=rownum;i++) {
         for(int j=0;j<colcount;j++) {
          logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1",i,j);
     }
    } 
     return logindata;
    
     }}   
