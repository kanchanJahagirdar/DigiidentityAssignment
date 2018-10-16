##DigiidentityAssignment
Assignment
#Purpose:
Assignment was meant to write some scenarios to test the registration and sign in DdySmallApp.
It coveres the testing steps to check the registration functionality,login(Valid and Invalid credntials) using Page Object Model.

##Prerequisites:
Eclipse,Java,Maven dependencies(Selenium/Cucumber/Junit),chromedriver.exe,Plugin for feature file
DdySmallApp server should be up and running

##Running the tests
This project is made using POM.
Package :com.DdySmallAppPages
It contains 5 class ,each class for each page in the App
Example:LoginPage.java class
It stores all the web element present on the login screen and releted methods
It is done to acheive reusability and for easy maintainence

Package Digidentity.DigidentityAssignment:
It contains 2 class files
1.Runner class :It uses the Junit annotation @RunWith().It more like a starting point for Junit to start executing tests.
2.stepDefinition :Contains the defination of each step to be executed as mentained in feature file

##Feature File :DDTofDdySmallApp

It consist of 4 scenarios currently
Login with Valid credentials 
Registration with already exsisting Email 
Registration with blank password 
Create New Account
DataHandling is done through Datatables

##Reporting
Execution reports are stored under target folder

##Author Details
Kanchan Jahagirdar is ISTQB Certified tester with 7 years of experiance in Testing
