package testngVerify;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestNGVerification extends TestNGverifyBase {

    WebDriver driver;

    @BeforeMethod
    public  void gettingStarted ()
    {
       driver=initiation();

        //To maximize window size
        driver.manage().window().maximize();
        //Launching web browser
        driver.get("https://practicetestautomation.com/practice-test-login/");     //implicit wait to load web elemnets and to maintain synchronization
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));



    }
@Test
    public  void verifyLoginHArtAssert()
    {

        login(driver);
        try{
            verifyURLHardAssert(driver);
        }
        catch (Exception e)
        {
        System.out.println("Message matches not found");

        }
    }

    @Test
    public  void verifyLoginSoftAssert()
    {
        login(driver);
        verifyURLSoftAssert(this.driver);
    }

    @AfterMethod
    public void teardown()
    {
        driver.close();
    }

}
