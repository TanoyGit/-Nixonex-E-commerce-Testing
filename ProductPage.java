package CapStone.EcommercePrj;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class ProductPage {
    public static void main(String[] args) {
    	
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            
            driver.get("https://www.demoblaze.com/");

            driver.findElement(By.linkText("Laptops")).click();

            
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(2, document.body.scrollHeight);");

            if (!driver.findElements(By.linkText("MacBook Pro")).isEmpty()) {
                driver.findElement(By.linkText("MacBook Pro")).click();
            } 
            
            else {
                System.out.println("MacBook Pro not found.");
                return;
            }

           
            String productName = driver.findElement(By.xpath("//h2[@class='name']")).getText();
            String productPrice = driver.findElement(By.xpath("//h3[@class='price-container']")).getText();

            System.out.println("Product Name: " + productName);
            System.out.println("Product Price: " + productPrice);

      
            driver.findElement(By.linkText("Add to cart")).click();

            
            driver.switchTo().alert().accept();

            System.out.println("Product added to the cart successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        } 
        
        finally {
            driver.quit();
        }
    }
}
