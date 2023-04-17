package kayak.stepDefinitions;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import kayak.utilities.BaseClass;
import kayak.utilities.CommonMethods;

public class Hooks extends BaseClass{
	
	@Before			
	public void setup() {
		getDriver();
	}
	
	
	@After
	public void after(Scenario scenario) {
		if (scenario.isFailed()) {
            CommonMethods.takeScreenshot("scnerarioFailed");
		}
	}

}
