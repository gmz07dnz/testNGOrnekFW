package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CkHotelsHomePage {

    public CkHotelsHomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(linkText = "Log in")
    public WebElement ilklogin;


    @FindBy(id = "UserName")
    public WebElement userNameTextBox;


    @FindBy(id = "Password")
    public WebElement passwordTextBox;

    @FindBy(id = "btnSubmit")
    public WebElement ikinciLogin;

    @FindBy(xpath = "//*[.='System Management']")
    public WebElement systemManagement;

    @FindBy(xpath = "//div[@class='validation-summary-errors']")
    public WebElement girilemediYazisi;
}
