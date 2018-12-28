package automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage {

    private WebDriver driver;
    private By subjectHeading = By.xpath("//select[@id = 'id_contact']");
    private By subjectHeadingValue = By.xpath("//option[contains(text(), 'Customer service')]");
    private By emailAddressField = By.id("email");
    private By orderReferenceField = By.id("id_order");
    private By attachFileField = By.xpath("//input[@type='file']");
    private By messageField = By.id("message");
    private By sendButton = By.id("submitMessage");
    private By successMessage = By.xpath("//p[contains(@class,'alert-success')]");
    private By errorMessage = By.xpath("//div[contains(@class,'alert-danger')]");

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }

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






