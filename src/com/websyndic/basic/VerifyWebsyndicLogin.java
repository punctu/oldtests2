/**
 * 
 */
package com.websyndic.basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.internal.thread.TestNGThread;

import com.websyndic.front.Pages.Login;

/**
 * @author mplesuvu
 *
 */
public class VerifyWebsyndicLogin {
	
	String appUrl;
	
	
	@Test
	public void verifyValidLogin() throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "/driver-servers/chromedriver");
		Login login=new Login(driver);
		appUrl = "http://websyndic:pentalog2017@websyndic.test";
		
		driver.get(appUrl + "/");
		TestNGThread.sleep(1000);
		login.clickConnectButton();
		TestNGThread.sleep(1000);
		login.typeUserName();
		TestNGThread.sleep(1000);
		login.typePassword();
		TestNGThread.sleep(1000);
		login.clickSubmitButton();
		
		
		driver.quit();
		
		
		
	}

}
