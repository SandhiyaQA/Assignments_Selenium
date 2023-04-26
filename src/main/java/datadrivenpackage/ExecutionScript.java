package datadrivenpackage;

import datadrivenpackage.pageObjects.PageObjectFiles1;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ExecutionScript {
    public  FileInputStream fileInputStream;
    public  XSSFWorkbook workbook;
    public  XSSFSheet sheet;
    public  XSSFRow row;
    public  String column;

    public  String[] content;
    public  String username, Password;
    public  int no_of_cells, no_of_rows;
    public  List<String> userName=new ArrayList<>();
    public  List<String> pass=new ArrayList<>();
    public  void readFromExcel(int n,int no_of_cells)  {

        row = sheet.getRow(n);
        int j=1;
        while(j<=no_of_cells)
        {
            XSSFCell col = row.getCell(j);
               column=col.getStringCellValue();


            switch(j) {
                case 1:   userName.add(column);
                            j++;

                case 2:  pass.add(column);
                        System.out.println(pass.size());
                        j++;
            }
        }
            }


    public void fetchToWebElements(WebDriver driver) throws IOException {
        fileInputStream = new FileInputStream("C:\\Users\\Dell\\IdeaProjects\\mavenpro\\src\\test\\resources\\Data_Driven.xlsx");
        workbook = new XSSFWorkbook(fileInputStream);
        sheet = workbook.getSheet("Sheet1");
        no_of_rows = sheet.getLastRowNum();
        no_of_cells = sheet.getRow(0).getLastCellNum();

        System.out.println(no_of_rows+""+no_of_cells);
        int n = 1;
        for (int i = 1; i<=no_of_rows; i++) {
            driver.get("https://demo.guru99.com/test/newtours/");

            //implicit wait to load web elements and to maintain synchronization
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(400));

            readFromExcel(n,2);
          for(int j=0;j<userName.size();j++)
          {
              username=userName.get(0);
             }
          for(int l=0;l< pass.size();l++)
          {
              Password=pass.get(0);
          }
          PageObjectFiles1 pageObjectFiles1=new PageObjectFiles1(driver);
            pageObjectFiles1.setUserName(username,Password);

            n++;
            userName.remove(0);
            pass.remove(0);
        }
    }

}



