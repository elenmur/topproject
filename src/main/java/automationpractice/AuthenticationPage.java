package automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthenticationPage {

    private WebDriver driver;

    private By createEmailField = By.id("email_create");
    private By createAnAccountButton = By.id("SubmitCreate");

    public AuthenticationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void typeEmailAddress(String mail) {
        driver.findElement(createEmailField).sendKeys(mail);
    }

    public void pressCreateAnAccountButton() {
        driver.findElement(createAnAccountButton).click();
    }
}
