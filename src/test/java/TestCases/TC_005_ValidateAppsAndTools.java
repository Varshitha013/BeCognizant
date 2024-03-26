package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.AppsAndToolsPage;
import PageObject.BeCongnizantPage;


public class TC_005_ValidateAppsAndTools extends TC_004_ValidateNewsItems{
	
	BeCongnizantPage beCogni;
	AppsAndToolsPage appsAndToolsPage;
	
	
	@Test(priority = 5)
	public void validateAppsAndTools() {
		
		appsAndToolsPage = new AppsAndToolsPage(driver);
		beCogni = new BeCongnizantPage(driver);
		
		logger.info("****** Starting TC_004_ValidateAppsAndTools ******");
		
		try {
			beCogni.scroll();
			// Clicking on the All app's and tools link
//			beCongnizantPage.clickOnAllAppsAndToolsLink();
//			logger.info("Clicked on the all app's and tools link");
			// Printing all app's and tools text on the console 
//			appsAndToolsPage.printAllAppsAndTools();
			
			
			
			System.out.println(beCogni.getApps());
//			System.out.println(beCogni.getString());
		}
		catch (Exception e) {
			e.printStackTrace();
			logger.error("Test failed...");
			Assert.fail();
			
		}
		
		logger.info("****** finished TC_004_ValidateAppsAndTools ******");
		
	}

}
