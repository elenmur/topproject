package automationpractice.tests;

import automationpractice.appmanager.RunUntilSuccess;
import automationpractice.appmanager.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class TestCase6 extends TestBase {

    @Test (retryAnalyzer = RunUntilSuccess.class)
    public void testCase6() {
        app.mainPage.moveToWomenCategory();
        WebDriverWait wait = (new WebDriverWait(app.driver, 3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(app.mainPage.getTshirtsCategory()));
        app.mainPage.clickOnTshirtsCategory();
        assertTrue(isElementPresent(app.categoryPage.getTshortItem()));
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
