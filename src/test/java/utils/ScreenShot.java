package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScreenShot {
	
	WebDriver driver;
	
	public ScreenShot(WebDriver driver) {
		this.driver = driver;
	}
	
	public void getScreenShot(String imgName) throws IOException {
		
		TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
		File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		File trgFile = new File(System.getProperty("user.dir")+"\\ScreenShots\\"+imgName+"");
		FileUtils.copyFile(srcFile, trgFile);
		
	}
	
	public void getScreenShot(String imgName,WebElement element) throws IOException {
		
		File srcFile = element.getScreenshotAs(OutputType.FILE);
		File trgFile = new File(System.getProperty("user.dir")+"\\ScreenShots\\"+imgName+"");
		FileUtils.copyFile(srcFile, trgFile);
	}
}
