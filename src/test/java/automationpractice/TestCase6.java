package automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class TestCase6 {

    private WebDriver driver;
    private MainPage mainPage;
    private CategoryPage categoryPage;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\OO\\IdeaProjects\\testselenium\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");
        mainPage = new MainPage(driver);
        categoryPage = new CategoryPage(driver);
    }

    @Test
    public void testCase6() {
        mainPage.moveToWomenCategory();
        WebDriverWait wait = (new WebDriverWait(driver, 15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(mainPage.getTshirtsCategory()));
        mainPage.clickOnTshirtsCategory();
        assertTrue(isElementPresent(categoryPage.getTshortItem()));
    }

    protected boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
