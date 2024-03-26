package TestBase;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class BaseClass {
	
	public WebDriver driver;
	public Logger logger;
	public Properties properties;
	
	@BeforeClass
	@Parameters({"browser"})
	public void setUp(String browser) throws InterruptedException, IOException {
		
		// config.properties file 
		FileInputStream propertiesFile = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		properties = new Properties();
		properties.load(propertiesFile);
		
		// Test logger
		logger = LogManager.getLogger(Test.class);
		
		
		// Multiple Browser 
		switch (browser.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("No Matching browser");
			return;
		}

		String baseURL = properties.getProperty("URL");
		
		driver.get(baseURL);
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
