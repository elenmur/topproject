package automationpractice.tests;

import automationpractice.appmanager.TestBase;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class TestCase2 extends TestBase {


    @Test
    public void testCase2() {
        app.mainPage.clickContactUs();
        app.contactUsPage.chooseSubjectHeading();
        app.contactUsPage.typeEmailAddress("email@mail.ru");
        app.contactUsPage.typeOrderReference("order");
        app.contactUsPage.addAttachFile("C:\\Users\\OO\\Documents\\GitHub\\testartid\\testFile\\CV.docx");
        app.contactUsPage.pressSendButton();

        assertTrue(app.contactUsPage.getErrorMessage().contains("The message cannot be blank."), "Messages should be equals");
    }
}

