import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    /* Start Test Case Login Page*/
    By loginButton = By.id("login2");
    By email = By.id("loginusername");
    By password = By.id("loginpassword");
    By loginButtonForm = By.xpath("//button[contains(text(),'Log in')]");
    /* End Test Case Login Page*/


    /*Start Test Case Navigate to Category List*/
    By category = By.xpath("//a[contains(text(),'Laptops')]");
    By product = By.linkText("MacBook Pro");

    /*End Test Case Navigate to Category List*/

    public HomePage (WebDriver driver)
    {
        this.driver = driver;
    }

    /* Start Test Case Login Page*/
    public void ClickOnLoginButton (){driver.findElement(loginButton).click();}
    public void EnterEmail (String E) {driver.findElement(email).sendKeys(E);} // Shortcut Email -> E
    public void EnterPassword (String P) {driver.findElement(password).sendKeys(P);} // Shortcut Password -> P
    public void ClickOnLoginButtonForm (){driver.findElement(loginButtonForm).click();}
    /* End Test Case Login Page*/


    /*Start Test Case Navigate to Category List*/
    public void ClickOnCategory(){driver.findElement(category).click();}
    public ProductDetaildPage ClickOnProduct ()
    {
        driver.findElement(product).click();
        return new ProductDetaildPage(driver);
    }
    /*End Test Case Navigate to Category List*/



}
