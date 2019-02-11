package automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

public class AuthenticationPage {

    public WebDriver driver;
    public By createEmailField = By.id("email_create");
    public By createAnAccountButton = By.id("SubmitCreate");

    public AuthenticationPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step ("Ввести в поле ввода e-mail")
    public void typeEmailAddress(String mail) {
        driver.findElement(createEmailField).sendKeys(mail);
    }
    @Step ("Нажать кнопку 'Create account'")
    public void pressCreateAnAccountButton() {
        driver.findElement(createAnAccountButton).click();
    }
}
