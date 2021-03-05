package com.techproed.smokeTest;

import com.techproed.pages.CkHotelsHomePage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.annotations.Test;

public class PositiveLogin {

    /*
       http://qa-environment.crystalkeyhotels.com adresine git
       login butonuna bas
       test data username: manager
       test data password : Manager2!
       Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
     */

    @Test
    public void positiveSmokeTest(){
        CkHotelsHomePage ckHotelsHomePage =new CkHotelsHomePage();
        Driver.getDriver().get(ConfigReader.getProperty("ck_hotels_url"));
        ckHotelsHomePage.ilklogin.click();
        ckHotelsHomePage.userNameTextBox.sendKeys(ConfigReader.getProperty("ck_hotels_user"));
        ckHotelsHomePage.passwordTextBox.sendKeys(ConfigReader.getProperty("ck_hotel_password"));
        ckHotelsHomePage.ikinciLogin.click();

    }
}
