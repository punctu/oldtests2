/**
 * 
 */
package com.websyndic.front.Pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * @author mplesuvu
 *
 */


public class FAQ {
	
	WebDriver driver;
    private  int randomInt;
    private  int randomInt2;
	
	 By faqPage = By.linkText("FAQ");
	 By submitQuestion =  By.xpath("//*[contains(text(), 'Soumettre une question')]");
	 By questionTitle = By.id("question-title");
	 By questionCategory = By.id("question-category");
	 By questionDescription = By.id("question-description");
	 By questionSubmit = By.xpath("//button[@type='submit']");
	 By questionConf = By.linkText("Retour en page d’accueil");
	 
	 
	 public FAQ(WebDriver driver)
	 {
		 this.driver=driver;
	 }
	 
	 public void goToFAQpage()
	 {
		 driver.findElement(faqPage).click();
	 }
	 
	 public void submitQuestion()
	 {
		 driver.findElement(submitQuestion).click();
	 }
	 
	 public void questionTitle()
	 {
        Random rd = new Random();
 	    for (int idx = 1000; idx <= 100000; ++idx) {
 	    randomInt = rd.nextInt(100000);
 	    randomInt2 = rd.nextInt(100000);
 	    }
		 driver.findElement(questionTitle).sendKeys("test portal"+" "+randomInt+" "+randomInt2);
	 }
	 
	 public void questionCategory()
	 {
		 new Select(driver.findElement(questionCategory)).selectByVisibleText("Charges");
	 }
	 
	 public void questionDescription()
	 {
		 driver.findElement(questionDescription).sendKeys("test test test");;
	 }
	 
	 public void questionSubmit()
	 {
		 driver.findElement(questionSubmit).click();
	 }
	 
	 public void questionConf()
	 {
		 driver.findElement(questionConf).click();
	 }
	 

}
