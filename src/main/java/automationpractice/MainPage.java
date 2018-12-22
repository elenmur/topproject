package automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver driver;
    private By contactUsLink = By.linkText("Contact us");
    private By signInLink = By.linkText("Sign in");
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSignIn() {
        driver.findElement(signInLink).click();
           }

    public void clickContactUs() {
        driver.findElement(contactUsLink).click();
    }
}

