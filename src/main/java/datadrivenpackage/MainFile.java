package datadrivenpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class MainFile {

public static WebDriver driver;


    public static void executionStarts()
    {
        System.setProperty("web driver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();

        //To maximize window size
        driver.manage().window().maximize();

        //Launching web browser

    }

    public static void closingBrowser()
    {
        driver.close();
    }




    public static void main(String[] args) throws IOException {
        MainFile.executionStarts();
       ExecutionScript executionScript=new ExecutionScript();
       executionScript.fetchToWebElements(driver);
        MainFile.closingBrowser();



    }
}
