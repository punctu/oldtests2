/**
 * 
 */
package com.websyndic.admin.ecommerce.pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author mplesuvu
 * This class will store all the locators and methods of login page
 */
public class Produits {
	
	WebDriver driver;
    private  int randomInt;
    private  int randomInt2;
	
	
	 By expandTree = By.xpath("//li[5]/a/span");;
	 By clickProduits =  By.linkText("Produits");
	 By clickAddProduct = By.linkText("Ajouter");
	 By inputTitle = By.xpath("//*[contains(@name, 'title')]");
	 By inputDescr = By.xpath("//*[contains(@class, 'cke_wysiwyg_frame')]");
	 By inputDescr2 = By.xpath("//*[contains(@class, 'cke_wysiwyg_frame')]");
	 By inputPrix = By.xpath("//*[contains(@name, 'price')]");
	 By inputPrixSubscriber = By.xpath("//*[contains(@name, 'Subscriber')]");
	 By inputStock = By.xpath("//*[contains(@name, 'stock')]");
	 By clickCreateButton = By.xpath("//*[contains(@name, 'tn_create_and_list')]");
	 
	 
	 
	 
	 
	 public Produits(WebDriver driver)
	 {
		 this.driver=driver;
	 }
	 
	 public void clickEcommerce()
	 {
		 driver.findElement(expandTree).click();
	 }
	 
	 public void clickProduits()
	 {
		 driver.findElement(clickProduits).click();
	 }
	 
	 
	 public void clickAjouter()
	 {
		 driver.findElement(clickAddProduct).click();
	 }
	 
	 public void typeTitle()
	 {
	        Random rd = new Random();
	 	    for (int idx = 1000; idx <= 100000; ++idx) {
	 	    randomInt = rd.nextInt(100000);
	 	    randomInt2 = rd.nextInt(100000);
	 	    }
		 
		 driver.findElement(inputTitle).sendKeys("Test title" + " " + randomInt + " " + randomInt2);
	 }
	 
	 public void typeDescription()
	 {	
		 driver.switchTo().frame(0);
		 WebElement element = driver.findElement(By.cssSelector("body"));
		 element.sendKeys("test test");
		 driver.switchTo().defaultContent();

	 }
	 
	 public void typeDescription2()
	 {	
		 driver.switchTo().frame(1);
		 WebElement element = driver.findElement(By.cssSelector("body"));
		 element.sendKeys("test test");
		 driver.switchTo().defaultContent();

	 }
	 
	 public void typeDescription3()
	 {	
		 driver.switchTo().frame(2);
		 WebElement element = driver.findElement(By.cssSelector("body"));
		 element.sendKeys("test test");
		 driver.switchTo().defaultContent();

	 }
	 
	 
	 public void typePrice()
	 {
		 driver.findElement(inputPrix).sendKeys("12");
	 }
	 
	 public void inputPrixSubscriber()
	 {
		 driver.findElement(inputPrixSubscriber).sendKeys("10");
	 }
	 
	 public void typeStock()
	 {
		 driver.findElement(inputStock).sendKeys("1");
	 }
	 
	 public void clickCreate()
	 {
		 driver.findElement(clickCreateButton).click();
	 }
	 
	 
	 
	 
	 
	 
}
