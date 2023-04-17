package kayak.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty",
				"junit:target/cucumber-xmlReport/Cucumber.xml",
				"html:target/smokeTests-cucumber-reports.html" }, 
		features = "src/test/resources/featureFiles", 
		glue = "kayak/stepDefinitions",
		dryRun = false,    
		monochrome = true,
		tags = "@search or @book"
		)


public class SmokeRunner {

	
	
	
	
}
