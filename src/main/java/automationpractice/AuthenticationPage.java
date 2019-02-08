package automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AuthenticationPage {

    public FirefoxDriver driver;
    public By createEmailField = By.id("email_create");
    public By createAnAccountButton = By.id("SubmitCreate");

    public AuthenticationPage(FirefoxDriver driver) {
        this.driver = driver;
    }

    public void typeEmailAddress(String mail) {
        driver.findElement(createEmailField).sendKeys(mail);
    }

    public void pressCreateAnAccountButton() {
        driver.findElement(createAnAccountButton).click();
    }
}
