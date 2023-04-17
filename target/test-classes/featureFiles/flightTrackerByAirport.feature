Feature: Flight Tracker Functionality 



Scenario: Users should be able to track the flight based on the correct information that they fill in.
Given User is on KAYAK Home Page
When User click on the Flight Tracker tap
Then User should be navigated to "<Page>"
When User select Airport tab
And User select "<Airport>" from flight tracker (IAD)
And User select "<Airline>" name (Korean Air)
And User click on trackFlight Button
Then User should be able to track the flight based on the airport name, airline name and date they have input.
And User can close the brower

Examples:
|Page		|Airport|  Airline 				|
|tracker|IAD 		| Korean Air (KE) |

	


