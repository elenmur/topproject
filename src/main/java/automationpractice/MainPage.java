package automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MainPage {

    private WebDriver driver;
    private By contactUsLink = By.linkText("Contact us");
    private By signInLink = By.linkText("Sign in");
    private By searchField = By.id("search_query_top");
    private By searchButton = By.name("submit_search");
    private By womenCategory = By.xpath("//a[@title = 'Women']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
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
}

