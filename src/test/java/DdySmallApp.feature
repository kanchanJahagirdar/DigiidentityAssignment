#Author: Kanchan Jahagirdar
#Keywords Summary :This project is meant to test DdySmall application
#Feature: Scenarios include Account creation/Login 1

Feature: To test the functinality of DdySmall App
 
 @tag1
Scenario: Create Account
    Given Lauch Application 
    When Click Register   
    When  Enter New Account details "ii@ww.com" and "333"
   	Then Verify New Profile page    
    #When Enter Profile details "Name" "Surname" and DOB
    Then Verify New address page
    #When Enter Address "Street" "HouseNo" and "Postcode"
    Then Verify confirmation page
    #When User click on Confirm
    Then Verify Successfully registered message   		  
    Then CloseBrowser  
 @tag2
 Scenario: Login with Valid credentials    
    Given Open Browser and Application
    Then enter "k@k.com" and "123"
    Then It should successfully navigate to next page
    Then CloseBrowser
    
@tag3
Scenario: Registration with alredy exsisting Email  
		Given Open Browser and Application
		When  Click Register
		When  Enter New Account details "k@k.com" and "333"
    Then  Verify Account creation prohibited
    Then CloseBrowser
    
@tag4
Scenario: Registration with blank password 
		Given Open Browser and Application
		When  Click Register
	  When  Enter New Account details "x@y.com" and ""
    Then  Verify Error Message
    Then CloseBrowser
    


