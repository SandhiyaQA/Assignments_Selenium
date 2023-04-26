import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class tootl {
    public static void main(String[] args) throws InterruptedException {

        //setting up web browser
        System.setProperty("web driver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");


        WebDriver driver = new ChromeDriver(option); //To maximize window size
        driver.manage().window().maximize();

        //Launching web browser
        driver.get("https://emicalculator.net/");

        //implicit wait to load web elements and to maintain synchronization
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //web element for more and gift card
/*
driver.findElement(By.id("loanamount")).clear();
driver.findElement(By.id("loanamount")).sendKeys("600000");
driver.findElement(By.id("loaninterest")).clear();
driver.findElement(By.id("loaninterest")).sendKeys("1");
driver.findElement(By.id("loanterm")).clear();
driver.findElement(By.id("loanterm")).sendKeys("1");

*/
        List<WebElement> piechart=driver.findElements(By.xpath("//*[local-name()='svg']//*[name()='g' and @class='highcharts-series-group']//*[name()='g' and @class='highcharts-series highcharts-series-0 highcharts-pie-series highcharts-tracker']"));
        //WebElement e=driver.findElement(By.xpath("//*[local-name()='svg']//*[name()='g' and @class='highcharts-label highcharts-tooltip highcharts-color-undefined']//*[name()='text']"));

        System.out.println(piechart.size());
        Actions action=new Actions(driver);
        for(WebElement element1:piechart) {
            action.moveToElement(element1).perform();
            Thread.sleep(500);


            System.out.println(driver.findElement(By.xpath("//*[local-name()='svg']//*[name()='g' and contains(@class,'  highcharts-color-1')]//*[name()='text']//*")).getText());
        }

        /*
        WebElement element=driver.findElement(By.xpath("//*[local-name()='svg']//*[name()='g' and @class='highcharts-series-group']//*[name()='rect']"));
        JavascriptExecutor javascriptExecutor=(JavascriptExecutor)driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);",element);


        List<WebElement> l=driver.findElements(By.xpath("//*[local-name()='svg']//*[name()='g' and @class='highcharts-series-group']//*[name()='rect']"));//Action class to perform  mouse move and scroll down
         WebElement e=driver.findElement(By.xpath("//*[local-name()='svg']//*[name()='g' and @class='highcharts-label highcharts-tooltip highcharts-color-undefined']//*[name()='text']"));

        System.out.println(l.size());
        Actions action=new Actions(driver);
        for(WebElement element1:l) {
            action.moveToElement(element1).perform();


                    System.out.println(driver.findElement(By.xpath("//*[local-name()='svg']//*[name()='g' and @class='highcharts-label highcharts-tooltip highcharts-color-undefined']//*[name()='text']")).getText());
        }
*/

        //closing web browser
        //driver.close();
    }
}
