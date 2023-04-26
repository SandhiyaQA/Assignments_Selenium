package cartAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ExecutionStart {

    static WebDriver driver;
    static String  URL,Driver,path;
    @BeforeTest
    public void settingBrowser() throws IOException {

        FileInputStream fileInputStream=new FileInputStream("src/test/java/modularFramework/config.properties");
        Properties properties=new Properties();
        properties.load(fileInputStream);
        Driver=properties.getProperty("chromedriver");
        path=properties.getProperty("chromepath");
        URL=properties.getProperty("urlof");
        System.out.println();
        System.out.println(URL+""+path);

        //setting up web browser
        System.setProperty(Driver,path);
        driver = new ChromeDriver();

        //To maximize window size
        driver.manage().window().maximize();

        //Launching web browser
        driver.get("https://www.saucedemo.com/");


    }

    @Test
    public void execute() throws InterruptedException {
        HomPage home = new HomPage(driver);
        home.login();
        ProductPage productPage = new ProductPage(driver);
        productPage.clickProduct();
        AddToCartPAge cart = new AddToCartPAge(driver);
        cart.verifyAddCart();
    }
     @AfterTest
    public void closingTheBrowser()
     {
         driver.quit();
     }



}
