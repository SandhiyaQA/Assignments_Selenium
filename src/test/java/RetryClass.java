import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryClass implements IRetryAnalyzer {

    int limit=5;
    int failureCount=0;
    @Override
    public boolean retry(ITestResult iTestResult) {

     if(failureCount<limit)   {
        failureCount++;
        return true;
    }
     return false;
}
}
