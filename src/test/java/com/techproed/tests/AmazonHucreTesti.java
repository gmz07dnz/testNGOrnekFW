package com.techproed.tests;

import com.techproed.pages.AmazonPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBaseRapor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonHucreTesti extends TestBaseRapor {

    /*
      AmazonPage sayfasinda istedigim satir ve sutun sayisi ile cagirdigimda bana
        hucredeki yaziyi getirecek bir method olusturun
      Tests paketi altinda yeni bir class olusturun: D26_AmazonHucreTesti
      Bu class’in altinda bir test method olusturun : hucretesti() ve webtable’da 3. satir
        7.sutundaki yazinin “Home Services” yazisi icerdigini test edin
      Yeni bir method olusturun : AmazonYazisi() ve tabloda 9 Hucrede “Amazon” yazisi
        bulundugunu test edin
     */

    @Test
    public void hucreTesti(){
        extentTest = extentReports.createTest("Hucre Testi","3.Satır 7.sutun yazısının dogrulugunu test ettik");
        // amazon'a git
        Driver.getDriver().get(ConfigReader.getProperty("amazon_URL"));
        extentTest.info("Amazon sayfasına gidildi");
        AmazonPage amazonPage =new AmazonPage();
        amazonPage.enAltaGit();
        extentTest.info("En alta git");
        Assert.assertTrue(amazonPage.getCellText(3,7).contains(ConfigReader.getProperty("arananHucre")));
         extentTest.pass("Hucredeki yazı dogru,test basarılı");
        Driver.getDriver().close();
    }

    @Test
    public void amazonYazısı() {
        // amazon'a git
        Driver.getDriver().get(ConfigReader.getProperty("amazon_URL"));
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.enAltaGit();

       /* int kelimeSayici=0;
        for (int i=1 ; i<=amazonPage.satirlarListesi.size(); i+=2){
            for (int j=1 ; j<=amazonPage.birinciSatirElementleri.size(); j+=2){
                if (amazonPage.getCellText(i,j).contains(ConfigReader.getProperty("aranan_kelime"))){
                    kelimeSayici++;
                }
                 }
                 }
        System.out.println(kelimeSayici);
        */

        int kelimeSayısı=0;
        for (int i=0;i<amazonPage.allCells.size();i++){
            if (amazonPage.allCells.get(i).getText().contains(ConfigReader.getProperty("aranan_kelime"))){
                kelimeSayısı++;
            }
        }
        System.out.println(kelimeSayısı);
        Driver.closeDriver();

    }
}
