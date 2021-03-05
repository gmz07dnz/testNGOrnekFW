package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WebTablePage {

    public WebTablePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "btn2")
    public WebElement skipSignIn;

    @FindBy(linkText = "WebTable")
    public WebElement webTable;

    @FindBy(xpath = "//div[@class='ui-grid-header-cell-wrapper']")
    public List<WebElement> headers;

    @FindBy(xpath = "//select[@ng-model='grid.options.paginationPageSize']")
    public WebElement itemsPerPageDropdown;

    @FindBy(xpath = "//div[@class='ui-grid-row ng-scope']")
    public List<WebElement> satirSayisi;

    @FindBy(xpath = "//div[@class='ui-grid-cell-contents ng-binding ng-scope']")
    public List<WebElement> dataSayisi;

    @FindBy(xpath = "(//div[@class='ui-grid-row ng-scope'])[16]")
    public List<WebElement> satir16;

    @FindBy(xpath = "//div[@col='col']")
    public List<WebElement> headersDatalar;

    // 1. satirdaki datalar
    //String path = "(//div[@class='ui-grid-row ng-scope'])[1]//div[@class='ui-grid-cell-contents ng-binding ng-scope']"
    public void istenenColumnDatalar(int istenenColumn){
        System.out.println(istenenColumn+". column'daki datalar: ");
        for (int i=1;i<=satirSayisi.size();i++){
            List<WebElement> list = Driver.getDriver().findElements(By.xpath("(//div[@class='ui-grid-row ng-scope'])[" + i + "]//div[@class='ui-grid-cell-contents ng-binding ng-scope']"));
            System.out.println(list.get(istenenColumn-1).getText());
        }
    }

    public void istenenSatirData(int istenenSatir){
        for (WebElement w : Driver.getDriver().findElements(By.xpath("(//div[@class='ui-grid-row ng-scope'])["+istenenSatir+"]"))) {
            System.out.println(w.getText());
        }


    }

}
