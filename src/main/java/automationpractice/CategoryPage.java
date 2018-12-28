package automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoryPage {

    private WebDriver driver;
    private By blouseItem = By.xpath("//div[@class = 'product-container']");
    private By addToCartButton = By.xpath("//div[@class = 'button-container']/a[@title = 'Add to cart']");
    private By proceedToCheckout = By.xpath("//a[@title='Proceed to checkout']");


    public CategoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getBlouseItem() {
        return blouseItem;
    }

    public void pressAddToCartButton() {
        driver.findElement(addToCartButton).click();
    }

    public void pressProceedToCheckout()
    {
        WebDriverWait wait = (new WebDriverWait(driver, 5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(proceedToCheckout));
        driver.findElement(proceedToCheckout).click();
    }

}
