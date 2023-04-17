@search
Feature: Searching the cheapest hotel

Scenario: User can book a the cheapest 5star hotel in the selected city and date 
Given user on the stays page
When user select city "<City>"
And user select checked-in date "<StartDate>" and checked-out date "<EndDate>"
And user select room "<RoomAmount>", adult "<AdultAmount>", and children amount "<ChildrenAmount>"
And user click on 5 stars Hotel and 8plus Review score
And user select sorted by Price (low to high) "<SortedBy>"
Then user can see the lowest price on the top of result list



Examples:
| City         					 | StartDate    | EndDate      | RoomAmount | AdultAmount | ChildrenAmount | SortedBy 					| 
| New York, United States| March 26 2023| April 8 2023 | 3          | 8           | 4              | Price (low to high)|



  