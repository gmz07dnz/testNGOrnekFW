package com.selfStudy;

import com.techproed.pages.WebTablePage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class webTable1 {

    WebTablePage webTablePage = new WebTablePage();

    @Test
    public void test() {
        //- "http://demo.automationtesting.in/Index.html" adresine git
        Driver.getDriver().get(ConfigReader.getProperty("webTable_Url"));

        //- Skip Sign In Butonuna tikla
        webTablePage.skipSignIn.click();

        //- Web Table tikla
        webTablePage.webTable.click();

        //-Baslik sayisini bulun ve konsola yazdirin
        int headersNumber = webTablePage.headersDatalar.size();
        System.out.println("Baslik Sayisi: " + headersNumber);
        for (WebElement w : webTablePage.headers) {
            System.out.println(w.getText());
        }

        //- Tablonun altindaki items per page'i 20 yapin ve Body'deki data sayisinin 100  ve
        //  satir sayisinin 20 oldugunu test edin.
        Select select = new Select(webTablePage.itemsPerPageDropdown);
        select.selectByVisibleText("20");
        int satirSayisi = webTablePage.satirSayisi.size();
        System.out.println("Satir Sayisi: " + satirSayisi);
        Assert.assertEquals(satirSayisi, 20);
        int dataSayisi = webTablePage.dataSayisi.size();
        System.out.println("Data Sayisi: " + dataSayisi);
        Assert.assertEquals(dataSayisi, 100);

        // -16. satiri yazdirin
        webTablePage.istenenSatirData(16);
        // -2. column'u yazdirin
        webTablePage.istenenColumnDatalar(2);

        // -Last Name'i "Carlos Santos" olanin phone number "9999989991" oldugunu test edin
        // Last Name column bul
        int columnLastName = 0;
        for (int i = 0; i < webTablePage.headersDatalar.size(); i++) {
            if (webTablePage.headersDatalar.get(i).getText().contains("Last Name")) {
                columnLastName = i + 1;
            }
        }
        System.out.println("Column: " + (columnLastName)); // ==>4

        // Last Name columdaki Carlos Pantosun Satir Sayisini bul
        int satirSayisiCarlos = 0;
        for (int i = 1; i <= satirSayisi; i++) {
            List<WebElement> list1 = Driver.getDriver().findElements(By.xpath("(//div[@class='ui-grid-row ng-scope'])[" + i + "]//div[@class='ui-grid-cell-contents ng-binding ng-scope']"));
            if (list1.get(columnLastName - 1).getText().contains("Carlos Santos")) {
                satirSayisiCarlos = i;
            }
        }
        System.out.println("Carlos Satir Sayisi: " + satirSayisiCarlos);

        // Phone'ın Column sayisini bul
        int columnPhone = 0;
        for (int i = 0; i < webTablePage.headersDatalar.size(); i++) {
            if (webTablePage.headersDatalar.get(i).getText().contains("Phone")) {
                columnPhone = i + 1;
            }
        }
        System.out.println("Column: " + (columnPhone));

        // phone number "9999989991" oldugunu test edin
        List<WebElement> list3 = Driver.getDriver().findElements(By.xpath("(//div[@class='ui-grid-row ng-scope'])[" + satirSayisiCarlos + "]//div[@class='ui-grid-cell-contents ng-binding ng-scope']"));
        String phone =list3.get(columnPhone - 1).getText();
        Assert.assertEquals(phone,"9999989991");

    }
}
