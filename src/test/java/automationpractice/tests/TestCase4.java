package automationpractice.tests;

import automationpractice.appmanager.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class TestCase4 extends TestBase {

    @Test
    public void testCase4() {

        app.mainPage.fillInSearchField("Blouse");
        app.mainPage.pressSearchButton();
        assertTrue(isElementPresent(app.categoryPage.getBlouseItem()));
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

