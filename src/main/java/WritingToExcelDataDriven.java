import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WritingToExcelDataDriven {
    public static void main(String[] args) throws IOException {

        //setting up web browser
        /*System.setProperty("web driver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //To maximize window size
        driver.manage().window().maximize();

        //Launching web browser
        driver.get("https://demo.guru99.com/test/newtours/register.php");

        //implicit wait to load web elements and to maintain synchronization
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(400));
*/
        FileInputStream fileInputStream =new FileInputStream("C:\\Users\\Dell\\Desktop\\Book1.xlsx");
        XSSFWorkbook workbook=new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet=workbook.getSheet("sheet2");
        int rows=sheet.getLastRowNum();
        int col=sheet.getRow(0).getLastCellNum();
        System.out.println(rows+ "  "+col);

        FileOutputStream fileOutputStream=new FileOutputStream("C:\\Users\\Dell\\Desktop\\Book1.xlsx");
        XSSFWorkbook w1=new XSSFWorkbook();
        XSSFSheet s1=w1.createSheet("sheet3");

        for(int i=0;i<rows;i++) {

            Row row1 = s1.createRow(i);
            Cell cell = row1.createCell(2);
            cell.setCellValue("test");

        }

        w1.write(fileOutputStream);
        fileOutputStream.close();




     }}
