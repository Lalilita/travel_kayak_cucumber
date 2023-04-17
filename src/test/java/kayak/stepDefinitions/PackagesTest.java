package kayak.stepDefinitions;


import org.openqa.selenium.Keys;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import kayak.utilities.CommonMethods;

public class PackagesTest extends CommonMethods {

//	@Given("User is on KAYAK Home Page")
//	public void user_is_on_kayak_home_page() {
//		getDriver();
//	}

	@When("User click on the packages category tab")
	public void user_click_on_the_packages_category_tab() throws InterruptedException {
		homePage.packagesTab.click();
	}

	@Then("User should be navigated to {string} and able to input information in the search field")
	public void user_should_be_navigated_to_and_able_to_input_information_in_the_search_field(String PKPage) throws InterruptedException {
		Assert.assertTrue(driver.getCurrentUrl().contains(PKPage));
	}

	@Then("User click and select the city of destination to {string}")
	public void user_click_and_select_the_city_of_destination_to(String destination) throws InterruptedException {
		sendText(homePage.toField, destination);
		Thread.sleep(1000);
		homePage.toField.sendKeys(Keys.ARROW_DOWN);
		homePage.toField.sendKeys(Keys.TAB);
	}
	@Then("User select the departure {string} and arrival {string}")
	public void user_select_the_departure_and_arrival(String startDate,String endDate) throws InterruptedException {
		homePage.startDateField.click();
		clickDate(startDate, homePage.navBar, homePage.nextBtn);
		
		homePage.endDateField.click();
		clickDate(endDate, homePage.navBar, homePage.nextBtn);
	}

	@Then("User click on search button")
	public void user_click_on_search_button() throws InterruptedException {
		homePage.searchBtn.click();
	}

	@Then("User should be able to see {string} out of all recommended hotels on the page")
	public void user_should_be_able_to_see_out_of_all_recommended_hotels_on_the_page(String hotelAmountOnPage) throws InterruptedException {
		switchToChildWindow();
		Thread.sleep(3000);
		Assert.assertEquals(packagesPage.hotelsOnPageList.size(), Integer.parseInt(hotelAmountOnPage));
	}

	@When("User click on the five stars button")
	public void user_click_on_the_five_stars_button() throws InterruptedException {
		packagesPage.fifthStarBtn.click();
		System.out.println("clicked 5star");
	}

	@When("User click on eight plus review score button")
	public void user_click_on_eight_plus_review_score_button() throws InterruptedException {
		packagesPage.eightPlusBtn.click();
		System.out.println("clicked 8+");
	}

	@When("User select price at maximum")
	public void user_select_price_at_maximum() throws InterruptedException {
		jsClick(packagesPage.leftSlider);
		limitPriceRange(packagesPage.leftSlider, 100);
	}

	@Then("User should be able to see only one hotel with a price matching the selected price")
	public void user_should_be_able_to_see_only_one_hotel_with_a_price_matching_the_selected_price() throws InterruptedException {
		for (int i = 0; i < packagesPage.hotelPriceResult.size(); i++) {
			Thread.sleep(1000);
			Assert.assertTrue(getPrice(packagesPage.hotelPriceResult.get(i)) <= getPrice(packagesPage.minPrice));
			System.out.println("result price is in range");
		}
	}

}
