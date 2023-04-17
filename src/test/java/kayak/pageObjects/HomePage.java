package kayak.pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import kayak.utilities.BaseClass;
import kayak.utilities.CommonMethods;

public class HomePage extends CommonMethods {

	public HomePage() {
		PageFactory.initElements(BaseClass.getDriver(), this);
	}

	@FindBy(xpath = "//a[@aria-label='Search for flights']")
	public WebElement flightsTab;
	
	@FindBy(xpath = "//a[@aria-label='Search for packages']")
	public WebElement packagesTab;

	@FindBy(xpath = "//a[@aria-label='Search for trains']")
	public WebElement trainsAndBusTab;

	@FindBy(xpath = "//a[@aria-label='Track a flight']")
	public WebElement flightTrackerTab;

	@FindBy(xpath = "//input[@placeholder='From']")
	public WebElement fromField;

	@FindBy(xpath = "//input[@placeholder='Enter destination or airport']")
	public WebElement toField;

	@FindBy(xpath = "//span[@aria-label='Start date calendar input']")
	public WebElement startDateField;

	@FindBy(xpath = "//span[@aria-label='End date calendar input']")
	public WebElement endDateField;

	@FindBy(xpath = "//button[@aria-label='Search']")
	public WebElement searchBtn;

	@FindBy(xpath = "//div[@class='wHSr-monthName']")
	public WebElement navBar;

	@FindBy(xpath = "//button[@aria-label='Next Month']")
	public WebElement nextBtn;
	
	// ratthanon
	@FindBy(xpath = "//div[text()='Things to do']")
	public WebElement thinkTodoTab;

	@FindBy(xpath = "//div[@class='sign-in-nav-link']")
	public WebElement SignInLink;

	@FindBy(xpath = "//div[@class='common-authentication-react-AuthenticationDialog authentication--dialog unified-login unified-login']")
	public WebElement signInMethod;

	@FindBy(xpath = " (//div[@class='social-button-content'])[1]")
	public WebElement BookingButton;

	@FindBy(xpath = "//input[@id='username']")
	public WebElement InputUsername;

	@FindBy(xpath = "//button[@type='submit']")
	public WebElement buttonSubMit;

	@FindBy(xpath = "//input[@id='password']")
	public WebElement InputPassword;

	@FindBy(xpath = "//div[text()='Travel Restrictions']")
	public WebElement TravelRestrictionLink;


	
}
