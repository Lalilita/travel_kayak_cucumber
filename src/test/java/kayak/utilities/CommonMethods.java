package kayak.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CommonMethods extends PageInitializer {

	public static void sendText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);

	}
	

	public static void clickRadioOrCheckbox(List<WebElement> radioOrCheckbox, String value) {

		String actualValue;
		// el = each element
		for (WebElement el : radioOrCheckbox) {
			actualValue = el.getAttribute("value").trim();
			if (el.isEnabled() && actualValue.equals(value)) {
				el.click();
				break;
			}

		}

	}

	public static void selectDropDownValue(WebElement element, String textToSelect) {

		try {
			Select select = new Select(element);

			List<WebElement> options = select.getOptions();
			for (WebElement el : options) {
				if (el.getText().equals(textToSelect)) {
					select.selectByVisibleText(textToSelect);
					break;
				}
			}

		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}
	}

	public static void selectDropDownIndex(WebElement element, int indexValue) {

		try {
			Select select = new Select(element);

			int size = select.getOptions().size();

			if (size > indexValue) {
				select.selectByIndex(indexValue);
			}

		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}

	}

	// methods that dismisses alerts and catches exception if alert is not present
	public static void dismissAlert() {

		try {

			Alert alert = BaseClass.getDriver().switchTo().alert();
			alert.dismiss();

		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}

	}

	// methods that gets text of alert and catches exception if laert is not present
	// return type has to be String
	public static String getAlertText() {

		String alertText = null; // in method, every variable must be initiate. But the class is not
		try {
			Alert alert = BaseClass.getDriver().switchTo().alert();
			alertText = alert.getText();

		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
		return alertText;

	}

	// accept alert
	public static void aceptAlert() {

		try {

			Alert alert = BaseClass.getDriver().switchTo().alert();
			alert.accept();

		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}

	// sends text to alert box
	public static void sendAlertText(String text) {

		try {

			Alert alert = BaseClass.getDriver().switchTo().alert();
			alert.sendKeys(text);
			alert.accept();

		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}

	}

	// iframe
	public static void switchToFrame(String nameOrId) {

		try {
			BaseClass.getDriver().switchTo().frame(nameOrId);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}

	}

	// iframe
	public static void switchToFrame(WebElement element) {

		try {
			BaseClass.getDriver().switchTo().frame(element);

		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}

	}

	// iframe index
	public static void switchToFrame(int index) {

		try {
			BaseClass.getDriver().switchTo().frame(index);

		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
	}

	// handle windows by switching to child Window (either window and tab)
	public static void switchToChildWindow() {
		String mainWindow = BaseClass.getDriver().getWindowHandle();
		Set<String> windows = BaseClass.getDriver().getWindowHandles();

		for (String eachWindow : windows) {

			if (!eachWindow.equals(mainWindow)) {
				BaseClass.getDriver().switchTo().window(eachWindow);
				break;
			}
		}
	}

	public static WebDriverWait getWaitObject() {
		WebDriverWait wait = new WebDriverWait(BaseClass.getDriver(), Constants.explicit_wait_time);
		return wait;
	}

	public static WebElement waitForClickability(WebElement element) {

		return getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
	}

	public static WebElement waitForVisibility(WebElement element) {

		return getWaitObject().until(ExpectedConditions.visibilityOf(element));
	}

	public static void click(WebElement element) {
		waitForVisibility(element).click();
	}

	// js executer
	public static JavascriptExecutor getJSObject() {
		JavascriptExecutor js = (JavascriptExecutor) BaseClass.getDriver();
		return js;
	}

	public static void jsClick(WebElement element) {
		getJSObject().executeScript("arguments[0].click();", element);
	}

	public static void jsSendKeys(WebElement element, String text) {
		getJSObject().executeScript("arguments[0].setAttribute(value);", text);
	}
	
	public static void scrollToElement(WebElement element) {
		getJSObject().executeScript("arguments[0].scrollIntoView(true);", element);
	}
	

	public static void ScrolByPixel(int pixel) {
		// scroll down positive
		// scroll up negative

		getJSObject().executeScript("window.scrollBy(0," + pixel + ")");

	}

	public static String getTimeStemp() {

		Date date = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");

		return sdf.format(date.getTime());
	}

	public static byte[] takeScreenshot(String filename) {
		TakesScreenshot ts = (TakesScreenshot) BaseClass.getDriver();
		byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);

		File file = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = Constants.SCREENSHOT_FILEPATH + filename + getTimeStemp() + ".png";

		try {
			FileUtils.copyFile(file, new File(destinationFile));
		} catch (Exception ex) {
			System.out.println("Cannot take screenshot!");
		}

		return picBytes;
	}

	public static void wait(int second) {

		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void selectCalendarDate(List<WebElement> element, String text) {
		for (WebElement pickDate : element) {
			if (pickDate.isEnabled()) {
				if (pickDate.getText().equals(text)) {
					pickDate.click();
					break;
				}
			}
		}
	}

	public static void hover(WebElement element) {
		Actions actions = new Actions(BaseClass.getDriver());
		actions.moveToElement(element).perform();
	}

	public static void dragAndDrop(WebElement source, WebElement target) {
		Actions actions = new Actions(BaseClass.getDriver());
		actions.dragAndDrop(source, target).perform();
	}

	public static void doubleClick(WebElement source) {
		Actions actions = new Actions(BaseClass.getDriver());
		actions.doubleClick(source).perform();
	}

	/**
	 * return a list of string from a list of elements ignores any element with no
	 * text
	 * 
	 * @param list
	 * @return
	 */
	public static List<String> getElementsText(List<WebElement> list) {
		List<String> elemTexts = new ArrayList<String>();
		for (WebElement el : list) {
			if (!el.getText().isEmpty()) {
				elemTexts.add(el.getText());
			}
		}
		return elemTexts;
	}

	/*
	 * Method to generate new email by random char and int
	 * 
	 */
	public static String generateRandomEmail() {
		Random rd = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 5; i++) {
			char c = 'a';
			c += rd.nextInt(5);
			sb.append(c);
		}
		int randomNum = rd.nextInt(1000);
		return sb.toString() + randomNum + "@mail.com";
	}

	/*
	 * Method to navigate to a page
	 */
	public static void goToPage(WebElement pageTab) {
		pageTab.click();
	}

	/*
	 * Method to select date on calendar
	 */
	public static boolean clickDate(String selectDate, WebElement navBar, WebElement nextBtn) {

		String selectDay = selectDate.split(" ")[1];
		String selectMonth = selectDate.split(" ")[0];
		String selectYear = selectDate.split(" ")[2];
		String formatDate = selectMonth + " " + selectDay; // + ", " + selectYear;

		String navBarDate = navBar.getText();
		String webYear = navBarDate.split(" ")[1];
		String webMonth = navBarDate.split(" ")[0];

		while (!webYear.equals(selectYear) || !webMonth.equals(selectMonth)) {

			nextBtn.click();
			navBarDate = navBar.getText();
			webYear = navBarDate.split(" ")[1];
			webMonth = navBarDate.split(" ")[0];

		}

		WebElement webDate = driver.findElement(By.xpath("//*[contains(@aria-label,'" + formatDate + "')]"));
		webDate.click();

		return true;

	}

	/*
	 * Method to select price range
	 */
	public static void highPriceRange(WebElement leftSlider, int pricePoint) {

		for (int i = 1; i <= pricePoint; i++) {
			leftSlider.sendKeys(Keys.ARROW_RIGHT);
		}

	}
	
	public static void changeMaxPrive(WebElement maxPrice, String priceNeed) {

		sendText(maxPrice, priceNeed);

	}
	
	/*
	 * Method cut dollar sign and cast to integer
	 * 
	 */
	public static int getPrice(WebElement element) {
		String text = element.getText();
		text = text.substring(1);
		text = text.replace(",", "");
		int price = Integer.parseInt(text);
		return price;
	}

	/*
	 * Method add increment in dropdown list
	 */
	public static void addIncrementDropdown(WebElement dropdown, WebElement increment, int amount) throws InterruptedException {
		dropdown.click();
		Thread.sleep(1000);
		int i = 1;
		while (i < amount) {
			increment.click();
			i++;
		}
	}
	
	/*
	 * Method pick only date (find all matching nodes in calendar)
	 */
	public static void pickDate(List<WebElement> startDates, String startDate, List<WebElement> endDates, String endDate) {
		                 
		 		for(WebElement ele:startDates) {
		 			String date=ele.getText();
		 			System.out.println(date);
		 			if(date.equalsIgnoreCase(startDate)) {
		 				ele.click();
		 				break;
		 			}
		 		}
		 		
		 		for(WebElement ele:endDates) {
		 			String date=ele.getText();
		 			System.out.println(date);
		 			if(date.equalsIgnoreCase(endDate)) {
		 				ele.click();
		 				break;
		 			}
		 		}
	}
	

	
	/*
	 * Add action click
	 */
	
	public static void Click(WebElement source) {
		Actions actions = new Actions(BaseClass.getDriver());
		actions.moveToElement(source).click().build().perform();
		
	}
	
	public static void limitPriceRange(WebElement leftSlider, int pricePoint) {

		for (int i = 1; i <= pricePoint; i++) {
			leftSlider.sendKeys(Keys.ARROW_RIGHT);
		}

	}
	
	/*
	 * Method handle windows multiple windows using iterator
	
	 */
	
		public static void switchToMultipleWindow() {
			
			Set<String> windowHandles = BaseClass.getDriver().getWindowHandles();
			System.out.println(windowHandles);
			Iterator<String> iterator = windowHandles.iterator();
			String parentWindow = iterator.next();
			String firstChildWindow = iterator.next();
			String secondChildWindow = iterator.next();
			BaseClass.getDriver().switchTo().window(secondChildWindow);			
		}
		
	 /*
	  * drag and drop price slider
	  */
		
	public static void setAttributeValue(WebElement targetElement, String attributeName, String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("targetElement.setAttribute('" +attributeName+"', '" +value+"')");
	}
	
	public static void checkSameHotelName(String name1, String name2) {
		int commaIndex = name1.indexOf(",");
		String new_name1;
		if(commaIndex >= 0) {
			new_name1 = name1.substring(0, commaIndex).toLowerCase();
		}else {
			new_name1 = name1.toLowerCase();
		}
		String new_name2 = name2.toLowerCase();
		Assert.assertEquals(new_name1, new_name2);
		System.out.print("same name");
	}
	
}

