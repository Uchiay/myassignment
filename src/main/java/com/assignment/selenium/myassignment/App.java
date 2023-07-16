package com.assignment.selenium.myassignment;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
    	//1. Initialize web driver
    	//System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
    	
    	System.setProperty("webdriver.chrome.driver","/Users/puneetaggarwal/Documents/Softwares/chromedriver_mac64/chromedriver");
    	ChromeOptions chromeOptions = new ChromeOptions();
    	//chromeOptions.addArguments("headless");
    	chromeOptions.addArguments("--disable-infobars");
    	chromeOptions.addArguments("--disable-dev-shm-usage");
    	chromeOptions.addArguments("--no-sandbox");
    	
    	WebDriver driver = new ChromeDriver(chromeOptions);
    	
    	//2.open the application url in browser
    	driver.get("https://www.facebook.com");
    	
    	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
;    	
    	//4. Locate fields and enter details
    	driver.findElement(By.id("email")).sendKeys("puneetpower007@gmail.com");
    	Thread.sleep(1000);
    	driver.findElement(By.id("pass")).sendKeys("cobraismyname");
    	Thread.sleep(1000);
    	
    	//5. Click on Login Button
    	driver.findElement(By.name("login")).click();
    	Thread.sleep(3000);
    	
    	//validate info
    	
    	
    	//quit driver
    	driver.quit();
    }
}
