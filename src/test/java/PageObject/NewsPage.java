package PageObject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.ScreenShot;


public class NewsPage extends BasePage {
	
	BeCongnizantPage beCongnizantPage;
	NewsPage newsPage;
	ScreenShot screenShot;
	
	public NewsPage(WebDriver driver) {
		super(driver);
	}
	
	// Be.Cognizant link element
    @FindBy(xpath = "//a[@name='be.cognizant']")
    public WebElement beCognizantLinkElement;
	
	// immersiveReader Element
	public @FindBy(xpath = "//button[@name='Immersive Reader']")
	WebElement immersiveReaderElement;
	
	// Author Name Element
	@FindBy(xpath = "(//div[@data-automation-id='personaDetails']/div)[1]")
	public WebElement authorNameElement;
	
	// News Info Element
	@FindBy(xpath = "//div[@data-automation-id='textBox']")
	public WebElement newsInfoElement;
	
	// Growth page Image Element
	@FindBy(xpath = "//div[@data-automation-id='titleRegionBackgroundImage']//img")
	public WebElement growthPageImgElement;
	
	@FindBy(xpath = "//*[@id=\"title_text\"]")
	public WebElement heading;
	
	public void clickon() {
		beCognizantLinkElement.click();
	}
	

}
