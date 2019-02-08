package automationpractice.appmanager;

import automationpractice.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    public FirefoxDriver driver;

    public ContactUsPage contactUsPage;
    public MainPage mainPage;
    public AuthenticationPage authenticationPage;
    public CreateAccountPage createAccountPage;
    public CategoryPage categoryPage;
    public CartPage cartPage;


    public void init() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\OO\\IdeaProjects\\testselenium\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
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

