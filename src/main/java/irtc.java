import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class irtc {
    public static void main(String[] args) throws IOException {


 System.setProperty("web driver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();

        //To maximize window size
        driver.manage().window().maximize();

    //Launching web browser
        driver.get("https://www.irctc.co.in/nget/train-search");     //implicit wait to load web elemnets and to maintain synchronization
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(600));
        SoftAssert soft= new SoftAssert();
    //finding web elements of username and password field and performing mouse click
  /*  Boolean display=driver.findElement(By.xpath("//div[@class='pull-right h_logo_right_div']/child::img")).isDisplayed();
        soft.assertEquals(display.booleanValue(),true);
        Assert.assertTrue(display,"logo not present");
*/
        Dimension dimension =driver.findElement(By.xpath("//div[@class='pull-right h_logo_right_div']/child::img")).getSize();
        System.out.println(dimension.height+""+dimension.width);
takeScreenShotshot(driver,"C:\\Users\\Dell\\IdeaProjects\\mavenpro\\screenshot\\sc.jpg");
    driver.quit();
    }

    public static void takeScreenShotshot(WebDriver driver,String fpath) throws IOException {
        TakesScreenshot screenshot=((TakesScreenshot)driver);
        File src=screenshot.getScreenshotAs(OutputType.FILE);
        File desc=new File(fpath);
        FileUtils.copyFile(src,desc);


        System.out.println("Image captured");

    }
}