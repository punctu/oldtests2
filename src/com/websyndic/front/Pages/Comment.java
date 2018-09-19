package com.websyndic.front.Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author mplesuvu
 * This class will store all the locators and methods of login page
 */
public class Comment {
	
	WebDriver driver;
	
	
	 By goToQuestion = By.linkText("Comment réduire les charges de notre copropriété ?");
	 By typeComment = By.xpath("html/body/app-root/main/app-question/div/div/div[1]/div[5]/div[2]/div/form/textarea");
	 By submitComment = By.name("Envoyer");
	 
	 
	 public Comment(WebDriver driver)
	 {
		 this.driver=driver;
	 }
	 
	 public void goToQuestion()
	 {
		 driver.findElement(goToQuestion).click();
	 }
	 
	 
	 public void typeComment()
	 {
		 driver.findElement(typeComment).sendKeys("test comment");
	 }
	 
	 public void submitComment()
	 {
		 driver.findElement(submitComment).click();
	 }

	
}
