import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.time.Duration;

public class RegistrationTest {
    public static void main(String[] args) {
        // Set up WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        // Implicit wait - applies to all element finds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            // Open the site
            driver.get("https://www.demoblaze.com/"); // change to your site URL

            // Click Sign up link
            driver.findElement(By.linkText("Sign up")).click();

            // Enter username
            driver.findElement(By.id("sign-username")).sendKeys("testUser");

            // Enter password
            driver.findElement(By.id("sign-password")).sendKeys("testPass123");

            // Click Sign up button
            driver.findElement(By.xpath("//button[@onClick='register()']")).click();

            // Take screenshot of entire screen
            String timestamp = String.valueOf(System.currentTimeMillis());
            Robot robot = new Robot();
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            Rectangle screenRect = new Rectangle(0, 0, screenSize.width, screenSize.height);
            BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
            File dest = new File(System.getProperty("user.dir") + "/screenshots/Registration_" + timestamp + ".png");
            ImageIO.write(screenFullImage, "png", dest);

            System.out.println("Screenshot saved: " + dest.getAbsolutePath());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
