package kayak.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import kayak.utilities.BaseClass;
import kayak.utilities.CommonMethods;

public class HotelResultPage extends CommonMethods {

	public HotelResultPage() {
		PageFactory.initElements(BaseClass.getDriver(), this);
	}

//	@FindBy(xpath = "//span[@class='title-txt']")
	@FindBy(xpath = "//h1[@class='hotel-name text-2.5xl sm:text-1.5xl']")
	public WebElement hotelName;
	
//	@FindBy(xpath = "//button[@id='button_book']")
	@FindBy(xpath = "//div[@class='px-3 sm:px-1 py-2 text-lg bg-white rounded-b-lg']//button")
	public WebElement bookBtn;
	
	@FindBy(xpath = "//input[@id='fname-input']")
	public WebElement inputFName;

	@FindBy(xpath = "//input[@id='lname-input']")
	public WebElement inputLName;
	
	@FindBy(xpath = "//input[@id='email-input']")
	public WebElement inputEmail;
	
	@FindBy(xpath = "//input[@id='mobile-input']")
	public WebElement inputMobile;
	
	@FindBy(xpath = "(//div[@id='toggle-list-btn'])[1]")
	public WebElement countryBox1;
	
	@FindBy(xpath = "(//div[@class='w-full h-full relative sm:px-0 px-2 my-1']//input)[1]")
	public WebElement InputCountry1;
	
	@FindBy(xpath = "(//span[@class='text-base sm:text-base font-normal sm:w-auto'])[1]")
	public WebElement firstOfCountryList;
	
	@FindBy(xpath = "//input[@id='invoice-address1-input']")
	public WebElement inputAddress1;
	
	@FindBy(xpath = "//input[@id='invoice-address2-input']")
	public WebElement inputAddress2;
	
	@FindBy(xpath = "//input[@id='invoice-province-input']")
	public WebElement inputState;
	
	@FindBy(xpath = "//input[@id='invoice-postalcode-input']")
	public WebElement inputZipCode;
	
	@FindBy(xpath = "(//div[@id='toggle-list-btn'])[2]")
	public WebElement countryBox2;
	
	@FindBy(xpath = "(//div[@class='w-full h-full relative sm:px-0 px-2 my-1']//input)[2]")
	public WebElement InputCountry2;
	
	@FindBy(xpath = "//input[@id='invoice-city-input']")
	public WebElement InputCity;
	
	@FindBy(xpath = "//input[@id='card-number-input']")
	public WebElement InputCardNumber;
	
	@FindBy(xpath = "//select[@id='month-input']")
	public WebElement monthDropdown;
	
	@FindBy(xpath = "//select[@id='year-input']")
	public WebElement yearDropdown;
	
	@FindBy(xpath = "//input[@id='cvv-input']")
	public WebElement InputCVV;
	
	@FindBy(xpath = "//input[@id='bank-input']")
	public WebElement InputBankName;
	
	@FindBy(xpath = "//div[@id='card-payment-id']")
	public WebElement confirmCheckBox;
	
	@FindBy(xpath = "//button[@id='submit-booking-btn']")
	public WebElement confirmBtn;
	
}
