package kayak.stepDefinitions;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import kayak.utilities.BaseClass;
import kayak.utilities.CommonMethods;


public class SearchFunctionTest extends CommonMethods{


	@When("User click on the Things to do tab")
	public void user_click_on_the_things_to_do_tab() throws InterruptedException {
		homePage.thinkTodoTab.click();	   
	}

	@Then("User should be navigated to things to do page")
	public void user_should_be_navigated_to_things_to_do_page() {
	    Assert.assertTrue(getDriver().getTitle().contains(getProperty("titleThingTodo")) && (thingsToDoPage.thingTodoHeader.getText().contains(getProperty("headerThingTodo"))));
	    
	}

	@Then("User able to see the search box")
	public void user_able_to_see_the_search_box() {
		Assert.assertTrue(thingsToDoPage.ThingToDoTextBox.isDisplayed());
	    
	}

	@When("User enter a city and click on the city on the drop down and click search button")
	public void user_enter_a_city_and_click_on_the_city_on_the_drop_down_and_click_search_button() throws InterruptedException {
		
		thingsToDoPage.ThingToDoText.click();
		thingsToDoPage.ThingToDoInputBox.sendKeys(getProperty("cityCenter"));
		thingsToDoPage.ThingToDoselectCity.click();
		thingsToDoPage.ThingToDoSearchButton.click();
	  
	}

	@Then("User able to see Top attractions in Chicago and see all button")
	public void user_able_to_see_top_attractions_in_chicago_and_see_all_button() throws InterruptedException {
		waitForVisibility(thingsToDoPage.headerTopAttractionCity);
		Assert.assertTrue(thingsToDoPage.headerTopAttractionCity.getText().contains(getProperty("headerTopAttraction")) && thingsToDoPage.seeallButton.isDisplayed());
	   
	}

	@When("User click on see all button")
	public void user_click_on_see_all_button() {
		thingsToDoPage.seeallButton.click();
	
	}

	@Then("User able to see experiences attraction places of the city")
	public void user_able_to_see_experiences_attraction_places_of_the_city() throws InterruptedException {
		Thread.sleep(5000);
		
		int number = Integer.parseInt(getProperty("numberAttraction"));
		
		while(thingsToDoPage.getNumberResult() < number) {
			System.out.println(thingsToDoPage.getNumberResult());
			scrollToElement(thingsToDoPage.FooterCompany);
			Thread.sleep(3000);
		}
		
		Assert.assertTrue(thingsToDoPage.getNumberResult() == number);
		tearDown();
		
	}
	
	@Then("User able to see Tours in Most popular experiences in that city session  and see all button")
	public void user_able_to_see_tours_in_most_popular_experiences_in_that_city_session_and_see_all_button() {
	    ScrolByPixel(1500);
	    Assert.assertTrue(thingsToDoPage.headerTourCity.getText().contains(getProperty("headerTourCity")) && thingsToDoPage.headerTour.getText().contains(getProperty("headerTour")));
	    Assert.assertTrue(thingsToDoPage.seeallButtonTour.isDisplayed());
	    
	}
	
	@When("User click {string} and navigate to the correct page")
	public void user_click_and_navigate_to_the_correct_page(String linkurl) throws InterruptedException {
		WebElement linktext = getDriver().findElement(By.xpath("//span[text()='" + linkurl + "']"));
		linktext.click();
		Thread.sleep(2000);
		
		WebElement headerPage = getDriver().findElement(By.xpath("//h1[text()='" + linkurl + "']"));
		Assert.assertTrue(headerPage.getText().contains(linkurl));
		driver.navigate().back();
		ScrolByPixel(1500);
	    
	}

	@When("User click on see all button in Tour city")
	public void user_click_on_see_all_button_in_tour_city() {
		thingsToDoPage.seeallButtonTour.click();

	}

	@Then("User able to see experiences information of the Tours in that city")
	public void user_able_to_see_experiences_information_of_the_tours_in_that_city() throws InterruptedException {		
		Thread.sleep(3000);
		thingsToDoPage.ButtonTours.click();
		Assert.assertTrue(thingsToDoPage.getNumberTourPlace()>0 && thingsToDoPage.getNumberTourPlace() == thingsToDoPage.Priceplace.size());

	}
	
	@When("User click filter the type of tour")
	public void user_click_filter_the_type_of_tour() throws InterruptedException {
		waitForVisibility(thingsToDoPage.filterTour);
		Click(thingsToDoPage.filterTour);
	}

	@Then("User show see the correct number of results to dispaly on the page")
	public void user_show_see_the_correct_number_of_results_to_dispaly_on_the_page() {
		System.out.println(thingsToDoPage.ResultnumberCityTour.getText());
		Assert.assertEquals(thingsToDoPage.numberCityTour.getText(), thingsToDoPage.ResultnumberCityTour.getText());
	}



}
