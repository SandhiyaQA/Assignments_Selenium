import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class firstscript {
    static public void main(String[] args) {
        System.setProperty("web driver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        ChromeOptions option=new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");

        WebDriver driver=new ChromeDriver(option);
        driver.get("http://relevel.com");
        driver.manage().window().maximize();
        driver.navigate().to("http://google.com");
        driver.navigate().back();
        driver.navigate().forward();
        String s=driver.getTitle();
        String s1=driver.getCurrentUrl();
        System.out.print(s1);
        System.out.println(s);
        if(s.equals("Google"))
        {
            System.out.println("page found");

        }
        else{
            System.out.println(" page not foung");
        }
      //  driver.quit();
    }
}
