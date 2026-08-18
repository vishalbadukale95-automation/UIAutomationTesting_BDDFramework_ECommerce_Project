package RunnerTest;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features = {"AllFeatureFiles"},
		glue = {"StepDefination_iPhone"},
		dryRun = false,
		monochrome = true,	
		plugin= {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		tags= "@iPhone"
		)
public class iPhoneTestRunner extends AbstractTestNGCucumberTests{

}