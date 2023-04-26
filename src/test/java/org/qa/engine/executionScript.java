package org.qa.engine;

import org.qa.actionkeywords.ActionKeywords;
import org.qa.utilities.ExcelUtilities;

import java.io.IOException;

public class executionScript {
    public static void main(String[] args) throws IOException {
        ExcelUtilities excelUtilities=new ExcelUtilities();
        excelUtilities.readExcelFileLocation("src/test/resources/testdata_keyword_driven.xlsx");
        for(int row=1;row<=6;row++)
        {
        String keyword=excelUtilities.getValuesFromExcel(row,3);
        if(keyword.equalsIgnoreCase("openbrowser"))
        {
            ActionKeywords.openBrowser();
        } else if (keyword.equalsIgnoreCase("gotourl")) {
            ActionKeywords.goToUrl();
        } else if (keyword.equalsIgnoreCase("enterusername")) {
            ActionKeywords.enterUserName();
        }
        else if (keyword.equalsIgnoreCase("enterpassword")) {
            ActionKeywords.enterPassword();
              }
        else if (keyword.equalsIgnoreCase("clicklogin")) {
            ActionKeywords.clickLogin();
        } else if (keyword.equalsIgnoreCase("closeBrowser")) {
            ActionKeywords.closeBrowser();
        }
        }}

}
