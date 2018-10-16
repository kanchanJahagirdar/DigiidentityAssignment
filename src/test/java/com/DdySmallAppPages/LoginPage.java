/**
 * 
 */
package com.DdySmallAppPages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * @author Kanchan Jahagirdar
* It stores elements present on Authentication/Login screen
 */
public class LoginPage  {
	
	WebDriver driver;
	
	By emailId  = By.xpath("//input[@id='account_email']");
	By password = By.xpath("//input[@id='account_password_digest']");
	By signBtn  = By.xpath("//input[@value='Sign in']");
	By registerBtn = By.xpath("//a[@href='/register']");
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		
	}
	//String user name,String pwd
	public void SignToDdy(String username,String pwd) 
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(emailId).sendKeys(username);	
		driver.findElement(password).sendKeys(pwd);		
		driver.findElement(signBtn).click();
		
	}
	
	public void RegisterToDdy()
	{
		
		driver.findElement(registerBtn).click();
	}
}
