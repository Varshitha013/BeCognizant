package stepDefination;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import PageObject.*;
import utils.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef {
	BeCongnizantPage bcp;
	BasePage bp;
	AppsAndToolsPage aatp;
	NewsPage np;
	ExcelUtility excelUtility;
	
	WebDriver driver;
	@Given("start the browser")
	public void start_the_browser() {
	    // Write code here that turns the phrase above into concrete actions
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://cognizantonline.sharepoint.com/sites/Be.Cognizant/SitePages/Home.aspx");
//	    throw new io.cucumber.java.PendingException();
	}

	@When("BeCognizant page is visible")
	public void be_cognizant_page_is_visible() {
	    // Write code here that turns the phrase above into concrete actions

		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Be.Cognizant - Home");
//	    throw new io.cucumber.java.PendingException();
	}

	@When("click on user info button")
	public void click_on_user_info_button() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		bcp= new BeCongnizantPage(driver);
		Thread.sleep(5000);
		bcp.clickOnUserInfoButton();
//	    throw new io.cucumber.java.PendingException();
	}

	@Then("validate user details")
	public void validate_user_details() throws IOException, InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		excelUtility = new ExcelUtility();
		Thread.sleep(3000);
		String expNameString = bcp.getUserName();
		String expEmailString = bcp.getUserEmail();
		
		String actNameString = excelUtility.readExcelData("UserValidationData", 1, 0);
		String actEmailString = excelUtility.readExcelData("UserValidationData", 1, 1);
		
		Assert.assertEquals(actNameString, expNameString);
		Assert.assertEquals(actEmailString, expEmailString);
//	    throw new io.cucumber.java.PendingException();
	}

	@When("get the featured news headers")
	public void get_the_featured_news_headers() {
	    // Write code here that turns the phrase above into concrete actions
		bcp.getHeaders();
//	    throw new io.cucumber.java.PendingException();
	}

	@Then("validate image and headers")
	public void validate_image_and_headers() {
	    // Write code here that turns the phrase above into concrete actions
		int num = bcp.headersList();
		Assert.assertEquals(5, num);
//	    throw new io.cucumber.java.PendingException();
	}

	@Then("validate the toolTip")
	public void validate_the_tool_tip() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions


			 
		for(int i = 0 ;i<bcp.toolTips.size(); i++)
		{ 
			String headline=bcp.toolTips.get(i).getText();
			Actions actions = new Actions(driver);	
			actions.moveToElement(bcp.toolTips.get(i)).perform();
			Thread.sleep(1500);
			String tooltip=bcp.toolTips.get(i).getAttribute("aria-label");	
			try { 
				Assert.assertEquals(headline, tooltip);
				System.out.println("News"+ (i + 1) +" Headline and Tooltip is matched"); 
			}
			catch (Exception e) {
				System.out.println ("News" + (i + 1) +" Headline and Tooltip is not matched");
			}
	
		}
		System.out.println();
		}
		
//	    throw new io.cucumber.java.PendingException();
	

	@When("click on news page")
	public void click_on_news_page() {
	    // Write code here that turns the phrase above into concrete actions
		bcp.newsElement1.isDisplayed();
		bcp.newsElement1.click();
//	    throw new io.cucumber.java.PendingException();
	}

	@Then("validate the news items")
	public void validate_the_news_items() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		np = new NewsPage(driver);
		np.heading.isDisplayed();
		np.clickon();
		Thread.sleep(3000);
		
//	    throw new io.cucumber.java.PendingException();
	}

	@When("BeCognizant page is visible again")
	public void BeCognizant_page_is_visible_again() {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(driver.getTitle(), "Be.Cognizant - Home");
//	    throw new io.cucumber.java.PendingException();
	}

	@Then("close the browser")
	public void close_the_browser() {
	    // Write code here that turns the phrase above into concrete actions
		driver.quit();
//	    throw new io.cucumber.java.PendingException();
	}
}
