package relevelTest;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtilities {
   public static FileInputStream fis;
    public static XSSFWorkbook workbook;
    public static XSSFSheet sheet;
    public static XSSFCell cell;

    public static void readFromExcel() throws IOException {


        fis=new FileInputStream("src/test/resources/Relevel_SANDHIYA_K.xlsx");
        workbook=new XSSFWorkbook(fis);
        sheet=workbook.getSheetAt(2);
    }
        public static String getValuesFromExcel(int row,int column)
        {

            cell=sheet.getRow(row).getCell(column);
            String info=cell.getStringCellValue();
            return info;
        }
}
