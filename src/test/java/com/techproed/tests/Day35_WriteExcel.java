package com.techproed.tests;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Day35_WriteExcel {
    @Test
    public void test() throws IOException {
        String path="src/test/java/resources/baskentler.xlsx";
        FileInputStream fileInputStream =new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        System.out.println(workbook.getSheetAt(0).getRow(3).getCell(5));

        workbook.getSheetAt(0).getRow(0).createCell(6).setCellValue("Neyi Meshur");
        workbook.getSheetAt(0).getRow(1).createCell(6).setCellValue("Ordek");
        // once yazıyoruz cunku once ne yapacagını soyluyoruz o da dosyaya yazıyor

        FileOutputStream fileOutputStream=new FileOutputStream(path);
        workbook.write(fileOutputStream);

        // o datanın yazdırdıgını test et
        Assert.assertEquals(workbook.getSheetAt(0).getRow(1).getCell(6).toString(),"Ordek");




    }
}
