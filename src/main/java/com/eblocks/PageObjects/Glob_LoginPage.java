package com.eblocks.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Glob_LoginPage extends BasePage{

    public Glob_LoginPage(WebDriver newDriver, WebDriverWait newWait) {
        super(newDriver, newWait);
    }

    public void OpenPage() throws Exception {

        if (System.getProperty("env").equals("dev")) {
            webDriver.get("https://www.calculator.net");
            System.out.println("Opening - https://www.calculator.net");
        }else if (System.getProperty("env").equals("sit")) {
            webDriver.get("https://www.calculator.net");
            System.out.println("Opening - https://www.calculator.net");
        }

    }
}
