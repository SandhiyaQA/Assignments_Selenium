package pageObjectModelProject.ExecutionScript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import pageObjectModelProject.objectRepository.HomePage;
import pageObjectModelProject.objectRepository.LoginSuccessPage;
import pageObjectModelProject.objectRepository.TourPage;
import pageObjectModelProject.objectRepository.WelcomeLoginPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class ExecutionEngine {
public  static WebDriver driver;
public static String browser,url,drivers,path,wait;
public static long implicit_wait;
    public static void settingProperty() throws IOException {

        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Dell\\IdeaProjects\\mavenpro\\src\\test\\java\\pageObjectModelProject\\propertyfile\\config.properties");
        Properties properties = new Properties();
        properties.load(fileInputStream);
        browser = properties.getProperty("browser");
        url = properties.getProperty("url");
        wait =properties.getProperty("implicitwait");

        if(browser.equalsIgnoreCase("chrome"))
        {
            drivers= properties.getProperty("chromedriver");
            path=properties.getProperty("chromepath");
            System.setProperty(drivers,path);
            driver=new ChromeDriver();
        }
        else  if(browser.equalsIgnoreCase("firefox"))
        {
            drivers= properties.getProperty("firefoxdriver");
            path=properties.getProperty("firefoxpath");
            System.setProperty(drivers,path);
            driver=new FirefoxDriver();
        }

        else if(browser.equalsIgnoreCase("internetexplorer"))
        {
            drivers= properties.getProperty("IEdriver");
            path=properties.getProperty("IEpath");
            System.setProperty(drivers,path);
            driver=new InternetExplorerDriver();
        }

    }

    public static void goToUrl()
    {
        //To maximize window size
        driver.manage().window().maximize();
        //Launching web browser
        driver.get(url);
        //implicit wait to load web elements and to maintain synchronization
        implicit_wait=Long.parseLong(wait);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(implicit_wait));
    }

    public static void callingHomePage()
    {
        HomePage d =new HomePage(driver);
        d.setEmail("sandhiyaravi01@gmail.com");
    }

public static void callingTourPage()
{
    TourPage tour=new TourPage(driver);
    tour.clickNewTour(driver);
}
public static void callingWelcomePage()
{
    WelcomeLoginPage welcome=new WelcomeLoginPage(driver);
    welcome.setUsername("sandhiya");
    welcome.setPassword("sandhiya");
    welcome.setSubmit();

}


public static void callingSuccessfulLoginPage()
{
    LoginSuccessPage successPage=new LoginSuccessPage(driver);
    successPage.validateSuccessPage();
}
 public static void closingBrowser()
 {
     driver.quit();
 }


    public static void main(String[] args) throws IOException {
        ExecutionEngine.settingProperty();
        ExecutionEngine.goToUrl();
        ExecutionEngine.callingHomePage();
        ExecutionEngine.callingTourPage();
        ExecutionEngine.callingWelcomePage();
         ExecutionEngine.callingSuccessfulLoginPage();
         ExecutionEngine.closingBrowser();

        }
    }




