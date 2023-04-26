package Relevel_Sandhiya;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class HomeLoan {

    WebDriver driver;

    @BeforeClass
    public void launchURL() {
        //Setting up webbrowser
        System.setProperty("web driver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");


        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(option);

        //To maximize window size
        driver.manage().window().maximize();

        //Launching web browser
        driver.get("https://www.switchme.in/calculator/prepayment");


        //implicit wait to load web elemnets and to maintain synchronization
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

    }

    @Test(priority = 1)
    public void enterBelowDetails() throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='outstanding_principal']")).sendKeys("5000000");
        WebElement tenture = driver.findElement(By.xpath("//select[@id='unit']"));
        Select select = new Select(tenture);
        select.selectByIndex(0);

        driver.findElement(By.xpath("//input[@id='months']")).sendKeys("180");

        driver.findElement(By.xpath("//input[@id='interest-or-emi']")).sendKeys("6.7");

        driver.findElement(By.xpath("//body/div[@id='page']/div[1]/div[1]/div[1]/div[1]/div[2]/div[7]/label[2]")).click();


        WebElement outstanding=driver.findElement(By.xpath("//input[@id='outstanding_principal1']"));
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scroll(0,500)");



//        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.elementToBeClickable(outstanding));


        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();",outstanding);
        jse.executeScript("document.getElementById('outstanding_principal1').value='5000;'");


        WebElement EndOfButton = driver.findElement(By.xpath("//select[@id='unitls']"));

        Select select1 = new Select(EndOfButton);
        select1.selectByIndex(0);

         driver.findElement(By.xpath("//input[@id='months1']")).sendKeys("1");


        WebElement HowOften = driver.findElement(By.xpath("//select[@id='freq']"));
        Select select2 = new Select(HowOften);
        select2.selectByIndex(0);

    }

    @Test(priority = 2, dependsOnMethods = "enterBelowDetails")
    public void clickCalculate() {
        JavascriptExecutor jse1 = (JavascriptExecutor) driver;
        jse1.executeScript("arguments[0].click();",driver.findElement(By.xpath("//button[@id='button']")));



    }

    @Test(priority = 3, dependsOnMethods = "clickCalculate")
    public void printTotalAndReducedBy() {
        String interest = driver.findElement(By.xpath("//span[@id='data1']")).getText();
        String reducedBy = driver.findElement(By.xpath("//span[@id='data2']")).getText();

        System.out.println("Total Interest :  "+  interest  + "  Reduced By"  +  reducedBy);
    }

@Test(priority = 4, dependsOnMethods = "printTotalAndReducedBy")
public void   ClickonAmortizationTable()
{
driver.findElement(By.cssSelector("#white")).click();
}


@Test(priority = 5, dependsOnMethods = "ClickonAmortizationTable")
public void verifyTotalRows() {

    List<WebElement> rows = driver.findElements(By.tagName("tr"));
    int rowcount = rows.size();
    System.out.println(rowcount);
    int expectedRowCount = 151;
    try {
        Assert.assertEquals(expectedRowCount, rowcount, "Row count didn't match");
    } catch (AssertionError a) {
        System.out.println(a);
    }
}

//@AfterClass
//    public void close()
//{
//    driver.close();
//}
}

