package automationpractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class TestCase1 {

    private WebDriver driver;
    private ContactUsPage contactUsPage;
    private MainPage mainPage;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\OO\\IdeaProjects\\testselenium\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");
        mainPage = new MainPage(driver);
        contactUsPage = new ContactUsPage(driver);
    }

    @Test
    public void testCase1() {
        mainPage.clickContactUs();
        contactUsPage.chooseSubjectHeading();
        contactUsPage.typeEmailAddress("email@mail.ru");
        contactUsPage.typeOrderReference("order");
        contactUsPage.addAttachFile("C:\\Users\\OO\\Documents\\GitHub\\testartid\\testFile\\CV.docx");
        contactUsPage.typeMessage("message");
        contactUsPage.pressSendButton();
        String successMessage = contactUsPage.getSuccessMessage();
        assertEquals("Your message has been successfully sent to our team.", successMessage);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}




