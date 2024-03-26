package TestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


import PageObject.BeCongnizantPage;
import PageObject.NewsPage;
import utils.ExcelUtility;
import utils.ScreenShot;

public class TC_004_ValidateNewsItems extends TC_003_ToolTipValidation {
	
	NewsPage newsPage;
	BeCongnizantPage beCongnizantPage;
	ScreenShot screenShot;
	
	@Test(priority = 4)
	public void validateNewsItems() throws InterruptedException {
		
		logger.info("****** Starting TC_003_ValidateNewsItems ******");
		
		newsPage = new NewsPage(driver);
		beCongnizantPage = new  BeCongnizantPage(driver);
		screenShot = new ScreenShot(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		System.out.println("=================================================================");
		System.out.println("News Information : ");
		System.out.println();

		try {
			for(int i=1;i<=beCongnizantPage.newsLinkElements.size();i++) {
				

				wait.until(ExpectedConditions.visibilityOfAllElements(beCongnizantPage.newsLinkElements));
				
				// Featured news links 
				driver.findElement(By.xpath(("(//div[@data-automation-id='newsItem']/div/div/a)["+i+"]"))).click();
				logger.info("Clicked on the featured news link");
				
				wait.until(ExpectedConditions.visibilityOf(newsPage.immersiveReaderElement));
				
				
				String title = i+") News Title : "+driver.getTitle();
				System.out.println(title);
				System.out.println();
				
				String newsInfo = "";
				
				// retrieving Our growth mind set page news data
				if(driver.getTitle().equals("Our growth mindset")) {
					for(int j=1;j<3;j++) {
						
						wait.until(ExpectedConditions.visibilityOf(newsPage.growthPageImgElement));
	
						newsInfo = driver.findElement(By.xpath("(//div[@data-automation-id='textBox'])["+j+"]")).getText();
						System.out.println("News : "+newsInfo);
					}
				}
				// retrieving other page news data
				else {
					newsInfo = newsPage.newsInfoElement.getText();
					wait.until(ExpectedConditions.visibilityOf(newsPage.authorNameElement));
					System.out.println("Author Name : "+newsPage.authorNameElement.getText());
					System.out.println();
					System.out.println("News : "+newsInfo);
				}
				
				System.out.println("=========================================================================================================");
				
				String data = title+newsInfo;
				
				// Writing data into Excel 
				ExcelUtility.writeData("NewsInformation", i, 0, data);
				
				// Taking individual Page ScreenShot
				screenShot.getScreenShot(driver.getTitle().substring(0,8)+".png");
				logger.info("News Screenshot is taken");
				
				// clicking on be.cognizant 
				newsPage.beCognizantLinkElement.click();
				logger.info("Clicked on the be.Congnizant link");
				
				wait.until(ExpectedConditions.visibilityOfAllElements(beCongnizantPage.newsLinkElements));
			}
		
			
		}
		catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
			logger.error("Test failed...");
		}	
		
		logger.info("****** finished TC_003_ValidateNewsItems ****** ");

	}

}