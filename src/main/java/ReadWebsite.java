import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

public class ReadWebsite {


        public static void main(String[] args) throws IOException {

            //setting up web browser
            System.setProperty("web driver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
            WebDriver driver = new ChromeDriver();

            //To maximize window size
            driver.manage().window().maximize();

            //Launching web browser
            driver.get("https://demo.guru99.com/test/newtours/register.php");

            //implicit wait to load web elements and to maintain synchronization
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(400));


            FileInputStream fileInputStream=new FileInputStream("C:\\Users\\Dell\\Desktop\\Book1.xlsx");
            XSSFWorkbook workbook=new XSSFWorkbook(fileInputStream);
            XSSFSheet sheet= workbook.getSheet("Sheet2");
            int no_of_r_ows=sheet.getLastRowNum();
            int no_of_cells=sheet.getRow(0).getLastCellNum();
            for(int i=1;i<=no_of_r_ows;i++) {
                XSSFRow row = sheet.getRow(i);
                String first_name=row.getCell(0).toString();
                String last_name=row.getCell(1).toString();
                String phone_num=row.getCell(2).toString();
                String e_mail=row.getCell(3).toString();
                String address=row.getCell(4).toString();
                String city=row.getCell(5).toString();
                String state=row.getCell(6).toString();
                String post_code=row.getCell(7).toString();
                String country=row.getCell(8).toString();
                String user_name=row.getCell(9).toString();
                String password=row.getCell(10).toString();

        driver.findElement(By.name("firstName")).sendKeys(first_name);
                driver.findElement(By.name("lastName")).sendKeys(last_name);
                driver.findElement(By.name("phone")).sendKeys(phone_num);
                driver.findElement(By.name("userName")).sendKeys(e_mail);
                driver.findElement(By.name("address1")).sendKeys(address);
                driver.findElement(By.name("city")).sendKeys(city);

                driver.findElement(By.name("state")).sendKeys(state);
                driver.findElement(By.name("postalCode")).sendKeys(post_code);

                Select select=new Select(driver.findElement(By.name("country")));
                select.selectByVisibleText(country);
                driver.findElement(By.name("email")).sendKeys(user_name);
                driver.findElement(By.name("password")).sendKeys(password);
                driver.findElement(By.name("confirmPassword")).sendKeys(password);
                driver.findElement(By.name("submit")).click();

WebElement message=driver.findElement(By.xpath("//a[contains(text(),'sign-in')]"));
          String msg=message.getText();
                System.out.println(msg);
                if(message.isDisplayed())
                {
                    System.out.println("testcase passed");

                }
                else {
                    System.out.println("testcase failed");

                }

                driver.navigate().back();
                driver.navigate().refresh();


            }

driver.close();
            fileInputStream.close();
        }
    }


