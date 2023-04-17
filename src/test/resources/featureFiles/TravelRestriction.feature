
Feature: Travel Restrictions by country


Scenario: User can check the travel Restriction of destination country
		Given User is on KAYAK Home Page
		When User click on Travel Restrictions tab
		Then User should be navigated to Travel Restrict page
		And User able to see the form to select origin and destination country 
		When User select "<OriginCountry>" from traveling from  
		And User select "<DestinationCountry>" from traveling to
		Then User able to see the travel restriction status "<Result>" of destination country
		And User can close the brower
		
		Examples:
|   OriginCountry		 |  DestinationCountry |  Result  |
|   Thailand         |     Yemen           |  Closed  |
|   United States    |     Thailand        |  Open    |
|   United States    |     China           |  Closed  |

