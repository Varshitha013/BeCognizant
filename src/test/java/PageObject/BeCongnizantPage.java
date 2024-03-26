package PageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class BeCongnizantPage extends BasePage {
	
	WebDriver driver;
	NewsPage newsPage;
	
	public BeCongnizantPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		newsPage = new NewsPage(driver);
	}
	
	// UserInfoButton Element
	@FindBy(xpath="//div[@id='O365_MainLink_MePhoto']")
	public WebElement userInfoButtonElement;
	
//	UserInfoTab Element 
//	@FindBy(css = "div#mectrl_main_body")
//	public WebElement userInfoTabElement;
	
	// User Name Element
	@FindBy(css = "div#mectrl_currentAccount_primary")
	public WebElement userNameElement;
	
	// User Email Element
	@FindBy(css = "div#mectrl_currentAccount_secondary")
	WebElement userEmailElement;
	
	// List of all featured news Elements
	@FindBy(xpath = "//div[@data-automation-id='newsItem']//img")
	public List<WebElement> imagElements;
	
	// List of all featured header Elements
	@FindBy(xpath = "//div[@data-automation-id='newsItem']/div/div/a")
	List<WebElement> headerElements;
	
	//locate and store all featured news Tool tip in "toolTip"
	@FindBy(xpath = "//div[contains(@class,'newsItem__hero')]//a")
	public List<WebElement> toolTips;
	
	// news Element (CanvasSection)
	@FindBy(xpath = "(//div[@data-automation-id='CanvasSection'])[1]")
	public WebElement newsElement;
	
	// List of news link Elements
	@FindBy(xpath = "//div[@data-automation-id='newsItem']/div/div/a")
	public List<WebElement> newsLinkElements;
	
	@FindBy(xpath = "(//div[@data-automation-id='newsItem']/div/div/a)[1]")
	public WebElement newsElement1;
	
	// All app's and tools link Element
	@FindBy(xpath = "(//*[@id=\"QuicklinksItemTitle\"])[14]")
	public WebElement allAppsAndToolsLinkElement;
	
	@FindBy(xpath = "//*[@id=\"QuicklinksItemTitle\"]")
	public List <WebElement> apps;
	
	@FindBy(xpath = "//a[@id='news_text_title']")
	public List<WebElement> linksElements;
	
	@FindBy(xpath="//strong[normalize-space()='Around Cognizant']")
	WebElement Scrolls;
	private String header;
	
	
	// Click on the User Info Button
	public void clickOnUserInfoButton() throws InterruptedException {
		
		try {
			userInfoButtonElement.click();
		}
		catch (Exception e) {
			// TODO: handle exception
			userInfoButtonElement.click();
		}
		

	}
	
	// User Name
	public String getUserName() {
		return userNameElement.getText();
	}
	
	// User Email
	public String getUserEmail() {
		return userEmailElement.getText();
	}
	
	// Featured news Image Count
	public int getCountOfImages() {
		return imagElements.size();
	}
	public int  headersList(){
		return headerElements.size();
	}
	// Print all the Featured news headers
	public String getHeaders() {
		int i = 1;
		for(WebElement ele:headerElements) {
			String header = ele.getText();
			System.out.println(i+") "+header);
			//System.out.println(i+") "+ele.getText());
			i++;
		}
		System.out.println("===========================================================");
		return header;
		
	}
		
	// Click on the all app's and tools link
	public void clickOnAllAppsAndToolsLink() {
		allAppsAndToolsLinkElement.click();
	}
	
	
	public List<String> getApps() {
			List<String> AppList= new ArrayList<String>();
			for(int i=5;i<apps.size();i++) {
				String detail = apps.get(i).getAttribute("title");
				AppList.add(detail);
			}
			return AppList;
		}
	
	public String getString() {
		String detaill = apps.get(5).getAttribute("title");
		return detaill;
	}
	
	public void scroll() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver ;
		js.executeScript("arguments[0].scrollIntoView();",Scrolls);
		Thread.sleep(10000);
	}

}
//div[normalize-space()='All Apps & Tools']//div[@id='QuicklinksItemTitle']
//a[@aria-label='All Apps & Tools.  ']
//*[@id="QuicklinksItemTitle"]
