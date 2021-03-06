package automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

public class CategoryPage {

    public WebDriver driver;
    public By blouseItem = By.xpath("//div[@class = 'product-container']");
    public By addToCartButton = By.xpath("//div[@class = 'button-container']/a[@title = 'Add to cart']");
    public By proceedToCheckout = By.xpath("//*[@id='layer_cart']//a[@title='Proceed to checkout']");
    //public By proceedToCheckout = By.xpath("//a[@title='Proceed to checkout']");
    public By tshortItem = By.xpath("//a[contains(text(), 'T-shirts')]");

    public CategoryPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Проверить наличие элемента 'T-short'")
    public By getTshortItem() {
        return tshortItem;
    }
    @Step("Проверить наличие элемента 'Blouse'")
    public By getBlouseItem() {
        return blouseItem;
    }

    @Step("Нажать на кнопку 'Add to cart'")
    public void pressAddToCartButton() {
        driver.findElement(addToCartButton).click();
    }
    @Step("Нажать на кнопку 'Proceed to checkout'")
    public void pressProceedToCheckout() {
        WebDriverWait wait = (new WebDriverWait(driver, 15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(proceedToCheckout));
        driver.findElement(proceedToCheckout).click();
    }

}
