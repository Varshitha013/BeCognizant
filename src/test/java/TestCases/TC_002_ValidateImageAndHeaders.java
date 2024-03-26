package TestCases;



import java.io.IOException;
import java.time.Duration;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.BeCongnizantPage;

import utils.ScreenShot;

public class TC_002_ValidateImageAndHeaders extends TC_001_ValidateUser {
	
	BeCongnizantPage beCongnizantPage;
	ScreenShot screenShot;
	
	@Test(priority = 2)
	public void validateImageCountAndHeaders() throws InterruptedException, IOException {
		
		logger.info("****** Starting TC_002_ValidateImageAndHeaders ******");
		
		try {
			beCongnizantPage = new BeCongnizantPage(driver);
			screenShot = new ScreenShot(driver);
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOfAllElements(beCongnizantPage.imagElements));
			Thread.sleep(3000);
			
			// Get number of featured news images
//			int imgcount = beCongnizantPage.getCountOfImages();
			int num = beCongnizantPage.headersList();
			System.out.println("Number of Headers : "+num);
			
//			System.out.println("Number of Images : "+imgcount);
//			
//			System.out.println("Headers : ");
		
			// Get featured news headers 
			beCongnizantPage.getHeaders();
			
			// Taking screenshot of featured news 
			screenShot.getScreenShot("featuredNews.png", beCongnizantPage.newsElement);
			logger.info("Featured News screenshot is taken");
			
			logger.info("Validating expected message...");
			// Comparing the number of image with actual Data
			Assert.assertEquals(5, num);
		}
		catch (Exception e) {
			// TODO: handle exception
			logger.error("Test failed...");
			Assert.fail();
		}
		
		logger.info("****** finished TC_002_ValidateImageAndHeaders ****** ");
	}
	
	

}
