package automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver driver;
    private By contactUsLink = By.linkText("Contact us");
    private By signInLink = By.linkText("Sign in");
    private By searchField = By.id("search_query_top");
    private By searchButton = By.name("submit_search");

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
}

