package CapStone.EcommercePrj;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CheckoutPage {
    public static void main(String[] args) {
    	
        WebDriver driver = new ChromeDriver();
        
        driver.manage().window().maximize();
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
        	

            driver.get("https://www.demoblaze.com/");

            driver.findElement(By.linkText("Cart")).click();

            driver.findElement(By.xpath("//button[contains(text(),'Place Order' )]")).click();

            
            driver.findElement(By.id("name")).sendKeys("John Doe");
            driver.findElement(By.id("country")).sendKeys("USA");
            driver.findElement(By.id("city")).sendKeys("New York");
            driver.findElement(By.id("card")).sendKeys("1234567890123456");
            driver.findElement(By.id("month")).sendKeys("12");
            driver.findElement(By.id("year")).sendKeys("2025");

            
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(1, document.body.scrollHeight);");
            
            driver.findElement(By.xpath("//button[contains(text(),'Purchase')]")).click();

            if (driver.findElement(By.xpath("//h2[contains(text(),'Thank you for your purchase!')]")).isDisplayed()) {
                System.out.println("Order placed successfully!");
            } else {
                System.out.println("Order failed!");
            }

            
            driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}

