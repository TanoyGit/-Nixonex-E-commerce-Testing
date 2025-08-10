package CapStone.EcommercePrj;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage {
    public static void main(String[] args) {
        
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            
            driver.get("https://www.demoblaze.com/"); 



            driver.findElement(By.xpath("//a[contains(text(),'Laptops')]")).click(); 
            
            driver.findElement(By.linkText("MacBook Pro")).click(); 
            
            List <WebElement> els = driver.findElements(By.xpath("//div[@id='more-information']"));
            
           
            for(WebElement e : els) {
            	
            	System.out.println(e.getText());
            	
            }
               


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
        
    }
}

