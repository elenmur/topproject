package automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CartPage {

    public By blouseInShoppingCart = By.xpath("//p[@class = 'product-name']/a[1]");
    public By deleteButton = By.xpath("//a[@id='2_7_0_0']/i");
    public By alert = By.xpath("//p[contains(@class,'alert-warning')]");
    public FirefoxDriver driver;

    public CartPage(FirefoxDriver driver) {
        this.driver = driver;
    }

    public By getBlouseInShoppingCart() {
        return blouseInShoppingCart;
    }

    public String getAlert() {
        return driver.findElement(alert).getText();
    }

    public void clickDeleteButton() {
        driver.findElement(deleteButton).click();
    }
}
