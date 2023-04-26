package relevelTest;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class VerificationOfTitle {
    public  static WebDriver driver;
    public static String browser,URL,drivers,driverPath;

    public static FileInputStream fis1;
    public static XSSFWorkbook workbook;
    public static XSSFSheet sheet;
    public static XSSFCell cell;



    @Test
   public static void asettingProperty() throws IOException {
       FileInputStream fis = new FileInputStream("C:\\Users\\Dell\\IdeaProjects\\mavenpro\\src\\test\\java\\relevelTest\\config.properties");
       Properties properties=new Properties();
       properties.load(fis);
       browser=properties.getProperty("browser");

       if(browser.equalsIgnoreCase("chromedriver"))
       {
           drivers=properties.getProperty("chromedriver");
           driverPath=properties.getProperty("chromepath");
           System.setProperty(drivers,driverPath);
            driver=new ChromeDriver();}
       else if(browser.equalsIgnoreCase("firefoxdriver"))
       {
           drivers=properties.getProperty("firefoxdriver");
           driverPath=properties.getProperty("firefoxpath");
           System.setProperty(drivers,driverPath);
           driver=new FirefoxDriver();
       }
       else if(browser.equalsIgnoreCase("IEdriver"))
       {
           drivers=properties.getProperty("IEdriver");
           driverPath=properties.getProperty("IEpath");
           System.setProperty(drivers,driverPath);
       }
   }

@Test
    public static String creadFromExcel(int row,int column) throws IOException {


        fis1=new FileInputStream("src/test/resources/Relevel_SANDHIYA_K.xlsx");
        workbook=new XSSFWorkbook(fis1);
        sheet=workbook.getSheetAt(2);
        System.out.println();
           cell = sheet.getRow(row).getCell(column);
        String cell1=cell.toString();
           return cell1;


    }
@AfterTest
    public static  void bgoToURl(WebDriver driver) throws IOException {


    URL=VerificationOfTitle.creadFromExcel(1,1) ;
    //Launching web browser
    driver.get(URL);
    //To maximize window
     driver.manage().window().maximize();



     //implicit wait to load web elements and to maintain synchronization
     driver.manage().timeouts().implicitlyWait(Duration.ofMillis(200));


 }
 @Test
 public void everifyTitleOfPage(WebDriver driver)
 {
     String expectedTitle=(sheet.getRow(1).getCell(2)).toString();
             String actulTitle=driver.getTitle();
     SoftAssert softAssert=new SoftAssert();
     softAssert.assertEquals(expectedTitle,actulTitle);
     softAssert.assertAll();
 }









}
