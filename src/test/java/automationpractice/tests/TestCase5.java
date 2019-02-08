package automationpractice.tests;

import automationpractice.appmanager.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class TestCase5 extends TestBase {

    @Test
    public void testCase5()

    {
        app.mainPage.fillInSearchField("Blouse");
        app.mainPage.pressSearchButton();
        WebElement item = app.driver.findElement(app.categoryPage.getBlouseItem());
        Actions actions = new Actions(app.driver);
        actions.moveToElement(item).build().perform();
        app.categoryPage.pressAddToCartButton();
        app.categoryPage.pressProceedToCheckout();
        assertTrue(isElementPresent(app.cartPage.getBlouseInShoppingCart()));
        app.cartPage.clickDeleteButton();
        WebDriverWait wait = (new WebDriverWait(app.driver, 5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(@class,'alert-warning')]")));
        assertTrue(app.cartPage.getAlert().contains("Your shopping cart is empty."));
    }

    protected boolean isElementPresent(By by) {
        try {
            app.driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}


