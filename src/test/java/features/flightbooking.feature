#----------------------------------
# Empty Cucumber .feature file
#----------------------------------
Feature: Flight Bookings    

Scenario: User login
Given User is on Home Page
When User Logs in
Then User Profile Page is Displayed   
