import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class facebooklogin {

    WebDriver driver;
@BeforeTest
    public void setup()
    {
        //setting up web browser
        System.setProperty("web driver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        ChromeOptions option=new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(option);

        //To maximize window size
        driver.manage().window().maximize();

        //Launching web browser
        driver.get("https://www.facebook.com/");     //implicit wait to load web elemnets and to maintain synchronization
    }

@Test
@Parameters({"username","password"})
    public void login(String username,String password) {
    //finding web elements of username and password field and performing mouse click
    driver.findElement(By.xpath("//input[@type='text']")).sendKeys(username);
    driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
    driver.findElement(By.xpath("//button[@name='login']")).click();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@class='x5yr21d xl1xv1r xh8yej3'][1]")));
    System.out.println("Explicitly waited for the webelement to load");

}

@AfterTest
        public void closing()
        {
        driver.close();
            }
 }

