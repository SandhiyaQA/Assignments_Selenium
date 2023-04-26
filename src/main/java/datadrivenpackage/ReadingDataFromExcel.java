package datadrivenpackage;

import org.apache.poi.xssf.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadingDataFromExcel {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream=new FileInputStream("C:\\Users\\Dell\\Desktop\\Book1.xlsx");
        XSSFWorkbook workbook=new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet= workbook.getSheet("Sheet2");
        int no_of_r_ows=sheet.getLastRowNum();
        int no_of_cells=sheet.getRow(0).getLastCellNum();
        for(int i=0;i<no_of_r_ows;i++) {
            XSSFRow row = sheet.getRow(i);
        for(int j=0;j<no_of_cells;j++)
        {
            System.out.print("     "+row.getCell(j).toString());
        }
            System.out.println();
        }


    }
}
