package automationpractice.tests;

import automationpractice.appmanager.TestBase;
import org.testng.annotations.Test;
import static automationpractice.RandomEmail.createRandomEmail;
import static org.testng.AssertJUnit.assertEquals;

public class TestCase3 extends TestBase {

    @Test
    public void testCase3() {
        app.mainPage.clickSignIn();
        app.authenticationPage.typeEmailAddress(createRandomEmail());
        app.authenticationPage.pressCreateAnAccountButton();
        app.createAccountPage.chooseFemaleGender();
        app.createAccountPage.typeFirstName("Elen");
        app.createAccountPage.typeLastName("Murashkina");
        app.createAccountPage.typePassword("zxcvbnm");
        app.createAccountPage.typeAddressFirstName("NY");
        app.createAccountPage.typeAddressLastName("NY");
        app.createAccountPage.typeAddress("NY");
        app.createAccountPage.typeCityName("NY");
        app.createAccountPage.chooseState();
        app.createAccountPage.typePostCode("10001");
        app.createAccountPage.typeMobilePhone("123456789");
        app.createAccountPage.typeAddressAlias("alias");
        app.createAccountPage.pressRegisterButton();

        for (String windowHandle : app.driver.getWindowHandles()) {
            app.driver.switchTo().window(windowHandle);
        }
        String myAccountPage = app.driver.getCurrentUrl();
        assertEquals("http://automationpractice.com/index.php?controller=my-account", myAccountPage);
    }
}

