package automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class TestCase5 {
    private WebDriver driver;
    private CategoryPage categoryPage;
    private MainPage mainPage;
    private CartPage cartPage;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\OO\\IdeaProjects\\testselenium\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");
        categoryPage = new CategoryPage(driver);
        mainPage = new MainPage(driver);
        cartPage = new CartPage(driver);
    }

    @Test
    public void TestCase5()

    {
        mainPage.fillInSearchField("Blouse");
        mainPage.pressSearchButton();
        WebElement item = driver.findElement(categoryPage.getBlouseItem());
        Actions actions = new Actions(driver);
        actions.moveToElement(item).build().perform();
        categoryPage.pressAddToCartButton();
        categoryPage.pressProceedToCheckout();
        assertTrue(isElementPresent(cartPage.getBlouseInShoppingCart()));
        cartPage.clickDeleteButton();
        WebDriverWait wait = (new WebDriverWait(driver, 5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(@class,'alert-warning')]")));
        assertTrue(cartPage.getAlert().contains("Your shopping cart is empty."));
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


