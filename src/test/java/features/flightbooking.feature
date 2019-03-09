#----------------------------------
# Empty Cucumber .feature file
#----------------------------------
Feature: Flight Bookings    

Scenario: User login
Given User is on Home Page
When User Logs in
Then Flight Search Page is displayed   

Scenario: Flight Search
Given User is logged in
When User enters following search criteria
|roundtrip|1|New York|March|15|London|March|24|Economy|
Then matching flights are displayed

Scenario: Book Flight
Given User is on Home Page
When User Logs in
And User enters following search criteria
|roundtrip|1|New York|March|15|London|March|24|Economy|
And User selects following flights
|2|2|
And User enters following passenger details
|Narendra|Lilaramani|123412341234|
Then System displays flight confirmation

