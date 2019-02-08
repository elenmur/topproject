package automationpractice.tests;

import automationpractice.appmanager.TestBase;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class TestCase1 extends TestBase {

    @Test
    public void testCase1() {
        app.mainPage.clickContactUs();
        app.contactUsPage.chooseSubjectHeading();
        app.contactUsPage.typeEmailAddress("email@mail.ru");
        app.contactUsPage.typeOrderReference("order");
        app.contactUsPage.addAttachFile("C:\\Users\\OO\\Documents\\GitHub\\testartid\\src\\main\\resources\\CV.docx");
        app.contactUsPage.typeMessage("message");
        app.contactUsPage.pressSendButton();
        String successMessage = app.contactUsPage.getSuccessMessage();
        assertEquals("Your message has been successfully sent to our team.", successMessage);
    }
}




