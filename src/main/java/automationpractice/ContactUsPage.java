package automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage {

    private WebDriver driver;
    private By subjectHeading = By.id("id_contact");
    private By emailAddressField = By.id("email");
    private By orderReferenceField = By.id("id_order");
    private By attachFileField = By.xpath("//input[@type='file']");
    private By messageField = By.id("message");
    private By sendButton = By.id("submitMessage");
    private By successMessage = By.xpath("/html/body/div/div[2]/div/div[3]/div/p");
    private By errorMessage = By.xpath("/html/body/div/div[2]/div/div[3]/div/div/ol/li");
    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void chooseSubjectHeading() {
        driver.findElement(subjectHeading).click();
        new Select(driver.findElement(subjectHeading)).selectByVisibleText("Customer service");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Customer service'])[1]/following::option[2]")).click();
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

    public By getSuccessMessage() {
        return successMessage;
    }

    public By getErrorMessage() {
        return errorMessage;
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }


}
