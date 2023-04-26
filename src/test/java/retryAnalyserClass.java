import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

public class retryAnalyserClass {

     public  static WebDriver driver;
        @BeforeMethod
        public static void setup() {

            //setting up web browser
            driver = new ChromeDriver();

            //To maximize window size
            driver.manage().window().maximize();

            //Launching web browser
            driver.get("https://www.bing.com/");

            //implicit wait to load web elemnets and to maintain synchronization
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));


        }



        @DataProvider(name = "dataprovider")
        public  Object[][] dataProviderMethod() throws IOException {
            Object[][] keys = getFromExcel();
            return keys;
        }

        @Test(dataProvider = "dataprovider",retryAnalyzer = RetryClass.class)

        public static void sendData(String key1,String key2){
            driver.findElement(By.xpath("//textarea[@id='sb_form_q']")).sendKeys(key1+" "+key2);

            driver.findElement(By.xpath("//textarea[@id='sb_form_q']")).sendKeys(Keys.ENTER);

            Reporter.log("Results found");
        }



        public String[][] getFromExcel() throws IOException {
            FileInputStream inputStream = new FileInputStream("src/test/resources/retryAnalyser.xlsx");

            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheetAt(0);

            int rowCount = sheet.getLastRowNum();
            int columnCount=sheet.getRow(0).getLastCellNum();


            System.out.println(rowCount + " " + columnCount);
            String[][] data=new String[rowCount][columnCount];

            for(int i=1;i<=rowCount;i++)
            {
                for(int j=0;j<columnCount;j++)
                {
                    XSSFCell cell=sheet.getRow(i).getCell(j);
                    data[i-1][j]=cell.toString();
                }
            }
            return data;
        }


        @AfterMethod
        public static void tearDown()
        {
            driver.close();
        }

    }

