package automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

public class ContactUsPage {

    public WebDriver driver;
    public By subjectHeading = By.xpath("//select[@id = 'id_contact']");
    public By subjectHeadingValue = By.xpath("//option[contains(text(), 'Customer service')]");
    public By emailAddressField = By.id("email");
    public By orderReferenceField = By.id("id_order");
    public By attachFileField = By.xpath("//input[@type='file']");
    public By messageField = By.id("message");
    public By sendButton = By.id("submitMessage");
    public By successMessage = By.xpath("//p[contains(@class,'alert-success')]");
    public By errorMessage = By.xpath("//div[contains(@class,'alert-danger')]");

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Выбрать опцию 'Customer service'")
    public void chooseSubjectHeading() {
        driver.findElement(subjectHeading).click();
        driver.findElement(subjectHeadingValue).click();
    }

    @Step("Ввести e-mail в поле ввода")
    public void typeEmailAddress(String email) {
        driver.findElement(emailAddressField).sendKeys(email);
    }

    @Step("Ввести id order")
    public void typeOrderReference(String value) {
        driver.findElement(orderReferenceField).sendKeys(value);
    }

    @Step("Загрузить файл")
    public void addAttachFile(String value) {
        driver.findElement(attachFileField).sendKeys(value);
    }

    @Step("Написать сообщение")
    public void typeMessage(String value) {
        driver.findElement(messageField).sendKeys(value);
    }

    @Step("Нажать кнопку 'Отправить'")
    public void pressSendButton() {
        driver.findElement(sendButton).click();
    }

    @Step("Проверить наличие сообщения об успехе")
    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }

    @Step("Проверить наличие сообщения об ошибке")
    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}






