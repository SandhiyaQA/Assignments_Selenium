package org.qa.actionkeywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ActionKeywords {


static  WebDriver driver;
    //open browser

    public static void openBrowser()
    {
        System.setProperty("web driver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

         driver = new ChromeDriver();

    }

    //go to url

    public static  void goToUrl()
    {
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://demo.guru99.com/V1/index.php");
        driver.manage().window().maximize();

    }
    //enter username


    public static void enterUserName()
    {

        driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("mngr476387");
    }
    //enter password

    public static  void enterPassword()
    {
        driver.findElement(By.name("password")).sendKeys("naretam");
    }

    //click login
    public static void clickLogin()
    {
        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
    }
public  static void closeBrowser()
{
    driver.quit();
}


}
