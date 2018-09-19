package com.websyndic.front.tests;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.internal.thread.TestNGThread;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.websyndic.front.Pages.Comment;
import com.websyndic.front.Pages.Login;
 
public class ValidateCommentFunctionality {
 
    WebDriver driver;
    String appUrl;
    String pagesource;
 
    static ExtentReports reports;
    ExtentTest test;
    String testname = "UserCanSubmitNewComment";
    
 
    @BeforeClass
    public synchronized void initialize() {
        // Create an instance of ExtentsReports class and pass report storage
        // path as a parameter
    	// true / false for new report file
        reports = new ExtentReports(System.getProperty("user.dir") + "/HtmlReport/index.html", false);
    }
 
    @BeforeTest
    public void setup() throws IOException {
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "/driver-servers/chromedriver");
        driver = new ChromeDriver();
        appUrl = "http://websyndic:pentalog2017@websyndic.test/questions/all";
    }
 
    @Test
    public void validateCommentFunctionality() throws IOException {
        try {
        	// Start test. Mention test script name
            test = reports.startTest("UserCanSubmitNewComment", "Validate create question functionality");
 
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            Login login=new Login(driver);
            Comment comment=new Comment(driver);
    		driver.get(appUrl + "/");

    		
    		//execute
    		TestNGThread.sleep(2000);
    		login.clickConnectButton(); 
    		TestNGThread.sleep(2000);
    		login.typeUserName();   		
    		login.typePassword();   		
    		login.clickSubmitButton();
    		
    		TestNGThread.sleep(2000);
    		
    		comment.goToQuestion();
    		TestNGThread.sleep(2000);
    		comment.typeComment();
    		comment.submitComment();
    		
    		
    		    		
    		TestNGThread.sleep(2000);

    		
    		//verify
            pagesource = (String) driver.getPageSource();
            assertTrue(pagesource.contains("test comment"));

                       
            // Print log info in HTML report
            TestNGThread.sleep(1000);
            test.log(LogStatus.INFO, "User can submit new comment");
            
            
            
 
        } catch (Throwable t) {
            // Print fail info in HTML report
            test.log(LogStatus.FAIL, t.getMessage());
			String screenShotPath = System.getProperty("user.dir") + "/HtmlReport/Screens/" + testname + ".png";
            // Take screen shot of page
            takeScreenShot(driver, screenShotPath);
 
            // Attach screen shot in HTML report
            test.log(LogStatus.INFO, "Snapshot below: " + test.addScreenCapture(screenShotPath));
             
            Assert.assertTrue(false, t.getMessage());
 
        }
 
    }
 
    @AfterTest
    public void tearDown() {
        // Ending Test
        reports.endTest(test);
 
        // writing everything into HTML report
        reports.flush();
    }
 
    @AfterClass
    public void clearingSetup() {
        // Quitting browser
        driver.quit();
    }
 
    public void takeScreenShot(WebDriver driver, String filePath) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}