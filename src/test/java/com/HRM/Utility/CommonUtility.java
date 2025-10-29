package com.HRM.Utility;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class CommonUtility {
	
	static public void captureScreenShot(WebDriver driver,String screenShotName)  {
		
		
		try {
			 String destinationPath = System.getProperty("user.dir") + "/screenshots/" 
	                 + screenShotName + ".png";
			
			//will take screenshot and save in ss variable 
			File ss = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(ss,new File(destinationPath));
			System.out.println("Screenshot Capture!!!!");
			
		}catch(Exception e) {
			System.out.println("Error Occur: "+e);
		}
		
		
	}

}
