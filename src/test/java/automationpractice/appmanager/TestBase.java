package automationpractice.appmanager;


import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;

@Listeners(MyTestListener.class)
public class TestBase {


    public static final ApplicationManager app
            = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));
    /*Logger logger = LoggerFactory.getLogger(TestBase.class);*/


    @BeforeMethod
    public void setUp(ITestContext context) throws IOException {
        app.init();
       /* context.setAttribute("app", app);*/
       // app.driver.manage().logs().get("driver");
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown(/*Method m*/) throws IOException {
       /* LogEntries logEntries = app.driver.manage().logs().get("driver");
        File driverLog = new File(m.getName() + ".log");
        FileWriter out = new FileWriter(driverLog);
        for (LogEntry logEntry : logEntries.getAll()) {
            out.write(logEntry.toString() + "\n");
        }
        out.close();*/
        app.stop();
    }

   /* @BeforeMethod
    public void logTestStart(Method m) {
        logger.info("Start test " + m.getName());
    }

    @AfterMethod(alwaysRun = true)
    public void logTestStop(Method m) {
        logger.info("Stop test " + m.getName());
    }*/
}
