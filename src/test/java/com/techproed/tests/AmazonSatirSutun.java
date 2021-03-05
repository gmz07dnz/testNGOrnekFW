package com.techproed.tests;

import com.techproed.pages.AmazonPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.ReusableMethods;
import com.techproed.utilities.TestBaseRapor;
import org.testng.Assert;
import org.testng.annotations.Test;
import sun.security.krb5.Config;

public class AmazonSatirSutun extends TestBaseRapor {
    /*
      Amazon anasayfaya gidebilecek sekilde bir page sayfasi olusturun : AmazonPage
      Amazon ana sayfasinda en altta bulunan Webtable’i inceleyebilmek icin AmazonPage
        clasinda en altta gitme isini yapacak bir method olusturun
      Tests paketi altinda yeni bir class olusturun: D26_AmazonSatirSutunSayisi
      Bu class’in altinda bir test method olusturun : satirSayisi() ve webtable’da 10 satir
        oldugunu test edin
      Yeni bir method olusturun : sutunSayisi() ve yazi olan sutun sayisinin 7oldugunu test
        edin
     */

    @Test
    public void satirSayisi(){
        extentTest = extentReports.createTest("satır sayısı","Amazın sayfasındakı webtable satır sayısını bulma");
        // amazon'a git
        Driver.getDriver().get(ConfigReader.getProperty("amazon_URL"));
        extentTest.info("Amazon sayfasına gidildi");
        AmazonPage amazonPage =new AmazonPage();
        amazonPage.enAltaGit();
        extentTest.info("En alta git");
        Assert.assertTrue(amazonPage.satirlarListesi.size()==10);
        extentTest.pass("Satır sayısının 10 oldugunu test edildi");

        Driver.closeDriver();

    }


    @Test
    public void sutunSayisi(){
        // amazon'a git
        Driver.getDriver().get(ConfigReader.getProperty("amazon_URL"));
        AmazonPage amazonPage =new AmazonPage();
        amazonPage.enAltaGit();
        Assert.assertTrue(amazonPage.sutunlar.size()==7);
        Driver.getDriver().close();

    }
}
