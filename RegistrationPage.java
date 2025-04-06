package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class RegistrationPage {
    private final WebDriver driver;
    TakesScreenshot ts;
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By signupLink = By.linkText("Sign up");
    private final By username = By.id("sign-username");
    private final By password = By.id("sign-password");
    private final By signupButton = By.xpath("//button[@onClick='register()']");

    public void clickSignupLink() {
        driver.findElement(signupLink).click();
    }

    public void enterUsername(String uname) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(username).sendKeys(uname);
    }

    public void enterPassword(String pass) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(password).sendKeys(pass);
    }

    public void clickSignupButton() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(signupButton).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public String takeScreenshot() {
        String className = this.getClass().getSimpleName();
        String timestamp = String.valueOf(System.currentTimeMillis());
        String relativePath = "./screenshots/" + className + "_" + timestamp + ".png";
        try {
            Robot robot = new Robot();
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            Rectangle screenRect = new Rectangle(0, 0, screenSize.width, screenSize.height);
            BufferedImage screenFullImage = robot.createScreenCapture(screenRect);

            File dest = new File(System.getProperty("user.dir") + "/screenshots/" + className + "_" + timestamp + ".png");
            ImageIO.write(screenFullImage, "png", dest);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return relativePath;
    }
}