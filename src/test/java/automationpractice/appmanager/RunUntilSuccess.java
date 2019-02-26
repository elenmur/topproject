package automationpractice.appmanager;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RunUntilSuccess implements IRetryAnalyzer {

    @Override
    public boolean retry(ITestResult result){
        return ! result.isSuccess();
    }
}
