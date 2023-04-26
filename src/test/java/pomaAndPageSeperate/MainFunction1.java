package pomaAndPageSeperate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LogOutPage;
import pageObjects.LoginPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class MainFunction1 {
static WebDriver driver;
static String  URL,Driver,path;
@BeforeTest
    public void settingBrowser() throws IOException {

    FileInputStream fileInputStream=new FileInputStream("src/test/java/modularFramework/config.properties");
    Properties properties=new Properties();
    properties.load(fileInputStream);
         Driver=properties.getProperty("chromedriver");
         path=properties.getProperty("chromepath");
    URL=properties.getProperty("urlof");
    System.out.println();
    System.out.println(URL+""+path);

        //setting up web browser
        System.setProperty(Driver,path);
        driver = new ChromeDriver();

        //To maximize window size
        driver.manage().window().maximize();

        //Launching web browser
        driver.get("https://ultimateqa.com/automation");


    }
@Test
    public void homePageScript() {

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    PageFactory.initElements(driver, HomePage.class);
    HomePage1.loginAutomation();
    PageFactory.initElements(driver, LoginPage.class);
    LoginPage1.login();
    PageFactory.initElements(driver, LogOutPage.class);
    LogOutPage1.setSignOut();
    }

@AfterTest()
    public void closingWebdriver()
{
    driver.close();
}
}