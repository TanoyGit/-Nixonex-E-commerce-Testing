package CapStone.EcommercePrj;


import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationPage {


	    public static void main(String[] args) {
	        
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        
	       
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	        try {
	           
	            driver.get("https://www.demoblaze.com/"); // change to your site URL

	            
	            driver.findElement(By.linkText("Sign up")).click();

	            
	            driver.findElement(By.id("sign-username")).sendKeys("testUser");

	            
	            driver.findElement(By.id("sign-password")).sendKeys("testPass123");

	            
	            driver.findElement(By.xpath("//button[@onClick='register()']")).click();

	           //Screenshot
	            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

                //Save Screenshot
	            File destination = new File(System.getProperty("Desktop") + "/screenshotsr/page.png");
	            destination.getParentFile().mkdirs(); 
	            FileUtils.copyFile(screenshot, destination);

	            System.out.println("Screenshot saved at: " + destination.getAbsolutePath());

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	           
	            driver.quit();
	        }
	    }
	}
