/**
 * 
 */
package com.websyndic.front.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author mplesuvu
 *
 */


public class Subscribe {
	
	WebDriver driver;

	By subscribeButton = By.xpath("//*[contains(text(), 'Suivre')]");
	By unSubscribeButton = By.xpath("//*[contains(text(), 'Ne plus suivre')]");
	
	 
	 public Subscribe(WebDriver driver)
	 {
		 this.driver=driver;
	 }
	 
	 public void clickSubscribeButton()
	 {
		 driver.findElement(subscribeButton).click();
	 }
	 
	 public void clickUnSubscribeButton()
	 {
		 driver.findElement(unSubscribeButton).click();
	 }
	 
	

}
