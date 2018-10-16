/**
 * 
 */
package com.DdySmallAppPages;

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
	public void SignToDdy(String username,String pwd) throws InterruptedException
	{
		driver.findElement(emailId).sendKeys(username);
		Thread.sleep(1000);
		driver.findElement(password).sendKeys(pwd);
		Thread.sleep(1000);
		driver.findElement(signBtn).click();
		Thread.sleep(1000);
	}
	
	public void RegisterToDdy()
	{
		//driver.findElement(emailId).sendKeys(username);
		//driver.findElement(password).sendKeys(pwd);
		driver.findElement(registerBtn).click();
	}
}
