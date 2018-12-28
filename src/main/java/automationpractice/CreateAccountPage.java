package automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccountPage {

    private WebDriver driver;

    private By maleGenderRadiobutton = By.id("id_gender1");
    private By femaleGenderRadiobutton = By.id("id_gender2");
    private By firstNameField = By.id("customer_firstname");
    private By lastNameField = By.id("customer_lastname");
    private By passwordField = By.id("passwd");
    private By addressFirstNameField = By.id("firstname");
    private By addressLastNameField = By.id("lastname");
    private By addressField = By.id("address1");
    private By cityField = By.id("city");
    private By stateField = By.xpath("//select[@id = 'id_state']");
    private By stateValue = By.xpath("//option[contains(text(), 'Alaska')]");
    private By postCodeField = By.id("postcode");
    private By mobilePhoneField = By.id("phone_mobile");
    private By addressAliasField = By.id("alias");
    private By registerButton = By.id("submitAccount");


    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void chooseFemaleGender() {
        driver.findElement(femaleGenderRadiobutton).click();
    }

    public void chooseMaleGender() {
        driver.findElement(maleGenderRadiobutton).click();
    }

    public void typeFirstName(String first_name) {
        driver.findElement(firstNameField).sendKeys(first_name);
    }

    public void typeLastName(String last_name) {
        driver.findElement(lastNameField).sendKeys(last_name);
    }

    public void typePassword(String pass) {
        driver.findElement(passwordField).sendKeys(pass);
    }

    public void typeAddressFirstName(String addressFirst) {
        WebElement element = driver.findElement(addressFirstNameField);
        element.clear();
        element.sendKeys(addressFirst);
    }

    public void typeAddressLastName(String addressLast) {
        WebElement element = driver.findElement(addressLastNameField);
        element.clear();
        element.sendKeys(addressLast);
    }

    public void typeAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    public void typeCityName(String city) {
        driver.findElement(cityField).sendKeys(city);
    }

    public void chooseState() {
        driver.findElement(stateField).click();
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(stateValue));
        driver.findElement(stateValue).click();
    }

    public void typePostCode(String postCode) {
        driver.findElement(postCodeField).sendKeys(postCode);
    }

    public void typeMobilePhone(String mobilePhone) {
        driver.findElement(mobilePhoneField).sendKeys(mobilePhone);
    }

    public void typeAddressAlias(String alias) {
        driver.findElement(addressAliasField).sendKeys(alias);
    }

    public void pressRegisterButton() {
        driver.findElement(registerButton).click();
    }
}
