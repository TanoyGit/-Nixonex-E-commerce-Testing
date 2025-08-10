package CapStone.EcommercePrj;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPg {

	public static void main(String[] args) {
	
		
        WebDriver driver = new ChromeDriver();
        
        driver.manage().window().maximize();
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        driver.get("https://www.demoblaze.com/");
        
        driver.findElement(By.id("login2")).click(); 
        
        driver.findElement(By.id("loginusername")).sendKeys("testUser"); 
        
        driver.findElement(By.id("loginpassword")).sendKeys("testPass123"); 
        
        driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
        
        driver.close();

	}

}
