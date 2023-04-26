package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class MainFunction {
static WebDriver driver;
@BeforeTest
    public void settingBrowser() {
        //setting up web browser
        System.setProperty("web driver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();

        //To maximize window size
        driver.manage().window().maximize();

        //Launching web browser
        driver.get("https://ultimateqa.com/automation");


    }
@Test
    public void executionScript()  {

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
       HomePage homePage=new HomePage(driver);
       homePage.loginAutomation();
       LoginPage loginPage=new LoginPage(driver);
       loginPage.login();
       LogOutPage logOutPage=new LogOutPage(driver);
       logOutPage.setSignOut();
    }

@AfterTest
    public void closingWebdriver()
{
    driver.close();
}
}