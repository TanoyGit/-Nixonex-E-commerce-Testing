package Pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LoginPage {
    private final WebDriver driver;
    Boolean flag = false;
    TakesScreenshot ts;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By loginLink = By.linkText("Log in");
    private final By username = By.id("loginusername");
    private final By password = By.id("loginpassword");
    private final By loginButton = By.xpath("//button[@onclick='logIn()']");
    private final By userButton = By.id("nameofuser");


    public void clickLoginLink() {
        driver.findElement(loginLink).click();
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

    public void clickLoginButton() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(loginButton).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean isLoginSuccessful() {
        if (driver.findElement(userButton).isDisplayed()) {
            flag = true;
        }
        return flag;
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

            relativePath = "./screenshots/" + className + "_" + timestamp + ".png";
            File dest = new File(System.getProperty("user.dir") + "/screenshots/" + className + "_" + timestamp + ".png");
            ImageIO.write(screenFullImage, "png", dest);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return relativePath;
    }
}