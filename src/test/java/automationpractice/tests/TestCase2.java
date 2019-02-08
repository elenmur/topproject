package automationpractice.tests;

import automationpractice.appmanager.TestBase;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URISyntaxException;

import static org.testng.Assert.assertTrue;

public class TestCase2 extends TestBase {


    @Test
    public void testCase2() throws URISyntaxException {
        app.mainPage.clickContactUs();
        app.contactUsPage.chooseSubjectHeading();
        app.contactUsPage.typeEmailAddress("email@mail.ru");
        app.contactUsPage.typeOrderReference("order");
        app.contactUsPage.addAttachFile(getFile());
        app.contactUsPage.pressSendButton();

        assertTrue(app.contactUsPage.getErrorMessage().contains("The message cannot be blank."), "Messages should be equals");
    }
        private String getFile () throws URISyntaxException {
            File file = new File(TestCase2.class.getClassLoader().getResource("CV.docx").toURI());
            return file.getAbsolutePath();
        }
    }

