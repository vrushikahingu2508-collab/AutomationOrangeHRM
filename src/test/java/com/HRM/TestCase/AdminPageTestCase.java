package com.HRM.TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.HRM.Utility.BaseClass;

public class AdminPageTestCase extends BaseClass{
	
	
  @Test (priority = 1)
  public void testMenus() 
  {
	  
	  String actUrl = lp.login("Admin","admin123");
	  Assert.assertTrue(actUrl.contains("dashboard"),"Not able to Login, Something goes wrong!!!");
	  System.out.println("Login successfully!!!!");
	  int menuCount = ap.displayMenuCount();
	  System.out.println("Total Menus: "+ menuCount);
	  Assert.assertEquals(menuCount, 12,"Test Fail: Count not match!!!");
	  System.out.println("Test Pass: Count match!!!!");
	  
  }
  
  @Test (priority = 2)
  public void testSearchWithUserName()
  {
	   System.out.println("No of Records for Username: "+ ap.searchWithUserName());
	  
  }
  
  @Test (priority = 3)
  public void testSearchWithUserRole() 
  {
	  System.out.println("No of Records for User Role: "+ ap.searchWithUserRole());
  }
  
  @Test (priority = 4)
  public void testSearchWithUserStatus() 
  {
	  System.out.println("No of Records for User Status Enable: "+ ap.searchWithUserStatus());
	
  }
  
}
