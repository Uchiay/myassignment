package com.assignment.selenium.myassignment;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class App 
{
    public static void main( String[] args ) throws InterruptedException, IOException
    {
    	
    	//1. Initialize web driver
    	System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
    	
    	//System.setProperty("webdriver.chrome.driver","/Users/puneetaggarwal/Documents/Softwares/chromedriver_mac64/chromedriver");
    	ChromeOptions chromeOptions = new ChromeOptions();
    	//chromeOptions.addArguments("headless");
    	chromeOptions.addArguments("--disable-infobars");
    	chromeOptions.addArguments("--disable-dev-shm-usage");
    	chromeOptions.addArguments("--no-sandbox");
    	
    	WebDriver driver = new ChromeDriver(chromeOptions);
    	
    	 System.out.println("Script Execution Started");
    	//2.open the application url in browser
    	driver.get("https://www.facebook.com");
    	
    	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
;    	
    	//4. Locate fields and enter details
    	driver.findElement(By.id("email")).sendKeys("test@gmail.com");
    	Thread.sleep(1000);
    	driver.findElement(By.id("pass")).sendKeys("testpassword");
    	Thread.sleep(1000);
    	
    	//5. Click on Login Button
    	driver.findElement(By.name("login")).click();
    	Thread.sleep(3000);
    	
    	File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
   
    	FileUtils.copyFile(screenshot, new File("../loginresult.png"));
        
    	System.out.println("Results stored in file loginresult.png");
    	//quit driver
    	driver.quit();
    	System.out.println("Script Execution Completed");
    }
}
