Feature: Search Box Functionality in packages category tab




Scenario: User is able to search for hotel and flight schedule in this package tab
Given User is on KAYAK Home Page
When User click on the packages category tab
Then User should be navigated to "<PKPage>" and able to input information in the search field 
And User click and select the city of destination to "<Destination>"
And User select the departure "<StartDate>" and arrival "<EndDate>"
And User click on search button
Then User should be able to see "<hotelAmountOnPage>" out of all recommended hotels on the page
When User click on the five stars button 
And User click on eight plus review score button
And User select price at maximum
Then User should be able to see only one hotel with a price matching the selected price
And User can close the brower


Examples:
|PKPage		|Departure|Destination|StartDate		|EndDate 			 |hotelAmountOnPage|
|packages	|IAD			|New york   |August 1 2022|August 31 2022|16							 |






