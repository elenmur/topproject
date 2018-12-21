package automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By contactUsLink = By.linkText("Contact us");
    private By signInLink = By.linkText("Sign in");


    public void clickContactUs() {
        driver.findElement(contactUsLink).click();
    }


    //public clickSignIn() {
     //   driver.findElement(signInLink).click();
    //    return new AuthenticationPage(driver);
   // }
}

