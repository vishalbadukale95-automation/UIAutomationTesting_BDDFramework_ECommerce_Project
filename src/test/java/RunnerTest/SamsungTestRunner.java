package RunnerTest;

	import io.cucumber.testng.AbstractTestNGCucumberTests;
	import io.cucumber.testng.CucumberOptions;

	@CucumberOptions(
			
			features = {"AllFeatureFiles"},
			glue = {"StepDefination_Samsung"},
			dryRun = false,
			monochrome = true,	
			plugin= {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
			tags = "@Samsung"
			)
	public class SamsungTestRunner extends AbstractTestNGCucumberTests{


}
