package Tests;

import Base.BaseClass;
import Pages.ProductPage;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseClass {
    ProductPage productPage = new ProductPage(BaseClass.getDriver());

    @BeforeMethod
    public void startTest() {
        test = extent.createTest("Add To Cart Feature");
    }

    @Test
    public void addProductToTheCart() {
        productPage.clickLaptopCategory();

        if (!productPage.chooseProduct()) {
            String screenshotPath = productPage.takeScreenshot();
            test.fail("Product not found in any category.",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            Assert.fail("Product not found in any category.");
        }

        System.out.println("The product name is " + productPage.getProductTitle());
        System.out.println("The product cost is " + productPage.getProductPrice());

        productPage.addToCart();
        String screenshotPath = productPage.takeScreenshot();
        productPage.acceptTheAlert();

        test.pass("Product added to the cart successfully", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }
}