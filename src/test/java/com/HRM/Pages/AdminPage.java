package com.HRM.Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPage {
	
	WebDriver driver;
	
	
	//initialize driver 
	public AdminPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//data member (locators)
	private By menus = By.xpath("//*[@id='app']/div/div/aside/nav/div[2]/ul/li");
	private By adminLink = By.linkText("Admin");
	
	private By userName = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input");
	private By searchBtn = By.xpath("//*[@type=\"submit\"]");
	private By recordCount = By.xpath("//*[@id='app']/div/div[2]/div[2]/div/div[2]/div[2]/div/span");
	
	private By userRole = By.xpath("//*[@id='app']/div/div[2]/div[2]/div/div/div[2]/form/div/div/div[2]/div/div[2]/div/div/div[2]/i");
	private By userRoleOptions = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div[2]/div[2]/span");
	
	private By userStatus = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div/div[2]/i");
	private By activeStatus = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div[2]/div[2]");
	
	
	//Methods
	public int displayMenuCount() 
	{
		int count = 0;
		
		try {
			 count = driver.findElements(menus).size();
			 driver.findElement(adminLink).click();
			 Thread.sleep(3000);
			 
		}catch(Exception e ) {
			
			System.out.println("Exception Occor: "+e.toString());
		}
		
		return count;
	}
	
	public String searchWithUserName() 
	{
		String record = "";
		driver.findElement(userName).sendKeys("Admin");
		record = searchbtn();
	return record;
		
	}
	
	public String searchWithUserRole() {
		
		String record = "";
		driver.findElement(userRole).click();
		driver.findElement(userRoleOptions).click();
		record = searchbtn();
	return record;	
		
	}
	
	
	public String searchWithUserStatus() {
		 String record = "";
		 driver.findElement(userStatus).click();
		 driver.findElement(activeStatus).click();
		 record = searchbtn();
		 return record;
	
	}
	
	
	public String searchbtn ()
	{
		String record = "";
		
		try {
			
			driver.findElement(searchBtn).click();	
			record = driver.findElement(recordCount).getText();
			Thread.sleep(4000);
			driver.navigate().refresh();
			Thread.sleep(4000);
			
		}catch(Exception e) {
			System.out.println("Exception Occor: "+e.toString());	
		}
		return record;
		
	}
	

}
