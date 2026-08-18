package RunnerTest;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features = {"AllFeatureFiles"},
		glue = {"StepDefination_iPhone","StepDefination_Samsung"},
		dryRun = false,
		monochrome = true,	
		plugin= {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)
public class ParallelScenarioTestRunner extends AbstractTestNGCucumberTests{

	@DataProvider(parallel=true)
	@Override 
	public Object[][] scenarios() {
		
		return super.scenarios();
	}

	
}