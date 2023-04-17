package kayak.pageObjects;

import java.util.List;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import kayak.utilities.BaseClass;
import kayak.utilities.CommonMethods;

public class ThingToDoPage extends CommonMethods {
	
	public ThingToDoPage() {
		PageFactory.initElements(BaseClass.getDriver(), this);
	}
	
    @FindBy(xpath = "//div[text()='Things to do']")
    public WebElement thingTodoTab ;
    
    @FindBy(xpath = "//h1[@class='dEi8-title']")
    public WebElement thingTodoHeader;
    
    @FindBy(xpath = "//div[@class='dEi8-search-form']")
    public WebElement ThingToDoTextBox;
    
    @FindBy(xpath = " //div[@class='lNCO-inner']")
    public WebElement ThingToDoText;
    
    @FindBy(xpath = "//input[@placeholder='Search for a city']")
    public WebElement ThingToDoInputBox;
    
    @FindBy(xpath = "//li[@aria-label='New York, United States']")
    public WebElement ThingToDoselectCity;
    
    @FindBy(xpath = "//button[@aria-label='Search']")
    public WebElement ThingToDoSearchButton;
    
    @FindBy(xpath = "(//h2[@class='c2OEc-title'])[1]")
    public WebElement headerTopAttractionCity;
    
    @FindBy(xpath = "(//h2[@class='c2OEc-title'])[2]")
    public WebElement headerTourCity;
    
    @FindBy(xpath = "(//h2[@class='c2OEc-title'])[3]")
    public WebElement headerTour;
    
    @FindBy(xpath = "(//div[@class='c2OEc']/div/a)[1]")
    public WebElement seeallButton;
    
    @FindBy(xpath = "(//div[@class='c2OEc']/div/a)[5]")
    public WebElement seeallButtonTour;
    
    
    @FindBy(xpath = "//div[@class='c4Hod-title']")
    public List<WebElement> listallResult;
    
    @FindBy(xpath = "//button[text()='Tours']")
    public WebElement ButtonTours;
    
    @FindBy(xpath = "//div[@class='c4Hod-title']")
    public List<WebElement> titleplace;
    
    @FindBy(xpath = "//span[@class='c0p_q-price']")
    public List<WebElement> Priceplace;
    
    
    @FindBy(xpath = "//div[@id='ResultsListSortDropdownLabelactivitiesResultList']")
    public WebElement filterDropdown;
    
  
    @FindBy(xpath = "(//div[@class='c5FFC-item'])[3]")
    public WebElement selectLowToHigh;
    
    @FindBy(xpath = "//input[@id='categories_item_208' ]")
    public WebElement InputCityTour;
    
    @FindBy(xpath = "(//div[@class='MfRJ-additional-label'])[7]")
    public WebElement numberCityTour;
    
    @FindBy(xpath = "//div[@class='yNPo-filtered']")
    public WebElement ResultnumberCityTour;
    
    @FindBy(xpath = "(//*[name()='svg'])[35]")
    public WebElement filterTour;
    
    @FindBy(xpath = "//h6[text()='Company']")
    public WebElement FooterCompany;
    
  //h6[text()='Company']
    
            
    
    public int getNumberResult() {    	
    	return listallResult.size();
    }
    
    public int getNumberTourPlace() {
    	return titleplace.size();
    }
    
    public void SelectLowToHightPrice() {
    	filterDropdown.click();
    	selectLowToHigh.click();
    }
    
    
    
    
    
    

}
