package TestCases;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.BeCongnizantPage;



public class TC_003_ToolTipValidation extends TC_002_ValidateImageAndHeaders {
	
	BeCongnizantPage beCongnizantPage;
	
	@Test(priority = 3)
	public void validateToolTip() throws InterruptedException {
		
		beCongnizantPage = new BeCongnizantPage(driver);
		
		Actions actions = new Actions(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(beCongnizantPage.imagElements));
		
		System.out.println("=========================================================");
		System.out.println("Tool Tip Validation");
		System.out.println();
		
		try {
			for(WebElement ele:beCongnizantPage.linksElements) {
		
				actions.moveToElement(ele).perform();
				Thread.sleep(1500);
				System.out.println(ele.getAttribute("aria-label"));
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			Assert.fail();
		}
		
		
		
		
		
	}

}
