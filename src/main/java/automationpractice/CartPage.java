package automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

public class CartPage {

    public By blouseInShoppingCart = By.xpath("//p[@class = 'product-name']/a[1]");
    public By deleteButton = By.xpath("//div/a[@class='cart_quantity_delete'/i");
    public By alert = By.xpath("//p[contains(@class,'alert-warning')]");
    public WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Проверить отображение категории 'Blouse' в корзине")
    public By getBlouseInShoppingCart() {
        return blouseInShoppingCart;
    }
    @Step("Проверить отображение аллерта")
    public String getAlert() {
        return driver.findElement(alert).getText();
    }
    @Step ("Нажать на кнопку 'Delete'")
    public void clickDeleteButton() {
        driver.findElement(deleteButton).click();
    }
}
