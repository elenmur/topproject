package automationpractice.appmanager;


import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.lang.reflect.Method;

@Listeners (MyTestListener.class)
public class TestBase {

    public static ApplicationManager app
            = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeSuite
    public void setUp(ITestContext context)  {
        app.init();
        context.setAttribute("app", app);
    }

    @AfterSuite (alwaysRun = true)
    public void tearDown() {
        app.stop();
    }

    @BeforeMethod
    public void logTestStart (Method m) {
        logger.info("Start test " + m.getName());
    }

    @AfterMethod (alwaysRun = true)
    public void logTestStop (Method m) {
        logger.info("Stop test " + m.getName());
    }
}
