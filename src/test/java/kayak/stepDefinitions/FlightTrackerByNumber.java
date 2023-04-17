package kayak.stepDefinitions;

import org.testng.Assert;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import kayak.utilities.CommonMethods;

public class FlightTrackerByNumber extends CommonMethods {

	@When("User click on Flight Tracker tab")
	public void user_click_on_flight_tracker_tab() {
		homePage.flightTrackerTab.click();
	}

	@Then("User should be navigated to its {string}")
	public void user_should_be_navigated_to_its_page(String page) {
		Assert.assertTrue(driver.getCurrentUrl().contains(page));
	}

	@Then("User able to see the form to select airline and flight number and date")
	public void user_able_to_see_the_form_to_select_airline_and_flight_number_and_date() {
		Assert.assertTrue(flightPage.flightTrackerForm.isDisplayed());
	}

	@When("User select {string} from flight tracker")
	public void user_select_from_flight_tracker(String airline) {
		flightPage.airlineInput.sendKeys(airline);
		flightPage.airlineInput.click();
		flightPage.airlineAV.click();
	}

	@When("User select {string} from Flight Number")
	public void user_select_from_flight_number(String flightnumber) {
		flightPage.flightInput.sendKeys(flightnumber);
	}

	@When("User select defualt date click on track flight button")
	public void user_select_defualt_date_click_on_track_flight_button() {
		flightPage.trackFlightBtn.click();
	}

	@Then("User able to see the result of selected airline")
	public void user_able_to_see_the_result_of_selected_airline() {
		Assert.assertTrue(flightPage.flightHeader.isDisplayed());
		Assert.assertTrue(flightPage.flightMap.isDisplayed());
	}



}
