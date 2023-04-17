@flightTracker
Feature: Flight Tracker Functionality 



Scenario: User can check flignt based on providing correct information
Given User is on KAYAK Home Page
When User click on Flight Tracker tab
Then User should be navigated to its "<Page>"
And User able to see the form to select airline and flight number and date 
When User select "<Airline>" from flight tracker
And User select "<FlightNumber>" from Flight Number
And User select defualt date click on track flight button
Then User able to see the result of selected airline
And User can close the brower


Examples:
|Page		|Airline   		|FlightNumber |
|tracker|Avianca (AV) |  581    		|






