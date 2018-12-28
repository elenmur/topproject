package automationpractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static automationpractice.RandomEmail.createRandomEmail;
import static org.testng.AssertJUnit.assertEquals;

public class TestCase3 {

    private WebDriver driver;
    private MainPage mainPage;
    private AuthenticationPage authenticationPage;
    private CreateAccountPage createAccountPage;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\OO\\IdeaProjects\\testselenium\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");
        mainPage = new MainPage(driver);
        authenticationPage = new AuthenticationPage(driver);
        createAccountPage = new CreateAccountPage(driver);
    }

    @Test
    public void testCase3() {
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

        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }

        String myAccountPage = driver.getCurrentUrl();
        assertEquals("http://automationpractice.com/index.php?controller=my-account", myAccountPage);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}

