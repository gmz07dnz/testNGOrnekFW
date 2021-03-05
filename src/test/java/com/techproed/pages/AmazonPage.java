package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AmazonPage {

    public AmazonPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public void enAltaGit(){
        Actions actions =new Actions(Driver.getDriver());
        actions.sendKeys(Keys.END).perform();
    }


    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> satirlarListesi;          // bırden fazla oldugu için list yaptık


    @FindBy(xpath = "//tr[1]//td[@class='navFooterDescItem']")
    public List<WebElement> sutunlar;

    @FindBy(xpath = "(//tr[1]//td)")
    public List<WebElement> birinciSatirElementleri;

    @FindBy(xpath = "//tr//td")
    public List<WebElement> allCells;

    @FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']")
    public WebElement sonucYazisiElementi;

    @FindBy(id = "twotabsearchtextbox")
    public WebElement aramaKutusu;



    public String getCellText(int satir,int sutun){
        String cellXPath = "//tr["+satir+"]//td["+sutun+"]";
        String cellText =Driver.getDriver().findElement(By.xpath(cellXPath)).getText();
        return cellText;
    }

}
