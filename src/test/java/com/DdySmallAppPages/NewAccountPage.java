/**
 * 
 */
package com.DdySmallAppPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author Kanchan Jahagirdar
* It stores elements present on New Account screen
 */
public class NewAccountPage {

	WebDriver driver = null;
	
	By emailTextBox = By.xpath("//form/div/input[@id='account_email']");
    
	By pwdTextBox =By.xpath("//input[@id='account_password_digest']");
	
	By createaccntBtn = By.xpath("//input[@value='Create Account']");
	
	public NewAccountPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void NewAccountDetails(String username,String pwd) throws InterruptedException
	{
		driver.findElement(emailTextBox).sendKeys(username);
		Thread.sleep(1000);
		driver.findElement(pwdTextBox).sendKeys(pwd);
		Thread.sleep(1000);
		driver.findElement(createaccntBtn).click();
		Thread.sleep(1000);
	}
	
}
