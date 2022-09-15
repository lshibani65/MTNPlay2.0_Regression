package com.mtnplay.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ViewMenuStructure_Movies_AllGenresPage extends BasePage{

    @FindBy(xpath = "//div[contains(text(), 'Video')]")
    public WebElement btnVideo;

    @FindBy(xpath = "")
    public WebElement btnPurchaseForAmount;

    @FindBy(xpath = "")
    public WebElement rdBtnAirtime; //Two elements with the same ID

    @FindBy(xpath = "")
    public WebElement btnConfirmPurchase;

    @FindBy(xpath = "")
    public WebElement btnConfirm;

    @FindBy(xpath = "")
    public WebElement btnWatchNow;

    public ViewMenuStructure_Movies_AllGenresPage(WebDriver newDriver, WebDriverWait newWait) {
        super(newDriver, newWait);}
}
