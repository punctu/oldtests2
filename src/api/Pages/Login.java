/**
 * 
 */
package api.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author mplesuvu
 * This class will store all the locators and methods of login page
 */
public class Login {
	
	WebDriver driver;
	
	
	 By connectButton = By.xpath("//*[contains(text(), 'Connexion')]");
	 By username =  By.id("inputEmail");
	 By password = By.id("inputPassword");
	 By submit = By.xpath("//button[@type='submit']");
	 
	 public Login(WebDriver driver)
	 {
		 this.driver=driver;
	 }
	 
	 public void clickConnectButton()
	 {
		 driver.findElement(connectButton).click();
	 }
	 
	 public void typeUserName()
	 {
		 driver.findElement(username).sendKeys("m.plique@cotoit.fr");
	 }
	 
	 public void typePassword()
	 {
		 driver.findElement(password).sendKeys("test123");
	 }
	 
	 public void clickSubmitButton()
	 {
		driver.findElement(submit).click(); 
	 }
	 
	 

	
}
