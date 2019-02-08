package automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

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

    public void clickSignIn() {
        driver.findElement(signInLink).click();
    }

    public void clickContactUs() {
        driver.findElement(contactUsLink).click();
    }

    public void fillInSearchField(String value) {
        driver.findElement(searchField).sendKeys(value);
    }

    public void pressSearchButton() {
        driver.findElement(searchButton).click();
    }

    public void moveToWomenCategory() {
        WebElement category = driver.findElement(womenCategory);
        Actions actions = new Actions(driver);
        actions.moveToElement(category).build().perform();
    }

    public void clickOnTshirtsCategory() {
        driver.findElement(tshirtsCategory).click();
    }
}

