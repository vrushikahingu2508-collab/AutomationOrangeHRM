package com.HRM.Utility;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.HRM.Pages.AdminPage;
import com.HRM.Pages.LoginPage;

public class BaseClass 

{
	
	public String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	
	public WebDriver driver;
	public ExcelUtils excel;
	
	public LoginPage lp ;
	public AdminPage ap;
	
	
	@BeforeTest
	public void configure()
	{
		excel = new ExcelUtils("./TestData/DataForLogin.xlsx", "Data");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(url);
		
		CommonUtility.captureScreenShot(driver, "LoginPage");
		
		lp = new LoginPage(driver);
		ap = new AdminPage(driver);
		
		
	}
	
	@AfterTest
	public void close () 
	{

		driver.close();
	}
	

}
