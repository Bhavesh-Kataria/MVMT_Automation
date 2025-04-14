package com.mvmt.pages;

import com.mvmt.base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MensWatchesPage extends Base {
    private WebDriver webDriver;

    @FindBy(xpath = "//a[contains(text(),'Bourbon Blue')]")
    WebElement selectedWatchElement;

    @FindBy(xpath = "(//button[@class='add-to-cart btn btn-primary'])[4]")
    WebElement addToCartBtn;

    public MensWatchesPage(){
        webDriver = driver.get();
        PageFactory.initElements(webDriver,this);
    }

    public MensWatchesPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    public void selectAndAddToCart() throws InterruptedException {
        Thread.sleep(8000);
        selectedWatchElement.click();
        Thread.sleep(5000);
        addToCartBtn.click();
    }
}
