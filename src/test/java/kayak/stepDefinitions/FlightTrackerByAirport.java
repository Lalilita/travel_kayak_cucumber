package kayak.stepDefinitions;


import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import kayak.utilities.BaseClass;
import kayak.utilities.CommonMethods;

public class FlightTrackerByAirport extends CommonMethods {
	
	@Given("User is on KAYAK Home Page")
	public void user_is_on_kayak_home_page() {
		getDriver();
	}
	@When("User click on the Flight Tracker tap")
	public void user_click_on_the_flight_tracker_tap() {
		homePage.flightTrackerTab.click();
	}
	
	@Then("User should be navigated to {string}")
	public void user_should_be_navigated_to_page(String page) {
		Assert.assertTrue(driver.getCurrentUrl().contains(page));
	}
	@When("User select Airport tab")
	public void user_select_airport_tab() {
		flightPage.airportTab.click();
	}
	@Then("User select {string} from flight tracker \\(IAD)")
	public void user_select_from_flight_tracker_iad(String airport) {
		flightPage.airportInput.sendKeys(airport);
		flightPage.airportInput.click();
		flightPage.airportIAD.click();
	}
	@Then("User select {string} name \\(Korean Air)")
	public void user_select_name_korean_air(String airline) {
		flightPage.airportAirlineInput.sendKeys(airline);
		flightPage.airportAirlineInput.click();
		flightPage.airlineKE.click();
	}
	@Then("User click on trackFlight Button")
	public void user_click_on_track_flight_button() {
		flightPage.airportTrackFlightBtn.click();
	}
	@Then("User should be able to track the flight based on the airport name, airline name and date they have input.")
	public void user_should_be_able_to_track_the_flight_based_on_the_airport_name_airline_name_and_date_they_have_input() {
		Assert.assertTrue(flightPage.flightHeader.isDisplayed());
		Assert.assertTrue(flightPage.flightMap.isDisplayed());
	}

}

