package pageFactoryAndPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LogOutPage;
import pageObjects.LoginPage;

import java.time.Duration;

public class MainFunction3 {
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
    public void executionScript() throws InterruptedException {

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        PageFactory.initElements(driver, HomePage.class);
        HomePage3.loginAutomation();

                PageFactory.initElements(driver, LoginPage.class);
        LoginPage3.login();
               PageFactory.initElements(driver, LogOutPage.class);
        LogOutPage3.setSignOut();
    }

@AfterTest
    public void closingWebdriver()
{
    driver.close();
}
}