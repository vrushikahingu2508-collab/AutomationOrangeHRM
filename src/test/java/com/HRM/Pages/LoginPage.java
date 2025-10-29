package com.HRM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.HRM.Utility.CommonUtility;

public class LoginPage {

	WebDriver driver;
	
	
	//initialize driver
	public LoginPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	//data member (locator)
	private By userName = By.name("username");
	private By password = By.name("password");
	private By loginBtn = By.xpath("//button[@type=\"submit\"]");
	
	private By profileBtn = By.xpath("//i[@class=\"oxd-icon bi-caret-down-fill oxd-userdropdown-icon\"]");
	private By logoutLink = By.linkText("Logout");
	//methods
	
	public String login(String un, String pw)
	{
		driver.findElement(userName).sendKeys(un);
		driver.findElement(password).sendKeys(pw);
		driver.findElement(loginBtn).click();
		CommonUtility.captureScreenShot(driver,"Login Data Added");
		return driver.getCurrentUrl();
		
	}
	
	public String logout() 
	{
		driver.findElement(profileBtn).click();
		driver.findElement(logoutLink).click();
		
		return driver.getCurrentUrl();
		
		
	}
	
	
	
}
