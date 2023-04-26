import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Relevel_Sandhiya {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        //System.setProperty("web driver.gecko.driver","src/test/resources/drivers/geckodriver.exe");

        WebDriver driver=new ChromeDriver();
      //  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS.SECONDS);
    //driver.get("https://www.etmoney.com/tools-and-calculators/sip-calculator");
    driver.manage().window().maximize();


        driver.get("https://accounts.google.com");

  driver.findElement(By.xpath("//input[@type='email']")).sendKeys("sandhiyaravi01@gmail.com");

        driver.findElement(By.xpath("//button[@type='button']")).click();
      driver.findElement(By.xpath("//input[@type='password']")).sendKeys("depeshwaran");

        driver.findElement(By.xpath("//button[@type='button']")).click();
        //close browser
 driver.close();
    }
}
