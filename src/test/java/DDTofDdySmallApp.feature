#Author: kawar.kanchan7@gmail.com
#Keywords Summary : It is menat to test functionality of DdySmall App
#Feature: Currently 4 scenarios are coverd which covers both positive and negative testing
#Scenario: Business rule through list of steps with arguments.
#Given: The DdySmallApp server should be up
#When: Login /Filling Details/Close.Data is handles using Tables
#Then: Message validation

Feature: To test the functinality of DdySmall App

@SmokeTest
 Scenario: Login with Valid credentials    
    Given Open Browser and Application
    | C:\\WebDrivers | chrome|
    Then enter userid and password
     | k@k.com | 123 |
    Then It should successfully navigate to next page
    Then CloseBrowser
 
@SmokeTest
Scenario: Registration with already exsisting Email  
		Given Open Browser and Application
		| C:\\WebDrivers | chrome|
		When  Click Register
		When  Enter New Account details
		| k@k.com | 333 |
    Then  Verify Account creation prohibited
    Then CloseBrowser
    
@SmokeTest
Scenario: Registration with blank password 
		Given Open Browser and Application
		| C:\\WebDrivers | chrome|
		When  Click Register
	  When  Enter New Account details
	  | k234@k.com | |
    Then  Verify Error Message
    Then CloseBrowser  
   
@SmokeTest
Scenario: Create New Account
    Given Open Browser and Application
    | C:\\WebDrivers | chrome|
    When Click Register   
    When  Enter New Account details for registration
    | PK | 1234 |
   	Then Verify New Profile page    
    When Enter Profile details Name Surname and DOB
    | tom | thomas | 2013 | July | 11|
    Then Verify New address page
    When Enter Address Street HouseNo and Postcode
    | MGROAD | 41 | 107|
    Then Verify confirmation page
    When User click on Confirm
    Then Verify Successfully registered message  		  
    Then CloseBrowser       
     