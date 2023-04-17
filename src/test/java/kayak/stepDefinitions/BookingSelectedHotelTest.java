package kayak.stepDefinitions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import kayak.utilities.CommonMethods;

public class BookingSelectedHotelTest extends CommonMethods{

	String selectedHotelName1;
	String actualHotelName;
	
	@Given("user on the result page")
	public void user_on_the_result_page() {
	    System.out.println("on result page");
	}
	@When("user click on View Deal button of the top hotel")
	public void user_click_on_view_deal_button_of_the_top_hotel() {
		selectedHotelName1 = staysPage.topHotelName.getText();
		staysPage.topViewDealBtn.click();
	}
	@Then("the page navigate to new window of the detail of hotel in different website")
	public void the_page_navigate_to_new_window_of_the_detail_of_hotel_in_different_website() {
		switchToMultipleWindow();
		actualHotelName = hotelResultPage.hotelName.getText();
		checkSameHotelName(selectedHotelName1, actualHotelName);
	}
	@When("user click on book button")
	public void user_click_on_book_button() {
		hotelResultPage.bookBtn.click();
	}
	
	@When("user can fill out customer detail {string} {string} {string} {string} {string}")
	public void user_can_fill_out_customer_detail(String FName, String LName, String Email, String Phone, String Country) {
		sendText(hotelResultPage.inputFName, FName);
		sendText(hotelResultPage.inputLName, LName);
		sendText(hotelResultPage.inputEmail, Email);
		hotelResultPage.countryBox1.click();
		sendText(hotelResultPage.InputCountry1, Country);
		hotelResultPage.firstOfCountryList.click();
		sendText(hotelResultPage.inputMobile, Phone);
	}
	
	@When("user can fill out billing address {string} {string} {string} {string} {string}")
	public void user_can_fill_out_billing_address(String Address1, String State, String Zipcode, String Country, String City) {
		sendText(hotelResultPage.inputAddress1, Address1);
		sendText(hotelResultPage.inputState, State);
		sendText(hotelResultPage.inputZipCode, Zipcode);
		hotelResultPage.countryBox2.click();
		sendText(hotelResultPage.InputCountry2, Country);
		hotelResultPage.firstOfCountryList.click();
		sendText(hotelResultPage.InputCity, City);
	}
	
	@When("user can fill out payment information {string} {string} {string} {string} {string}")
	public void user_can_fill_out_payment_information(String CardNumber, String ExpMonth, String ExpYear, String CVV, String BankName) {
		sendText(hotelResultPage.inputAddress1, CardNumber);
		selectDropDownValue(hotelResultPage.monthDropdown, ExpMonth);
		selectDropDownValue(hotelResultPage.yearDropdown, ExpYear);
		sendText(hotelResultPage.InputCVV, CVV);
		sendText(hotelResultPage.InputBankName, BankName);
	}
	
	@Then("user can see the confirm your booking button to confirm booking")
	public void user_can_see_the_confirm_your_booking_button_to_confirm_booking() {
		hotelResultPage.confirmCheckBox.click();
		hotelResultPage.confirmBtn.click();
	}
}
