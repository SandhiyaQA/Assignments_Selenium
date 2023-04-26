import datadrivenpackage.pageObjects.PageObjectRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Main_Function {


        public static void main(String[] args) {

            System.setProperty("web driver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            PageObjectRepository d =new PageObjectRepository(driver);
            //To maximize window size
            driver.manage().window().maximize();

            //Launching web browser
            driver.get("https://www.facebook.com/");

            //implicit wait to load web elements and to maintain synchronization
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(400));
            String username="sandhiyaravi01@gmail.com";
            String password="depeshwaran";


            d.setUsername(username);
            d.setPassword(password);
            d.clickmethod1();
        }
    }


