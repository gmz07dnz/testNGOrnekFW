package com.techproed.tests;

import com.techproed.pages.CkHotelsHomePage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sun.security.krb5.Config;

public class Day_33_Data_Provider_Coklu {

    /*
    1.https://qa-environment.crystalkeyhotels.com/ sayfasina gidelim
    2.Cucumber parametre ,cucumber scenario outline ve TestNg framework @Dataprovider kullanarak asagidaki gorevi tamamlayin
      - Login tusuna basin
      - Asagidaki 5 kullanici adi ve sifreyi deneyin ve login olmadigini test edin
      - Manager – Manager
      - Manager1- Manager1
      - Manager2 - Manager2
      - Manager3 - Manager3
      - Manager4 – Manager4
     */


    @DataProvider
    public static Object[][] kullanicilar() {
        Object[][] aranacaklar={{"Manager","Manager"},{"Manager1","Manager1"},{"Manager2","Manager2"},{"Manager3","Manager3"},{"Manager4","Manager4"}};
        return aranacaklar;
    }


    @Test(dataProvider = "kullanicilar")
    public void test(String userName,String psw){
        Driver.getDriver().get(ConfigReader.getProperty("ck_hotels_url"));
        CkHotelsHomePage ckHotelsHomePage =new CkHotelsHomePage();
        ckHotelsHomePage.ilklogin.click();
        ckHotelsHomePage.userNameTextBox.sendKeys(userName+ Keys.ENTER);
        ckHotelsHomePage.passwordTextBox.sendKeys(psw+ Keys.ENTER);
        ckHotelsHomePage.ikinciLogin.click();
        Assert.assertTrue(ckHotelsHomePage.girilemediYazisi.isDisplayed());
        Driver.closeDriver();
    }
}
