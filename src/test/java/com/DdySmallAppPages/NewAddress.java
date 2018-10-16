/**
 * 
 */
package com.DdySmallAppPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author Kanchan Jahgairdar
 *
 */
public class NewAddress {
	
	WebDriver driver = null;
	
	By streetTextBox = By.id("address_street");   
	By houseNoTextBox =By.id("address_house_number");	
	By postalCodeTextBox = By.id("address_postcode");	
	By createAddressBtn = By.xpath("//input[@value='Create Address']");
		
	public NewAddress(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void Addressdetails(String street,String houseNo,String Postalcode) throws InterruptedException
	{
		driver.findElement(streetTextBox).sendKeys(street);
		driver.findElement(houseNoTextBox).sendKeys(houseNo);
		driver.findElement(postalCodeTextBox).sendKeys(Postalcode);
		driver.findElement(createAddressBtn).click();
	}

}
