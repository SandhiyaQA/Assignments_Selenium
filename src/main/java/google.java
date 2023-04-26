import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class google {
    public static void main(String[] args) {


        System.setProperty("web driver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");


        Actions action=new Actions(driver);     driver.findElement(By.xpath("//input[@type='text']")).sendKeys("chennai");
        System.out.println(driver.getTitle());
        System.out.println(driver.getWindowHandle());
        driver.navigate().to("http://www.google.com");
        System.out.println(driver.getWindowHandles());
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        driver.navigate().back();
        driver.manage().window().minimize();
    }}
