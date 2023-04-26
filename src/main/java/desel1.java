import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class desel1 {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://only-testing-blog.blogspot.com/2014/01/textbox.html");

        WebElement element= (WebElement) driver.findElements(By.name("FromLB"));
        Select select=new Select(element);
        select.selectByIndex(3);
        select.selectByValue("USA");
        select.selectByVisibleText("Russia");
    driver.close();
        Dimension d=element.getSize();

    }


   }

