package Pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CheckoutPage {
    private final WebDriver driver;
    TakesScreenshot ts;
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By cartLink = By.linkText("Cart");
    private final By placeOrderButton = By.xpath("//button[contains(text(),'Place Order' )]");
    private final By nameField = By.id("name");
    private final By countryField = By.id("country");
    private final By cityField = By.id("city");
    private final By creditCardField = By.id("card");
    private final By monthField = By.id("month");
    private final By yearField = By.id("year");
    private final By purchaseButton = By.xpath("//button[contains(text(),'Purchase')]");
    private final By successMessage = By.xpath("//h2[contains(text(),'Thank you for your purchase!')]");
    private final By acceptButton = By.xpath("//button[contains(text(),'OK')]");
    private final By modal = By.xpath("//*[@id=\"orderModal\"]/div/div/div[2]");

    public void clickCart() {
        driver.findElement(cartLink).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void clickPlaceOrderButton() {
        driver.findElement(placeOrderButton).click();
    }

    public void enterName(String name) {
        driver.findElement(nameField).sendKeys(name);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void enterCountry(String country) {
        driver.findElement(countryField).sendKeys(country);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void enterCity(String city) {
        driver.findElement(cityField).sendKeys(city);
    }

    public void enterCreditCard(String creditCard) {
        driver.findElement(creditCardField).sendKeys(creditCard);
    }

    public void enterMonth(String month) {
        driver.findElement(monthField).sendKeys(month);
    }

    public void enterYear(String year) {
        driver.findElement(yearField).sendKeys(year);
    }

    public void clickPurchaseButton() {
        WebElement modalElement = driver.findElement(modal);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop = arguments[0].scrollHeight;", modalElement);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(purchaseButton).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Boolean isSuccessMessageDisplayed() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(driver.findElement(successMessage).isDisplayed()){
            return true;
        }
        return false;
    }

    public String takeScreenshot() {
        String className = this.getClass().getSimpleName();
        String timestamp = String.valueOf(System.currentTimeMillis());
        String relativePath = "./screenshots/" + className + "_" + timestamp + ".png";
        try {

            Robot robot = new Robot();
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            java.awt.Rectangle screenRect = new Rectangle(0, 0, screenSize.width, screenSize.height);
            BufferedImage screenFullImage = robot.createScreenCapture(screenRect);

            relativePath = "./screenshots/" + className + "_" + timestamp + ".png";
            File dest = new File(System.getProperty("user.dir") + "/screenshots/" + className + "_" + timestamp + ".png");
            ImageIO.write(screenFullImage, "png", dest);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return relativePath;
    }

    public void acceptAlert() {
        driver.findElement(acceptButton).click();
    }
}