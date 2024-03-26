package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features={"Feature"}, 
		//features= {"@target/rerun.txt"},
		glue="stepDefination",
		plugin = {
				"pretty","html:target/cucumber-reports/cucumber-pretty", 
            "json:target/cucumber-reports/CucumberTestReport.json",
            "rerun:target/cucumber-reports/rerun.txt",
            "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
	monochrome = true,
	publish=true)

public class Runner {
	 
		
	}


					
	
