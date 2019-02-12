package automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import ru.yandex.qatools.allure.annotations.Step;

public class MainPage {

    public WebDriver driver;
    public By contactUsLink = By.linkText("Contact us");
    public By signInLink = By.linkText("Sign in");
    public By searchField = By.id("search_query_top");
    public By searchButton = By.name("submit_search");
    public By womenCategory = By.xpath("//a[@title = 'Women']");
    public By tshirtsCategory = By.xpath("//a[@title = 'T-shirts']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getTshirtsCategory() {
        return tshirtsCategory;
    }

    @Step("Нажать 'Sign in'")
    public void clickSignIn() {
        driver.findElement(signInLink).click();
    }

    @Step("Нажать 'Contact us'")
    public void clickContactUs() {
        driver.findElement(contactUsLink).click();
    }

    @Step("Очистить и ввести значение в поле поиска")
    public void fillInSearchField(String value) {
        WebElement element = driver.findElement(searchField);
        element.clear();
        element.sendKeys(value);
    }

    @Step("Нажать кнопку 'Search'")
    public void pressSearchButton() {
        driver.findElement(searchButton).click();
    }

    @Step("Навести курсор на категорию 'Women'")
    public void moveToWomenCategory() {
        WebElement category = driver.findElement(womenCategory);
        Actions actions = new Actions(driver);
        actions.moveToElement(category).build().perform();
    }

    @Step("Нажать на категорию 'T-shirts'")
    public void clickOnTshirtsCategory() {
        driver.findElement(tshirtsCategory).click();
    }
}

