/**
 * 
 */
package com.DdySmallAppPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author Kanchan Jahagirdar
 *
 */
public class Confirmation {
	WebDriver driver = null;
	By confirmBtn = By.xpath("//input[@value='Confirm']");
	
	public Confirmation(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void ClickConfirmBtn() {
		
		driver.findElement(confirmBtn).click();
	}
}
