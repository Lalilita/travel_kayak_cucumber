package kayak.pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import kayak.utilities.BaseClass;
import kayak.utilities.CommonMethods;

public class FlightPage extends CommonMethods {

	public FlightPage() {
		PageFactory.initElements(BaseClass.getDriver(), this);
	}

	@FindBy(xpath = "//*[@class='flight-number-link active ']")
	public WebElement flightNumberTab;

	@FindBy(xpath = "//div[@class='track-form-container']")
	public WebElement flightTrackerForm;

	//Flight number
	@FindBy(xpath = "//input[@placeholder='Airline']")
	public WebElement airlineInput;

	@FindBy(xpath = "//input[@placeholder='Flight Number']")
	public WebElement flightInput;

	@FindBy(xpath = "//li[@id='al-AV']")
	public WebElement airlineAV;

	@FindBy(xpath = "//*[contains(@id,'lightNumberTrackForm-submit') and @type='submit']")
	public WebElement trackFlightBtn;

	@FindBy(xpath = "//*[@class='errorContent']")
	public WebElement errorContent;

	@FindBy(xpath = "//*[contains(@class,' errorDialogCloseButton')]")
	public WebElement dismissContent;

	@FindBy(xpath = "//*[@class='col col-6-12']")
	public WebElement flightHeader;

	@FindBy(xpath = "//*[@class='map']")
	public WebElement flightMap;

	//Airport
	@FindBy(linkText = "Airport")
	public WebElement airportTab;
	
	@FindBy(xpath = "//input[@placeholder='Airport (required)']")
	public WebElement airportInput;

	@FindBy(xpath = "//li[@id='ap-IAD/2279']")
	public WebElement airportIAD;
	
	@FindBy(xpath = "//input[@placeholder='Airline (optional)']")
	public WebElement airportAirlineInput;

	@FindBy(xpath = "//li[@id='al-KE']")
	public WebElement airlineKE;
	
	@FindBy(xpath = "//*[contains(@id,'airportTrackForm-submit')]")
	public WebElement airportTrackFlightBtn;


}
