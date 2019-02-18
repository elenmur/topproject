package automationpractice.appmanager;

import automationpractice.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public abstract class ApplicationManager {

    public WebDriver driver;
    private final Properties properties;
    public ContactUsPage contactUsPage;
    public MainPage mainPage;
    public AuthenticationPage authenticationPage;
    public CreateAccountPage createAccountPage;
    public CategoryPage categoryPage;
    public CartPage cartPage;
    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
        properties =new Properties();
    }

    public void init() throws MalformedURLException {
        if ("".equals(properties.getProperty("selenium.server"))) {
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
        } else {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName(browser);
            driver = new RemoteWebDriver(new URL(properties.getProperty("selenium.server")), capabilities);
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

    public byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}

