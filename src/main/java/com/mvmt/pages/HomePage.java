package com.mvmt.pages;

import com.mvmt.base.Base;
import com.mvmt.util.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Base {
    private WebDriver webDriver ;

    @FindBy(id = "mens")
    WebElement mensNavbarElement;

    @FindBy(xpath = "//a[@href='https://www.mvmt.com/mens-watches/shop-all-mens-watches/']")
    WebElement shopAllMensWatchesElement;

    public HomePage(){
        webDriver = driver.get();
        PageFactory.initElements(webDriver,this);
    }

    public HomePage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    public void gotoMensWatches() throws InterruptedException {
        TestUtil.hoverOperation(mensNavbarElement,webDriver);
        Thread.sleep(5000);
        shopAllMensWatchesElement.click();
        Thread.sleep(5000);
    }

}
