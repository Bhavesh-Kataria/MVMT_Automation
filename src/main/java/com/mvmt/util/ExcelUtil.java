package com.mvmt.util;

import com.mvmt.base.Base;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtil extends Base {
    public static Object[][] getLoginData(){
        try{
            FileInputStream fis = new FileInputStream("/Users/topb/Desktop/Automation Testing/Web Testing/MVMT_Automation/src/main/java/com/mvmt/testdata/MVMT_DATA.xlsx");
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet selectedSheet = workbook.getSheet("LoginPage");
            int rowCount = selectedSheet.getPhysicalNumberOfRows() - 1;
            Object[][] data = new Object[rowCount][2];
            for (int i = 1; i <= rowCount; i++) {
                Row row = selectedSheet.getRow(i);
                data[i - 1][0] = row.getCell(0).getStringCellValue(); // username
                data[i - 1][1] = row.getCell(1).getStringCellValue(); // password
            }
            workbook.close();
            fis.close();
            return data;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
