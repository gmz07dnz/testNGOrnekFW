package com.techproed.tests;

import com.techproed.utilities.ExcelUtil;
import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Day34ReadExcel {


    @Test
    public void test01() throws IOException {

        String path = "src/test/java/resources/baskentler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(21);
        Cell cell = row.getCell(2);
        System.out.println(cell);  // cell data type'dır yazdırıyor fakat string degildir

        String baskentIsmi = cell.toString();  // cell data type'ı Strig'e cevirdik
        System.out.println(baskentIsmi);
        Assert.assertEquals(baskentIsmi, "Ankara");

        // satir sayisini bulalim
        int satirSayisi = sheet.getLastRowNum();
        System.out.println(satirSayisi);

        // Tum baskentleri yazdiralim
        String baskentler = "";
        for (int i = 1; i < satirSayisi; i++) {
            baskentler = sheet.getRow(i).getCell(2).toString();
            System.out.println(baskentler);
        }

        //sayfa 2 icin son satir no ve kullanilan satir no yazdirin
        int sayfa2SonSatirNo = workbook.getSheetAt(1).getLastRowNum() + 1;
        int sayfa2KullanilanSatirNo = workbook.getSheetAt(1).getPhysicalNumberOfRows();
        System.out.println("Kullanilan satir No: " + sayfa2KullanilanSatirNo);
        System.out.println("Son Satir No:" + sayfa2SonSatirNo);

        // 4. satir'daki 2. hucre'deki bilgiyi yazdirin
        workbook.getSheetAt(0).getRow(3).getCell(1);

        //Baskenti Ankara olan ulkenin tum bilgilerini yaz
        int arananSatirSayisi = 0;
        for (int i=0; i<satirSayisi;i++){
            if(workbook.getSheetAt(0).getRow(i).getCell(2).toString().equals("Ankara")){
                System.out.println("Aranan satir Sayisi: "+(i+1));
                arananSatirSayisi=i+1;
                break;
            }
        }
        int sutunSayisi = workbook.getSheetAt(0).getRow(1).getPhysicalNumberOfCells();
        for(int k=0;k<sutunSayisi;k++){
            System.out.println(workbook.getSheetAt(0).getRow(arananSatirSayisi-1).getCell(k).toString());
        }


    }


    @Test
    public void test02() {
    ExcelUtil excelUtil = new ExcelUtil("src/test/java/resources/baskentler.xlsx","Sayfa1");

       // 4. satir'daki 2. hucre'deki bilgiyi yazdirin
        System.out.println(excelUtil.getCellData(3,1));

        // 22. satirdaki baskent isminin Ankara oldugunu test edin
       Assert.assertEquals(excelUtil.getCellData(21,2),"Ankara");

        // sutun sayisini bulalim
        System.out.println(excelUtil.columnCount());

        // excel'deki tum bilgileri bir map'e aktaralim
        List<Map<String,String>> tumDataList = excelUtil.getDataList();
        System.out.println(tumDataList);

        //Baskenti Ankara olan ulkenin tum bilgilerini yaz

       for(int i=0;i<tumDataList.size();i++) {
           if (tumDataList.get(i).containsValue("Ankara")){
               System.out.println(tumDataList.get(i));
           }
       }
    }








}