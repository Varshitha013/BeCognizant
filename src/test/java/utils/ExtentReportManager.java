package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {
	
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extentReports;
	public ExtentTest extentTest;
	
	public void onStart(ITestContext context) {
		
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"\\reports\\myReport.html");
		
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setReportName("TestNG Extended Report");
		sparkReporter.config().setTheme(Theme.STANDARD);
		
		extentReports = new ExtentReports();
		
		extentReports.attachReporter(sparkReporter);
		
		extentReports.setSystemInfo("Computer Name", "HP");
		extentReports.setSystemInfo("Environment", "QEA");
		extentReports.setSystemInfo("Tester Name", "Mallepalli Varshitha");
		extentReports.setSystemInfo("OS", "Windows11");
		extentReports.setSystemInfo("Browser Name", "Chrome,Edge");
		
	}
	
	public void onTestSuccess(ITestResult result) {
		
		extentTest = extentReports.createTest(result.getName());
		extentTest.log(Status.PASS, "Test case PASSED is : "+result.getName());
	}
	
	public void onTestFailure(ITestResult result) {
		
		extentTest = extentReports.createTest(result.getName());
		extentTest.log(Status.FAIL, "Test case FAILED is : "+result.getName());
		extentTest.log(Status.FAIL, "Test case FAILED due to : "+result.getThrowable());
	}
	
	public void onTestSkipped(ITestResult result) {
		
		extentTest = extentReports.createTest(result.getName());
		extentTest.log(Status.SKIP, "Test case Skipped is : "+result.getName());
		extentTest.log(Status.SKIP, "Test case Skipped due to : "+result.getThrowable());
		
	}
	
	public void onFinish(ITestContext context) {
		
		extentReports.flush();
		
	}
}
