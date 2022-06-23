package com.eblocks.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OnlineCalculatorPage extends BasePage{

    @FindBy(xpath = "//span[@onclick='r(1)']")
    public WebElement intOne;

    @FindBy(xpath = "//span[@onclick=\"r('+')\"]")
    public WebElement charPlusSign;

    @FindBy(xpath = "//span[@onclick='r(2)']")
    public WebElement intTwo;

    @FindBy(xpath = "//span[@onclick=\"r('=')\"]")
    public WebElement charEqualSign;

    @FindBy(xpath = "//div[@id='sciOutPut']")
    public WebElement txtContainsThree;

    public OnlineCalculatorPage(WebDriver newDriver, WebDriverWait newWait) {
        super(newDriver, newWait);
    }
}
