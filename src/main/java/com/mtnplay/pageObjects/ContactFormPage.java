package com.mtnplay.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactFormPage extends BasePage{

    @FindBy(xpath = "//iframe[@id='hs-form-iframe-0']")
    public WebElement iFrame;

    @FindBy(id = "your_name-c2e387f9-4bd8-496f-ab2a-81fbbc31712a")
    public WebElement nameTextField;

    @FindBy(id = "email-c2e387f9-4bd8-496f-ab2a-81fbbc31712a")
    public WebElement workEmailTextField;

    @FindBy(name = "mobilephone")
    public WebElement contactNumberTextField;

    @FindBy(name = "numemployees")
    public WebElement companySizeDropDown;

    @FindBy(name = "what_kind_of_problem_is_your_business_currently_facing_")
    public WebElement businessServiceDropDown;

    @FindBy(name = "message")
    public WebElement messageTextField;

    @FindBy(id = "LEGAL_CONSENT.subscription_type_10841063-c2e387f9-4bd8-496f-ab2a-81fbbc31712a")
    public WebElement legalConsentRadioButton;

    @FindBy(xpath = "//input[@data-reactid='.hbspt-forms-0.5.1.0']")
    public WebElement submitButton;

    public ContactFormPage(WebDriver newDriver, WebDriverWait newWait) {
        super(newDriver, newWait);
    }
}
