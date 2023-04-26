package modularFramework.ExceutionMachine;

import modularFramework.modules.Modules;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class ExecutionMachine {

        public  static WebDriver driver;
        public static String browser,url,drivers,path,wait;
        public static long implicit_wait;
        public static void settingProperty() throws IOException {

            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Dell\\IdeaProjects\\mavenpro\\src\\test\\java\\modularFramework\\config.properties");
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

        public static void main(String[] args) throws IOException
        {


        ExecutionMachine.settingProperty();
        ExecutionMachine.goToUrl();
            Modules modules=new Modules(driver);
            modules.setEmail();
            modules.clickNewTour(driver);
            modules.login();
        modules.validateSuccessPage();

        }






}
