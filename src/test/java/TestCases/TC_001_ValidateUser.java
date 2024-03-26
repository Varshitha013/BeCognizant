package TestCases;


import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


import PageObject.BeCongnizantPage;
import TestBase.BaseClass;
import utils.ExcelUtility;
import utils.ScreenShot;


public class TC_001_ValidateUser extends BaseClass {
	
	BeCongnizantPage beCongnizantPage;
	ScreenShot screenShot;
	ExcelUtility excelUtility;

	@Test(priority = 1)
	public void ValidateUser() throws IOException, InterruptedException {
		
		logger.info("****** Starting TC_001_ValidateUser ******");
		
		try {
			beCongnizantPage = new BeCongnizantPage(driver);
			screenShot = new ScreenShot(driver);
			excelUtility = new ExcelUtility();
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			
			wait.until(ExpectedConditions.elementToBeClickable(beCongnizantPage.userInfoButtonElement));
			
			// Clicking on the user info button 
			beCongnizantPage.clickOnUserInfoButton();
			
			logger.info("Clicked on User info button");
			Thread.sleep(6000);
			
			wait.until(ExpectedConditions.visibilityOf(beCongnizantPage.userNameElement));
			
			// Taking screen shot
			screenShot.getScreenShot("userInfo.png");
			
			logger.info("User info screenshot is taken");
			
			// Reading data from the excel (actual data)
			String actNameString = excelUtility.readExcelData("UserValidationData", 1, 0);
			String actEmailString = excelUtility.readExcelData("UserValidationData", 1, 1);
			
			// Reading data from the WebPage (expected data)
			String expNameString = beCongnizantPage.getUserName();
			String expEmailString = beCongnizantPage.getUserEmail();
			
			// Printing the User data on the console
			System.out.println("User Information : ");
			System.out.println("Name : "+expNameString);
			System.out.println("Email : "+expEmailString);
			
			logger.info("Validating expected message...");
			
			// Comparing the actual data with the expected data 
			Assert.assertEquals(actNameString, expNameString);
			Assert.assertEquals(actEmailString, expEmailString);
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
			logger.error("Test failed...");
			Assert.fail();
		}
		
		logger.info("****** finished TC_001_ValidateUser ****** ");
	}
	
	

}
