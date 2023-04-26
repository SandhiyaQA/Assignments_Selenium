package testNgDependendant;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Dependency {
    WebDriver driver;
    @BeforeSuite
    public void setup() {
        //setting up web browser
        System.setProperty("web driver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");

         driver = new ChromeDriver(option);

        //To maximize window size
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void goToWebsite()
    {

        //Launching web browser
        driver.get("https://www.facebook.com/");     //implicit wait to load web elemnets and to maintain synchronization
    }

    @Test(priority = 2,dependsOnMethods = "goToWebsite")
    @Parameters({"username","password"})
    public void login(String username,String password) {
        //finding web elements of username and password field and performing mouse click
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@name='login']")).click();

    }

    @AfterSuite
    public void closing()
    {
        driver.close();
    }

}
