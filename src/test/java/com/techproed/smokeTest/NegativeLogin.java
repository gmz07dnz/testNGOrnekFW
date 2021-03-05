package com.techproed.smokeTest;

import com.techproed.pages.CkHotelsHomePage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLogin {

    @Test
    public void yanlisUserName(){
        Driver.getDriver().get(ConfigReader.getProperty("ck_hotels_url"));
        CkHotelsHomePage ckHotelsHomePage = new CkHotelsHomePage();
        ckHotelsHomePage.ilklogin.click();
        ckHotelsHomePage.userNameTextBox.sendKeys(ConfigReader.getProperty("ck_invalid_user"));
        ckHotelsHomePage.passwordTextBox.sendKeys(ConfigReader.getProperty("ck_hotel_password"));
        ckHotelsHomePage.ikinciLogin.click();
        Assert.assertTrue(ckHotelsHomePage.girilemediYazisi.isDisplayed());
        Driver.closeDriver();
    }


    @Test
    public void yanlisPassword(){
        Driver.getDriver().get(ConfigReader.getProperty("ck_hotels_url"));
        CkHotelsHomePage ckHotelsHomePage = new CkHotelsHomePage();
        ckHotelsHomePage.ilklogin.click();
        ckHotelsHomePage.userNameTextBox.sendKeys(ConfigReader.getProperty("ck_hotels_user"));
        ckHotelsHomePage.passwordTextBox.sendKeys(ConfigReader.getProperty("ck_invalid_password"));
        ckHotelsHomePage.ikinciLogin.click();
        Assert.assertTrue(ckHotelsHomePage.girilemediYazisi.isDisplayed());
        Driver.closeDriver();

    }

    @Test
    public void yanliskullaniciyanlisPassword(){
        Driver.getDriver().get(ConfigReader.getProperty("ck_hotels_url"));
        CkHotelsHomePage ckHotelsHomePage = new CkHotelsHomePage();
        ckHotelsHomePage.ilklogin.click();
        ckHotelsHomePage.userNameTextBox.sendKeys(ConfigReader.getProperty("ck_invalid_user"));
        ckHotelsHomePage.passwordTextBox.sendKeys(ConfigReader.getProperty("ck_invalid_password"));
        ckHotelsHomePage.ikinciLogin.click();
        Assert.assertTrue(ckHotelsHomePage.girilemediYazisi.isDisplayed());
        Driver.closeDriver();

    }
}
