package kayak.stepDefinitions;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import kayak.utilities.CommonMethods;

public class SearchTheCheapestHotelTest extends CommonMethods{

	@Given("user on the stays page")
	public void user_on_the_stays_page() {
		staysPage.clickStays();
	}

	@When("user select city {string}")
	public void user_select_city(String City) {
		sendText(staysPage.cityOfStay, City);
		System.out.println("put city");
	}

	@And("user select checked-in date {string} and checked-out date {string}")
	public void user_select_checked_in_date_and_check_out_date(String StartDate, String EndDate) {
		waitForVisibility(staysPage.startDateBox);
		staysPage.startDateBox.click();
		System.out.println("click date box");
		waitForVisibility(staysPage.monthName1);
		staysPage.pickDate(staysPage.monthName1, staysPage.dates, staysPage.nextMonthArrow, StartDate);
		System.out.println("pick start date");
		staysPage.pickDate(staysPage.monthName1, staysPage.dates, staysPage.nextMonthArrow, EndDate);
		System.out.println("pick end date");
	}


	@And("user select room {string}, adult {string}, and children amount {string}")
	public void user_select_room_adult_and_children_amount(String RoomAmount, String AdultAmount, String ChildrenAmount) throws InterruptedException {
//		staysPage.roomNumAndGuestNum.click();
		System.out.println(RoomAmount + AdultAmount + ChildrenAmount);
		waitForVisibility(staysPage.addRoom);
//		staysPage.addItem(staysPage.addRoom, RoomAmount);
//		staysPage.addItem(staysPage.addAdults, AdultAmount);
//		staysPage.addItem(staysPage.addChildren, ChildrenAmount);
		staysPage.addItem(staysPage.addRoom, staysPage.addAdults, staysPage.addChildren, RoomAmount, AdultAmount, ChildrenAmount);
//		Thread.sleep(1000);
		System.out.println("search done");
	}

	@And("user click on 5 stars Hotel and 8plus Review score")
	public void user_click_on_5_stars_Hotel_and_8plus_Review_score(){
		waitForVisibility(staysPage.hotelClass_FiveStars);
		waitForClickability(staysPage.hotelClass_FiveStars);
		staysPage.hotelClass_FiveStars.click();
		System.out.println("click 5");
		staysPage.reviewScore_EightPlus.click();
		System.out.println("click 8");
	}


	@And("user select sorted by Price \\(low to high) {string}")
	public void user_select_sorted_by_price_low_to_high(String SortedBy ) {
		staysPage.sortDropDown.click();
		staysPage.clickSortBy(SortedBy);
		System.out.println("drop");
	}

	@When("Then user can see the lowest price on the top of result list")
	public void Then_user_can_see_the_lowest_price_on_the_top_of_result_list() {
		System.out.println("complete search");
	}


}







