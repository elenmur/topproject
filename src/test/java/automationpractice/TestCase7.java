package automationpractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static automationpractice.RandomEmail.createRandomEmail;

public class TestCase7 {

    private WebDriver driver;
    private MainPage mainPage;
    private AuthenticationPage authenticationPage;
    private CreateAccountPage createAccountPage;
    private CategoryPage categoryPage;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\OO\\IdeaProjects\\testselenium\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");
        mainPage = new MainPage(driver);
        authenticationPage = new AuthenticationPage(driver);
        createAccountPage = new CreateAccountPage(driver);
        categoryPage = new CategoryPage(driver);
    }

    @Test
    public void testCase7() {
        mainPage.clickSignIn();
        authenticationPage.typeEmailAddress(createRandomEmail());
        authenticationPage.pressCreateAnAccountButton();
        createAccountPage.chooseFemaleGender();
        createAccountPage.typeFirstName("Elen");
        createAccountPage.typeLastName("Murashkina");
        createAccountPage.typePassword("zxcvbnm");
        createAccountPage.typeAddressFirstName("NY");
        createAccountPage.typeAddressLastName("NY");
        createAccountPage.typeAddress("NY");
        createAccountPage.typeCityName("NY");
        createAccountPage.chooseState();
        createAccountPage.typePostCode("10001");
        createAccountPage.typeMobilePhone("123456789");
        createAccountPage.typeAddressAlias("alias");
        createAccountPage.pressRegisterButton();
        mainPage.fillInSearchField("Blouse");
        mainPage.pressSearchButton();
        WebElement item = driver.findElement(categoryPage.getBlouseItem());
        Actions actions = new Actions(driver);
        actions.moveToElement(item).build().perform();
        categoryPage.pressAddToCartButton();
        categoryPage.pressProceedToCheckout();

    }
}
