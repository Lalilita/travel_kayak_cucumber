package kayak.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import kayak.utilities.BaseClass;
import kayak.utilities.CommonMethods;

public class TravelRestrictionsPage extends CommonMethods {
	
	public TravelRestrictionsPage() {
		PageFactory.initElements(BaseClass.getDriver(), this);
	}
	
	 @FindBy(xpath = "//h1[@class='qm2e-title']")
	 public WebElement headerPage;
	 
	 @FindBy(xpath = "//div[@class='c1c-c']")
	 public WebElement FormInput;
	 
	 @FindBy(xpath = "//div[@class='c1c-c']/div[1]")
	 public WebElement OriginCountry;
	 
	 @FindBy(xpath = "//div[@class='c1c-c']/div[2]/div")
	 public WebElement DestinationCountry;
	 
	 @FindBy(xpath = "(//div[@class='c7dw9']/div)[2]")
	 public WebElement RegulationStatus;
	 
	 @FindBy(xpath = "//label[@id='vaccination-form-label']")
	 public WebElement vaccination;
	 

}
