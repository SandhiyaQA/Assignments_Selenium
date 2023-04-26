package org.qa.utilities;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtilities {
    FileInputStream fileInputStream;
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFCell cell;

//"src/test/resources/testdata_keyword_driven.xlsx"
    public void readExcelFileLocation(String location) throws IOException {
        fileInputStream=new FileInputStream(location);
        workbook=new XSSFWorkbook(fileInputStream);
        sheet=workbook.getSheetAt(0);
    }
    public String getValuesFromExcel(int row,int column){

                cell=sheet.getRow(row).getCell(column);
        String info=cell.getStringCellValue();
     return info;

    }


}
