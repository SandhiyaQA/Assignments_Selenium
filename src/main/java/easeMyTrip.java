import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class easeMyTrip {
    public static void main(String[] args) {

    //setting up web browser
    System.setProperty("web driver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();

    //To maximize window size
    driver.manage().window().maximize();

    //Launching web browser
    driver.get("https://www.easemytrip.com/");

    //implicit wait to load web elements and to maintain synchronization
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

    //web element for more and gift card
        WebElement more= driver.findElement(By.xpath("//a[contains(text(),'More ')][1]"));
        WebElement gift= driver.findElement(By.xpath("//a[contains(@href,'giftcard')][1]"));


        //Action class to perform  mouse move and scroll down
    Actions action=new Actions(driver);
    action.moveToElement(more).moveToElement(gift).click().perform();

    WebElement FAQ= driver.findElement(By.xpath("//div[contains(text(),\"FAQ's\")]"));

    WebElement Question1= driver.findElement(By.xpath("//div[contains(text(),\"What is EaseMyTrip Gift Card?\")]"));

    WebElement ans= driver.findElement(By.xpath("//div[contains(text(),\"What is EaseMyTrip Gift Card?\")]/following::p"));

    Actions action2=new Actions(driver);
    action2.moveToElement(FAQ).moveToElement(Question1).click().moveToElement(ans).perform();

    //getting text from FAQ
    String Answer=driver.findElement(By.xpath("//div[contains(text(),\"What is EaseMyTrip Gift Card?\")]/following::p")).getText();
    System.out.println(Answer);

    //closing web browser
    driver.close();
}
}
