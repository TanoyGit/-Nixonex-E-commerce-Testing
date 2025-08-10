package CapStone.EcommercePrj;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class AddtoCart {
    public static void main(String[] args) {
    	
    	
        WebDriver driver = new ChromeDriver();
        
        driver.manage().window().maximize();
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        
        try {
            
           
            driver.get("https://www.demoblaze.com/");

            
            driver.findElement(By.xpath("//a[contains(text(),'Laptops')]")).click();

            

            driver.findElement(By.linkText("MacBook Pro")).click();

            
            String productName = driver.findElement(By.xpath("//h2[@class='name']")).getText();
            String productPrice = driver.findElement(By.xpath("//h3[@class='price-container']")).getText();

            System.out.println("The product name is " + productName);
            System.out.println("The product cost is " + productPrice);

            
            driver.findElement(By.xpath("//a[contains(text(),'Add to cart')]")).click();

            
            driver.switchTo().alert().accept();

            System.out.println("Product added to the cart successfully");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
             
                driver.quit();
        }
   
    }
}

