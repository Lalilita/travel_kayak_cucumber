@book
Feature: Booking the selected hotel

Scenario: User can book a the selected hotel 
Given user on the result page
When user click on View Deal button of the top hotel
Then the page navigate to new window of the detail of hotel in different website
When user click on book button
And user can fill out customer detail "<FName>" "<LName>" "<Email>" "<Phone>" "<Country>"
And user can fill out billing address "<Address1>" "<State>" "<Zipcode>" "<Country>" "<City>"
And user can fill out payment information "<CardNumber>" "<ExpMonth>" "<ExpYear>" "<CVV>" "<BankName>"
Then user can see the confirm your booking button to confirm booking


Examples:
| FName | LName | Email              | Phone      | Country       |
| Mary  | J     | test.mary@mail.com | 2223334444 | United States |

Examples:
| Address1 				 | State   | Zipcode | Country       | City  |
| 10345 Black St.  | Florida | 30111   | United States | Tampa |


Examples:
| CardNumber			    | ExpMonth | ExpYear | CVV | BankName |
| 1234 5678 8765 4321 | 01       | 2024    | 911 | ABCDEFG  |