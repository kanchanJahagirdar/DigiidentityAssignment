/**
 * 
 */
package com.DdySmallAppPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Kanchan Jahagirdar
* It stores elements present on New Profile screen
 */
public class NewProfile {
	
	WebDriver driver = null;
	
	By nameTextBox = By.id("profile_name");   
	By surnameTextBox =By.id("profile_surname");	
	By createprofileBtn = By.xpath("//input[@value='Create Profile']");	
	By yearDropdown = By.id("profile_date_of_birth_1i");	
	By monthDropdown = By.id("profile_date_of_birth_2i");
	By dayDropdown = By.id("profile_date_of_birth_3i");
	
	public NewProfile(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void NewProfiledetails(String profilename,String surname) throws InterruptedException
	{
		driver.findElement(nameTextBox).sendKeys(profilename);
		driver.findElement(surnameTextBox).sendKeys(surname);
		
	}
	
	public void BirthDaydetails(String BirthYear,String BirthMonth,String BirthDay) throws InterruptedException
	{
		//DOB Selection
		Select drpyear = new Select(driver.findElement(yearDropdown));
		drpyear.selectByVisibleText(BirthYear);
		Thread.sleep(1000);
		Select drpmonth = new Select(driver.findElement(monthDropdown));
		drpmonth.selectByVisibleText(BirthMonth);
		Thread.sleep(1000);
		Select drpday = new Select(driver.findElement(dayDropdown));
		drpday.selectByVisibleText(BirthDay);
		Thread.sleep(1000);
		driver.findElement(createprofileBtn).click();
	}
	
}
