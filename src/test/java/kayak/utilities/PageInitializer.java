package kayak.utilities;

import kayak.pageObjects.FlightPage;
import kayak.pageObjects.HomePage;
import kayak.pageObjects.PackagesPage;
import kayak.pageObjects.StaysPage;
import kayak.pageObjects.ThingToDoPage;
import kayak.pageObjects.TrainsPage;
import kayak.pageObjects.TravelRestrictionsPage;
import kayak.pageObjects.HotelResultPage;

public class PageInitializer extends BaseClass {

	public static HomePage homePage;
	public static PackagesPage packagesPage;
	public static TrainsPage trainsPage;
	public static FlightPage flightPage;
	public static ThingToDoPage thingsToDoPage;
	public static TravelRestrictionsPage travelRestrictpage;
	public static StaysPage staysPage;
	public static HotelResultPage hotelResultPage;
	
	
	public static void initialize() {
		homePage = new HomePage();
		packagesPage = new PackagesPage();
		trainsPage = new TrainsPage();
		flightPage = new FlightPage();
		thingsToDoPage = new ThingToDoPage() ;
		travelRestrictpage = new TravelRestrictionsPage();
		staysPage = new StaysPage();
		hotelResultPage = new HotelResultPage();
	}
	
}
	
