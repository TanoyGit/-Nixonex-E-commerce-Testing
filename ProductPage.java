package Pages;

import org.openqa.selenium.*;
import java.awt.Rectangle;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;

import static org.apache.commons.io.FileUtils.waitFor;

public class ProductPage {
    private final WebDriver driver;
    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }
    private final By laptopCategory = By.linkText("Laptops");
    private final By product = By.linkText("MacBook Pro");
    private final By productTitle = By.xpath("//h2[@class='name']");
    private final By productPrice = By.xpath("//h3[@class='price-container']");
    private final By addToCartButton = By.linkText("Add to cart");

    public void clickLaptopCategory(){
        driver.findElement(laptopCategory).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Boolean chooseProduct() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        if (!driver.findElements(product).isEmpty()) {
            driver.findElement(product).click();
            return true;
        }
        return false;
    }


    public String getProductTitle(){
        String productName = driver.findElement(productTitle).getText();
        return productName;
    }

    public String getProductPrice(){
        String productCost = driver.findElement(productPrice).getText();
        return productCost;
    }

    public void addToCart(){
        driver.findElement(addToCartButton).click();
        try {
            Thread.sleep(3000);
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

    public void acceptTheAlert(){
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}