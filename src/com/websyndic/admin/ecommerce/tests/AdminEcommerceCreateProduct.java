package com.websyndic.admin.ecommerce.tests;
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
import com.websyndic.admin.ecommerce.pages.Produits;
 
public class AdminEcommerceCreateProduct {
 
    WebDriver driver;
    String appUrl;
    String localStorage;
 
    static ExtentReports reports;
    ExtentTest test;
    String testname = "AdminEcommerceCreateProduct";
    
 
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
        appUrl = "http://api.websyndic.test/web/portal-admin/";
    }
 
    @Test
    public void addNewProduct() throws IOException {
        try {
        	// Start test. Mention test script name
            test = reports.startTest("AdminEcommerceCreateProduct", "Admin can create a new product");
 
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            Produits produits=new Produits(driver);
    		driver.get(appUrl + "/");

    		
    		TestNGThread.sleep(1000);
    		produits.clickEcommerce();
    		TestNGThread.sleep(2000);
    		produits.clickProduits();
    		TestNGThread.sleep(2000);
    		produits.clickAjouter();
    		TestNGThread.sleep(2000);
    		produits.typeTitle();
    		TestNGThread.sleep(2000);
    		produits.typeDescription();
    		TestNGThread.sleep(2000);
    		produits.typeDescription2();
    		TestNGThread.sleep(2000);
    		produits.typeDescription3();
    		TestNGThread.sleep(2000);
    		produits.typePrice();
    		TestNGThread.sleep(2000);
    		produits.inputPrixSubscriber();
    		TestNGThread.sleep(2000);
    		produits.typeStock();   		
    		TestNGThread.sleep(2000);
    		produits.clickCreate();
    		TestNGThread.sleep(2000);

            //Validation
    		assertTrue(isTextPresent("a été créé avec succès."));
    		
    		
    		
            // Print log info in HTML report
            TestNGThread.sleep(1000);
            test.log(LogStatus.INFO, "Admin can create a new question");
            
            
            
 
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
    
    protected boolean isTextPresent(String text){
        try{
            boolean b = driver.getPageSource().contains(text);
            return b;
        }
        catch(Exception e){
            return false;
        }
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