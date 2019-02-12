package automationpractice.appmanager;

import automationpractice.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    public WebDriver driver;
    public ContactUsPage contactUsPage;
    public MainPage mainPage;
    public AuthenticationPage authenticationPage;
    public CreateAccountPage createAccountPage;
    public CategoryPage categoryPage;
    public CartPage cartPage;
    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {

        switch (browser) {
            case BrowserType.FIREFOX:
                driver = new FirefoxDriver();
                break;
            case BrowserType.CHROME:
                driver = new ChromeDriver();
                break;
            case BrowserType.IE:
                driver = new InternetExplorerDriver();
                break;
        }

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");
        mainPage = new MainPage(driver);
        contactUsPage = new ContactUsPage(driver);
        createAccountPage = new CreateAccountPage(driver);
        authenticationPage = new AuthenticationPage(driver);
        categoryPage = new CategoryPage(driver);
        cartPage = new CartPage(driver);

    }

    public void stop() {
        driver.quit();
    }
}

