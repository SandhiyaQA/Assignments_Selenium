import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class flipkart {  public static void main(String[] args) throws IOException {

    //setting up web browser
    System.setProperty("web driver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();

    //To maximize window size
    driver.manage().window().maximize();

    //Launching web browser
    driver.get("https://www.flipkart.com/search?q=shoes&sid=osp%2Ccil%2C1cu&as=on&as-show=on&otracker=AS_QueryStore_OrganicAutoSuggest_1_4_na_na_na&otracker1=AS_QueryStore_OrganicAutoSuggest_1_4_na_na_na&as-pos=1&as-type=RECENT&suggestionId=shoes%7CSports+Shoes&requestId=cda18d3e-1cb9-445f-a266-f44799c2f0cc&as-searchtext=shoe");
    //implicit wait to load web elements and to maintain synchronization
    driver.manage().timeouts().implicitlyWait(Duration.ofMillis(400));

    //finding web elementts of search and then typing content to search for the item

    WebElement search= driver.findElement(By.xpath("//input[@class='_3704LK']"));
    search.clear();
    WebDriverWait wait3=new WebDriverWait(driver,Duration.ofMillis(400));
    wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='_3704LK']")));
    Actions actions=new Actions(driver);
    actions.moveToElement(search).click().sendKeys("rack").sendKeys(Keys.ENTER).perform();

    //performing click to select that particular item
    WebElement item=driver.findElement(By.xpath("//a[@class='s1Q9rs' and contains(@href,'dbeautify')][1]"));
    actions.moveToElement(item).click().build().perform();

    //screenshot
    TakesScreenshot screenshot=((TakesScreenshot)driver);
    File src=screenshot.getScreenshotAs(OutputType.FILE);
    File desc=new File("C:\\Users\\Dell\\IdeaProjects\\mavenpro\\screenshot\\sc2.jpg");
    FileUtils.copyFile(src,desc);

    System.out.println("screenshot captured");

    //closing all browsers
    driver.quit();
}
}
