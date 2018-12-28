package automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private WebDriver driver;
    private By blouseInShoppingCart = By.xpath("//p[@class = 'product-name']/a[1]");
    private By deleteButton = By.xpath("//a[@id='2_7_0_0']/i");
    private By alert = By.xpath("//p[contains(@class,'alert-warning')]");
    private By proceedToCheckout = By.xpath("//a[@title = 'Proceed to checkout']");

    public CartPage(WebDriver driver) {

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
