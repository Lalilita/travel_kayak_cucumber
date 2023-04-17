package kayak.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import kayak.utilities.CommonMethods;

public class RestrictionTravelTest extends CommonMethods {
	
	@When("User click on Travel Restrictions tab")
	public void user_click_on_travel_restrictions_tab() {
	    homePage.TravelRestrictionLink.click();
	}

	@Then("User should be navigated to Travel Restrict page")
	public void user_should_be_navigated_to_travel_restrict_page() {
		Assert.assertTrue(travelRestrictpage.headerPage.getText().contains(getProperty("headerRestrict")));
	}

	@And("User able to see the form to select origin and destination country")
	public void user_able_to_see_the_form_to_select_origin_and_destination_country() {
		Assert.assertTrue(travelRestrictpage.FormInput.isDisplayed());
	}
	
	@When("User select {string} from traveling from")
	public void user_select_from_traveling_from(String origin) {
		travelRestrictpage.OriginCountry.click();
		WebElement originCountry = getDriver().findElement(By.xpath("//li[@aria-label='" + origin + "']"));
		originCountry.click();
	}

	@When("User select {string} from traveling to")
	public void user_select_from_traveling_to(String destination) throws InterruptedException {
		Thread.sleep(2000);
		travelRestrictpage.DestinationCountry.click();
		WebElement Destination = getDriver().findElement(By.xpath("//li[@aria-label='" + destination + "']"));
		Destination.click();
	}
	
	@Then("User able to see the travel restriction status {string} of destination country")
	public void user_able_to_see_the_travel_restriction_status_of_destination_country(String restrictResult) {
		System.out.println(travelRestrictpage.RegulationStatus.getText());
		Assert.assertTrue(travelRestrictpage.RegulationStatus.getText().contains(restrictResult));
	    
	}


	@And("User can close the brower")
	public void user_can_close_the_brower() {
	    tearDown();
	}

}
