package automationpractice.tests;

import automationpractice.appmanager.TestBase;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URISyntaxException;

import static org.testng.Assert.assertEquals;

public class TestCase1 extends TestBase {

    @Test
    public void testCase1() throws URISyntaxException {
        app.mainPage.clickContactUs();
        app.contactUsPage.chooseSubjectHeading();
        app.contactUsPage.typeEmailAddress("email@mail.ru");
        app.contactUsPage.typeOrderReference("order");
        app.contactUsPage.addAttachFile(getFile());
        app.contactUsPage.typeMessage("message");
        app.contactUsPage.pressSendButton();
        String successMessage = app.contactUsPage.getSuccessMessage();
        assertEquals("Your message has been successfully sent to our team.", successMessage);
    }

    private String getFile() throws URISyntaxException {
        File file = new File(TestCase1.class.getClassLoader().getResource("CV.docx").toURI());
        return file.getAbsolutePath();
    }
}




