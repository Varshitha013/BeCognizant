package PageObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.ExcelUtility;
import utils.ScreenShot;


public class AppsAndToolsPage extends BasePage{
	
	ScreenShot screenShot;

	
	public AppsAndToolsPage(WebDriver driver) {
		super(driver);
		screenShot = new ScreenShot(driver);
	}
	
	// App's and tools section element to take screenshot
	@FindBy(xpath = "(//div[@class='g_b_50a7110f f_b_50a7110f'])[2]")
	WebElement appsAndToolsSectionElement;
	
	@FindBy(xpath = "//*[@id=\"title_text\"]")
	public WebElement title;

	public List<WebElement> appsAndToolsElements() throws InterruptedException, IOException{
		
		// ArrayList to store all the app's WebElements
		List<WebElement> appsAndToolsElements = new ArrayList<WebElement>();
		
		for(int i=1;i<=3;i++) {
			Thread.sleep(1000);
			// all app's WebElement are stored in the Array List appsAndToolsElements  
			appsAndToolsElements.addAll(driver.findElements(By.xpath("(//div[@data-automation-id='textBox']/ul)["+i+"]//a")));
		}
		
		// JavascriptExecutor used to scroll the webPage. to take screen shot
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("(//div[@data-automation-id='textBox']/ul)[1]/li[1]")));
		
		screenShot.getScreenShot("appsAndToolsElements.png");
		
		return appsAndToolsElements;
		
	}
	
	// print all the app's and tools to the console
	public void printAllAppsAndTools() throws InterruptedException, IOException {
		
		System.out.println("Apps And Tools List : ");
		System.out.println();
		
		int i=1;
		for(WebElement element:appsAndToolsElements()) {
			
			String apps = i+") "+element.getText();
			System.out.println(apps);
			// Writing data into excel
			ExcelUtility.writeData("AppsAndTools", i, 0, apps);
			i++;
		}
		
	}
	
	
	
}
