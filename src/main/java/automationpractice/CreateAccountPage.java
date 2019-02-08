package automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountPage {

    public WebDriver driver;

    public By femaleGenderRadiobutton = By.id("id_gender2");
    public By firstNameField = By.id("customer_firstname");
    public By lastNameField = By.id("customer_lastname");
    public By passwordField = By.id("passwd");
    public By addressFirstNameField = By.id("firstname");
    public By addressLastNameField = By.id("lastname");
    public By addressField = By.id("address1");
    public By cityField = By.id("city");
    public By postCodeField = By.id("postcode");
    public By mobilePhoneField = By.id("phone_mobile");
    public By addressAliasField = By.id("alias");
    public By registerButton = By.id("submitAccount");


    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void chooseFemaleGender() {
        driver.findElement(femaleGenderRadiobutton).click();
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
        new Select(driver.findElement(By.id("id_state"))).selectByVisibleText("Alaska");
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
