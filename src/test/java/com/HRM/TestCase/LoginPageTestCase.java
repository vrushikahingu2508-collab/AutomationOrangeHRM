package com.HRM.TestCase;

import org.testng.annotations.Test;
import org.testng.Assert;

import org.testng.annotations.*;
import com.HRM.Utility.*;

public class LoginPageTestCase extends BaseClass {

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        int rowCount = excel.getRowCount();
        Object[][] data = new Object[rowCount - 1][2]; // assuming username/password columns

        for (int i = 1; i < rowCount; i++) {
            data[i - 1][0] = excel.getCellData(i, 0);
            data[i - 1][1] = excel.getCellData(i, 1);
        }
        return data;
    }

    @Test(dataProvider = "loginData")
    public void performLogin(String username, String password) {
    	 String actUrl = lp.login(username, password);
    	 System.out.println("Username:"+username+"/"+"Password"+password);
    	 
    	 
    	CommonUtility.captureScreenShot(driver, username);
   	  Assert.assertTrue(actUrl.contains("dashboard"),"Test Fail: Invalid Login Data");
   	  System.out.println("Test Pass: Login Successfully");
   	  CommonUtility.captureScreenShot(driver, username);
   	  if(actUrl.contains("dashboard")) {
   		  lp.logout();
   	  }
    }
}

