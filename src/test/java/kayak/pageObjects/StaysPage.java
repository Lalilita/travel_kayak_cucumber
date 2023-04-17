package kayak.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import kayak.utilities.BaseClass;
import kayak.utilities.CommonMethods;
import kayak.utilities.Constants;

public class StaysPage extends CommonMethods {

	public StaysPage() {
		PageFactory.initElements(BaseClass.getDriver(), this);
	}

	@FindBy(xpath = "//a[@aria-label='Search for hotels']")
	public WebElement staysButton;

	@FindBy(xpath = "//input[@placeholder='Enter a city, hotel, airport, address or landmark']")
	public WebElement cityOfStay;
	
	@FindBy(xpath = "(//span[@class='gWvk'])[1]")
	public WebElement firstOfList;
	

	@FindBy(xpath = "//span[@aria-label='Start date calendar input']")
	public WebElement startDateBox;

	@FindBy(xpath = "//span[@aria-label='End date calendar input")
	public WebElement endDateBox;

	@FindBy(xpath = "//button[@aria-label='Next Month']")
	public WebElement nextMonthArrow;

	@FindBy(xpath = "(//div[contains(@class, 'monthName')])[1]")
	public WebElement monthName1;

	@FindBy(xpath = "(//div[contains(@class, 'monthName')])[2]")
	public WebElement monthName2;

	@FindBy(xpath = "(//div[contains(@class, 'days')])[1]/div")
	public List<WebElement> dates;

	@FindBy(xpath = "//div[contains(@class, 'buttonWrapper')]")
	public WebElement roomNumAndGuestNum;

	@FindBy(xpath = "(//div[contains(@class, 'mod-theme-default')]//button[2])[1]")
	public WebElement addRoom;

	@FindBy(xpath = "(//div[contains(@class, 'mod-theme-default')]//button[2])[2]")
	public WebElement addAdults;

	@FindBy(xpath = "(//div[contains(@class, 'mod-theme-default')]//button[2])[3]")
	public WebElement addChildren;

	@FindBy(xpath = "//button[@aria-label='Search']")
	public WebElement searchButton;

	@FindBy(xpath = "//div[@aria-label='Click to reset filters']")
	public WebElement searchResult;

//	@FindBy(xpath = "(//div[contains(@class, 'mod-icon-stars') and @aria-label='5 only'])[2]")
	@FindBy(xpath = "(//div[@aria-label='Hotel class']/div/div[5]//div[1]/div)[1]")
	public WebElement hotelClass_FiveStars;

	@FindBy(xpath = "//div[@aria-label='Review Score']//div[2]//div[4]")
	public WebElement reviewScore_EightPlus;

	@FindBy(xpath = "(//div[@aria-label='Maximum price'])[1]")
	public WebElement maxPrice;

	@FindBy(xpath = "//div[@class='ui-filters-RangeSlider']//div[2]")
	public WebElement minPrice;

	@FindBy(xpath = "//div[@class='c5FFC-icon']")
	public WebElement sortDropDown;

	@FindBy(xpath = "//li[@aria-label='Price (low to high)']")
	public WebElement tabList;
	
	@FindBy(xpath = "//div[@data-target='price'][1]")
	public List<WebElement> priceList;
	
	@FindBy(xpath = "(//div[@data-target='price'][1])[1]")
	public WebElement topPrice;
	
	@FindBy(xpath = "(//div[@class='FLpo-hotel-name'])[1]")
	public WebElement topHotelName;
	
	@FindBy(xpath = "(//div[@class='zV27 zV27-mod-flexible-height']//button)[1]")
	public WebElement topViewDealBtn;
	
	
	
	

	public void clickStays() {
		click(staysButton);
	}

	@FindBy(xpath = "(//div[contains(@class, 'wHSr-monthName')])[1]")
	public WebElement aonMonthYear;

	// new
	public void pickDate(WebElement monthName1, List<WebElement> dates, WebElement nextBtn, String needDate) {
		String[] arrStart = needDate.split(" ");
		String month = arrStart[0];
		String date = arrStart[1];
		String year = arrStart[2];
		String monthYear = month + " " + year;
		System.out.println("monthYear = " + monthYear);
		System.out.println("date = " + date);

		String webMonthYear1 = monthName1.getText();
		System.out.println("webMonthYear1 = " + webMonthYear1);

		staysPage.monthName1.click();

		Boolean aonChk = true;

		System.out.println(aonMonthYear.getText());

		while (aonChk) {
			if (!(aonMonthYear.getText().equalsIgnoreCase(monthYear))) {
				nextBtn.click();
			} else {
				int i = 1;
				while (aonChk) {
					WebElement ele = driver
							.findElement(By.xpath("(//div[contains(@class, 'onx_-days')])[1]/div[" + i + "]"));
					if (ele.getText().equalsIgnoreCase(date)) {
						ele.click();
						System.out.println("selected date");
						aonChk = false;
					}
					i++;
				}
				System.out.println("**** End date pick ****");
				aonChk = false;
			}
		}
	}

	public void addItem(WebElement addRooms, WebElement addAdults, WebElement addChildren, String rooms, String adults,
			String children) {

		int rAmount = Integer.parseInt(rooms);
		int aAmount = Integer.parseInt(adults);
		int cAmount = Integer.parseInt(children);

		System.out.println("room = " + rAmount);
		System.out.println("adult = " + aAmount);
		System.out.println("child = " + cAmount);

		if (rAmount <= 2) {
			aAmount -= 2;
		} else {
			aAmount -= rAmount;
		}

		System.out.println("room = " + rAmount);
		System.out.println("adult = " + aAmount);
		System.out.println("child = " + cAmount);

		for (int i = 1; i < rAmount; i++) {
			addRooms.click();
		}

		for (int i = 1; i <= aAmount; i++) {
			addAdults.click();
		}

		for (int i = 1; i <= cAmount; i++) {
			addChildren.click();
		}
		searchButton.click();
	}

	public void clickSortBy(String byText) {
		String selectedTab = "//li[@aria-label='" + byText + "']";
		WebElement ele = driver.findElement(By.xpath("//li[@aria-label='" + byText + "']"));
		ele.click();
	}

}
