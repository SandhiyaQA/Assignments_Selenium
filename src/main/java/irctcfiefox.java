import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class irctcfiefox {


        public static void main(String[] args) throws IOException {


            System.setProperty("web driver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
            WebDriver driver= new FirefoxDriver();
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
      File src=((FirefoxDriver)driver).getFullPageScreenshotAs(OutputType.FILE);
            FileHandler.copy(src,new File("C:\\Users\\Dell\\IdeaProjects\\mavenpro\\screen\\sc1.jpg"));
            driver.quit();
        }



        }


