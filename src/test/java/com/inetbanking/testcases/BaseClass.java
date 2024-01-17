package com.inetbanking.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;



public class BaseClass {

public String BaseURL="https://demo.guru99.com/V4/";
public String Username="mngr548206";
public String Password="pEbAryq";
public static WebDriver driver;
public Logger logger;

@BeforeClass
public void setup() {
WebDriverManager.chromedriver().setup();
driver = new ChromeDriver();
logger = Logger.getLogger("BaseClass.class");	
PropertyConfigurator.configure("log4j.properties");
driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
driver.manage().window().maximize();
driver.get(BaseURL);

}


@AfterClass
public void Teardown() {
driver.quit();	
}
}


