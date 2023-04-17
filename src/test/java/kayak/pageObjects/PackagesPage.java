package kayak.pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import kayak.utilities.BaseClass;
import kayak.utilities.CommonMethods;

public class PackagesPage extends CommonMethods{

	
	public PackagesPage() {
		PageFactory.initElements(BaseClass.getDriver(), this);
	}
	
	@FindBy(xpath = "//*[@class='iRhY']")
	public List <WebElement> hotelsOnPageList;
	
	@FindBy(xpath = "//*[text()='5']")
	public WebElement fifthStarBtn;
	
	@FindBy(xpath = "//*[text()='8+']")
	public WebElement eightPlusBtn;
	
	@FindBy(xpath = "//div[@role='slider' and @aria-label='Minimum price']")
	public WebElement leftSlider;
	
	@FindBy(xpath = "//*[@role='button' and @class='MpuP-min']")
	public WebElement minPrice;
	
	@FindBy(xpath = "//*[@class='LR-R-best']")
	public List <WebElement> hotelPriceResult;
	

}	
	