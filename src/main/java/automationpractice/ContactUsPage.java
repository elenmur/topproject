package automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.qatools.allure.annotations.Step;

public class ContactUsPage {

    public FirefoxDriver driver;
    public By subjectHeading = By.xpath("//select[@id = 'id_contact']");
    public By subjectHeadingValue = By.xpath("//option[contains(text(), 'Customer service')]");
    public By emailAddressField = By.id("email");
    public By orderReferenceField = By.id("id_order");
    public By attachFileField = By.xpath("//input[@type='file']");
    public By messageField = By.id("message");
    public By sendButton = By.id("submitMessage");
    public By successMessage = By.xpath("//p[contains(@class,'alert-success')]");
    public By errorMessage = By.xpath("//div[contains(@class,'alert-danger')]");

    public ContactUsPage(FirefoxDriver driver) {
        this.driver = driver;
    }

    @Step ("выбрать Customer service")
    public void chooseSubjectHeading() {
        driver.findElement(subjectHeading).click();
        driver.findElement(subjectHeadingValue).click();
    }

    public void typeEmailAddress(String email) {
        driver.findElement(emailAddressField).sendKeys(email);
    }

    public void typeOrderReference(String value) {
        driver.findElement(orderReferenceField).sendKeys(value);
    }

    public void addAttachFile(String value) {
        driver.findElement(attachFileField).sendKeys(value);
    }

    public void typeMessage(String value) {
        driver.findElement(messageField).sendKeys(value);
    }

    public void pressSendButton() {
        driver.findElement(sendButton).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}






