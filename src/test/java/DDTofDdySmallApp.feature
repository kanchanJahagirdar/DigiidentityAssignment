#Author: kawar.kanchan7@gmail.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: To test the functinality of DdySmall App

 #@tag1
 #Scenario: Login with Valid credentials    
    #Given Open Browser and Application
    #| C:\\WebDrivers | chrome|
    #Then enter userid and password
     #| k@k.com | 123 |
    #Then It should successfully navigate to next page
    #Then CloseBrowser
 #
#@tag2
#Scenario: Registration with already exsisting Email  
#		Given Open Browser and Application
#		| C:\\WebDrivers | chrome|
#		When  Click Register
#		When  Enter New Account details
#		| k@k.com | 333 |
    #Then  Verify Account creation prohibited
    #Then CloseBrowser
    #
#@tag3
#Scenario: Registration with blank password 
#		Given Open Browser and Application
#		| C:\\WebDrivers | chrome|
#		When  Click Register
#	  When  Enter New Account details
#	  | k234@k.com | |
    #Then  Verify Error Message
    #Then CloseBrowser  
   
@tag4
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
     