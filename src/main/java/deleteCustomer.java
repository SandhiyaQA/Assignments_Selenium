import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class deleteCustomer {
    public static void main(String[] args) {

        //setting up web browser
        System.setProperty("web driver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //To maximize window size
        driver.manage().window().maximize();

        //Launching web browser
        driver.get("https://demo.guru99.com/test/delete_customer.php");

        //implicit wait to load web elemnets and to maintain synchronization
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(400));

        //finding web elements of customer id field sending keys
        driver.findElement(By.name("cusid")).sendKeys("1234");

        //finding web elements of submit button and performing click
        driver.findElement(By.name("submit")).click();

        //using alert accepting the pop-menu
        driver.switchTo().alert().accept();

        //getting text message of alert box after accept
        System.out.println(driver.switchTo().alert().getText());

        //accepting second pop-up
        driver.switchTo().alert().accept();

        //closing the web driver
        driver.close();
    }
}